package co.edu.uniminuto.fing.eds.daw.exception;

/**
 * Excepcion lanzada cuando una Categoria solicitada no existe en la base de datos.
 */
public class RecursoNoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RecursoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
