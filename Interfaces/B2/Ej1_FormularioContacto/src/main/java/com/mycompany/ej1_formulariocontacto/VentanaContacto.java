package com.mycompany.ej1_formulariocontacto;

import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class VentanaContacto extends JFrame {
    //CREAMOS TODOS LOS COMPONENTES
    // los componentes van COMO ATRIBUTOS
    private final JTextField nombre = new JTextField(20);
    private final JTextField correo = new JTextField(20);

    private JLabel titulo = new JLabel("Escribe A Secretaria");
    private JTextField Textfield_Correo = new JTextField(20);

    private final JComboBox<String> asunto = new JComboBox<>(
            new String[]{"Info ciclos", "Matrícula", "Becas"}
    );

    private final JTextArea mensaje = new JTextArea(5, 20);

    private final JCheckBox privacidad = new JCheckBox(
            "He leído y acepto"
    );

    //1º CADENA: EL PANEL, 2º LAS COLUMNAS Y 3º LAS FILAS
    JPanel panel = new JPanel(new MigLayout("debug, wrap 2, insets 20, gap 10"));

    JLabel Titulo = new JLabel("copote");

    public VentanaContacto() {

        setTitle("Mi ventana");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel.add(Titulo, "span 2, center");
        panel.add(new JLabel("Nombre"));
        panel.add(nombre);

        add(panel);
    }
}