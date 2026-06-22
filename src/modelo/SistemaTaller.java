package modelo;

import java.util.HashMap;
import interfaces.ISistemaTaller;
import excepciones.IdRepetidoException;
import excepciones.MecanicoNoEncontradoException;
import excepciones.LimiteMecanicosException;

public class SistemaTaller implements ISistemaTaller {

    String nombreSistema;
    String fechaCreacion;

    HashMap<Integer, Mecanico> mecanicos = new HashMap<>();

    public SistemaTaller(String nombreSistema, String fechaCreacion) {
        this.nombreSistema = nombreSistema;
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "SistemaTaller [nombreSistema=" + nombreSistema
                + ", fechaCreacion=" + fechaCreacion
                + ", mecanicos=" + mecanicos + "]";
    }

    @Override
    public void agregarMecanico(Integer id, String nombre, String especialidad) {

        if (mecanicos.size() >= 10)
        throw new LimiteMecanicosException();

        if (mecanicos.containsKey(id))
            throw new IdRepetidoException();

        Mecanico mecanico = new Mecanico(id, nombre, especialidad);

        mecanicos.put(id, mecanico);

    }

    @Override
    public void agregarAutoAMecanico(Integer idMecanico,
            String placa,
            String marca,
            String modelo) {

        Mecanico mecanico = mecanicos.get(idMecanico);

        if (mecanico == null)
            throw new MecanicoNoEncontradoException();

        Auto auto = new Auto(placa, marca, modelo);

        mecanico.agregarAuto(auto);

    }

    @Override
    public int cantidadMecanicos() {
        return mecanicos.size();
    }

    @Override
    public int cantidadAutosPorMecanico(int idMecanico) {
        Mecanico mecanico = mecanicos.get(idMecanico);
        if (mecanico == null)
            throw new RuntimeException("Mecanico inexistente");
        return mecanico.cantidadAutosReparados();
    }

    @Override
    public int cantidadTotalAutos() {
        int total = 0;
        for (Mecanico mecanico : mecanicos.values()) {
            total += mecanico.cantidadAutosReparados();
        }
        return total;
    }

    @Override
    public boolean existeMecanico(int idMecanico) {
        return mecanicos.containsKey(idMecanico);
    }

}
