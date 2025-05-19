


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BD.ProcesaProfesor" %>
<%@page import="modelos.Profesor" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mentorízate - Login Profesor</title>
        <link rel="stylesheet" type="text/css" href="login.css">
    </head>
    <body class="login-bg">
        <div class="login-container">
            <img src="../imagenes/logo.png" alt="Logo" class="logo-img logo-img-grande">
            <div class="bienvenida bienvenida-grande">BIENVENIDO PROFESOR</div>
            <% String mensaje = "";
            if (request.getMethod().equalsIgnoreCase("POST")) {
                String matricula = request.getParameter("matricula");
                String contrasena = request.getParameter("contrasena");
                Profesor alumno = ProcesaProfesor.autenticarProfesor(matricula, contrasena);
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
