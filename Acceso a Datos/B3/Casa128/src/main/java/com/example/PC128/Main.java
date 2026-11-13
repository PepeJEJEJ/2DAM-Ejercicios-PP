package com.example.PC128;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {

    public static final String URL = "jdbc:h2:file:~/data/gimnasio";

    public static void main(String[] args) {
        ConfigurableApplicationContext contexto = SpringApplication.run(Main.class, args);
        String url = contexto.getEnvironment().getRequiredProperty("spring.datasource.url");
        String usuario = contexto.getEnvironment().getRequiredProperty("spring.datasource.username");
        String password = contexto.getEnvironment().getRequiredProperty("spring.datasource.password");

        try (Scanner sc = new Scanner(System.in)) {
            int opcion = -1;

            try (Connection con = DriverManager.getConnection(url, usuario, password);
                 Statement st = con.createStatement()) {
                System.out.println("Conexion OK");

                while (opcion != 0) {
                    System.out.println("\n===== GIMNASIO =====");
                    System.out.println("1. Listar actividades");
                    System.out.println("2. Insertar socio");
                    System.out.println("3. Cambiar ciudad de un socio");
                    System.out.println("4. Borrar inscripciones de un socio");
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
        } finally {
            contexto.close();
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
        String sql = "INSERT INTO socio (nombre, ciudad, email, fecha_alta) VALUES (?, ?, ?, CURDATE())";
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
}
