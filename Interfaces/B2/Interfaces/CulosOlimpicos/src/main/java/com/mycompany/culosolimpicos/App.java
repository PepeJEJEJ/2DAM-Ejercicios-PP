/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.culosolimpicos;

import javax.swing.SwingUtilities;

/**
 *
 * @author PC128
 */
public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaAnillos ventana = new VentanaAnillos();
            ventana.setVisible(true);
        });
    }
}