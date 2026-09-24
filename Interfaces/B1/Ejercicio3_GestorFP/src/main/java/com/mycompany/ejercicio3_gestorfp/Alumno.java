/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio3_gestorfp;

/**
 *
 * @author PC128
 */
public class Alumno {

    private String nombreApellidos;
    private String email;
    private String fechaNacimiento;
    private String genero;
    private String titulacionAcceso;
    private String observaciones;

    public Alumno(String nombreApellidos, String email, String fechaNacimiento,
                   String genero, String titulacionAcceso, String observaciones) {
        this.nombreApellidos = nombreApellidos;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.titulacionAcceso = titulacionAcceso;
        this.observaciones = observaciones;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulacionAcceso() {
        return titulacionAcceso;
    }

    public void setTitulacionAcceso(String titulacionAcceso) {
        this.titulacionAcceso = titulacionAcceso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "----- MATRICULA ALUMNO -----\n"
             + "Nombre y Apellidos: " + nombreApellidos + "\n"
             + "Email: " + email + "\n"
             + "Fecha de Nacimiento: " + fechaNacimiento + "\n"
             + "Genero: " + genero + "\n"
             + "Titulacion de Acceso: " + titulacionAcceso + "\n"
             + "Observaciones: " + observaciones + "\n"
             + "-----------------------------";
    }
}