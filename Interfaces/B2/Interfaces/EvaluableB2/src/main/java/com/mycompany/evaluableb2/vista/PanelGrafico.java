/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluableb2.vista;

import com.mycompany.evaluableb2.modelo.Voto;
import com.mycompany.evaluableb2.modelo.Votos;
import java.awt.Color;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;

public class PanelGrafico extends JPanel {
    private Votos votos;

    // Colores fijos por partido para que siempre se repitan igual
    private static final Map<String, Color> COLORES_PARTIDO = new HashMap<>();
    static {
        COLORES_PARTIDO.put("Partido Popular", new Color(0, 102, 204));     // Azul
        COLORES_PARTIDO.put("Partido Socialista", new Color(204, 0, 0));    // Rojo
        COLORES_PARTIDO.put("Partido Nacionalista", new Color(50, 150, 50));// Verde
        COLORES_PARTIDO.put("Partido Anarquista", new Color(128, 0, 128));  // Morado
        COLORES_PARTIDO.put("Otros", new Color(150, 150, 150));             // Gris
        COLORES_PARTIDO.put("Blanco", new Color(255, 255, 255));      //Blanco
        COLORES_PARTIDO.put("Negro", new Color(0, 0, 0));   //Negro
    }

    public PanelGrafico(Votos votos) {
        this.votos = votos;
        setBackground(Color.WHITE);
    }
// EL METODO QUE HACE QUE CIERTOS NOMBRES LES ASIGNEN UN COLOR
    private static Color colorParaPartido(String nombre) {

        Color c = COLORES_PARTIDO.get(nombre);
        if (c != null) {
            return c;
        }
        // Color consistente por nombre (hash): el mismo partido siempre tiene el mismo color
        int h = nombre.hashCode();
        int r = 50 + Math.abs(h % 150);
        int g = 50 + Math.abs((h * 7) % 150);
        int b = 50 + Math.abs((h * 13) % 150);
        return new Color(r, g, b);
    }
// EL METODO QUE DIBUJA LAS "TARTAS"
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Gráfico de votos por partido", 20, 20);
        int cantidad = votos.getLista().size();
        int total = 0;
        for (Voto voto : votos.getLista()) {
            total += Math.max(0, voto.getVotos());
        }
// QUE SE MUESTRA SI NO HAY VOTOS
        if (cantidad == 0 || total == 0) {
            g.drawString("No hay votos para mostrar", 20, 45);
            return;
        }
// LA ESPECIFICACION DEL DIAMETRO DEL CIRCULO
        int diametro = Math.min(220, Math.min(getHeight() - 60, getWidth() - 180));
        diametro = Math.max(80, diametro);
        int x = 30;
        int y = 40;
        int anguloInicio = 0;
        double acumulado = 0;
        int indice = 0;
// EL BUCLE QUE PERMITE EL CALCULO DE VOTOS
        for (Voto voto : votos.getLista()) {
            int numVotos = Math.max(0, voto.getVotos());
            int anguloFinal = ++indice == cantidad ? 360 : (int) Math.round((acumulado + numVotos) / total * 360);
// ESTO DEFINE EL COLOR Y LA PORCION DE CADA PARTIDO
            Color color = colorParaPartido(voto.getPartido());
            g.setColor(color);
            g.fillArc(x, y, diametro, diametro, anguloInicio, anguloFinal - anguloInicio);
// ESTO PERMITE DEFINIR LA PORCION, Y TAMBIEN EL COLOR DEL TEXTO, LA ETIQUETA DE GANADOR Y LA FECHA
            int leyendaX = x + diametro + 20;
            int leyendaY = y + 18 * (indice - 1);
            g.fillRect(leyendaX, leyendaY - 10, 12, 12);
            g.setColor(Color.BLACK);
            String etiquetaGanador = voto.isGanador() ? " [GANADOR]" : "";
            String etiquetaFecha = new SimpleDateFormat("dd/MM/yyyy").format(voto.getFecha());
            g.drawString(voto.getPartido() + " (" + voto.getVotos() + ")" + etiquetaGanador + " - " + etiquetaFecha, leyendaX + 18, leyendaY);

            acumulado += numVotos;
            anguloInicio = anguloFinal;
        }
    }
}