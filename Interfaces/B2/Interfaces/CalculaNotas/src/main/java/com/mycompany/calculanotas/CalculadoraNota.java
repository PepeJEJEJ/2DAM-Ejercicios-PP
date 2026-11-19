package com.mycompany.calculanotas;

import java.awt.Color;
import java.text.DecimalFormat;

public class CalculadoraNota extends javax.swing.JFrame {

    private static final Color COLOR_PRINCIPAL = new Color(35, 91, 145);

    public CalculadoraNota() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        lblTitulo.setForeground(COLOR_PRINCIPAL);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(java.awt.Font.BOLD, 24f));
        lblEvaluacion.setFont(lblEvaluacion.getFont().deriveFont(java.awt.Font.BOLD));
        lblNota.setFont(lblNota.getFont().deriveFont(java.awt.Font.BOLD));
        lblPorcentaje.setFont(lblPorcentaje.getFont().deriveFont(java.awt.Font.BOLD));
        lblResultado.setForeground(COLOR_PRINCIPAL);
        lblResultado.setFont(lblResultado.getFont().deriveFont(java.awt.Font.BOLD, 18f));
        btnCalcular.setBackground(COLOR_PRINCIPAL);
        btnCalcular.setForeground(Color.WHITE);
        btnCalcular.setFocusPainted(false);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNotaMaxima = new javax.swing.JLabel();
        txtNotaMaxima = new javax.swing.JTextField();
        lblMinimoAprobacion = new javax.swing.JLabel();
        txtMinimoAprobacion = new javax.swing.JTextField();
        lblEvaluacion = new javax.swing.JLabel();
        lblNota = new javax.swing.JLabel();
        lblPorcentaje = new javax.swing.JLabel();
        lblEval1 = new javax.swing.JLabel();
        txtNota1 = new javax.swing.JTextField();
        txtPeso1 = new javax.swing.JTextField();
        lblEval2 = new javax.swing.JLabel();
        txtNota2 = new javax.swing.JTextField();
        txtPeso2 = new javax.swing.JTextField();
        lblEval3 = new javax.swing.JLabel();
        txtNota3 = new javax.swing.JTextField();
        txtPeso3 = new javax.swing.JTextField();
        lblAyuda = new javax.swing.JLabel();
        lblResultado = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora de nota final");

        lblTitulo.setText("Calculadora de nota final");

        lblNotaMaxima.setText("Nota máxima:");

        txtNotaMaxima.setText("5");

        lblMinimoAprobacion.setText("Nota mínima para aprobar:");

        txtMinimoAprobacion.setText("3");

        lblEvaluacion.setText("Evaluación");

        lblNota.setText("Nota");

        lblPorcentaje.setText("Porcentaje (%)");

        lblEval1.setText("Evaluación 1");

        txtPeso1.setText("30");

        lblEval2.setText("Evaluación 2");

        txtPeso2.setText("30");

        lblEval3.setText("Evaluación 3");

        txtPeso3.setText("40");

        lblAyuda.setText("Las notas deben estar entre 0 y la nota máxima; los porcentajes deben sumar 100.");

        lblResultado.setText("Introduce tus notas y pulsa Calcular");

        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstado.setText(" ");

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNotaMaxima)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNotaMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(lblMinimoAprobacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMinimoAprobacion, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblEvaluacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEval1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEval2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEval3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNota1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(txtNota2)
                            .addComponent(txtNota3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPorcentaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPeso1)
                            .addComponent(txtPeso2)
                            .addComponent(txtPeso3)))
                    .addComponent(lblAyuda)
                    .addComponent(lblResultado)
                    .addComponent(lblEstado)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(btnCalcular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNotaMaxima)
                    .addComponent(txtNotaMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMinimoAprobacion)
                    .addComponent(txtMinimoAprobacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEvaluacion)
                    .addComponent(lblNota)
                    .addComponent(lblPorcentaje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEval1)
                    .addComponent(txtNota1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPeso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEval2)
                    .addComponent(txtNota2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPeso2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEval3)
                    .addComponent(txtNota3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPeso3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(lblAyuda)
                .addGap(14, 14, 14)
                .addComponent(lblResultado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEstado)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalcular)
                    .addComponent(btnLimpiar))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            double notaMaxima = leerNumero(txtNotaMaxima, "la nota máxima");
            double minimoAprobacion = leerNumero(txtMinimoAprobacion, "la nota mínima para aprobar");
            if (notaMaxima <= 0) {
                throw new IllegalArgumentException("La nota máxima debe ser mayor que cero.");
            }
            if (minimoAprobacion < 0 || minimoAprobacion > notaMaxima) {
                throw new IllegalArgumentException("La nota mínima debe estar entre 0 y la nota máxima.");
            }

            javax.swing.JTextField[] camposNotas = {txtNota1, txtNota2, txtNota3};
            javax.swing.JTextField[] camposPesos = {txtPeso1, txtPeso2, txtPeso3};
            double sumaPorcentajes = 0;
            double sumaPonderada = 0;
            for (int i = 0; i < camposNotas.length; i++) {
                double nota = leerNumero(camposNotas[i], "la nota de la evaluación " + (i + 1));
                double porcentaje = leerNumero(camposPesos[i], "el porcentaje de la evaluación " + (i + 1));
                if (nota < 0 || nota > notaMaxima) {
                    throw new IllegalArgumentException("La nota de la evaluación " + (i + 1)
                            + " debe estar entre 0 y " + formatear(notaMaxima) + ".");
                }
                if (porcentaje < 0 || porcentaje > 100) {
                    throw new IllegalArgumentException("Cada porcentaje debe estar entre 0 y 100.");
                }
                sumaPorcentajes += porcentaje;
                sumaPonderada += nota * porcentaje;
            }
            if (Math.abs(sumaPorcentajes - 100) > 0.001) {
                throw new IllegalArgumentException("Los porcentajes deben sumar 100 (ahora suman "
                        + formatear(sumaPorcentajes) + ").");
            }

            double notaFinal = sumaPonderada / 100;
            lblResultado.setText("Nota final: " + formatear(notaFinal) + " / " + formatear(notaMaxima));
            boolean aprobado = notaFinal >= minimoAprobacion;
            lblEstado.setText(aprobado ? "¡Aprobado!" : "No aprobado");
            lblEstado.setForeground(aprobado ? new Color(35, 125, 75) : new Color(180, 55, 55));
        } catch (IllegalArgumentException ex) {
            lblResultado.setText("No se pudo calcular la nota");
            lblEstado.setText(ex.getMessage());
            lblEstado.setForeground(new Color(180, 55, 55));
        }
    }

    private double leerNumero(javax.swing.JTextField campo, String nombre) {
        String texto = campo.getText().trim().replace(',', '.');
        if (texto.isEmpty()) {
            throw new IllegalArgumentException("Completa " + nombre + ".");
        }
        try {
            double valor = Double.parseDouble(texto);
            if (!Double.isFinite(valor)) {
                throw new NumberFormatException();
            }
            return valor;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Escribe un número válido para " + nombre + ".");
        }
    }

    private String formatear(double valor) {
        return new DecimalFormat("0.##").format(valor);
    }

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {
        txtNota1.setText("");
        txtNota2.setText("");
        txtNota3.setText("");
        txtPeso1.setText("30");
        txtPeso2.setText("30");
        txtPeso3.setText("40");
        txtNotaMaxima.setText("5");
        txtMinimoAprobacion.setText("3");
        lblResultado.setText("Introduce tus notas y pulsa Calcular");
        lblEstado.setText(" ");
        lblEstado.setForeground(Color.BLACK);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel lblAyuda;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEval1;
    private javax.swing.JLabel lblEval2;
    private javax.swing.JLabel lblEval3;
    private javax.swing.JLabel lblEvaluacion;
    private javax.swing.JLabel lblMinimoAprobacion;
    private javax.swing.JLabel lblNota;
    private javax.swing.JLabel lblNotaMaxima;
    private javax.swing.JLabel lblPorcentaje;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtMinimoAprobacion;
    private javax.swing.JTextField txtNota1;
    private javax.swing.JTextField txtNota2;
    private javax.swing.JTextField txtNota3;
    private javax.swing.JTextField txtNotaMaxima;
    private javax.swing.JTextField txtPeso1;
    private javax.swing.JTextField txtPeso2;
    private javax.swing.JTextField txtPeso3;
    // End of variables declaration//GEN-END:variables
}
