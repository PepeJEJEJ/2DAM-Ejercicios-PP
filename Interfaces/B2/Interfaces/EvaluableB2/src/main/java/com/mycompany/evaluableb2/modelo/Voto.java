/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluableb2.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PC128
 */

public class Voto {
// EL METODO DE LAS FECHAS (CALENDARIO)
    private static final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy");
// LA DECLARACION DE OBJETOS
    private Date fecha;
    private String partido;
    private String tipo;
    private int votos;
    private boolean ganador;
// DECLARAR LAS PROPIEDADES Y PERMITIR LECTURA Y ESCRITURA
    public Voto(Date fecha, String partido, String tipo,
            int votos, boolean ganador) {

        this.fecha = fecha;
        this.partido = partido;
        this.tipo = tipo;
        this.votos = votos;
        this.ganador = ganador;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getPartido() {
        return partido;
    }

    public String getTipo() {
        return tipo;
    }

    public int getVotos() {
        return votos;
    }

    public boolean isGanador() {
        return ganador;
    }
// DAR LA ESTRUCTURA DE LOS DATOS
    @Override
    public String toString() {
        return partido + " | " + tipo + " | " + votos + " votos | " + FORMATO_FECHA.format(fecha);
    }

    public String toLinea() {
        return fecha.getTime() + ";"+ partido + ";"+ tipo + ";"+ votos + ";"+ ganador;
    }

    public static Voto desdeLinea(String linea) {
// CREAR UN ARRAID DE Strings (El ";" es para separar el texto donde haya ";")
        try {
            String[] partes = linea.split(";");
            if (partes.length < 5) {// PARA LOS ERRORES DE QUE LAS PARTES ESTEN BIEN
                System.err.println("Línea mal formada (menos de 5 campos): " + linea);
                return null;
            }
            Date fecha = new Date(Long.parseLong(partes[0]));// CREAMOS LA FECHA EN EL 1º SITIO DEL ARRAID
            String partido = partes[1];// EL NOMBRE DEL PARTIDO EN EL 2º SITIO
            String tipo = partes[2];// EL TIPO
            int numVotos = Integer.parseInt(partes[3]);// EL NUMERO DE VOTOS EN EL 4º
            boolean esGanador = Boolean.parseBoolean(partes[4]);// EL BOOLEANO QUE PERMITE SABER SI UNO HA GANADO O NO
            return new Voto(fecha, partido, tipo, numVotos, esGanador);// Devolver el Voto
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {// LAS EXCEPCIONES
            System.err.println("Error al leer línea de voto: " + linea + " -> " + e.getMessage());
            return null;
        }
    }
}