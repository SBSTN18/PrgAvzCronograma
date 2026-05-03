package pa.taller4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase principal de la aplicación Spring Boot.
 * Configura el arranque del servidor y las políticas CORS
 * para permitir la comunicación con el frontend.
 *
 * @version 1.0
 */
@SpringBootApplication
public class Application {

    /**
     * Método principal que arranca la aplicación Spring Boot.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Configura las políticas CORS de la aplicación.
     * Permite solicitudes desde el frontend en localhost:8383
     * con los métodos HTTP necesarios para el CRUD.
     *
     * @return configurador de CORS
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:8383")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .maxAge(3600);
            }
        };
    }
}
