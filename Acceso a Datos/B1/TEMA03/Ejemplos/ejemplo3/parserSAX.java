package Ejemplos.ejemplo3;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;

public class parserSAX {
    public static void main(String[] args) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(true);
            SAXParser saxParser = factory.newSAXParser();
            File file = new File("C:\\Users\\PC128\\Documents\\JIJA\\2dam\\2DAM-Ejercicios\\Acceso a Datos\\B1\\TEMA03\\Ejemplos\\ejemplo3\\fichero.xml");
            saxParser.parse(file, new DefaultHandler());

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}