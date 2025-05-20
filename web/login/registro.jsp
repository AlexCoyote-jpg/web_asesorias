<%-- 
    Document   : Registro
    Created on : 18 may 2025, 6:07:55 p.m.
    Author     : Angel David SM
--%>
<%@page import="java.sql.*"%>
<%@page import="BD.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String error = null;
    String exito = null;

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String nombre = request.getParameter("nombre");
        String id = request.getParameter("id");
        String contrasena = request.getParameter("contrasena");
        String programa = request.getParameter("programa");
        String tipo = request.getParameter("tipo");

        try {
            Connection con = Conexion.getConexion();
            String sql;

            if ("alumno".equals(tipo)) {
                sql = "INSERT INTO alumnos (nombre, matricula, contrasena, programa) VALUES (?, ?, ?, ?)";
            } else {
                sql = "INSERT INTO profesores (nombre, clave_profesor, contrasena, programa) VALUES (?, ?, ?, ?)";
            }

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, id);
            ps.setString(3, contrasena);
            ps.setString(4, programa);
            ps.executeUpdate();

            ps.close();
            con.close();

            exito = "¡Registro exitoso! Ahora puedes iniciar sesión.";
        } catch (Exception e) {
            error = "Error al registrar: " + e.getMessage();
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mentorízate - Registrarse</title>
    <link rel="stylesheet" type="text/css" href="login.css">
</head>
<body class="login-bg">
    <div class="login-container">
        <img src="../imagenes/logo.png" alt="Logo" class="logo-img logo-img-grande">
        <div class="bienvenida bienvenida-grande">REGISTRARSE:</div>

        <% if (error != null) { %>
            <div style="color:red; text-align:center; margin-bottom: 10px;"><%= error %></div>
        <% } else if (exito != null) { %>
            <div style="color:green; text-align:center; margin-bottom: 10px;"><%= exito %></div>
        <% } %>

        <form class="form-login" action="registro.jsp" method="post">
            <label for="nombre" class="label-login label-login-center">Nombre:</label>
            <input type="text" id="nombre" name="nombre" class="input-login" required><br>

            <label for="id" class="label-login label-login-center">Matrícula o Clave:</label>
            <input type="text" id="id" name="id" class="input-login" required><br>

            <label for="contrasena" class="label-login label-login-center">Contraseña:</label>
            <input type="password" id="contrasena" name="contrasena" class="input-login" required><br>

            <label for="programa" class="label-login label-login-center">Programa:</label>
            <select id="programa" name="programa" class="input-login" required>
                <option value="ICC">ICC</option>
                <option value="LCC">LCC</option>
                <option value="ITI">ITI</option>
            </select><br>

            <label for="tipo" class="label-login label-login-center">Tipo de usuario:</label>
            <select id="tipo" name="tipo" class="input-login" required>
                <option value="alumno">Alumno</option>
                <option value="profesor">Profesor</option>
            </select><br>

            <button type="submit" class="btn-login btn-login-efecto">Registrarse</button>

            <div class="registro-link registro-link-center">
                <a href="iniciarsesion.jsp" class="registro-link-bonito">Iniciar Sesión</a>
            </div>
        </form>
    </div>
</body>
</html>
