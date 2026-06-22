package modelo;

import java.util.HashMap;
import excepciones.LimiteAutosException;
import excepciones.PlacaRepetidaException;

public class Mecanico {

    Integer id;
    String nombre;
    String especialidad;

    HashMap<String, Auto> autosReparados = new HashMap<>();

    public Mecanico(Integer id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Mecanico [id=" + id +
                ", nombre=" + nombre +
                ", especialidad=" + especialidad +
                ", autosReparados=" + autosReparados + "]";
    }

    public void agregarAuto(Auto auto) {

        if (autosReparados.size() >= 10)
            throw new LimiteAutosException();

        if (autosReparados.containsKey(auto.placa))
            throw new PlacaRepetidaException();

        autosReparados.put(auto.placa, auto);
    }

    public int cantidadAutosReparados() {
        return autosReparados.size();
    }

}