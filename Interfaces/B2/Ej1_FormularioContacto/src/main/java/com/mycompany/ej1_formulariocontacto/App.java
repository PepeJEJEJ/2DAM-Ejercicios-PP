/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ej1_formulariocontacto;

import javax.swing.SwingUtilities;

/**
 *
 * @author PC128
 */
public class App {

    public static void main(String[] args) {
        FlatLigthLaf.setup();
        SwingUtilities.invokeLater(() -> {
            new VentanaContacto().setVisible(true);
        });
    }
}
