package com.mycompany.ej1_formulariocontacto;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VentanaContacto extends JFrame {

    // los componentes van COMO ATRIBUTOS
    private final JTextField nombre = new JTextField(20);
    private final JTextField correo = new JTextField(20);

    private final JComboBox<String> asunto = new JComboBox<>(
            new String[]{"Info ciclos", "Matrícula", "Becas"}
    );

    private final JTextArea mensaje = new JTextArea(5, 20);

    private final JCheckBox privacidad = new JCheckBox(
            "He leído y acepto"
    );

    public VentanaContacto() {
        setTitle("Mi ventana");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}