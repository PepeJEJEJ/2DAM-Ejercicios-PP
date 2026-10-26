/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ej2_matriculadoalumno;

/**
 *
 * @author PC128
 */
public class Alumno {

    private final String nombre;
    private final String email;
    private final String fecha;

    public Alumno(String nombre, String email, String fecha) {
        this.nombre = nombre;
        this.email = email;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}