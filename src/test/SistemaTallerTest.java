package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import excepciones.LimiteAutosException;
import excepciones.LimiteMecanicosException;
import excepciones.MecanicoNoEncontradoException;
import excepciones.PlacaRepetidaException;
import modelo.SistemaTaller;
import persistencia.GestorJson;

public class SistemaTallerTest {

    // ==========================
    // MECÁNICOS
    // ==========================

    @Test
    public void sinMecanicosDevuelveCero() {

        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        assertEquals(0, sistema.cantidadMecanicos());

    }

    @Test
    public void agregarUnMecanicoIncrementaCantidad() {

        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        sistema.agregarMecanico("Juan", "Motor");

        assertEquals(1, sistema.cantidadMecanicos());

    }

    @Test
    public void agregarTresMecanicosDevuelveTres() {

        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        sistema.agregarMecanico("Juan", "Motor");
        sistema.agregarMecanico("Pedro", "Electricidad");
        sistema.agregarMecanico("Carlos", "Chasis");

        assertEquals(3, sistema.cantidadMecanicos());

    }

    @Test
    public void agregarMasDeDiezMecanicosLanzaExcepcion() {

        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        for (int i = 1; i <= 10; i++) {
            sistema.agregarMecanico("Mecanico" + i, "Motor");
        }

        assertThrows(
                LimiteMecanicosException.class,
                () -> sistema.agregarMecanico("Extra", "Frenos"));

    }

    // ==========================
    // AUTOS
    // ==========================

    @Test
    public void mecanicoSinAutosDevuelveCero() {

        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        sistema.agregarMecanico("Juan", "Motor");

        assertEquals(0, sistema.cantidadAutosPorMecanico(1));

    }

    @Test
    public void agregarUnAutoDevuelveUno() {

        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        sistema.agregarMecanico("Juan", "Motor");

        sistema.agregarAutoAMecanico(
                1,
                "ABC123",
                "Ford",
                "Fiesta");

        assertEquals(1, sistema.cantidadAutosPorMecanico(1));

    }

    @Test
    public void cantidadTotalAutosEsCorrecta() {

        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        sistema.agregarMecanico("Juan", "Motor");
        sistema.agregarMecanico("Pedro", "Electricidad");

        sistema.agregarAutoAMecanico(1, "AAA111", "Ford", "Fiesta");
        sistema.agregarAutoAMecanico(1, "BBB222", "Toyota", "Corolla");
        sistema.agregarAutoAMecanico(2, "CCC333", "VW", "Golf");

        assertEquals(3, sistema.cantidadTotalAutos());

    }

    @Test
    public void agregarAutoAMecanicoInexistenteLanzaExcepcion() {

        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        assertThrows(
                MecanicoNoEncontradoException.class,
                () -> sistema.agregarAutoAMecanico(
                        1,
                        "ABC123",
                        "Ford",
                        "Fiesta"));

    }

    @Test
    public void agregarPlacaRepetidaLanzaExcepcion() {

        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        sistema.agregarMecanico("Juan", "Motor");

        sistema.agregarAutoAMecanico(
                1,
                "ABC123",
                "Ford",
                "Fiesta");

        assertThrows(
                PlacaRepetidaException.class,
                () -> sistema.agregarAutoAMecanico(
                        1,
                        "ABC123",
                        "Toyota",
                        "Corolla"));

    }

    @Test
    public void agregarMasDeDiezAutosLanzaExcepcion() {

        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        sistema.agregarMecanico("Juan", "Motor");

        for (int i = 1; i <= 10; i++) {

            sistema.agregarAutoAMecanico(
                    1,
                    "PLACA" + i,
                    "Ford",
                    "Fiesta");

        }

        assertThrows(
                LimiteAutosException.class,
                () -> sistema.agregarAutoAMecanico(
                        1,
                        "PLACA11",
                        "Toyota",
                        "Corolla"));

    }

    @Test
    public void sinAutosCantidadTotalEsCero() {

        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        sistema.agregarMecanico("Juan", "Motor");
        sistema.agregarMecanico("Pedro", "Electricidad");

        assertEquals(0, sistema.cantidadTotalAutos());

    }

    // ==========================
    // PERSISTENCIA
    // ==========================

    @Test
    public void guardarYCargarSistemaConservaCantidadMecanicos() {

        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        sistema.agregarMecanico("Juan", "Motor");
        sistema.agregarMecanico("Pedro", "Electricidad");

        GestorJson gestor = new GestorJson();

        gestor.guardarSistema(sistema, "test.json");

        SistemaTaller recuperado = gestor.cargarSistema("test.json");

        assertEquals(2, recuperado.cantidadMecanicos());

    }

    @Test
    public void guardarYCargarSistemaConservaCantidadAutos() {

        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        sistema.agregarMecanico("Juan", "Motor");

        sistema.agregarAutoAMecanico(
                1,
                "ABC123",
                "Ford",
                "Fiesta");

        GestorJson gestor = new GestorJson();

        gestor.guardarSistema(sistema, "test.json");

        SistemaTaller recuperado = gestor.cargarSistema("test.json");

        assertEquals(1, recuperado.cantidadTotalAutos());

    }

}