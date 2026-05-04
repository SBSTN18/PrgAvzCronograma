package pa.taller4.errores;

public class ActividadNotFoundException extends RuntimeException {
    public ActividadNotFoundException(Long id) {
        super("Actividad con id " + id + " no encontrada");
    }
}
