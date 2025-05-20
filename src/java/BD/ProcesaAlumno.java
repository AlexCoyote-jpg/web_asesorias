package BD;

import modelos.Estudiante;
import java.sql.*;
import java.util.*;

public class ProcesaAlumno {

    // Método para obtener todos los alumnos
    public static LinkedList<Estudiante> obtenerAlumnos() {
        LinkedList<Estudiante> listaAlumnos = new LinkedList<>();
        try {
            // Establece la conexión con la base de datos
            Connection conexion = Conexion.getConexion();
            Statement sentenciaSQL = conexion.createStatement();
            ResultSet rs = sentenciaSQL.executeQuery("SELECT * FROM alumnos");

            // Procesa los resultados
            while (rs.next()) {
                Estudiante alumno = new Estudiante();
                alumno.setIdEstudiante(rs.getInt("id_alumno"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setMatricula(rs.getString("matricula"));
                alumno.setContrasena(rs.getString("contrasena"));
                alumno.setPrograma(rs.getString("programa"));
                listaAlumnos.add(alumno);
            }

            // Cierra los recursos
            rs.close();
            sentenciaSQL.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();  // Si hay error, lo imprime
        }
        return listaAlumnos;
    }

    // Método para autenticar un alumno con matrícula y contraseña
    public static Estudiante autenticarAlumno(String matricula, String contrasena) {
        Estudiante alumno = null;
        try {
            // Establece la conexión con la base de datos
            Connection conexion = Conexion.getConexion();
            String sql = "SELECT * FROM alumnos WHERE matricula = ? AND contrasena = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, matricula);
            ps.setString(2, contrasena);

            ResultSet rs = ps.executeQuery();

            // Si encuentra un alumno, lo asigna
            if (rs.next()) {
                alumno = new Estudiante();
                alumno.setIdEstudiante(rs.getInt("id_alumno"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setMatricula(rs.getString("matricula"));
                alumno.setContrasena(rs.getString("contrasena"));
                alumno.setPrograma(rs.getString("programa"));
            }

            // Cierra los recursos
            rs.close();
            ps.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();  // Si hay error, lo imprime
        }
        return alumno;
    }
}
