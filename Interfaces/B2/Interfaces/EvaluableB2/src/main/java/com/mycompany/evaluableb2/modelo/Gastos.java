/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluableb2.modelo;

import java.util.ArrayList;

public class Gastos {

    private ArrayList<Gasto> lista;

    public Gastos() {
        lista = new ArrayList<>();
    }

    public void anadir(Gasto gasto) {
        lista.add(gasto);
    }

    public ArrayList<Gasto> getLista() {
        return lista;
    }

    public double getTotal() {

        double total = 0;

        for (Gasto g : lista) {
            total += g.getImporte();
        }

        return total;
    }
}