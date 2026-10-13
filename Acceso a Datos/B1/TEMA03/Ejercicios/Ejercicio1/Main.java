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
            // Recorrer el XML
            // Recorre todas las bibliotecas encontradas en el XML
            for (int i = 0; i < bibliotecas.getLength(); i++) {
                // Obtiene la biblioteca actual (posición i) y la convierte a Element
                Element biblioteca = (Element) bibliotecas.item(i);
                // Obtiene el contenido de la etiqueta <name>
                String nombre = biblioteca.getElementsByTagName("name").item(0).getTextContent();
                // Obtiene el valor del atributo location
                String ubicacion = biblioteca.getAttribute("location");
                // Muestra el nombre y la ubicación de la biblioteca
                System.out.println("\nBiblioteca: " + nombre + " (" + ubicacion + ")");
                // Obtiene todos los nodos <book> de la biblioteca
                NodeList libros = biblioteca.getElementsByTagName("book");
                // Recorre todos los libros de la biblioteca actual
                for (int j = 0; j < libros.getLength(); j++) {
                    // Obtiene el libro actual (posición j) y lo convierte a Element
                    Element libro = (Element) libros.item(j);
                    // Obtiene el contenido de la etiqueta <title>
                    String titulo = libro.getElementsByTagName("title").item(0).getTextContent();
                    // Obtiene el contenido de la etiqueta <author>
                    String autor = libro.getElementsByTagName("author").item(0).getTextContent();
                    // Obtiene el contenido de la etiqueta <year>
                    String anno = libro.getElementsByTagName("year").item(0).getTextContent();
                    // Muestra la información del libro
                    System.out.println(" - " + titulo + " (" + autor + ", " + anno + ")");
                }
                // Muestra el número total de libros de esa biblioteca
                System.out.println("Total de libros: " + libros.getLength());
            }

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}
