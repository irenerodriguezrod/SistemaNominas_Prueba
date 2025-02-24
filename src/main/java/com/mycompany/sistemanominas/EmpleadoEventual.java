package com.mycompany.sistemanominas;

import java.util.logging.Logger;

/**
 * Clase que representa un empleado eventual con salario por horas
 * @author irene.rodrod.2
 */
public class EmpleadoEventual extends Empleado{
    private float salarioHora;
    private int horas;
    private static final Logger LOG = Logger.getLogger(EmpleadoEventual.class.getName());

    /**
     *
     * @param dni
     * @param nombre
     * @param nombre1
     * @param salarioHora
     * @param horas
     */
    public EmpleadoEventual(Dni dni,String nombre, String nombre1, float salarioHora, int horas) {
        super(dni, nombre);
        this.salarioHora = salarioHora;
        this.horas = horas;
    }

    public float getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(float salarioHora) {
        this.salarioHora = salarioHora;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public Dni getDni() {
        return dni;
    }

    @Override
    public void setDni(Dni dni) {
        this.dni = dni;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "," + salarioHora + "," + horas;
    }

    /**
     *
     * @return
     */
    @Override
    public float ingresos() {
        return salarioHora*horas;
    }
    
}
