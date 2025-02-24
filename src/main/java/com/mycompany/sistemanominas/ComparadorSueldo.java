package com.mycompany.sistemanominas;

import java.util.Comparator;

public class ComparadorSueldo implements Comparator<Empleado> {

    /**
     *
     * @param e1
     * @param e2
     * @return
     */
    @Override
    public int compare(Empleado e1, Empleado e2) {
        return Float.compare(e1.ingresos(), e2.ingresos());
    }
}
