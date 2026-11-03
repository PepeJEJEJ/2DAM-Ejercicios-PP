package com.mycompany.ej3blocdenotas;

import java.io.*;
import javax.swing.*;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;

public class Interfaz extends javax.swing.JFrame {

    private JFileChooser selector = new JFileChooser();

    public Interfaz() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void nuevo() {
        txtArea.setText("");
    }

    private void abrirArchivo() {

        if (selector.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            File archivo = selector.getSelectedFile();

            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

                txtArea.setText("");

                String linea;

                while ((linea = br.readLine()) != null) {
                    txtArea.append(linea + "\n");
                }

            } catch (IOException e) {

                JOptionPane.showMessageDialog(
                        this,
                        "Error al abrir archivo"
                );
            }
        }
    }

    private void guardarArchivo() {

        if (selector.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {

            File archivo = selector.getSelectedFile();

            try (PrintWriter pw = new PrintWriter(archivo)) {

                pw.print(txtArea.getText());

                JOptionPane.showMessageDialog(
                        this,
                        "Archivo guardado correctamente"
                );

            } catch (IOException e) {

                JOptionPane.showMessageDialog(
                        this,
                        "Error al guardar archivo"
                );
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        mnuNuevo = new javax.swing.JMenuItem();
        mnuAbrir = new javax.swing.JMenuItem();
        mnuGuardar = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenuItem();
        toolBar = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();

        menuArchivo.setText("Archivo");

        mnuNuevo.setText("Nuevo");
        menuArchivo.add(mnuNuevo);

        mnuAbrir.setText("Abrir");
        menuArchivo.add(mnuAbrir);

        mnuGuardar.setText("Guardar");
        menuArchivo.add(mnuGuardar);

        mnuSalir.setText("Salir");
        menuArchivo.add(mnuSalir);
        menuArchivo.add(new JMenuItem(actionTema));

        menuBar.add(menuArchivo);
        setJMenuBar(menuBar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bloc de Notas");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(this::btnNuevoActionPerformed);
        toolBar.add(btnNuevo);

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(this::btnAbrirActionPerformed);
        toolBar.add(btnAbrir);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        toolBar.add(btnGuardar);

        mnuNuevo.addActionListener(this::mnuNuevoActionPerformed);
        mnuAbrir.addActionListener(this::mnuAbrirActionPerformed);
        mnuGuardar.addActionListener(this::mnuGuardarActionPerformed);
        mnuSalir.addActionListener(this::mnuSalirActionPerformed);

        txtArea.setColumns(20);
        txtArea.setRows(5);

        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);

        scroll.setViewportView(txtArea);

        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
// </editor-fold>

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {
        nuevo();
    }

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {
        abrirArchivo();
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        guardarArchivo();
    }

    private void mnuNuevoActionPerformed(java.awt.event.ActionEvent evt) {
        nuevo();
    }

    private void mnuAbrirActionPerformed(java.awt.event.ActionEvent evt) {
        abrirArchivo();
    }

    private void mnuGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        guardarArchivo();
    }

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
    private boolean oscuro = false;

    private final Action actionTema = new AbstractAction("Cambiar tema") {
        @Override
        public void actionPerformed(ActionEvent e) {
            cambiarTema();
        }
    };

    private void cambiarTema() {
        oscuro = !oscuro;
        try {
            if (oscuro) {
                FlatDarkLaf.setup();
            } else {
                FlatLightLaf.setup();
            }
            SwingUtilities.updateComponentTreeUI(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mnuAbrir;
    private javax.swing.JMenuItem mnuGuardar;
    private javax.swing.JMenuItem mnuNuevo;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}