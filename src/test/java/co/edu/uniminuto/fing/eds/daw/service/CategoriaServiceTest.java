package co.edu.uniminuto.fing.eds.daw.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.edu.uniminuto.fing.eds.daw.dto.CategoriaDTO;
import co.edu.uniminuto.fing.eds.daw.entity.Categoria;
import co.edu.uniminuto.fing.eds.daw.repository.CategoriaRepository;

@ExtendWith(MockitoExtension.class)
class CategoriaServiceTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaService categoriaService;

    private Categoria categoria;

    @BeforeEach
    void setUp() {
        categoria = new Categoria(1, "Electrodomesticos", true);
    }

    @Test
    void listarDebeRetornarTodasLasCategorias() {
        when(categoriaRepository.findAll()).thenReturn(Arrays.asList(categoria));

        var resultado = categoriaService.listar();

        assertEquals(1, resultado.size());
        assertEquals("Electrodomesticos", resultado.get(0).getNombre());
    }

    @Test
    void obtenerPorIdDebeRetornarCategoriaExistente() {
        when(categoriaRepository.findById(1)).thenReturn(Optional.of(categoria));

        CategoriaDTO resultado = categoriaService.obtenerPorId(1);

        assertEquals(1, resultado.getIdCategoria());
        assertEquals("Electrodomesticos", resultado.getNombre());
    }

    @Test
    void obtenerPorIdDebeRetornarNullSiNoExiste() {
        when(categoriaRepository.findById(99)).thenReturn(Optional.empty());

        CategoriaDTO resultado = categoriaService.obtenerPorId(99);

        assertNull(resultado);
    }

    @Test
    void crearDebeGuardarYRetornarCategoria() {
        CategoriaDTO dto = new CategoriaDTO(null, "Tecnologia", true);
        when(categoriaRepository.save(any(Categoria.class))).thenReturn(new Categoria(2, "Tecnologia", true));

        CategoriaDTO resultado = categoriaService.crear(dto);

        assertEquals(2, resultado.getIdCategoria());
        assertEquals("Tecnologia", resultado.getNombre());
        verify(categoriaRepository, times(1)).save(any(Categoria.class));
    }

    @Test
    void actualizarDebeModificarCategoriaExistente() {
        CategoriaDTO dto = new CategoriaDTO(1, "Hogar", false);
        when(categoriaRepository.existsById(1)).thenReturn(true);
        when(categoriaRepository.save(any(Categoria.class))).thenReturn(new Categoria(1, "Hogar", false));

        CategoriaDTO resultado = categoriaService.actualizar(1, dto);

        assertEquals("Hogar", resultado.getNombre());
        assertFalse(resultado.getHabilitado());
    }

    @Test
    void actualizarDebeRetornarNullSiNoExiste() {
        when(categoriaRepository.existsById(anyInt())).thenReturn(false);

        CategoriaDTO resultado = categoriaService.actualizar(50, new CategoriaDTO(50, "X", true));

        assertNull(resultado);
    }

    @Test
    void eliminarDebeRetornarTrueSiExiste() {
        when(categoriaRepository.existsById(1)).thenReturn(true);

        boolean resultado = categoriaService.eliminar(1);

        assertTrue(resultado);
        verify(categoriaRepository, times(1)).deleteById(1);
    }

    @Test
    void eliminarDebeRetornarFalseSiNoExiste() {
        when(categoriaRepository.existsById(anyInt())).thenReturn(false);

        boolean resultado = categoriaService.eliminar(99);

        assertFalse(resultado);
    }
}
