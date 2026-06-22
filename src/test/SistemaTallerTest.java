package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import excepciones.IdRepetidoException;
import excepciones.LimiteAutosException;
import excepciones.LimiteMecanicosException;
import excepciones.MecanicoNoEncontradoException;
import excepciones.PlacaRepetidaException;
import modelo.SistemaTaller;

public class SistemaTallerTest {

    @Test
    public void sinMecanicosDevuelveCero() {
        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        int valorEsperado = 0;
        int valorObtenido = sistema.cantidadMecanicos();

        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void unMecanicoDevuelveUno() {
        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        sistema.agregarMecanico(1, "Juan", "Motor");

        int valorEsperado = 1;
        int valorObtenido = sistema.cantidadMecanicos();

        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void sistemaConUnMecanicoExisteMecanicoDevuelveTrue() {
        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        sistema.agregarMecanico(1, "Juan", "Motor");

        boolean valorEsperado = true;
        boolean valorObtenido = sistema.existeMecanico(1);

        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void unAutoEnUnMecanicoDevuelveUno() {
        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        sistema.agregarMecanico(1, "Juan", "Motor");

        sistema.agregarAutoAMecanico(
                1,
                "ABC123",
                "Ford",
                "Fiesta");

        int valorEsperado = 1;
        int valorObtenido = sistema.cantidadAutosPorMecanico(1);

        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void tresAutosEnTotalDevuelvenTres() {
        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        sistema.agregarMecanico(1, "Juan", "Motor");
        sistema.agregarMecanico(2, "Pedro", "Electricidad");

        sistema.agregarAutoAMecanico(1, "ABC123", "Ford", "Fiesta");
        sistema.agregarAutoAMecanico(1, "XYZ456", "Toyota", "Corolla");
        sistema.agregarAutoAMecanico(2, "AAA111", "Volkswagen", "Golf");

        int valorEsperado = 3;
        int valorObtenido = sistema.cantidadTotalAutos();

        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void dosMecanicosConDosAutosCadaUnoDevuelvenCuatroAutosTotales() {
        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        sistema.agregarMecanico(1, "Juan", "Motor");
        sistema.agregarMecanico(2, "Pedro", "Electricidad");

        sistema.agregarAutoAMecanico(1, "AAA111", "Ford", "Fiesta");
        sistema.agregarAutoAMecanico(1, "BBB222", "Toyota", "Corolla");

        sistema.agregarAutoAMecanico(2, "CCC333", "VW", "Golf");
        sistema.agregarAutoAMecanico(2, "DDD444", "Chevrolet", "Cruze");

        int valorEsperado = 4;
        int valorObtenido = sistema.cantidadTotalAutos();

        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void agregarIdRepetidoLanzaExcepcion() {
        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        sistema.agregarMecanico(1, "Juan", "Motor");

        assertThrows(
                IdRepetidoException.class,
                () -> sistema.agregarMecanico(1, "Pedro", "Electricidad"));
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

        sistema.agregarMecanico(1, "Juan", "Motor");

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
    public void agregarMasDeDiezMecanicosLanzaExcepcion() {
        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        for (int i = 1; i <= 10; i++) {
            sistema.agregarMecanico(i, "Mecanico" + i, "Motor");
        }

        assertThrows(
                LimiteMecanicosException.class,
                () -> sistema.agregarMecanico(11, "Extra", "Frenos"));
    }

    @Test
    public void agregarMasDeDiezAutosAMecanicoLanzaExcepcion() {
        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        sistema.agregarMecanico(1, "Juan", "Motor");

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
    public void mecanicoSinAutosDevuelveCeroAutos() {
        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        sistema.agregarMecanico(1, "Juan", "Motor");

        int valorEsperado = 0;
        int valorObtenido = sistema.cantidadAutosPorMecanico(1);

        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void sinAutosEnElSistemaLaCantidadTotalEsCero() {
        SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

        sistema.agregarMecanico(1, "Juan", "Motor");
        sistema.agregarMecanico(2, "Pedro", "Electricidad");

        int valorEsperado = 0;
        int valorObtenido = sistema.cantidadTotalAutos();

        assertEquals(valorEsperado, valorObtenido);
    }
}