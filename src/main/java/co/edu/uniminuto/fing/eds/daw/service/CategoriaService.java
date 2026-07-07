package co.edu.uniminuto.fing.eds.daw.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import co.edu.uniminuto.fing.eds.daw.dto.CategoriaDTO;
import co.edu.uniminuto.fing.eds.daw.entity.Categoria;
import co.edu.uniminuto.fing.eds.daw.exception.RecursoNoEncontradoException;
import co.edu.uniminuto.fing.eds.daw.repository.CategoriaRepository;

/**
 * Servicio con la logica de negocio del CRUD de Categoria.
 * Toda validacion y regla de negocio simple se centraliza aqui.
 */
@Service
public class CategoriaService {

    private static final Logger LOGGER = LogManager.getLogger(CategoriaService.class);

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaDTO> listar() {
        LOGGER.info("Consultando el listado completo de categorias.");
        List<CategoriaDTO> categorias = categoriaRepository.findAll()
                .stream()
                .map(CategoriaDTO::desdeEntidad)
                .collect(Collectors.toList());
        LOGGER.info("Se encontraron {} categorias.", categorias.size());
        return categorias;
    }

    public CategoriaDTO obtenerPorId(Integer id) {
        LOGGER.info("Buscando la categoria con id {}.", id);
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No existe una categoria con id " + id));
        return CategoriaDTO.desdeEntidad(categoria);
    }

    public CategoriaDTO crear(CategoriaDTO categoriaDTO) {
        validar(categoriaDTO);
        LOGGER.info("Creando una nueva categoria con nombre '{}'.", categoriaDTO.getNombre());
        Categoria categoria = categoriaDTO.haciaEntidad();
        categoria.setIdCategoria(null);
        Categoria guardada = categoriaRepository.save(categoria);
        LOGGER.info("Categoria creada con id {}.", guardada.getIdCategoria());
        return CategoriaDTO.desdeEntidad(guardada);
    }

    public CategoriaDTO actualizar(Integer id, CategoriaDTO categoriaDTO) {
        validar(categoriaDTO);
        LOGGER.info("Actualizando la categoria con id {}.", id);
        Categoria existente = categoriaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No existe una categoria con id " + id));
        existente.setNombre(categoriaDTO.getNombre());
        existente.setHabilitado(categoriaDTO.getHabilitado());
        Categoria actualizada = categoriaRepository.save(existente);
        LOGGER.info("Categoria con id {} actualizada correctamente.", id);
        return CategoriaDTO.desdeEntidad(actualizada);
    }

    public boolean eliminar(Integer id) {
        LOGGER.info("Eliminando la categoria con id {}.", id);
        if (!categoriaRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("No existe una categoria con id " + id);
        }
        categoriaRepository.deleteById(id);
        LOGGER.info("Categoria con id {} eliminada correctamente.", id);
        return true;
    }

    private CategoriaDTO toDTO(Categoria categoria) {
        return new CategoriaDTO(categoria.getIdCategoria(), categoria.getNombre(), categoria.getHabilitado());
    }

    private Categoria toEntity(CategoriaDTO dto) {
        return new Categoria(dto.getIdCategoria(), dto.getNombre(), dto.getHabilitado());
    }


    private void validar(CategoriaDTO categoriaDTO) {
        if (categoriaDTO == null || categoriaDTO.getNombre() == null || categoriaDTO.getNombre().trim().isEmpty()) {
            LOGGER.warn("Intento de guardar una categoria con nombre invalido.");
            throw new IllegalArgumentException("El nombre de la categoria es obligatorio.");
        }
    }
}

