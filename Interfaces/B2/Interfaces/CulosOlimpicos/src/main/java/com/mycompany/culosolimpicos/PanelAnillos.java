/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.culosolimpicos;
import java.awt.*;
import javax.swing.*;

public class PanelAnillos extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        try {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new BasicStroke(5));

            // Dibujar primero la fila inferior para que los anillos se crucen.
            g2.setColor(new Color(255, 205, 0));
            g2.drawOval(110, 100, 100, 100);

            g2.setColor(new Color(0, 155, 58));
            g2.drawOval(230, 100, 100, 100);

            g2.setColor(new Color(0, 129, 200));
            g2.drawOval(50, 50, 100, 100);

            g2.setColor(Color.BLACK);
            g2.drawOval(170, 50, 100, 100);

            g2.setColor(new Color(238, 51, 78));
            g2.drawOval(290, 50, 100, 100);
        } finally {
            g2.dispose();
        }
    }
}