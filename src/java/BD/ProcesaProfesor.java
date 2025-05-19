package BD;

import modelos.Profesor;
import java.sql.*;
import java.util.*;

public class ProcesaProfesor {
    public static Profesor autenticarProfesor(String clave_profesor, String contrasena) {
        Profesor profesor = null;
        try {
            Connection conexion = Conexion.getConexion();
            String sql = "SELECT * FROM profesores WHERE clave_profesor = ? AND contrasena = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, clave_profesor);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                profesor = new Profesor();
                profesor.setIdProfesor(rs.getInt("id_profesor"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setClaveProfesor(rs.getString("clave_profesor"));
                profesor.setContrasena(rs.getString("contrasena"));
                profesor.setPrograma(rs.getString("programa"));
            }
            rs.close();
            ps.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profesor;
    }

    public static List<Profesor> obtenerProfesores() {
        List<Profesor> listaProfesores = new ArrayList<>();
        try {
            Connection conexion = Conexion.getConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM profesores");
            while (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setIdProfesor(rs.getInt("id_profesor"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setClaveProfesor(rs.getString("clave_profesor"));
                profesor.setContrasena(rs.getString("contrasena"));
                profesor.setPrograma(rs.getString("programa"));
                listaProfesores.add(profesor);
            }
            rs.close();
            stmt.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProfesores;
    }
}
