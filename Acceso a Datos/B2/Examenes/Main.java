package Original.P2;

import java.sql.*;
import java.util.*;

public class Main {

    private static final String URL      = "jdbc:mysql://localhost:3307/gimnasio";
    private static final String USUARIO  = "alumno";
    private static final String PASSWORD = "contraseña";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
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
                    // si algo falla (dato incorrecto...) se avisa y se vuelve al menu
                    System.out.println("Error: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("El id tiene que ser un numero.");
                }
            }

        } catch (SQLException e) {
            System.out.println("No se pudo conectar: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------------
    // 1: muestra todas las actividades con un Statement: id - nombre - dia - monitor
    // ---------------------------------------------------------------
    static void listarActividades(Statement st) throws SQLException {
        String sql="select * from actividad";
        try {
            st.executeQuery(sql);
            st.toString();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------------
    // 2: inserta el socio en la tabla socio (nombre, ciudad, email, fecha_alta)
    //    con un PreparedStatement y la fecha de alta de hoy,
    //    y muestra las filas afectadas.
    //    Los datos ya te llegan por parametro.
    // ---------------------------------------------------------------
    static void insertarSocio(Connection con, String nombre, String ciudad, String email) throws SQLException {
        String sql="insert values(nombre,ciudad,email,fecha_alta) into socio (?,?,?,curdate())";
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,nombre);
            ps.setString(2,ciudad);
            ps.setString(3,email);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------------
    // 3: cambia la ciudad del socio con ese id
    //    con un PreparedStatement y muestra las filas afectadas
    //    Los datos ya te llegan por parametro.
    // ---------------------------------------------------------------
    static void cambiarCiudad(Connection con, int idSocio, String ciudad) throws SQLException {
        String sql="Update ciudad from socio where idSocio = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1,idSocio);
            ps.setString(2,ciudad);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------------
    // 4: borra todas las inscripciones del socio con ese id
    //    con un PreparedStatement y muestra las filas afectadas
    // ---------------------------------------------------------------
    static void borrarInscripciones(Connection con, int idSocio) throws SQLException {
        String sql="Delete * from socio where idSocio = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1,idSocio);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
