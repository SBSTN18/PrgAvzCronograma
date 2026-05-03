package pa.taller4.Modelo;

import java.time.LocalDate;

/**
 * Objeto de transferencia de datos (DTO) para la entidad Actividad.
* Se usa para exponer solo los campos necesarios en las respuestas
* de la API, evitando exponer directamente la entidad de base de datos.
*
* @version 1.0
*/
public class ActividadResponse {
    
    /** Identificador único de la actividad. */
    private Long id;
    /** Título breve de la actividad. */
    private String titulo;
    /** Descripción detallada de la actividad. */
    private String descripcion;
    /** Tipo o categoría de la actividad. */
    private String tipoActividad;
    /** Fecha de inicio de la actividad. */
    private LocalDate fechaInicio;
    /** Fecha de finalización de la actividad. */
    private LocalDate fechaTerminacion;
    /** Identificador del tutor asociado a la actividad. */
    private Long id_tutor;
    /** Identificador del hijo asociado a la actividad. */  
    private Long id_hijo;

    
    public ActividadResponse() {
    }

    /**
     * Constructor completo para crear una instancia de ActividadResponse con todos los campos.
     *
     * @param id identificador de la actividad
     * @param titulo título de la actividad
     * @param descripcion descripción detallada de la actividad
     * @param tipoActividad tipo o categoría de la actividad
     * @param fechaInicio fecha de inicio de la actividad
     * @param fechaTerminacion fecha de finalización de la actividad
     * @param id_tutor identificador del tutor asociado a la actividad
     * @param id_hijo identificador del hijo asociado a la actividad
     */
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

    /**
     * Retorna el identificador de la actividad.
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador de la actividad.
     * @param id identificador
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna el título de la actividad.
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la actividad.
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Retorna la descripción de la actividad.
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la actividad.
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Retorna el tipo o categoría de la actividad.
     * @return tipoActividad
     */
    public String getTipoActividad() {
        return tipoActividad;
    }

    /**
     * Establece el tipo o categoría de la actividad.
     * @param tipoActividad
     */
    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    /**
     * Retorna la fecha de inicio de la actividad.
     * @return fechaInicio
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio de la actividad.
     * @param fechaInicio
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Retorna la fecha de finalización de la actividad.
     * @return fechaTerminacion
     */
    public LocalDate getFechaTerminacion() {
        return fechaTerminacion;
    }

    /**
     * Establece la fecha de finalización de la actividad.
     * @param fechaTerminacion
     */
    public void setFechaTerminacion(LocalDate fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    /**
     * Retorna el identificador del tutor asociado a la actividad.
     * @return id_tutor
     */
    public Long getId_tutor() {
        return id_tutor;
    }

    /**
     * Establece el identificador del tutor asociado a la actividad.
     * @param id_tutor
     */
    public void setId_tutor(Long id_tutor) {
        this.id_tutor = id_tutor;
    }

    /**
     * Retorna el identificador del hijo asociado a la actividad.
     * @return id_hijo
     */
    public Long getId_hijo() {
        return id_hijo;
    }

    /**
     * Establece el identificador del hijo asociado a la actividad.
     * @param id_hijo
     */
    public void setId_hijo(Long id_hijo) {
        this.id_hijo = id_hijo;
    }
}
