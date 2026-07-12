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
    public void agregarMecanico(String nombre, String especialidad) {

        if (mecanicos.size() >= 10)
            throw new LimiteMecanicosException();
        
        int id = generarNuevoId();

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

    public void mostrarSistema() {

        System.out.println();
        System.out.println("=========================================================");
        System.out.println("         SISTEMA DE ADMINISTRACIÓN DE TALLER");
        System.out.println("=========================================================");

        System.out.println("Nombre del sistema    : " + nombreSistema);
        System.out.println("Fecha de creación     : " + fechaCreacion);
        System.out.println("Cantidad de mecánicos : " + cantidadMecanicos());
        System.out.println("Cantidad total autos  : " + cantidadTotalAutos());

        System.out.println();

        if (mecanicos.isEmpty()) {
            System.out.println("No hay mecánicos registrados.");
            return;
        }

        System.out.println("=========================================================");

        for (Mecanico mecanico : mecanicos.values()) {

            System.out.println("ID            : " + mecanico.getId());
            System.out.println("Nombre        : " + mecanico.getNombre());
            System.out.println("Especialidad  : " + mecanico.getEspecialidad());

            if (mecanico.getAutosReparados().isEmpty()) {

                System.out.println("Autos reparados: Ninguno");

            } else {

                System.out.println("Autos reparados:");

                for (Auto auto : mecanico.getAutosReparados().values()) {

                    System.out.println("   - "
                            + auto.getPlaca()
                            + " - "
                            + auto.getMarca()
                            + " "
                            + auto.getModelo());

                }

            }

            System.out.println("---------------------------------------------------------");
        }

    }

    public void mostrarMecanicos() {

        System.out.println();
        System.out.println("========== MECÁNICOS DISPONIBLES ==========");

        if (mecanicos.isEmpty()) {
            System.out.println("No hay mecánicos registrados.");
            return;
        }

        for (Mecanico mecanico : mecanicos.values()) {

            System.out.println(
                    "ID: " + mecanico.getId()
                            + " | Nombre: " + mecanico.getNombre()
                            + " | Especialidad: " + mecanico.getEspecialidad());

        }

        System.out.println("===========================================");

    }

    private int generarNuevoId() {

        int mayorId = 0;

        for (Integer id : mecanicos.keySet()) {

            if (id > mayorId) {
                mayorId = id;
            }

        }

        return mayorId + 1;

    }

}
