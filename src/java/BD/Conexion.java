/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import java.sql.*;
import java.util.*;;

/**
 *
 * @author aleja
 */
public class Conexion {
    public static Connection getConexion() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/asesorias_web";
            String usuario = "root";
            String contrasena = "";
            conexion = DriverManager.getConnection(url, usuario, contrasena);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se pudo cargar el driver de MySQL. " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error: No se pudo establecer la conexión con la base de datos. " + e.getMessage());
        }
        return conexion;
    }
}
