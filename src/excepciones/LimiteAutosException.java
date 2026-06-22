package excepciones;

public class LimiteAutosException extends RuntimeException {

    public LimiteAutosException() {
        super("El mecánico ya tiene 10 autos registrados.");
    }

}
