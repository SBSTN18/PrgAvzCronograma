package pa.taller4.errores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Map;

/**
 * Manejador global de excepciones para todos los controladores.
 * Captura las excepciones lanzadas por los servicios y devuelve
 * respuestas JSON con el código HTTP apropiado.
 *
 * @author [tu nombre]
 * @version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja el caso en que no se encuentra una actividad.
     *
     * @param ex excepción lanzada
     * @return respuesta con código 404
     */
    @ExceptionHandler(ActividadNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(ActividadNotFoundException ex) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(Map.of(
                "error", "NOT_FOUND",
                "message", ex.getMessage(),
                "status", 404
            ));
    }

    /**
     * Maneja cualquier otro error inesperado.
     *
     * @param ex excepción lanzada
     * @return respuesta con código 500
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex) {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(Map.of(
                "error", "INTERNAL_ERROR",
                "message", ex.getMessage(),
                "status", 500
            ));
    }
}