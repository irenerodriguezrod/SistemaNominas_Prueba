package com.mycompany.sistemanominas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * Clase SistemaNominas para gestionar empleados en un sistema de nóminas.
 *
 * @author irene.rodrod.2
 * @version 1.0
 */
public class SistemaNominas {

    private TreeMap<String, Empleado> empleados;

    /**
     *
     */
    public SistemaNominas() {
        empleados = new TreeMap<>();
    }

    /**
     *
     * @return
     */
    public TreeMap<String, Empleado> getEmpleados() {
        return empleados;
    }

    /**
     *
     * @param empleados
     */
    public void setEmpleados(TreeMap<String, Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     *
     * @param empleado
     * @return
     */
    public boolean incluirEmpleado(Empleado empleado) {
        
        return (empleados.putIfAbsent(empleado.getDni().toString(), empleado) == null);
    }

    /**
     *
     * @param dni
     * @return
     */
    public Empleado getEmpleado(String dni) {
        return empleados.get(dni);
    }

    /**
     *
     * @param empleado
     * @return
     */
    public boolean eliminarEmpleado(Empleado empleado) {
        return (empleados.remove(empleado.getDni().toString()) != null);
    }

    /**
     *
     * @return
     */
    public List<Empleado> listarEmpleados() {
        return new ArrayList<>(empleados.values());
    }

    /**
     *
     * @return
     */
    public List<Empleado> listarEmpleadosPorSueldo() {
        List<Empleado> salida = new ArrayList<>(empleados.values());
        Collections.sort(salida, new ComparadorSueldo());
        return salida;
    }

    /**
     *
     * @return
     */
    public List<Empleado> listarEmpleadosPorNombre() {
        List<Empleado> salida = new ArrayList<>(empleados.values());

        salida.sort(Comparator.comparing(Empleado::getNombre));
        return salida;
    }

    /**
     *
     * @return
     */
    public float getTotalSalarios() {
        float acumulador = 0;

        for (Empleado c : empleados.values()) {
            acumulador += c.ingresos();
        }
        return acumulador;
    }
}

