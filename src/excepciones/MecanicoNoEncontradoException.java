package excepciones;

public class MecanicoNoEncontradoException extends RuntimeException {

    public MecanicoNoEncontradoException() {
        super("El mecánico indicado no existe.");
    }

}
