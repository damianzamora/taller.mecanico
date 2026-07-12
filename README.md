# Sistema de Administración de Taller

Trabajo Práctico Final - Programación II

## Descripción

Sistema desarrollado en Java para la administración de un taller mecánico.

Permite administrar un conjunto de mecánicos y los vehículos reparados por cada uno de ellos, utilizando Programación Orientada a Objetos, interfaces, colecciones HashMap, manejo de excepciones personalizadas, persistencia en archivos JSON y pruebas unitarias.

---

## Funcionalidades

- Alta de mecánicos.
- Alta de autos reparados.
- Asociación de autos a cada mecánico.
- Consulta de la cantidad de mecánicos.
- Consulta de la cantidad total de autos reparados.
- Visualización completa del sistema.
- Persistencia de datos en formato JSON.
- Recuperación de datos desde archivo JSON.
- Manejo de excepciones personalizadas.
- Menú interactivo por consola.
- Modo demostración automática.

---

## Tecnologías utilizadas

- Java
- Visual Studio Code
- Gson 2.8.2
- JUnit 5
- Hamcrest

---

## Estructura del proyecto

```
src
│
├── app
│   └── App.java
│
├── modelo
│   ├── Auto.java
│   ├── Mecanico.java
│   └── SistemaTaller.java
│
├── interfaces
│   └── ISistemaTaller.java
│
├── persistencia
│   └── GestorJson.java
│
├── excepciones
│   ├── LimiteMecanicosException.java
│   ├── LimiteAutosException.java
│   ├── NombreVacioException.java
│   └── MecanicoNoEncontradoException.java
│
├── vista
│   └── Menu.java
│
└── test
    └── SistemaTallerTest.java
```

---

## Conceptos aplicados

Durante el desarrollo del proyecto se utilizaron los siguientes conceptos:

- Programación Orientada a Objetos.
- Encapsulamiento.
- Polimorfismo mediante interfaces.
- Interfaces e implementación.
- HashMap.
- Excepciones personalizadas.
- Persistencia de datos.
- Serialización y deserialización con Gson.
- Pruebas unitarias con JUnit.
- Organización del proyecto por paquetes.

---

## Persistencia

El sistema permite guardar y recuperar toda la información utilizando archivos JSON mediante la librería Gson.

Archivo utilizado:

```
datos.json
```

---

## UML

El proyecto incluye el diagrama UML desarrollado con PlantUML.

Archivo:

```
SistemaTaller.puml
```

---

## Ejecución

Al iniciar la aplicación se presenta un menú con las siguientes opciones:

```
1 - Crear un sistema nuevo

2 - Cargar sistema desde archivo JSON

3 - Ejecutar demostración automática

0 - Salir
```

Una vez creado o cargado el sistema se accede al menú principal donde pueden realizarse todas las operaciones disponibles.

---

# Historial de versiones

## Versión 1

Se desarrolló la estructura principal del sistema cumpliendo con la consigna del trabajo práctico.

### Características

- Diseño de las clases del modelo.
- Implementación de la interfaz `ISistemaTaller`.
- Administración de mecánicos mediante `HashMap`.
- Administración de autos reparados por cada mecánico.
- Uso de un segundo `HashMap` dentro de la clase `Mecanico`.
- Implementación de invariantes de representación.
- Manejo de excepciones personalizadas.
- Persistencia mediante archivos JSON utilizando Gson.
- Carga y recuperación de datos.
- Pruebas unitarias con JUnit.
- Documentación UML mediante PlantUML.
- Documentación del proyecto mediante README.

---

## Versión 2

Se incorporaron mejoras orientadas a la experiencia del usuario sin modificar la lógica de negocio del sistema.

### Mejoras incorporadas

- Incorporación de una nueva capa de presentación (`vista`).
- Creación de la clase `Menu`.
- Menú interactivo por consola.
- Separación entre interfaz de usuario y lógica de negocio.
- Opción para crear un sistema nuevo vacío.
- Opción para cargar un sistema desde JSON.
- Opción de demostración automática.
- Generación automática del ID de los mecánicos.
- Eliminación del ingreso manual del ID.
- Visualización amigable del sistema.
- Visualización de mecánicos disponibles antes de agregar un auto.
- Validaciones de ingreso de datos desde el menú.
- Manejo amigable de errores al cargar archivos inexistentes.
- Actualización automática del archivo JSON durante la demostración.
- Mejor organización del flujo de ejecución.
- Mejor experiencia de uso de la aplicación.

---

## Autor

Desarrollado como Trabajo Práctico Final para la materia Programación II.

