package app;

import modelo.SistemaTaller;
import persistencia.GestorJson;

public class App {

        public static void main(String[] args) {

                SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

                sistema.agregarMecanico(1, "Juan", "Motor");

                sistema.agregarAutoAMecanico(
                                1,
                                "ABC123",
                                "Ford",
                                "Fiesta");

                sistema.agregarMecanico(2, "Damian", "Motor");

                sistema.agregarAutoAMecanico(
                                2,
                                "AA503YV",
                                "Peugeot",
                                "208");                

                GestorJson gestor = new GestorJson();

                // Guardar
                gestor.guardarSistema(sistema, "datos.json");

                // Leer
                SistemaTaller sistemaLeido = gestor.cargarSistema("datos.json");

                System.out.println("Sistema recuperado desde JSON:");

                System.out.println(sistemaLeido);

        }

}
