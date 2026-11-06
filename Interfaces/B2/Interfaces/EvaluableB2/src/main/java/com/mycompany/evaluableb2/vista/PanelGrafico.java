/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluableb2.vista;

import com.mycompany.evaluableb2.modelo.Gasto;
import com.mycompany.evaluableb2.modelo.Gastos;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelGrafico extends JPanel {

    private Gastos gastos;

    public PanelGrafico(Gastos gastos) {
        this.gastos = gastos;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawString("Gráfico de gastos", 20, 20);

        int x = 40;

        for (Gasto gasto : gastos.getLista()) {

            int altura = (int) gasto.getImporte();

            g.setColor(Color.BLUE);

            g.fillRect(
                    x,
                    getHeight() - altura - 50,
                    50,
                    altura);

            g.setColor(Color.BLACK);

            g.drawString(
                    gasto.getNombre(),
                    x,
                    getHeight() - 20);

            x += 70;
        }
    }
}