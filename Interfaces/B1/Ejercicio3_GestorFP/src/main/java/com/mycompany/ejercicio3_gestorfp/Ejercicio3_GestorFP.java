/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio3_gestorfp;

/**
 *
 * @author PC128
 */
public class Ejercicio3_GestorFP {

    public static void main(String[] args) {
        javax.swing.JFrame ventana = new javax.swing.JFrame("Ventana Principal");
        ventana.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);

        ventana.add(new Interfaz());
        ventana.setVisible(true);
    }
}
