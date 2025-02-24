package com.mycompany.sistemanominas;

import java.util.Objects;

/**
 * Clase empleado, la cual contiene la información de este. Implementa Comparable para comparar empleados por DNI.
 *
 * @author irene
 * @version 1.0
 */
public abstract class Empleado implements Comparable<Empleado> {
    Dni dni;
    private String nombre;

    /**
     *
     */
    public Empleado() {
    }

    /**
     *
     * @param dni
     */
    public Empleado(Dni dni) {
        this.dni = dni;
    }

    /**
     *
     * @param dni
     * @param nombre
     */
    public Empleado(Dni dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public Dni getDni() {
        return dni;
    }

    /**
     *
     * @param dni
     */
    public void setDni(Dni dni) {
        this.dni = dni;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return dni + nombre ;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(dni, nombre);
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Empleado other = (Empleado) obj;
        return Objects.equals(dni, other.dni) && Objects.equals(nombre, other.nombre);
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Empleado o) {
        return this.dni.compareTo(o.dni);
    }

    /**
     *
     * @return
     */
    public abstract float ingresos();
}