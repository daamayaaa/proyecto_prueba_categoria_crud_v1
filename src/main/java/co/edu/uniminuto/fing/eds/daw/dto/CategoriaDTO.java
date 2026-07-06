package co.edu.uniminuto.fing.eds.daw.dto;

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
