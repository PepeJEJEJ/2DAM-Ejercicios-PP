package com.medac.PC128;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pc128Application {

    private static final String URL = "jdbc:h2:mem:gimnasio";
    private static final String USUARIO = "sa";
    private static final String PASSWORD = "password";

    static void resetearBaseDatos(Connection con) throws SQLException {
        try (Statement st = con.createStatement()) {
            st.executeUpdate("DROP TABLE IF EXISTS inscripcion");
            st.executeUpdate("DROP TABLE IF EXISTS actividad");
            st.executeUpdate("DROP TABLE IF EXISTS socio");
            st.executeUpdate("DROP TABLE IF EXISTS monitor");

            st.executeUpdate("CREATE TABLE monitor ("
                    + "id_monitor INT PRIMARY KEY AUTO_INCREMENT,"
                    + "nombre VARCHAR(100) NOT NULL"
                    + ")");

            st.executeUpdate("CREATE TABLE socio ("
                    + "id_socio INT PRIMARY KEY AUTO_INCREMENT,"
                    + "nombre VARCHAR(100) NOT NULL,"
                    + "ciudad VARCHAR(100),"
                    + "email VARCHAR(100) UNIQUE,"
                    + "fecha_alta DATE NOT NULL"
                    + ")");

            st.executeUpdate("CREATE TABLE actividad ("
                    + "id_actividad INT PRIMARY KEY AUTO_INCREMENT,"
                    + "nombre VARCHAR(100) NOT NULL,"
                    + "dia VARCHAR(20) NOT NULL,"
                    + "id_monitor INT NOT NULL,"
                    + "FOREIGN KEY (id_monitor) REFERENCES monitor(id_monitor)"
                    + ")");

            st.executeUpdate("CREATE TABLE inscripcion ("
                    + "id_socio INT NOT NULL,"
                    + "id_actividad INT NOT NULL,"
                    + "PRIMARY KEY (id_socio, id_actividad),"
                    + "FOREIGN KEY (id_socio) REFERENCES socio(id_socio),"
                    + "FOREIGN KEY (id_actividad) REFERENCES actividad(id_actividad)"
                    + ")");

            st.executeUpdate("INSERT INTO monitor (nombre) VALUES ('Laura'), ('Pablo'), ('Marta')");
            st.executeUpdate("INSERT INTO socio (nombre, ciudad, email, fecha_alta) VALUES "
                    + "('Ana', 'Sevilla', 'ana@mail.com', CURRENT_DATE),"
                    + "('Luis', 'Madrid', 'luis@mail.com', CURRENT_DATE),"
                    + "('Sara', 'Valencia', 'sara@mail.com', CURRENT_DATE)");
            st.executeUpdate("INSERT INTO actividad (nombre, dia, id_monitor) VALUES "
                    + "('Spinning', 'Lunes', 1),"
                    + "('Yoga', 'Miércoles', 2),"
                    + "('Pesas', 'Viernes', 3)");
            st.executeUpdate("INSERT INTO inscripcion (id_socio, id_actividad) VALUES "
                    + "(1, 1),"
                    + "(1, 3),"
                    + "(2, 2)");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Pc128Application.class, args);
        iniciarMenu();
    }

    private static void iniciarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
                Statement st = con.createStatement()) {
            resetearBaseDatos(con);
            System.out.println("Conexion OK");

            while (opcion != 0) {
                System.out.println("\n===== GIMNASIO =====");
                System.out.println("1. Listar actividades");
                System.out.println("2. Insertar socio");
                System.out.println("3. Cambiar ciudad de un socio");
                System.out.println("4. Borrar inscripciones de un socio");
                System.out.println("5. Mostrar socios");
                System.out.println("0. Salir");
                System.out.print("Opcion: ");

                try {
                    opcion = Integer.parseInt(sc.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Escribe un numero.");
                    continue;
                }

                try {
                    switch (opcion) {
                        case 1:
                            listarActividades(st);
                            break;
                        case 2:
                            System.out.print("Nombre: ");
                            String nombre = sc.nextLine();
                            System.out.print("Ciudad: ");
                            String ciudad = sc.nextLine();
                            System.out.print("Email: ");
                            String email = sc.nextLine();
                            insertarSocio(con, nombre, ciudad, email);
                            break;
                        case 3:
                            System.out.print("Id del socio: ");
                            int id = Integer.parseInt(sc.nextLine().trim());
                            System.out.print("Nueva ciudad: ");
                            String nuevaCiudad = sc.nextLine();
                            cambiarCiudad(con, id, nuevaCiudad);
                            break;
                        case 4:
                            System.out.print("Id del socio: ");
                            borrarInscripciones(con, Integer.parseInt(sc.nextLine().trim()));
                            break;
                        case 5:
                            listarSocios(st);
                            break;
                        case 0:
                            System.out.println("Adios.");
                            break;
                        default:
                            System.out.println("Opcion no valida.");
                    }
                } catch (SQLException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("El id tiene que ser un numero.");
                }
            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar: " + e.getMessage());
        }
    }

    static void listarActividades(Statement st) throws SQLException {
        String sql = "SELECT a.id_actividad, a.nombre, a.dia, m.nombre AS monitor FROM actividad a JOIN monitor m ON a.id_monitor = m.id_monitor";
        try (ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id_actividad") + " - " + rs.getString("nombre")
                        + " - " + rs.getString("dia") + " - " + rs.getString("monitor"));
            }
        }
    }

    static void insertarSocio(Connection con, String nombre, String ciudad, String email) throws SQLException {
        String sql = "INSERT INTO socio (nombre, ciudad, email, fecha_alta) VALUES (?, ?, ?, CURRENT_DATE)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, ciudad);
            ps.setString(3, email);
            System.out.println("INSERT: " + ps.executeUpdate() + " fila(s)");
        }
    }

    static void cambiarCiudad(Connection con, int idSocio, String ciudad) throws SQLException {
        String sql = "UPDATE socio SET ciudad = ? WHERE id_socio = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ciudad);
            ps.setInt(2, idSocio);
            System.out.println("UPDATE: " + ps.executeUpdate() + " fila(s)");
        }
    }

    static void borrarInscripciones(Connection con, int idSocio) throws SQLException {
        String sql = "DELETE FROM inscripcion WHERE id_socio = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idSocio);
            System.out.println("DELETE: " + ps.executeUpdate() + " fila(s)");
        }
    }

    static void listarSocios(Statement st) throws SQLException {
        String sql = "SELECT id_socio, nombre, ciudad, email, fecha_alta FROM socio";
        try (ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id_socio") + " - "+ rs.getString("nombre") + " - "+ rs.getString("ciudad") + " - "
                + rs.getString("email") + " - "+ rs.getDate("fecha_alta"));
            }
        }
    }
}