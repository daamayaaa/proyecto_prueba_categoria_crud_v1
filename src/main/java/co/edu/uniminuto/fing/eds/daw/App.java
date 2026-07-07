package co.edu.uniminuto.fing.eds.daw;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal. Arranca el contexto de Spring Boot y expone
 * el API REST de Categoria en el puerto configurado (por defecto 8080).
 */
@SpringBootApplication
public class App {

    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        try {
            LOGGER.info("Iniciando la aplicacion Prueba...");
            SpringApplication.run(App.class, args);
            LOGGER.info("Aplicacion Prueba iniciada correctamente.");
        } catch (Exception e) {
            LOGGER.error("Error critico al iniciar la aplicacion: {}", e.getMessage(), e);
            throw e;
        }
    }
}
