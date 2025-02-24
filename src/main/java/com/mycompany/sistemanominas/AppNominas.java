package com.mycompany.sistemanominas;

import java.io.IOException;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.SimpleFormatter;

public class AppNominas {

    private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(SistemaNominas.class.getName());

    public static void main(String[] args) throws DniException, IOException {
        Scanner teclado = new Scanner(System.in);
        SistemaNominas sn = new SistemaNominas();
        int opcion = 0;
        String nombre;
        Empleado empleado;
        String dni;
        float salario;
        int horas = 0;

        Handler controlador = new FileHandler("./registro.log", true);
        LogManager.getLogManager().readConfiguration(ClassLoader.getSystemClassLoader().getResourceAsStream("mylogging.properties"));
        // controlador.setFormatter(new SimpleFormatter);
        LOG.addHandler(controlador);

        //sirve para que el formato de log salga simple en lugar de en xml
        Formatter formateador = new SimpleFormatter();
        controlador.setFormatter(formateador);

        do {
            System.out.println("1. Crear empleado fijo");
            System.out.println("2. Crear empleado eventual");
            System.out.println("3. Consultar empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Listar empleados");
            System.out.println("6. Listar empleados por sueldo");
            System.out.println("7. Consultar total salarios");
            System.out.println("0. Salir");
            System.out.println("Introduce una opcion:");

            try {
                opcion = teclado.nextInt();
                LOG.log(Level.INFO, "Opcion seleccionada: {0}", opcion); //registra la opcion que el usuario ha seleccionado
            } catch (InputMismatchException ime) {

                opcion = 1000;
            }

            teclado.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Introduce DNI:");
                    dni = teclado.nextLine();

                    System.out.println("Introduce nombre:");
                    nombre = teclado.nextLine();
                    LOG.log(Level.INFO, "Nombre introducido: {0}", nombre);

                    try {
                        System.out.println("Introduce salario:");
                        salario = teclado.nextFloat();
                        LOG.log(Level.INFO, "Salario introducido: {0}", salario);

                        teclado.nextLine();
                        if (sn.incluirEmpleado(new EmpleadoFijo(Dni.valueOf(dni), nombre, salario))) {
                            System.out.println("Empleado fijo añadido al sistema de nóminas.");
                        } else {
                            System.out.println("No se ha podido añadir el empleado.");
                        }
                    } catch (DniException | IllegalFormatException | InputMismatchException ex) {
                        System.out.println(ex.getMessage());
                        LOG.warning(Arrays.toString(ex.getStackTrace())); //sirve para ver la ruta completa de donde ha sucedido el error. El error no solo ocurre en el main, es por eso que se guarda la ruta para saber de dónde ha procedido el error que ha dado
                    }

                }

                case 2 -> {
                    System.out.println("Introduce DNI:");
                    dni = teclado.nextLine();
                    System.out.println("Introduce nombre:");
                    nombre = teclado.nextLine();

                    try {
                        System.out.println("Introduce salario:");
                        salario = teclado.nextFloat();
                        LOG.log(Level.INFO, "Salario introducido: {0}", salario);

                        teclado.nextLine();
                        if (sn.incluirEmpleado(new EmpleadoEventual(Dni.valueOf(dni), nombre, nombre, salario, horas))) {
                            System.out.println("Empleado fijo añadido al sistema de nóminas.");
                        } else {
                            System.out.println("No se ha podido añadir el empleado.");
                        }
                    } catch (DniException | IllegalFormatException | InputMismatchException ex) {
                        System.out.println(ex.getMessage());
                        LOG.warning(Arrays.toString(ex.getStackTrace()));
                    }
                }

                case 3 -> {
                    try {
                        System.out.println("Introduce el DNI del empleado:");
                        dni = teclado.nextLine();
                        LOG.log(Level.INFO, "DNI introducido: {0}", dni);

                        empleado = sn.getEmpleado(dni);
                        if (empleado != null) {
                            System.out.println(empleado);
                        } else {
                            System.out.println("Empleado no encontrado.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al consultar el empleado.");
                        LOG.warning(Arrays.toString(e.getStackTrace()));
                    }
                }

                case 4 -> {
                    try {
                        System.out.println("Introduce el DNI del empleado a eliminar:");
                        dni = teclado.nextLine();
                        empleado = sn.getEmpleado(dni);
                        if (empleado != null) {
                            System.out.println("Empleado a eliminar: " + empleado);
                            System.out.println("¿Estás seguro de eliminarlo? (Si/No):");
                            String respuesta = teclado.nextLine();
                            if (respuesta.equalsIgnoreCase("si")) {
                                if (sn.eliminarEmpleado(empleado)) {
                                    System.out.println("Empleado eliminado.");
                                } else {
                                    System.out.println("No se ha podido eliminar el empleado.");
                                }
                            }
                        } else {
                            System.out.println("Empleado no encontrado.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al eliminar el empleado.");
                        LOG.warning(Arrays.toString(e.getStackTrace()));
                    }
                }

                case 5 -> {
                    try {
                        System.out.println("Lista de empleados:");
                        for (Empleado e : sn.listarEmpleados()) {
                            System.out.println(e);
                        }
                    } catch (Exception e) {
                        System.out.println("Error al listar los empleados.");
                    }
                }

                case 6 -> {
                    try {
                        System.out.println("Lista de empleados por sueldo:");
                        for (Empleado e : sn.listarEmpleadosPorSueldo()) {
                            System.out.println(e);
                        }
                    } catch (Exception e) {
                        System.out.println("Error al listar los empleados por sueldo.");
                    }
                }

                case 7 -> {
                    try {
                        System.out.println("Total salarios: " + sn.getTotalSalarios());
                    } catch (Exception e) {
                        System.out.println("Error al consultar el total de salarios.");
                    }
                }

                case 0 -> {
                    System.out.println("¡Adiós!");
                }

                default -> {
                    System.out.println("Error: Opción no válida.");
                }

            }
        } while (opcion != 0);
    }
}
