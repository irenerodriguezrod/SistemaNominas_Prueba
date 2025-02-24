/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemanominas;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 
 */
public class Dni implements Comparable<Dni> {

    private String dni;
    private static final Logger LOG = Logger.getLogger(Dni.class.getName());

    private Dni(String dni) throws DniException {
        if (!esValido(dni)) {
            throw new DniException("Formato incorrecto");
        }
        this.dni = dni;
    }

    /**
     *
     * @return
     */
    public String getDni() {
        return dni;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return dni;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.dni);
        return hash;
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
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dni other = (Dni) obj;
        return Objects.equals(this.dni, other.dni);
    }

    /**
     *
     * @param dni
     * @return
     * @throws DniException
     */
    public static Dni valueOf(String dni) throws DniException {
        if (!esValido(dni)) {
            LOG.log(Level.WARNING, "Formato DNI incorrecto", dni);
            throw new DniException("Formato incorrecto");
        }
        return new Dni(dni);
    }

    /**
     *
     * @param dni
     * @return
     */
    public static boolean esValido(String dni) {

        boolean valido = false;
        String letrasDni = "TRWAGMYFPDXBNJZSQVHLCKE";
        String patron = "([0-9]{8})([A-Z])";
        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(dni);
        if ((m.matches())) {
            int resto = Integer.parseInt(m.group(1)) % 23;
            valido = m.group(2).charAt(0) == letrasDni.charAt(resto);
        }
        return valido;

    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Dni o) {
        return this.dni.compareTo(o.dni);
    }
}
