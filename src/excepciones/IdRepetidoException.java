package excepciones;

public class IdRepetidoException extends RuntimeException {

    public IdRepetidoException() {
        super("Ya existe un mecánico con ese id.");
    }

}
