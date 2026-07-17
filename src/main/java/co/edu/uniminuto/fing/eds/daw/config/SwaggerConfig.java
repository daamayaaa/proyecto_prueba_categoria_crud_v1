package co.edu.uniminuto.fing.eds.daw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * Configuracion basica de la documentacion Swagger/OpenAPI de la API.
 * Disponible en /swagger-ui.html
 */
@Configuration
public class SwaggerConfig {

    /**
     * Metadatos generales mostrados en la interfaz de Swagger.
     *
     * @return configuracion de {@link OpenAPI}
     */
    @Bean
    public OpenAPI categoriaOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("API Categoria - Prueba")
                .description("CRUD REST por capas para la entidad Categoria")
                .version("1.0.0"));
    }
}
