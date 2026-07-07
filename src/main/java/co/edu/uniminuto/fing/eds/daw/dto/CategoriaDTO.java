package co.edu.uniminuto.fing.eds.daw.dto;

import co.edu.uniminuto.fing.eds.daw.entity.Categoria;

/**
 * DTO usado en el API REST para exponer/recibir datos de Categoria.
 * Incluye conversiones manuales hacia y desde la entidad para evitar
 * el uso de librerias de mapeo adicionales.
 */
public class CategoriaDTO {

    private Integer idCategoria;
    private String nombre;
    private Boolean habilitado;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Integer idCategoria, String nombre, Boolean habilitado) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.habilitado = habilitado;
    }

    public static CategoriaDTO desdeEntidad(Categoria categoria) {
        return new CategoriaDTO(categoria.getIdCategoria(), categoria.getNombre(), categoria.getHabilitado());
    }

    public Categoria haciaEntidad() {
        return new Categoria(this.idCategoria, this.nombre, this.habilitado);
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }
}
