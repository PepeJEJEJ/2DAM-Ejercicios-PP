/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluableb2.vista;

import com.mycompany.evaluableb2.modelo.Voto;
import com.mycompany.evaluableb2.modelo.Votos;
import com.toedter.calendar.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.miginfocom.swing.*;
// LA CLASE QUE PERMITE VER TODA LA INTERFAZ
public class VentanaPrincipal extends JFrame {

    private Votos votos;

    private JTextField txtPartido;
    private JComboBox<String> cmbTipo;
    private JSpinner spVotos;
    private JCheckBox chkGanador;
    private JDateChooser fecha;

    private JTextArea txtArea;
    private JLabel lblEstado;

    private DefaultListModel<String> modeloLista;
    private JList<String> lista;

    private PanelGrafico panelGrafico;

    private Action informeAction;

    public VentanaPrincipal() {

        votos = new Votos();
// EL TITULO DE LA INTERFAZ Y CUANTO MIDE
        setTitle("Control de Votos por Partido Político");
        setSize(1100, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        crearAction();
        crearMenu();
        crearToolbar();
        crearFormulario();
        actualizarVista();
    }

    private void crearAction() {

        informeAction = new AbstractAction("Generar informe") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Total de votos: "+ votos.getTotalVotos());
            }
        };
    }
// METODO PA CREAR EL MENU
    private void crearMenu() {
        JMenuBar barra = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenu menuAyuda = new JMenu("Ayuda");

        JMenuItem itemInforme = new JMenuItem(informeAction);
        itemInforme.setAccelerator(KeyStroke.getKeyStroke("control I"));

        JMenuItem itemGuardar = new JMenuItem("Guardar");
        itemGuardar.setAccelerator(KeyStroke.getKeyStroke("control S"));
        itemGuardar.addActionListener(e -> guardarArchivo());

        JMenuItem itemCargar = new JMenuItem("Cargar");
        itemCargar.setAccelerator(KeyStroke.getKeyStroke("control L"));
        itemCargar.addActionListener(e -> cargarArchivo());

        JMenuItem itemSalir = new JMenuItem("Salir");
        itemSalir.setAccelerator(KeyStroke.getKeyStroke("control Q"));
        itemSalir.addActionListener(e -> System.exit(0));

        menuArchivo.add(itemInforme);
        menuArchivo.addSeparator();
        menuArchivo.add(itemGuardar);
        menuArchivo.add(itemCargar);
        menuArchivo.addSeparator();
        menuArchivo.add(itemSalir);

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

        JPanel formulario = new JPanel(new MigLayout("wrap 2"));

        txtPartido = new JTextField(15);
        fecha = new JDateChooser();
        cmbTipo = new JComboBox<>(new String[]{
            "Válido","Nulo","Blanco"
        });

        spVotos= new JSpinner(new SpinnerNumberModel(10,1,1000000,1));

        chkGanador= new JCheckBox("Ganador");

        JButton btnAgregar= new JButton("Añadir");

        formulario.add(new JLabel("Partido"));
        formulario.add(txtPartido, "growx");

        formulario.add(new JLabel("Fecha"));
        formulario.add(fecha, "growx");

        formulario.add(new JLabel("Tipo"));
        formulario.add(cmbTipo, "growx");

        formulario.add(new JLabel("Votos"));
        formulario.add(spVotos, "growx");

        formulario.add(chkGanador, "span");

        formulario.add(btnAgregar, "span");

        add(formulario, BorderLayout.WEST);

        txtArea = new JTextArea();
        lblEstado = new JLabel("Sin votos");

        // El Panel inferior que combina el área de texto y la barra de estado
        // (SOUTH y PAGE_END son la misma zona en BorderLayout, así que se agrupan)
        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.add(new JScrollPane(txtArea), BorderLayout.CENTER);
        panelInferior.add(lblEstado, BorderLayout.SOUTH);

        add(panelInferior, BorderLayout.SOUTH);

        modeloLista = new DefaultListModel<>();

        lista = new JList<>(modeloLista);

        add(new JScrollPane(lista),
                BorderLayout.EAST);

        panelGrafico = new PanelGrafico(votos);

        add(panelGrafico, BorderLayout.CENTER);

        btnAgregar.addActionListener(e -> {

            String nombre = txtPartido.getText().trim();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this,"El campo Partido no puede estar vacío","Error de validación",JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (fecha.getDate() == null) {
                JOptionPane.showMessageDialog(this,"La fecha no puede estar vacía","Error de validación",JOptionPane.ERROR_MESSAGE);
                return;
            }

            Voto voto = new Voto(fecha.getDate(),nombre,cmbTipo.getSelectedItem().toString(),
            Integer.parseInt(spVotos.getValue().toString()),
            chkGanador.isSelected());

            votos.anadir(voto);
            txtArea.append(voto.toString() + "\n");
            modeloLista.addElement(voto.toString());
            lblEstado.setText("Total: "+ votos.getTotalVotos()+ " votos");
            panelGrafico.repaint();
        });
    }

    private void actualizarVista() {

        txtArea.setText("");
        modeloLista.clear();
        for (Voto v : votos.getLista()) {
            txtArea.append(v.toString() + "\n");
            modeloLista.addElement(v.toString());
        }
        String fechaTexto = "";
        if (!votos.getLista().isEmpty()) {
            fechaTexto = " | Fecha: " + new SimpleDateFormat("dd/MM/yyyy").format(votos.getLista().get(0).getFecha());
        }
        lblEstado.setText(
                "Total: "
                + votos.getTotalVotos()
                + " votos"
                + fechaTexto);
        panelGrafico.repaint();
    }

    // ESTO PERMITE GUARDAR LOS DATOS EN UN TXT
    private void guardarArchivo() {
        
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));
        int opcion = fc.showSaveDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            File archivo = fc.getSelectedFile();
            String ruta = archivo.getAbsolutePath();
            if (!ruta.toLowerCase().endsWith(".txt")) {
                ruta += ".txt";
            }
            try {
                votos.guardar(ruta);
                lblEstado.setText("Datos guardados en: " + ruta);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Error al guardar: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
// ESTE METODO PERMITE CARGAR LOS DATOS DE UN ARCHIVO TXT
    private void cargarArchivo() {

        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));
        int opcion = fc.showOpenDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            File archivo = fc.getSelectedFile();
            try {
                votos.cargar(archivo.getAbsolutePath());
                actualizarVista();
                lblEstado.setText("Datos cargados de: " + archivo.getName());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Error al cargar: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
