/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluableb2.vista;

import com.mycompany.evaluableb2.modelo.Gasto;
import com.mycompany.evaluableb2.modelo.Gastos;
import com.toedter.calendar.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

public class VentanaPrincipal extends JFrame {

    private Gastos gastos;

    private JTextField txtNombre;
    private JComboBox<String> cmbCategoria;
    private JSpinner spImporte;
    private JCheckBox chkImprescindible;
    private JDateChooser fecha;

    private JTextArea txtArea;
    private JLabel lblEstado;

    private DefaultListModel<String> modeloLista;
    private JList<String> lista;

    private PanelGrafico panelGrafico;

    private Action informeAction;

    public VentanaPrincipal() {

        gastos = new Gastos();

        setTitle("Control de Gastos");
        setSize(1100, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        crearAction();
        crearMenu();
        crearToolbar();
        crearFormulario();
    }

    private void crearAction() {

        informeAction = new AbstractAction("Generar informe") {

            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Total gastado: "
                        + gastos.getTotal()
                        + " €");
            }
        };
    }

    private void crearMenu() {

        JMenuBar barra = new JMenuBar();

        JMenu menuArchivo = new JMenu("Archivo");
        JMenu menuAyuda = new JMenu("Ayuda");

        JMenuItem itemInforme =
                new JMenuItem(informeAction);

        itemInforme.setAccelerator(
                KeyStroke.getKeyStroke("control I"));

        menuArchivo.add(itemInforme);

        barra.add(menuArchivo);
        barra.add(menuAyuda);

        setJMenuBar(barra);
    }

    private void crearToolbar() {

        JToolBar toolBar = new JToolBar();

        toolBar.add(informeAction);

        add(toolBar, BorderLayout.NORTH);
    }

    private void crearFormulario() {

        JPanel formulario =
                new JPanel(
                        new MigLayout("wrap 2"));

        txtNombre = new JTextField(15);

        fecha = new JDateChooser();

        cmbCategoria =
                new JComboBox<>(new String[]{
                    "Comida",
                    "Transporte",
                    "Ocio",
                    "Otros"
                });

        spImporte =
                new JSpinner(
                        new SpinnerNumberModel(
                                10,
                                1,
                                1000,
                                1));

        chkImprescindible =
                new JCheckBox("Imprescindible");

        JButton btnAgregar =
                new JButton("Añadir");

        formulario.add(new JLabel("Nombre"));
        formulario.add(txtNombre, "growx");

        formulario.add(new JLabel("Fecha"));
        formulario.add(fecha, "growx");

        formulario.add(new JLabel("Categoría"));
        formulario.add(cmbCategoria, "growx");

        formulario.add(new JLabel("Importe"));
        formulario.add(spImporte, "growx");

        formulario.add(chkImprescindible, "span");

        formulario.add(btnAgregar, "span");

        add(formulario, BorderLayout.WEST);

        txtArea = new JTextArea();

        add(new JScrollPane(txtArea),
                BorderLayout.SOUTH);

        modeloLista = new DefaultListModel<>();

        lista = new JList<>(modeloLista);

        add(new JScrollPane(lista),
                BorderLayout.EAST);

        panelGrafico = new PanelGrafico(gastos);

        add(panelGrafico, BorderLayout.CENTER);

        lblEstado = new JLabel("Sin gastos");

        add(lblEstado, BorderLayout.PAGE_END);

        btnAgregar.addActionListener(e -> {

            Gasto gasto = new Gasto(
                    fecha.getDate(),
                    txtNombre.getText(),
                    cmbCategoria.getSelectedItem().toString(),
                    Double.parseDouble(
                            spImporte.getValue().toString()),
                    chkImprescindible.isSelected());

            gastos.anadir(gasto);

            txtArea.append(
                    gasto.toString() + "\n");

            modeloLista.addElement(
                    gasto.toString());

            lblEstado.setText(
                    "Total: "
                    + gastos.getTotal()
                    + " €");

            panelGrafico.repaint();
        });
    }
}