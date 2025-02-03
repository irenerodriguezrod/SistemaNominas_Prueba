package com.mycompany.sistemanominas;

import java.util.Objects;

/**
 *
 * @author irene.rodrod.2
 */

public abstract class Empleado implements Comparable<Empleado>{
    
    private String dni;
    private String nombre;
    
    public Empleado() {
        
    }
    
    public Empleado(String dni){
        this.dni = dni;
    }
    
    public Empleado(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return dni + "," + nombre;
    }

    @Override
    public int compareTo(Empleado o) {
        return this.dni.compareTo(o.dni);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        return Objects.equals(this.dni, other.dni);
    }  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.dni);
        return hash;
    }
    
    public abstract float ingresos();

}
