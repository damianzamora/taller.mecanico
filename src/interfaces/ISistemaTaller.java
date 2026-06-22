package interfaces;

public interface ISistemaTaller {

    public void agregarMecanico(Integer id,
            String nombre,
            String especialidad);

    public void agregarAutoAMecanico(Integer idMecanico,
            String placa,
            String marca,
            String modelo);

    public int cantidadMecanicos();

    public int cantidadAutosPorMecanico(int idMecanico);

    public int cantidadTotalAutos();

    public boolean existeMecanico(int idMecanico);

}
