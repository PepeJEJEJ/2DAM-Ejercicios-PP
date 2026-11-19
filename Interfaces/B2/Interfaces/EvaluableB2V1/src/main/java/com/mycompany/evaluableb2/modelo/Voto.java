package com.mycompany.evaluableb2.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Voto {
    private static final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy");
    private Date fecha;
    private String partido;
    private String tipo;
    private int votos;
    private boolean ganador;

    public Voto(Date fecha, String partido, String tipo, int votos, boolean ganador) {
        this.fecha = fecha;
        this.partido = partido;
        this.tipo = tipo;
        this.votos = votos;
        this.ganador = ganador;
    }

    public Date getFecha() { return fecha; }
    public String getPartido() { return partido; }
    public String getTipo() { return tipo; }
    public int getVotos() { return votos; }
    public boolean isGanador() { return ganador; }

    @Override
    public String toString() {
        return partido + " | " + tipo + " | " + votos + " votos | " + FORMATO_FECHA.format(fecha);
    }

    public String toLinea() {
        return fecha.getTime() + ";" + partido + ";" + tipo + ";" + votos + ";" + ganador;
    }

    public static Voto desdeLinea(String linea) {
        try {
            String[] partes = linea.split(";");
            if (partes.length < 5) return null;
            Date fecha = new Date(Long.parseLong(partes[0]));
            return new Voto(fecha, partes[1], partes[2], Integer.parseInt(partes[3]), Boolean.parseBoolean(partes[4]));
        } catch (Exception e) {
            return null;
        }
    }
}