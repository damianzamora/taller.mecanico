package interfaces;

public interface ISistemaTaller {

    public void agregarMecanico(String nombre,
            String especialidad);

    public void agregarAutoAMecanico(Integer idMecanico,
            String placa,
            String marca,
            String modelo);

    public int cantidadMecanicos();

    public int cantidadAutosPorMecanico(int idMecanico);

    public int cantidadTotalAutos();

    public boolean existeMecanico(int idMecanico);

    public void mostrarSistema();

    public void mostrarMecanicos();

}
