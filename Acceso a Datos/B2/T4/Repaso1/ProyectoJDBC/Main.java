import java.sql.*;
import java.util.Scanner;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3307/aula";
    private static final String USUARIO  = "root";
    private static final String PASSWORD = "Med@c";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            Statement st = con.createStatement()) {
            System.out.println("Conexion OK");

            while (opcion != 0) {
                System.out.println("\n===== AULA =====");
                System.out.println("1. Listar portatiles");
                System.out.println("2. Insertar alumno");
                System.out.println("3. Ver portatil asignado");
                System.out.println("4. Cambiar portatil asignado");
                System.out.println("5. Borrar portatil segun su IP");
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
                            listarPortatiles(st);
                            break;
                        case 2:
                            System.out.print("Nombre: ");
                            String nombre = sc.nextLine();
                            System.out.print("Apellidos: ");
                            String apellidos = sc.nextLine();
                            System.out.print("Email: ");
                            String email = sc.nextLine();
                            System.out.print("Codigo de tu portatil: ");
                            int codigo = Integer.parseInt(sc.nextLine().trim());
                            insertarAlumno(con, nombre, apellidos, email, codigo);
                            break;
                        case 3:
                            System.out.print("Codigo del portatil: ");
                            verPortatil(con, Integer.parseInt(sc.nextLine().trim()));
                            break;
                        case 4:
                            System.out.print("Tu email: ");
                            String emailU = sc.nextLine();
                            System.out.print("Codigo del nuevo portatil: ");
                            cambiarPortatil(con, emailU, Integer.parseInt(sc.nextLine().trim()));
                            break;
                        case 5:
                            System.out.print("IP del portatil: ");
                            String ip = sc.nextLine();
                            borrarPC(con, ip);
                            break;
                        case 0:
                            System.out.println("Adios.");
                            break;
                        default:
                            System.out.println("Opcion no valida.");
                    }
                } catch (SQLException e) {
                    // si algo falla (portatil ocupado, no existe...) se avisa y se vuelve al menu
                    System.out.println("Error: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("El codigo tiene que ser un numero.");
                }
            }

        } catch (SQLException e) {
            System.out.println("No se pudo conectar: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------------
    // 1: muestra todos los portatiles con un Statement: codigo - ip - incidencias
    //         (SELECT codigo, ip, incidencias FROM portatil).
    //         Al final muestra cuantos portatiles ha encontrado la consulta.
    // ---------------------------------------------------------------
    static void listarPortatiles(Statement st) throws SQLException {
        String sql = "select codigo, ip, incidencia from portatil";
    }

    // ---------------------------------------------------------------
    // 2: inserta el alumno en la tabla alumno (nombre, apellidos, email, codigo_pc)
    //         con un PreparedStatement (4 "?") y muestra las filas afectadas.
    //         Los datos ya te llegan por parametro.
    // ---------------------------------------------------------------
    static void insertarAlumno(Connection con, String nombre, String apellidos, String email, int codigo) throws SQLException {
        String sql = "insert into alumno (nombre, apellidos, email, codigo_pc) values (?, ?, ?, ?)";
        try (PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,nombre);
            ps.setString(2,apellidos);
            ps.setString(3,email);
            ps.setInt(4,codigo);
            System.out.print("Se han insertado: "+ps.executeUpdate()+" filas");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------------
    // 3: busca el portatil por código y muestra su codigo, ip, incidencias y datos del alumno que lo tiene asignado
    //         Al final muestra cuantos portatiles ha encontrado la consulta.
    // ---------------------------------------------------------------
    static void verPortatil(Connection con, int codigo) throws SQLException {
    String sql ="SELECT p.codigo, p.ip, p.incidencia, a.nombre, a.apellidos " +
        "FROM portatil p JOIN alumno a ON p.codigo = a.codigo_pc " +
        "WHERE p.codigo = ?";
        try (PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,codigo);
            try (ResultSet rs=ps.executeQuery()){
                while (rs.next()) {
                    System.out.println(rs.getInt("codigo")+" - "+rs.getString("ip")+" - "+rs.getString("incidencia"));
                    System.out.println("Asignado a: " +rs.getString("nombre") + " " +rs.getString("apellidos"));
                }
                System.out.println("Tiene alumno asignado "+ps.execute());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------------
    // 4: cambia el portatil del alumno con ese email:
    //         Muestra las filas afectadas (0 = ese email no existe).
    //         Prueba con un portatil ocupado y con uno que no existe:
    //         veras el error en pantalla y el programa vuelve al menu.
    // ---------------------------------------------------------------
    static void cambiarPortatil(Connection con, String email, int codigo) throws SQLException {
        String sql = "UPDATE alumno SET codigo_pc = ? WHERE email = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.setString(2, email);
            int filas = ps.executeUpdate();
            System.out.println("Filas afectadas: " + filas);
        }
    }
    // 5 BORRAR PC SEGUN SU IP
    static void borrarPC(Connection con, String ip) throws SQLException {
        String sql = "DELETE FROM portatil WHERE ip = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ip);

            int filas = ps.executeUpdate();

            System.out.println("Filas afectadas: " + filas);
        }
    }
}