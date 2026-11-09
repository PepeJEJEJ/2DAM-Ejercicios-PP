package com.example.qizz;

public class Pregunta {
    private String texto;
    private String[] opciones;
    private int indiceCorrecta;

    public Pregunta(String texto, String[] opciones, int indiceCorrecta) {
        this.texto = texto;
        this.opciones = opciones;
        this.indiceCorrecta = indiceCorrecta;
    }

    public String getTexto() {
        return texto;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public int getIndiceCorrecta() {
        return indiceCorrecta;
    }
}
