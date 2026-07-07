package co.edu.uniminuto.fing.eds.daw.dto;

import co.edu.uniminuto.fing.eds.daw.entity.Categoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO usado en el API REST para exponer/recibir datos de Categoria.
 * Incluye conversiones manuales hacia y desde la entidad para evitar
 * el uso de librerias de mapeo adicionales.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {

    private Integer idCategoria;
    private String nombre;
    private Boolean habilitado;

    public static CategoriaDTO desdeEntidad(Categoria categoria) {
        return new CategoriaDTO(categoria.getIdCategoria(), categoria.getNombre(), categoria.getHabilitado());
    }

    public Categoria haciaEntidad() {
        return new Categoria(this.idCategoria, this.nombre, this.habilitado);
    }
    }
}
