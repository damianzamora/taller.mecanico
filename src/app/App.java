package app;

import modelo.SistemaTaller;
import persistencia.GestorJson;

public class App {

        public static void main(String[] args) {

                SistemaTaller sistema = new SistemaTaller("Mi Taller", "19/06/2026");

                // Agregar mecanicos

                sistema.agregarMecanico(1, "Juan", "Motor");
                sistema.agregarMecanico(2, "Damian", "Motor");
                sistema.agregarMecanico(3, "Rodolfo", "Chasis");

                 
                // Validacion : Agregar mecanico sin nombre 
                // sistema.agregarMecanico(3, "Chasis"); 
                

                //Validacion: arroja excepcion cuando crea mas de 10 mecanicos (LimiteMecanicosException)

/*                 sistema.agregarMecanico(4, "Juan", "Motor");
                sistema.agregarMecanico(5, "Damian", "Motor");
                sistema.agregarMecanico(6, "Rodolfo", "Chasis");
                sistema.agregarMecanico(7, "Juan", "Motor");
                sistema.agregarMecanico(8, "Damian", "Motor");
                sistema.agregarMecanico(9, "Rodolfo", "Chasis");
                sistema.agregarMecanico(10, "Juan", "Motor");
                sistema.agregarMecanico(11, "Damian", "Motor"); */
                
                
                
                //Validacion: Arroja excepcion creacion de mecanico repetido (IdRepetidoException)
                //sistema.agregarMecanico(3, "Rodolfo", "Chasis"); 
                

                // Agregar auto a mecanicos

                sistema.agregarAutoAMecanico(
                                1,
                                "ABC123",
                                "Ford",
                                "Fiesta");

                
                sistema.agregarAutoAMecanico(
                                2,
                                "AA503YV",
                                "Peugeot",
                                "208");    
                                
                sistema.agregarAutoAMecanico(
                                3,
                                "AA600AA",
                                "BMW",
                                "120i");            
                                
                
                // Validacion: Agregar un auto a un mecanico inexistente (MecanicoNoEncontradoException)
                /* sistema.agregarAutoAMecanico(
                                4,
                                "AA600AA",
                                "BMW",
                                "120i"); */

                // Validacion: Agregar mas de 10 autos para un mecanico (LimiteAutosException)
                
/*                 sistema.agregarAutoAMecanico(
                                1,
                                "ABC124",
                                "Ford",
                                "Fiesta");

                sistema.agregarAutoAMecanico(
                                1,
                                "ABC125",
                                "Ford",
                                "Fiesta");

                sistema.agregarAutoAMecanico(
                                1,
                                "ABC126",
                                "Ford",
                                "Fiesta");

                sistema.agregarAutoAMecanico(
                                1,
                                "ABC127",
                                "Ford",
                                "Fiesta");

                sistema.agregarAutoAMecanico(
                                1,
                                "ABC128",
                                "Ford",
                                "Fiesta");

                sistema.agregarAutoAMecanico(
                                1,
                                "ABC129",
                                "Ford",
                                "Fiesta");

                sistema.agregarAutoAMecanico(
                                1,
                                "ABC130",
                                "Ford",
                                "Fiesta");

                sistema.agregarAutoAMecanico(
                                1,
                                "ABC131",
                                "Ford",
                                "Fiesta");

                sistema.agregarAutoAMecanico(
                                1,
                                "ABC132",
                                "Ford",
                                "Fiesta");

                sistema.agregarAutoAMecanico(
                                1,
                                "ABC133",
                                "Ford",
                                "Fiesta");

                sistema.agregarAutoAMecanico(
                                1,
                                "ABC134",
                                "Ford",
                                "Fiesta");

                sistema.agregarAutoAMecanico(
                                1,
                                "ABC135",
                                "Ford",
                                "Fiesta");

                sistema.agregarAutoAMecanico(
                                1,
                                "ABC135",
                                "Ford",
                                "Fiesta"); */
                                               
                GestorJson gestor = new GestorJson();

                // Guardar
                gestor.guardarSistema(sistema, "datos.json");

                System.out.println();
                System.out.println("===== RESUMEN DEL SISTEMA =====");
                System.out.println("Cantidad de mecanicos: " + sistema.cantidadMecanicos());
                System.out.println("Cantidad total de autos reparados: "+ sistema.cantidadTotalAutos());

                // Resultado en consola 

                // SistemaTaller sistemaLeido = gestor.cargarSistema("datos.json");
                //System.out.println("Sistema recuperado desde JSON:");
                //System.out.println(sistemaLeido);

        }

}
