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

@Service
public class ActividadService {

    private final ActividadRepository actividadRepository;

    public ActividadService(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    public Actividad crearActividad(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    public List<Actividad> consultarTodas() {
        return actividadRepository.findAll();
    }

    public Optional<Actividad> consultarPorId(Long id) {
        return actividadRepository.findById(id);
    }

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

    public void borrarActividad(Long id) {
        actividadRepository.deleteById(id);
    }
}