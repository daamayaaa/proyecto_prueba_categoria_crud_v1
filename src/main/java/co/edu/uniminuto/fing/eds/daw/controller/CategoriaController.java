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

/**
 * Controlador REST que expone el CRUD de Categoria.
 * El manejo de CORS se realiza de forma centralizada en config.CorsFilter,
 * por lo que este controlador no requiere anotaciones adicionales de CORS.
 */
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private static final Logger LOGGER = LogManager.getLogger(CategoriaController.class);

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listar() {
        LOGGER.info("GET /categorias");
        List<CategoriaDTO> categorias = categoriaService.listar();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> obtenerPorId(@PathVariable Integer id) {
        LOGGER.info("GET /categorias/{}", id);
        CategoriaDTO categoria = categoriaService.obtenerPorId(id);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> crear(@RequestBody CategoriaDTO categoriaDTO) {
        LOGGER.info("POST /categorias");
        CategoriaDTO creada = categoriaService.crear(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> actualizar(@PathVariable Integer id, @RequestBody CategoriaDTO categoriaDTO) {
        LOGGER.info("PUT /categorias/{}", id);
        CategoriaDTO actualizada = categoriaService.actualizar(id, categoriaDTO);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        LOGGER.info("DELETE /categorias/{}", id);
        categoriaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
