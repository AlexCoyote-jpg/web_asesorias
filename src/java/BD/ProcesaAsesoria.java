package BD;

import java.sql.*;
import java.util.*;

public class ProcesaAsesoria {

    // Asesorías de un alumno por su id
    public static List<Map<String, Object>> getAsesoriasPorAlumno(int idAlumno) {
        List<Map<String, Object>> asesorias = new ArrayList<>();
        String sql = "SELECT * FROM asesorias WHERE alumno_id = ?";
        try (Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int cols = meta.getColumnCount();
            while (rs.next()) {
                Map<String, Object> fila = new HashMap<>();
                for (int i = 1; i <= cols; i++) {
                    fila.put(meta.getColumnName(i), rs.getObject(i));
                }
                asesorias.add(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return asesorias;
    }

    // Asesorías de un profesor por su id
    public static List<Map<String, Object>> getAsesoriasPorProfesor(int idProfesor) {
        List<Map<String, Object>> asesorias = new ArrayList<>();
        //String sql = "SELECT * FROM asesorias WHERE profesor_id = ?";
        String sql = "SELECT a.*, al.nombre, al.matricula, al.programa "
                + "FROM asesorias a "
                + "JOIN alumnos al ON a.alumno_id = al.id_alumno "
                + "WHERE a.profesor_id = ?";
        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProfesor);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int cols = meta.getColumnCount();
            while (rs.next()) {
                Map<String, Object> fila = new HashMap<>();
                for (int i = 1; i <= cols; i++) {
                    fila.put(meta.getColumnName(i), rs.getObject(i));
                }
                asesorias.add(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return asesorias;
    }
    
    public static void responderSolicitud(int idAsesoria, String estado, String comentario) {
        String sql = "UPDATE asesorias SET estado = ?, comentario = ? WHERE id_asesoria = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, estado);  // 'aceptada' o 'denegada'
            ps.setString(2, comentario);
            ps.setInt(3, idAsesoria);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Puedes reemplazar con un logger si estás en producción
        }
    }
}
