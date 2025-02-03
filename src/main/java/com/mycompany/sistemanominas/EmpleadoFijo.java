package com.mycompany.sistemanominas;

/**
 *
 * @author irene.rodrod.2
 */
public abstract class EmpleadoFijo extends Empleado {
    private float salario;

    public EmpleadoFijo(){
    
    }
    
    public EmpleadoFijo(String dni){
        super(dni);
    }
    
    public EmpleadoFijo(String dni, String nombre, float salario){
        super(dni, nombre);
        this.salario=salario;
    }

    @Override
    public String toString() {
        return "EmpleadoFijo{" + "salario=" + salario + '}';
    }
    
    @Override
    public abstract float ingresos();
    
}
