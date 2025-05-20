package Profesor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Profesor;

public class SolicitudesProximas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Profesor profesor = (Profesor) request.getSession().getAttribute("profesor");
            if (profesor == null) {
                response.sendRedirect("login/iniciarsesion.jsp");
                return;
            }

            List<Map<String, Object>> solicitudes = BD.ProcesaAsesoria.getAsesoriasPorProfesor(profesor.getIdProfesor());

            out.println("<!DOCTYPE html>");
            out.println("<html lang='es'>");
            out.println("<head>");
            out.println("    <meta charset='UTF-8'>");
            out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("    <title>Solicitudes Aceptadas</title>");
            out.println("    <link rel='stylesheet' href='estilos.css'>");
            out.println("<style>");
out.println("table {");
out.println("    width: 100%;");
out.println("    border-collapse: collapse;");
out.println("    background-color: white;");
out.println("    border: 2px solid black;");
out.println("}");
out.println("th, td {");
out.println("    border: 1px solid black;");
out.println("    padding: 8px;");
out.println("    text-align: left;");
out.println("}");
out.println("th {");
out.println("    background-color: #f2f2f2;");
out.println("    font-weight: bold;");
out.println("}");
out.println("button {");
out.println("    background-color: #4CAF50;");
out.println("    color: white;");
out.println("    padding: 10px 20px;");
out.println("    border: none;");
out.println("    cursor: pointer;");
out.println("    border-radius: 5px;");
out.println("    margin-top: 10px;");
out.println("}");
out.println("button:hover {");
out.println("    background-color: #45a049;");
out.println("}");
out.println("form {");
out.println("    display: flex;");
out.println("    flex-direction: column;");
out.println("}");
out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            out.println("    <div class='titulo-bienvenida'>BIENVENIDO: <span style='border-bottom:2px solid #fff; padding:0 2rem;'>" + profesor.getNombre() + "</span></div>");
            out.println("    <header class='header'>");
            out.println("        <img src='imagenes/logo.png' alt='Logo' class='logo' style='height:60px;'>");
            out.println("        <nav class='nav'>");
            out.println("            <a href='homeprofesorr' class='nav-link'>HOME</a>");
            out.println("            <a href='VerSolicitudes' class='nav-link'>VER SOLICITUDES</a>");
            out.println("            <a href='SolicitudesProximas' class='nav-link nav-link-activo'>SOLICITUDES PRÓXIMAS</a>");
            out.println("            <a href='login/iniciarsesion.jsp' class='nav-link cerrar-sesion'>CERRAR SESIÓN</a>");
            out.println("        </nav>");
            out.println("    </header>");

            out.println("    <main class='main-content'>");
            out.println("        <div class='contenedor-profesor'>");
            out.println("        <h2>Solicitudes Aceptadas</h2>");
            out.println("        <table border='1' cellpadding='8'>");
            out.println("            <tr><th>Fecha</th><th>Hora</th><th>Alumno</th><th>Materia</th><th>Asunto</th><th>Estado</th></tr>");

            for (Map<String, Object> s : solicitudes) {
                if (!"aceptada".equalsIgnoreCase(String.valueOf(s.get("estado")))) {
                    continue;
                }

                out.println("            <tr>");
                out.println("                <td>" + s.get("fecha_solicitud") + "</td>");
                out.println("                <td>" + s.get("hora_solicitud") + "</td>");
                out.println("                <td>" + s.get("nombre") + "</td>");
                out.println("                <td>" + s.get("materia") + "</td>");
                out.println("                <td>" + s.get("asunto") + "</td>");
                out.println("                <td>" + s.get("estado") + "</td>");
                out.println("            </tr>");
            }

            out.println("        </table>");
            out.println("        </div>");
            out.println("    </main>");

            out.println("    <footer class='footer'>");
            out.println("        &copy; 2025 Asesorías Web | Mentorízate");
            out.println("    </footer>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}