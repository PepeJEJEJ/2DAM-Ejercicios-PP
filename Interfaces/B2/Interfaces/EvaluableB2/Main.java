/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.evaluableb2;

import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.evaluableb2.vista.VentanaPrincipal;
import javax.swing.SwingUtilities;
//EL MAIN
public class Main {

    public static void main(String[] args) {

        FlatLightLaf.setup();

        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}