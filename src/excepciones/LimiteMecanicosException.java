package excepciones;

public class LimiteMecanicosException extends RuntimeException {

    public LimiteMecanicosException() {
        super("No se pueden registrar más de 10 mecánicos.");
    }

}
