/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculanotas;

import javax.swing.SwingUtilities;

/**
 *
 * @author PC128
 */
public class CalculaNotas {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraNota().setVisible(true));
    }
}
