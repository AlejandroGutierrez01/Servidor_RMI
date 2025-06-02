package Servicio;

import java.sql.*;
import java.util.ArrayList;

public class Consulta {

    public static ArrayList<Persona> getPersonas() {
        ArrayList<Persona> lista = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Carga el driver
            Class.forName("org.sqlite.JDBC");
            // Conecta a la base de datos (empleados.db)
            String ruta = "C:/Users/PC/Downloads/empleados.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + ruta);
            // Crea la consulta
            String sql = "SELECT id, nombre, correo, cargo, sueldo FROM empleado";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            // Recorre resultados y crea objetos Persona
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String cargo = rs.getString("cargo");
                double sueldo = rs.getDouble("sueldo");

                Persona p = new Persona(id, nombre, correo, cargo, sueldo);
                lista.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cierra recursos
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return lista;
    }
    public static void addPersona(Persona p) {
        String ruta = "C:/Users/PC/Downloads/empleados.db";
        String sql = "INSERT INTO empleado (id, nombre, correo, cargo, sueldo) VALUES (?, ?, ?, ?, ?)";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + ruta);
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, p.getId());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getCorreo());
            ps.setString(4, p.getCargo());
            ps.setDouble(5, p.getSueldo());
            ps.executeUpdate();

            System.out.println("Persona agregada correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updatePersona(Persona p) {
        String ruta = "C:/Users/PC/Downloads/empleados.db";
        String sql = "UPDATE empleado SET nombre = ?, correo = ?, cargo = ?, sueldo = ? WHERE id = ?";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + ruta);
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCorreo());
            ps.setString(3, p.getCargo());
            ps.setDouble(4, p.getSueldo());
            ps.setInt(5, p.getId());
            ps.executeUpdate();

            System.out.println("Persona actualizada correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deletePersona(int id) {
        String ruta = "C:/Users/PC/Downloads/empleados.db";
        String sql = "DELETE FROM empleado WHERE id = ?";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + ruta);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Persona eliminada correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
