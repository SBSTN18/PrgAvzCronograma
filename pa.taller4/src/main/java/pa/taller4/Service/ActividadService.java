/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa.taller4.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import pa.taller4.Modelo.Actividad;
import pa.taller4.Repository.ActividadRepository;

/**
 * Servicio que contiene la lógica de negocio para la gestión de actividades.
 * Actúa como intermediario entre el controlador y el repositorio,
 * aplicando las reglas del dominio antes de persistir o retornar datos.
 *
 * @author [tu nombre]
 * @version 1.0
 */
@Service
public class ActividadService {
    /** Repositorio para acceder a los datos de actividades en la base de datos. */
    private final ActividadRepository actividadRepository;

    /**
     * Constructor que inyecta el repositorio de actividades.
     *
     * @param actividadRepository repositorio de actividades
     */
    public ActividadService(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    /**
     * Guarda una nueva actividad en la base de datos.
     *
     * @param actividad objeto con los datos de la actividad a crear
     * @return la actividad creada con su id generado
     */
    public Actividad crearActividad(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    /**
     * Retorna todas las actividades registradas en la base de datos.
     *
     * @return lista con todas las actividades
     */
    public List<Actividad> consultarTodas() {
        return actividadRepository.findAll();
    }

    /**
     * Busca una actividad por su identificador único.
     *
     * @param id identificador de la actividad
     * @return un Optional con la actividad si existe, o vacío si no se encuentra
     */
    public Optional<Actividad> consultarPorId(Long id) {
        return actividadRepository.findById(id);
    }

    /**
     * Modifica los datos de una actividad existente.
     * Busca la actividad por id, actualiza sus campos y la guarda.
     *
     * @param id identificador de la actividad a modificar
     * @param actividad objeto con los nuevos datos
     * @return la actividad actualizada
     * @throws RuntimeException si la actividad no se encuentra
     */
    public Actividad modificarActividad(Long id, Actividad actividad) {
        return actividadRepository.findById(id)
                .map(a -> {
                    a.setTitulo(actividad.getTitulo());
                    a.setDescripcion(actividad.getDescripcion());
                    a.setFechaInicio(actividad.getFechaInicio());
                    a.setFechaTerminacion(actividad.getFechaTerminacion());
                    a.setTipoActividad(actividad.getTipoActividad());
                    a.setIdQuehacer(actividad.getIdQuehacer());
                    a.setIdTutor(actividad.getIdTutor());
                    a.setIdHijo(actividad.getIdHijo());
                    return actividadRepository.save(a);
                })
                .orElseThrow(() -> new RuntimeException("Actividad no encontrada"));
    }

    /**
     * Elimina una actividad de la base de datos por su identificador.
     *
     * @param id identificador de la actividad a eliminar
     */
    public void borrarActividad(Long id) {
        actividadRepository.deleteById(id);
    }
}