

package com.mycompany.ej1_formulariocontacto;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;

/**
 *
 * @author PC128
 */
public class App {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        SwingUtilities.invokeLater(() -> {
            new VentanaContacto().setVisible(true);
        });
    }
}