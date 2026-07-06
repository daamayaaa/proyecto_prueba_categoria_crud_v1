package co.edu.uniminuto.fing.eds.daw.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniminuto.fing.eds.daw.dto.CategoriaDTO;
import co.edu.uniminuto.fing.eds.daw.entity.Categoria;
import co.edu.uniminuto.fing.eds.daw.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> listar() {
        return categoriaRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public CategoriaDTO obtener(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.map(this::toDTO).orElse(null);
    }

    public CategoriaDTO crear(CategoriaDTO dto) {
        Categoria categoria = toEntity(dto);
        categoria.setIdCategoria(null);
        return toDTO(categoriaRepository.save(categoria));
    }

    public CategoriaDTO actualizar(Integer id, CategoriaDTO dto) {
        if (!categoriaRepository.existsById(id)) {
            return null;
        }
        Categoria categoria = toEntity(dto);
        categoria.setIdCategoria(id);
        return toDTO(categoriaRepository.save(categoria));
    }

    public boolean eliminar(Integer id) {
        if (!categoriaRepository.existsById(id)) {
            return false;
        }
        categoriaRepository.deleteById(id);
        return true;
    }

    private CategoriaDTO toDTO(Categoria categoria) {
        return new CategoriaDTO(categoria.getIdCategoria(), categoria.getNombre(), categoria.getHabilitado());
    }

    private Categoria toEntity(CategoriaDTO dto) {
        return new Categoria(dto.getIdCategoria(), dto.getNombre(), dto.getHabilitado());
    }
}
