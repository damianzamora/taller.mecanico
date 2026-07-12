package vista;

import java.util.Scanner;

import modelo.SistemaTaller;
import persistencia.GestorJson;

public class Menu {

    private Scanner scanner;
    private SistemaTaller sistema;
    private GestorJson gestor;

    public Menu() {
        scanner = new Scanner(System.in);
        gestor = new GestorJson();
    }

    public void iniciar() {

        int opcion;

        do {

            mostrarMenuInicial();

            opcion = leerEntero();

            switch (opcion) {

                case 1:
                    crearSistemaNuevo();
                    mostrarMenuPrincipal();
                    break;

                case 2:
                    cargarSistema();
                    mostrarMenuPrincipal();
                    break;

                case 3:
                    ejecutarDemostracion();
                    mostrarMenuPrincipal();
                    break;

                case 0:
                    System.out.println("\nHasta luego.");
                    break;

                default:
                    System.out.println("\nOpción inválida.");

            }

        } while (opcion != 0);

    }

    private void mostrarMenuInicial() {

        System.out.println();
        System.out.println("===========================================");
        System.out.println("   SISTEMA DE ADMINISTRACIÓN DE TALLER");
        System.out.println("===========================================");
        System.out.println("1 - Crear un sistema nuevo (comienza sin datos)");
        System.out.println("2 - Cargar sistema existente desde datos.json");
        System.out.println("3 - Ejecutar demostración automática");
        System.out.println("0 - Salir");
        System.out.print("\nSeleccione una opción: ");

    }

    private int leerEntero() {

        while (!scanner.hasNextInt()) {

            System.out.println("Debe ingresar un número.");

            scanner.next();

            System.out.print("Intente nuevamente: ");

        }

        int numero = scanner.nextInt();

        scanner.nextLine();

        return numero;

    }

    // Opcion 1
    private void crearSistemaNuevo() {

        sistema = new SistemaTaller(
                "Mi Taller",
                "19/06/2026");

        System.out.println("\nSistema creado correctamente.");

    }

    // Opcion 2
    private void cargarSistema() {

        try {

            sistema = gestor.cargarSistema("datos.json");

            if (sistema == null) {

                System.out.println("\nNo se pudo cargar el sistema.");

            } else {

                System.out.println("\nSistema cargado correctamente.");

            }

        } catch (Exception e) {

            System.out.println("\nError al cargar el archivo JSON.");

            sistema = null;

        }

    }

    // Opcion 3
    private void ejecutarDemostracion() {

        sistema = new SistemaTaller(
                "Mi Taller",
                "19/06/2026");

        sistema.agregarMecanico("Juan", "Motor");
        sistema.agregarMecanico("Damian", "Motor");
        sistema.agregarMecanico("Rodolfo", "Chasis");

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

        gestor.guardarSistema(sistema, "datos.json");        

        System.out.println("\nDemostración cargada correctamente.");

    }

    private void mostrarMenuPrincipal() {

        int opcion;

        do {

            System.out.println();
            System.out.println("===========================================");
            System.out.println("            MENÚ PRINCIPAL");
            System.out.println("===========================================");
            System.out.println("1 - Agregar mecánico");
            System.out.println("2 - Agregar auto a un mecánico");
            System.out.println("3 - Mostrar sistema");
            System.out.println("4 - Mostrar cantidad de mecánicos");
            System.out.println("5 - Mostrar cantidad total de autos");
            System.out.println("6 - Guardar sistema");
            System.out.println("7 - Cargar sistema");
            System.out.println("0 - Volver al menú inicial");

            System.out.print("\nSeleccione una opción: ");

            opcion = leerEntero();

            switch (opcion) {

                case 1:
                    agregarMecanico();
                    break;

                case 2:
                    agregarAuto();
                    break;

                case 3:
                    sistema.mostrarSistema();
                    break;

                case 4:
                    System.out.println("\nCantidad de mecánicos: "
                            + sistema.cantidadMecanicos());
                    break;

                case 5:
                    System.out.println("\nCantidad total de autos: "
                            + sistema.cantidadTotalAutos());
                    break;

                case 6:
                    gestor.guardarSistema(sistema, "datos.json");
                    System.out.println("\nSistema guardado correctamente.");
                    break;

                case 7:
                    sistema = gestor.cargarSistema("datos.json");
                    System.out.println("\nSistema cargado correctamente.");
                    break;

                case 0:
                    System.out.println("\nVolviendo al menú inicial...");
                    break;

                default:
                    System.out.println("\nOpción inválida.");
            }

        } while (opcion != 0);

    }

    private void agregarMecanico() {

        System.out.println();
        System.out.println("========== AGREGAR MECÁNICO ==========");

        String nombre;

        do {

            System.out.print("Nombre: ");
            nombre = scanner.nextLine().trim();

            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            }

        } while (nombre.isEmpty());

        String especialidad;

        do {

            System.out.print("Especialidad: ");
            especialidad = scanner.nextLine().trim();

            if (especialidad.isEmpty()) {
                System.out.println("La especialidad no puede estar vacía.");
            }

        } while (especialidad.isEmpty());

        try {

            sistema.agregarMecanico(nombre, especialidad);

            System.out.println("\nMecánico agregado correctamente.");

        } catch (RuntimeException e) {

            System.out.println("\nError: " + e.getMessage());

        }

    }

    private void agregarAuto() {

        System.out.println();
        System.out.println("========== AGREGAR AUTO ==========");

        sistema.mostrarMecanicos();

        System.out.print("ID del mecánico: ");
        int id = leerEntero();

        String patente;
        do {
            System.out.print("Patente: ");
            patente = scanner.nextLine().trim();

            if (patente.isEmpty()) {
                System.out.println("La patente no puede estar vacía.");
            }

        } while (patente.isEmpty());

        String marca;
        do {
            System.out.print("Marca: ");
            marca = scanner.nextLine().trim();

            if (marca.isEmpty()) {
                System.out.println("La marca no puede estar vacía.");
            }

        } while (marca.isEmpty());

        String modelo;
        do {
            System.out.print("Modelo: ");
            modelo = scanner.nextLine().trim();

            if (modelo.isEmpty()) {
                System.out.println("El modelo no puede estar vacío.");
            }

        } while (modelo.isEmpty());

        try {

            sistema.agregarAutoAMecanico(
                    id,
                    patente,
                    marca,
                    modelo);

            System.out.println("\nAuto agregado correctamente.");

        } catch (RuntimeException e) {

            System.out.println("\nError: " + e.getMessage());

        }

    }

}