/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa.taller4.Controller;

import java.util.List;
import java.util.stream.Collectors;

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

@RestController
@RequestMapping("/actividades")
public class ActividadController {

    private final ActividadService actividadService;

    public ActividadController(ActividadService actividadService) {
        this.actividadService = actividadService;
    }

    @PostMapping
    public Actividad crear(@RequestBody Actividad actividad) {
        return actividadService.crearActividad(actividad);
    }

    @GetMapping
    public List<ActividadResponse> consultarTodas() {
        return actividadService.consultarTodas().stream()
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
    }

    @GetMapping("/{id}")
    public ActividadResponse consultarPorId(@PathVariable Long id) {
        return actividadService.consultarPorId(id)
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
                .orElseThrow(() -> new RuntimeException("Actividad no encontrada"));
    }

    @PutMapping("/{id}")
    public Actividad modificar(@PathVariable Long id, @RequestBody Actividad actividad) {
        return actividadService.modificarActividad(id, actividad);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        actividadService.borrarActividad(id);
    }
}
