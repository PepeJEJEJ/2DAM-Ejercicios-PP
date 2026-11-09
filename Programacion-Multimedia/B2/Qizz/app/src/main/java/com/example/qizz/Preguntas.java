package com.example.qizz;

import java.util.ArrayList;
import java.util.List;

public class Preguntas {
    public static List<Pregunta> getTodas() {
        List<Pregunta> lista = new ArrayList<>();
        lista.add(new Pregunta("¿Cuál es la capital de Andalucia?",
                new String[]{"Sevilla", "Barcelona", "Valencia", "Madrid"}, 0));
        lista.add(new Pregunta("¿Cuánto es la Raiz Cuadrada de 169?",
                new String[]{"33", "13", "8", "5"}, 1));
        lista.add(new Pregunta("¿En qué año se disolvio la URSS?",
                new String[]{"1961", "1991", "1972", "2006"}, 1));
        lista.add(new Pregunta("¿Quién escribió \"There are more things\"?",
                new String[]{"HP Lovecraft", "Margaret Atwood", "Jorge Luis Borges", "Harlan Ellison"}, 2));
        lista.add(new Pregunta("¿Cuál es el pais más pobre del mundo?",
                new String[]{"Myanmar", "Somalia", "Burundi", "Venezuela"}, 2));
        lista.add(new Pregunta("¿Cuántos colores tiene el arcoíris?",
                new String[]{"5", "7", "6", "67"}, 1));
        lista.add(new Pregunta("¿Cual es la ''Capital'' de Africa?",
                new String[]{"Monrovia", "Addis Ababa", "Arusha", "Kinsasha"}, 1));
        lista.add(new Pregunta("¿Quién pintó la Mona Lisa?",
                new String[]{"Pablo Pijasso", "Vincent van Gogh", "Leonardo da Vinci", "Miguel Ángel"}, 2));
        lista.add(new Pregunta("¿Cuál es la palabra más larga del mundo?",
                new String[]{"Nombre Quimico de la Titina", "Taumata Hill (Nueva Zelanda)", "Llanfair (Gales)", "La Fobia a las Palabras largas y/o Complejas"}, 0));
        lista.add(new Pregunta("¿Cuántos lados tiene un eneágono?",
                new String[]{"6", "3", "7", "9"}, 3));
        return lista;
    }
}
