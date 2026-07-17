package co.edu.uniminuto.fing.eds.daw.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniminuto.fing.eds.daw.dto.CategoriaDTO;
import co.edu.uniminuto.fing.eds.daw.service.CategoriaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controlador REST que expone el CRUD de Categoria.
 * El manejo de CORS se realiza de forma centralizada en config.CorsFilter,
 * por lo que este controlador no requiere anotaciones adicionales de CORS.
 * Rutas base: /categorias
 */
@RestController
@RequestMapping("/categorias")
@Tag(name = "Categoria", description = "Operaciones CRUD sobre la entidad Categoria")
public class CategoriaController {

    private static final Logger LOGGER = LogManager.getLogger(CategoriaController.class);

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    /**
     * Obtiene el listado completo de categorias.
     *
     * @return HTTP 200 con la lista de categorias
     */
    @Operation(summary = "Listar categorias", description = "Retorna todas las categorias registradas.")
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listar() {
        LOGGER.info("GET /categorias");
        List<CategoriaDTO> categorias = categoriaService.listar();
        return ResponseEntity.ok(categorias);
    }

    /**
     * Obtiene una categoria por su identificador.
     *
     * @param id identificador de la categoria
     * @return HTTP 200 con la categoria encontrada
     */
    @Operation(summary = "Obtener categoria por id", description = "Retorna una categoria segun su identificador.")
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> obtenerPorId(@Parameter(description = "Identificador de la categoria") @PathVariable Integer id) {
        LOGGER.info("GET /categorias/{}", id);
        CategoriaDTO categoria = categoriaService.obtenerPorId(id);
        return ResponseEntity.ok(categoria);
    }

    /**
     * Crea una nueva categoria.
     *
     * @param categoriaDTO datos de la categoria a crear
     * @return HTTP 201 con la categoria creada
     */
    @Operation(summary = "Crear categoria", description = "Crea una nueva categoria.")
    @PostMapping
    public ResponseEntity<CategoriaDTO> crear(@RequestBody CategoriaDTO categoriaDTO) {
        LOGGER.info("POST /categorias");
        CategoriaDTO creada = categoriaService.crear(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    /**
     * Actualiza una categoria existente.
     *
     * @param id identificador de la categoria
     * @param categoriaDTO datos nuevos de la categoria
     * @return HTTP 200 con la categoria actualizada
     */
    @Operation(summary = "Actualizar categoria", description = "Actualiza una categoria existente segun su id.")
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> actualizar(@Parameter(description = "Identificador de la categoria") @PathVariable Integer id, @RequestBody CategoriaDTO categoriaDTO) {
        LOGGER.info("PUT /categorias/{}", id);
        CategoriaDTO actualizada = categoriaService.actualizar(id, categoriaDTO);
        return ResponseEntity.ok(actualizada);
    }

    /**
     * Elimina una categoria existente.
     *
     * @param id identificador de la categoria a eliminar
     * @return HTTP 204 sin contenido
     */
    @Operation(summary = "Eliminar categoria", description = "Elimina una categoria segun su id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@Parameter(description = "Identificador de la categoria") @PathVariable Integer id) {
        LOGGER.info("DELETE /categorias/{}", id);
        categoriaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
