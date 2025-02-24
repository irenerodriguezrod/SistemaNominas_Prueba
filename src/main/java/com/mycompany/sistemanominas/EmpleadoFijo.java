package com.mycompany.sistemanominas;

/**
 * Clase que representa un empleado fijo con salario mensual
 * @author irene.rodrod.2
 */
public class EmpleadoFijo extends Empleado {
    private float salario;

    /**
     *
     * @param dni
     * @param nombre
     * @param salario
     */
    public EmpleadoFijo(Dni dni, String nombre,float salario) {
        super(dni, nombre);
        this.salario = salario;
    }

    /**
     *
     * @return
     */
    public float getSalario() {
        return salario;
    }

    /**
     *
     * @param salario
     */
    public void setSalario(float salario) {
        this.salario = salario;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString()+","+salario;
    }
    
    /**
     *
     * @return
     */
    @Override
    public float ingresos() {
        return salario;
    }
    
}