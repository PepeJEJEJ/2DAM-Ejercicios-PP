/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluableb2.modelo;

/**
 *
 * @author PC128
 */

import java.util.Date;

public class Gasto {

    private Date fecha;
    private String nombre;
    private String categoria;
    private double importe;
    private boolean imprescindible;

    public Gasto(Date fecha, String nombre, String categoria,
            double importe, boolean imprescindible) {

        this.fecha = fecha;
        this.nombre = nombre;
        this.categoria = categoria;
        this.importe = importe;
        this.imprescindible = imprescindible;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getImporte() {
        return importe;
    }

    public boolean isImprescindible() {
        return imprescindible;
    }

    @Override
    public String toString() {

        return nombre + " | "
                + categoria + " | "
                + importe + " €";
    }
}