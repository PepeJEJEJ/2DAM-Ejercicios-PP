package Ejercicios.Ejercicio1;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Main {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // Validar el documento e ignorar espacios en blanco "sueltos"
            dbf.setValidating(true);
            dbf.setIgnoringElementContentWhitespace(true);
            // Inicializador del constructor del documento
            DocumentBuilder builder = dbf.newDocumentBuilder();
            // RUTA DEL XML
            File file = new File("Ejercicios\\Ejercicio1\\fichero.xml");

            // Se carga el fichero COMPLETO en memoria como un Document (árbol)
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            // A partir de aquí ya se puede navegar el árbol
            Element root = doc.getDocumentElement();
            System.out.println("Elemento raíz: " + root.getNodeName());
            NodeList bibliotecas = doc.getElementsByTagName("library");

            for (int i = 0; i < bibliotecas.getLength(); i++) {

                Element biblioteca = (Element) bibliotecas.item(i);

                String nombre = biblioteca.getElementsByTagName("name")
                        .item(0)
                        .getTextContent();

                String ubicacion = biblioteca.getAttribute("location");
                System.out.println("\nBiblioteca: " + nombre + " (" + ubicacion + ")");
                NodeList libros = biblioteca.getElementsByTagName("book");
                for (int j = 0; j < libros.getLength(); j++) {
                    Element libro = (Element) libros.item(j);

                    String titulo = libro.getElementsByTagName("title")
                            .item(0)
                            .getTextContent();

                    String autor = libro.getElementsByTagName("author")
                            .item(0)
                            .getTextContent();

                    String anio = libro.getElementsByTagName("year")
                            .item(0)
                            .getTextContent();

                    System.out.println(" - " + titulo +" (" + autor +", " + anio + ")");
                }
                System.out.println("Total de libros: " + libros.getLength());
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}
