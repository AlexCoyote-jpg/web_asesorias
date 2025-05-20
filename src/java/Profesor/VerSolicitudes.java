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

/**
 * @author carlos y Angel
 */
public class VerSolicitudes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Profesor profesor = (Profesor) request.getSession().getAttribute("profesor");
        if (profesor == null) {
            response.sendRedirect("login/iniciarsesion.jsp");
            return;
        }

        List<Map<String, Object>> solicitudes = BD.ProcesaAsesoria.getAsesoriasPorProfesor(profesor.getIdProfesor());

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='es'>");
            out.println("<head>");
            out.println("<head><title>Solicitudes</title><meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<link rel='stylesheet' href='estilos.css'></head><body>");
            //Bienvenida
            out.println("    <div class='titulo-bienvenida'>BIENVENIDO: <span style='border-bottom:2px solid #fff; padding:0 2rem;'>" + profesor.getNombre() + "</span></div>");
            //Menu
            out.println("    <header class='header'>");
            out.println("        <img src='imagenes/logo.png' alt='Logo' class='logo' style='height:60px;'>");
            out.println("        <nav class='nav'>");
            out.println("            <a href='homeprofesorr' class='nav-link'>HOME</a>");
            out.println("            <a href='VerSolicitudes' class='nav-link nav-link-activo'>VER SOLICITUDES</a>");
            out.println("            <a href='SolicitudesProximas' class='nav-link'> SOLICITUDES PROXIMAS</a>");
            out.println("            <a href='login/iniciarsesion.jsp' class='nav-link cerrar-sesion'>CERRAR SESIÓN</a>");
            out.println("        </nav>");
            out.println("    </header>");
            //Cuerpo
            out.println("    <main class='main-content'>");
            out.println("        <div class='contenedor-profesor'>");
            out.println("<h2>Solicitudes por Aprobar</h2>");
            out.println("<table border='1' cellpadding='8'>");
            out.println("<tr><th>Alumno</th><th>Matrícula</th><th>Programa</th><th>Materia</th><th>Fecha</th><th>Hora</th><th>Asunto</th><th>Es su alumno</th><th>Responder</th></tr>");

            for (Map<String, Object> s : solicitudes) {
                if (!"en proceso".equals(String.valueOf(s.get("estado")))) {
                    continue;
                }
                out.println("<tr>");
                out.println("<td>" + s.get("nombre") + "</td>");
                out.println("<td>" + s.get("matricula") + "</td>");
                out.println("<td>" + s.get("programa") + "</td>");
                out.println("<td>" + s.get("materia") + "</td>");
                out.println("<td>" + s.get("fecha_solicitud") + "</td>");
                out.println("<td>" + s.get("hora_solicitud") + "</td>");
                out.println("<td>" + s.get("asunto") + "</td>");
                out.println("<td>" + ((s.get("es_tu_docente")).equals('1') ? "Sí" : "No") + "</td>");
  
                out.println("<td>");
                out.println("<form method='post' action='VerSolicitudes'>");
                out.println("<input type='hidden' name='id_asesoria' value='" + s.get("id_asesoria") + "'/>");
                out.println("<select name='estado' required>");
                out.println("<option value=''>Seleccione</option>");
                out.println("<option value='aceptada'>Aceptar</option>");
                out.println("<option value='denegada'>Denegar</option>");
                out.println("</select><br>");
                out.println("<textarea name='comentario' required placeholder='Comentario...' rows='2' cols='20'></textarea><br>");
                out.println("<button type='submit'>Enviar</button>");
                out.println("</form>");
                out.println("</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("        </div>");
            out.println("    </main>");
            //Footer
            out.println("    <footer class='footer'>");
            out.println("        &copy; 2025 Asesorías Web | Mentorízate");
            out.println("    </footer>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_asesoria"));
        String estado = request.getParameter("estado");
        String comentario = request.getParameter("comentario");

        BD.ProcesaAsesoria.responderSolicitud(id, estado, comentario);
        response.sendRedirect("VerSolicitudes");
    }
}
