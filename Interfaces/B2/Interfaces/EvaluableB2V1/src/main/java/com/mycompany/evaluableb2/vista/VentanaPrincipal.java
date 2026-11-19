package com.mycompany.evaluableb2.vista;

import com.mycompany.evaluableb2.modelo.Voto;
import com.mycompany.evaluableb2.modelo.Votos;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends JFrame {

    private Votos votos;

    private JTextField txtPartido;
    private JComboBox<String> cmbTipo;
    private JSpinner spVotos;
    private JCheckBox chkGanador;
    private JSpinner fecha;

    private JTextArea txtArea;
    private JLabel lblEstado;

    private DefaultTableModel modeloTabla;
    private JTable tablaVotos;

    private PanelGrafico panelGrafico;
    private Action informeAction;

    public VentanaPrincipal() {
        votos = new Votos();
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
                generarInforme();
            }
        };
    }

        private void generarInforme() {
        // 1. Abrimos el JFileChooser
        JFileChooser fc = new JFileChooser(System.getProperty("user.home"));
        fc.setDialogTitle("Guardar informe PDF");
        fc.setSelectedFile(new File("informe.pdf"));
        fc.setFileFilter(new FileNameExtensionFilter("Documento PDF (*.pdf)", "pdf"));

        if (fc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            return; // Si el usuario cancela, salimos
        }
        
        // 2. AQUÍ ESTABA EL FALLO: Cogemos la ruta que el usuario ha elegido
        File archivo = fc.getSelectedFile(); 
        
        // 3. Si no termina en .pdf, se lo añadimos
        if (!archivo.getName().toLowerCase().endsWith(".pdf")) {
            archivo = new File(archivo.getAbsolutePath() + ".pdf");
        }

        // 4. Parámetros
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("tituloInforme", "Informe de Votos por Partido Político");
        parametros.put("numeroDatos", votos.getLista().size());
        parametros.put("totalVotos", votos.getTotalVotos());

        // Le pasamos el objeto Date puro y duro
        parametros.put("fechaGeneracion", new java.util.Date());

        // 5. Generación del PDF
        try (InputStream recurso = VentanaPrincipal.class.getResourceAsStream("/informe_votos.jasper")) {
            if (recurso == null) {
                throw new IOException("No está incluido /informe_votos.jasper en el classpath");
            }

            net.sf.jasperreports.engine.JasperReport reporte
                    = (net.sf.jasperreports.engine.JasperReport) net.sf.jasperreports.engine.util.JRLoader.loadObject(recurso);

            net.sf.jasperreports.engine.JasperPrint informe
                    = net.sf.jasperreports.engine.JasperFillManager.fillReport(
                            reporte, parametros, new net.sf.jasperreports.engine.JREmptyDataSource(1));

            // Exportamos a la ruta elegida
            net.sf.jasperreports.engine.JasperExportManager.exportReportToPdfFile(
                    informe, archivo.getAbsolutePath());

            JOptionPane.showMessageDialog(this, "PDF guardado correctamente en:\n" + archivo.getAbsolutePath());

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

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
        JPanel formulario = new JPanel(new GridLayout(0, 2, 5, 5));

        txtPartido = new JTextField(15);
        fecha = new JSpinner(new SpinnerDateModel());
        fecha.setEditor(new JSpinner.DateEditor(fecha, "dd/MM/yyyy"));
        cmbTipo = new JComboBox<>(new String[]{"Válido", "Nulo", "Blanco"});
        spVotos = new JSpinner(new SpinnerNumberModel(10, 1, 1000000, 1));
        chkGanador = new JCheckBox("Ganador");
        JButton btnAgregar = new JButton("Añadir");

        formulario.add(new JLabel("Partido"));
        formulario.add(txtPartido);
        formulario.add(new JLabel("Fecha"));
        formulario.add(fecha);
        formulario.add(new JLabel("Tipo"));
        formulario.add(cmbTipo);
        formulario.add(new JLabel("Votos"));
        formulario.add(spVotos);
        formulario.add(chkGanador);
        formulario.add(btnAgregar);

        add(formulario, BorderLayout.WEST);

        txtArea = new JTextArea();
        lblEstado = new JLabel("Sin votos");

        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.add(new JScrollPane(txtArea), BorderLayout.CENTER);
        panelInferior.add(lblEstado, BorderLayout.SOUTH);
        add(panelInferior, BorderLayout.SOUTH);

        modeloTabla = new DefaultTableModel(new String[]{"Partido", "Fecha", "Tipo", "Votos", "Ganador"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaVotos = new JTable(modeloTabla);
        tablaVotos.setRowHeight(25);
        tablaVotos.setFillsViewportHeight(true);
        add(new JScrollPane(tablaVotos), BorderLayout.EAST);

        panelGrafico = new PanelGrafico(votos);
        add(panelGrafico, BorderLayout.CENTER);

        btnAgregar.addActionListener(e -> {
            String nombre = txtPartido.getText().trim();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El campo Partido no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Voto voto = new Voto((java.util.Date) fecha.getValue(), nombre, cmbTipo.getSelectedItem().toString(),
                    Integer.parseInt(spVotos.getValue().toString()), chkGanador.isSelected());

            votos.anadir(voto);
            actualizarVista();
        });
    }

    private void actualizarVista() {
        txtArea.setText("");
        modeloTabla.setRowCount(0);
        for (Voto v : votos.getLista()) {
            txtArea.append(v.toString() + "\n");
            modeloTabla.addRow(new Object[]{
                v.getPartido(),
                new SimpleDateFormat("dd/MM/yyyy").format(v.getFecha()),
                v.getTipo(),
                v.getVotos(),
                v.isGanador() ? "Sí" : "No"
            });
        }
        lblEstado.setText("Total: " + votos.getTotalVotos() + " votos");
        panelGrafico.repaint();
    }

    private void guardarArchivo() {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File archivo = fc.getSelectedFile();
            String ruta = archivo.getAbsolutePath();
            if (!ruta.toLowerCase().endsWith(".txt")) {
                ruta += ".txt";
            }
            try {
                votos.guardar(ruta);
                lblEstado.setText("Datos guardados en: " + ruta);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void cargarArchivo() {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                votos.cargar(fc.getSelectedFile().getAbsolutePath());
                actualizarVista();
                lblEstado.setText("Datos cargados de: " + fc.getSelectedFile().getName());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al cargar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
