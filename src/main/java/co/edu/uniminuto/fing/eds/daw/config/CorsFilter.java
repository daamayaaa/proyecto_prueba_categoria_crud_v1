package co.edu.uniminuto.fing.eds.daw.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Filtro que centraliza toda la logica de CORS de la aplicacion.
 * Permite cualquier origen, los metodos requeridos y responde
 * directamente a las solicitudes de preflight (OPTIONS) sin
 * necesidad de llegar al controlador.
 */
@Component
@Order(1)
public class CorsFilter implements Filter {

    private static final Logger LOGGER = LogManager.getLogger(CorsFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("Filtro CORS inicializado.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");

        if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            LOGGER.info("Solicitud preflight OPTIONS recibida para {}.", httpRequest.getRequestURI());
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            LOGGER.error("Error procesando la solicitud {} {}: {}", httpRequest.getMethod(),
                    httpRequest.getRequestURI(), e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void destroy() {
        LOGGER.info("Filtro CORS finalizado.");
    }
}
