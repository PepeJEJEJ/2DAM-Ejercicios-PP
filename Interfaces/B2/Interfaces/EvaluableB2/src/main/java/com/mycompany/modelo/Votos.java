/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluableb2.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Votos {
//CREAR EL ARRAY DE VOTOS
    private ArrayList<Voto> lista;

    public Votos() {
        lista = new ArrayList<>();
    }

    public void anadir(Voto voto) {
        lista.add(voto);
    }

    public ArrayList<Voto> getLista() {
        return lista;
    }
// EL METODO QUE PERMITE AJUSTAR 
    public int getTotalVotos() {

        int total = 0;

        for (Voto v : lista) {
            total += v.getVotos();
        }

        return total;
    }
// LO QUE HACE "GUARDAR"
    public void guardar(String rutaArchivo) throws IOException {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Voto v : lista) {
                bw.write(v.toLinea());
                bw.newLine();
            }
        }
    }
// LO QUE HACE "CARGAR"
    public void cargar(String rutaArchivo) throws IOException {

        lista.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    Voto v = Voto.desdeLinea(linea);
                    if (v != null) {
                        lista.add(v);
                    }
                }
            }
        }
    }
}