package com.mycompany.evaluableb2.modelo;

import java.io.*;
import java.util.ArrayList;

/**
 * Guarda la lista de votos y calcula el total.
 * @author TuNombre
 */
public class Votos {
    private ArrayList<Voto> lista;

    public Votos() {
        lista = new ArrayList<>();
    }

    public void anadir(Voto voto) { lista.add(voto); }
    public ArrayList<Voto> getLista() { return lista; }

    /**
     * Suma los votos de todos los partidos de la lista.
     * @return el total de votos; 0 si la lista está vacía
     */
    public int getTotalVotos() {
        int total = 0;
        for (Voto v : lista) {
            total += v.getVotos();
        }
        return total;
    }

    public void guardar(String rutaArchivo) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Voto v : lista) {
                bw.write(v.toLinea());
                bw.newLine();
            }
        }
    }

    public void cargar(String rutaArchivo) throws IOException {
        lista.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    Voto v = Voto.desdeLinea(linea);
                    if (v != null) lista.add(v);
                }
            }
        }
    }
}