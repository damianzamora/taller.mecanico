package excepciones;

public class PlacaRepetidaException extends RuntimeException {

    public PlacaRepetidaException() {
        super("Ya existe un auto con esa placa.");
    }

}
