<%-- 
    Document   : loginAlumno
    Created on : 18 may 2025, 5:43:36 p.m.
    Author     : aleja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BD.ProcesaAlumno" %>
<%@page import="modelos.Estudiante" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mentorízate - Login Alumno</title>
        <link rel="stylesheet" type="text/css" href="login.css">
    </head>
    <body class="login-bg">
        <div class="login-container">
            <img src="../imagenes/logo.png" alt="Logo" class="logo-img logo-img-grande">
            <div class="bienvenida bienvenida-grande">BIENVENIDO ALUMNO:</div>
            <% String mensaje = "";
            if (request.getMethod().equalsIgnoreCase("POST")) {
                String matricula = request.getParameter("matricula");
                String contrasena = request.getParameter("contrasena");
                Estudiante alumno = ProcesaAlumno.autenticarAlumno(matricula, contrasena);
                if (alumno != null) {
                    session.setAttribute("alumno", alumno);
                    response.sendRedirect(request.getContextPath() + "/home");
                    return;
                } else {
                    mensaje = "Matrícula o contraseña incorrecta.";
                }
            }
            %>
            <form class="form-login" action="" method="post">
                <label for="matricula" class="label-login label-login-center">Usuario:</label>
                <input type="number" id="matricula" name="matricula" class="input-login" required placeholder="Ingresa tu matrícula"><br>
                <label for="contrasena" class="label-login label-login-center">Contraseña:</label>
                <input type="password" id="contrasena" name="contrasena" class="input-login" required placeholder="Ingresa tu contraseña"><br>
                <button type="submit" class="btn-login btn-login-efecto">INICIAR SESIÓN</button>
                <div class="registro-link registro-link-center">
                    <a href="registro.jsp" class="registro-link-bonito">Registrarse</a>
                </div>
            </form>
            <div class="mensaje-error"><%= mensaje %></div>
        </div>
    </body>
</html>
