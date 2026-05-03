/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa.taller4.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pa.taller4.Modelo.Actividad;
import pa.taller4.Modelo.ActividadResponse;
import pa.taller4.Service.ActividadService;

/**
 * Controlador REST para la gestión de actividades del hogar.
 * Expone los endpoints para crear, consultar, modificar y eliminar actividades.
 * Maneja los errores devolviendo respuestas JSON con código HTTP apropiado.
 *
 * @version 1.0
 */
@RestController
@RequestMapping("/actividades")
public class ActividadController {
    /** Servicio que contiene la lógica de negocio de las actividades. */
    private final ActividadService actividadService;

    /**
     * Constructor que inyecta el servicio de actividades.
     *
     * @param actividadService servicio de actividades
     */
    public ActividadController(ActividadService actividadService) {
        this.actividadService = actividadService;
    }

    /**
     * Crea una nueva actividad en la base de datos.
     *
     * @param actividad objeto con los datos de la actividad a crear
     * @return la actividad creada con código 201, o error 400 si falla
     */
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Actividad actividad) {
        try {
            Actividad nueva = actividadService.crearActividad(actividad);
            return new ResponseEntity<>(nueva, HttpStatus.CREATED);
        } catch (Exception ex) {
            Map<String, Object> body = Map.of(
                "error", "BAD_REQUEST",
                "message", "Error al crear la actividad: " + ex.getMessage(),
                "status", 400
            );
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }
    }   

    /**
     * Consulta todas las actividades registradas en la base de datos.
     *
     * @return lista de actividades con código 200, o error 500 si falla
     */
    @GetMapping
    public ResponseEntity<?> consultarTodas() {
        try {
            List<ActividadResponse> lista = actividadService.consultarTodas().stream()
                .map(a -> new ActividadResponse(
                    a.getIdActividad(),
                    a.getTitulo(),
                    a.getDescripcion(),
                    a.getTipoActividad(),
                    a.getFechaInicio(),
                    a.getFechaTerminacion(),
                    a.getIdTutor(),
                    a.getIdHijo()
                ))
                .collect(Collectors.toList());
            return ResponseEntity.ok(lista);
        } catch (Exception ex) {
            Map<String, Object> body = Map.of(
                "error", "INTERNAL_ERROR",
                "message", "Error al consultar actividades",
                "status", 500
            );
            return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Consulta una actividad específica por su identificador.
     *
     * @param id identificador único de la actividad
     * @return la actividad encontrada con código 200, o error 404 si no existe
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> consultarPorId(@PathVariable Long id) {
        try {
            ActividadResponse a = actividadService.consultarPorId(id)
                .map(act -> new ActividadResponse(
                    act.getIdActividad(),
                    act.getTitulo(),
                    act.getDescripcion(),
                    act.getTipoActividad(),
                    act.getFechaInicio(),
                    act.getFechaTerminacion(),
                    act.getIdTutor(),
                    act.getIdHijo()
                ))
                .orElseThrow(() -> new RuntimeException("Actividad no encontrada con id: " + id));
            return ResponseEntity.ok(a);
        } catch (RuntimeException ex) {
            Map<String, Object> body = Map.of(
                "error", "NOT_FOUND",
                "message", ex.getMessage(),
                "status", 404
            );
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Modifica una actividad existente con los nuevos datos proporcionados.
     *
     * @param id identificador de la actividad a modificar
     * @param actividad objeto con los nuevos datos
     * @return la actividad modificada con código 200, o error 404 si no existe
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Long id, @RequestBody Actividad actividad) {
        try {
            Actividad modificada = actividadService.modificarActividad(id, actividad);
            return ResponseEntity.ok(modificada);
        } catch (RuntimeException ex) {
            Map<String, Object> body = Map.of(
                "error", "NOT_FOUND",
                "message", ex.getMessage(),
                "status", 404
            );
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Elimina una actividad de la base de datos por su identificador.
     *
     * @param id identificador de la actividad a eliminar
     * @return mensaje de confirmación con código 200, o error 404 si no existe
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id) {
        try {
            actividadService.borrarActividad(id);
            Map<String, Object> body = Map.of(
                "message", "Actividad eliminada correctamente",
                "status", 200
            );
            return ResponseEntity.ok(body);
        } catch (RuntimeException ex) {
            Map<String, Object> body = Map.of(
                "error", "NOT_FOUND",
                "message", "No existe actividad con id: " + id,
                "status", 404
            );
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
    }
}
