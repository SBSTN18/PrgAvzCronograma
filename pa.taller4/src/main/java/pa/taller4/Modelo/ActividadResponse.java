package pa.taller4.Modelo;

import java.time.LocalDate;

public class ActividadResponse {
    
    private Long id;
    private String titulo;
    private String descripcion;
    private String tipoActividad;
    private LocalDate fechaInicio;
    private LocalDate fechaTerminacion;
    private Long id_tutor;
    private Long id_hijo;

    public ActividadResponse() {
    }

    public ActividadResponse(Long id, String titulo, String descripcion, String tipoActividad, LocalDate fechaInicio, LocalDate fechaTerminacion, Long id_tutor, Long id_hijo) {
        this.id = id;   
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipoActividad = tipoActividad;
        this.fechaInicio = fechaInicio;
        this.fechaTerminacion = fechaTerminacion;
        this.id_tutor = id_tutor;
        this.id_hijo = id_hijo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(LocalDate fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    public Long getId_tutor() {
        return id_tutor;
    }

    public void setId_tutor(Long id_tutor) {
        this.id_tutor = id_tutor;
    }

    public Long getId_hijo() {
        return id_hijo;
    }

    public void setId_hijo(Long id_hijo) {
        this.id_hijo = id_hijo;
    }
}
