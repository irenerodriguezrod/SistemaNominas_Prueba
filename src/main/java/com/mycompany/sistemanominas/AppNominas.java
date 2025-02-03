package com.mycompany.sistemanominas;

import java.util.Scanner;

/**
 *
 * @author irene.rodrod.2
 */
public class AppNominas {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String dni, nombre;
        int opcion;
        int opcion2;

        empleado = new Empleado();

        do {
            System.out.println("1.- Crear empleado.");
            System.out.println("2.- Consultar empleado.");
            System.out.println("3.- Eliminar empleado.");
            System.out.println("4.- Listar empleados.");
            System.out.println("5.- Listar empleados por sueldo.");
            System.out.println("6.- Consultar total salarios.");
            System.out.println("0.- Salir.");
            System.out.print("Introduzca opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();
            if (opcion >= 1 && opcion <= 6) {
                switch (opcion) {
                    case 1 -> {
                        if (dni == null) {
                            do {
                                System.out.println("1- Crear empleado fijo.");
                                System.out.println("2- Crear empleado eventual.");
                                System.out.println("0- Salir");
                                System.out.println("Introduzca su opcion");

                                opcion2 = teclado.nextInt();
                                teclado.nextLine();

                                switch (opcion2) {
                                    case 1 -> {

                                    }
                                    case 2 -> {

                                    }
                                    case 0 -> {
                                        System.out.println("Adios.");
                                    }

                                    default -> {
                                        System.out.println("Error en la opción.");
                                    }
                                }
                            } while (opcion != 0);   
                        }else {
                            System.out.println("Ya existe un empleado con ese DNI");
                            }
                    }

                    case 2 -> {
                        System.out.println("Introduzca DNI del empleado: ");
                        dni = teclado.nextLine();
                    }
                    case 3 -> {
                        System.out.println("Introduzca DNI del empleado: ");
                        dni = teclado.nextLine();
                    }
                    case 4 -> {

                    }
                    case 5 -> {

                    }
                    case 6 -> {

                    }
                    case 0 -> {
                    }
                    default -> {
                    }
                }

            } else {
                System.out.println("No existe un contacto con ese nombre");
            }
        } while (opcion != 0);
    }
}
