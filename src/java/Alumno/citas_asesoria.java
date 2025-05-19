/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Alumno;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import BD.ProcesaAsesoria;
import modelos.Estudiante;

/**
 *
 * @author aleja
 */
public class citas_asesoria extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='es'>");
            out.println("<head>");
            out.println("    <meta charset='UTF-8'>");
            out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("    <title>Solicitar Asesoría</title>");
            out.println("    <link rel='stylesheet' href='estilos.css'>");
            out.println("</head>");
            out.println("<body>");
            Estudiante alumno = (Estudiante) request.getSession().getAttribute("alumno");
            if (alumno == null) {
                response.sendRedirect("login/iniciarsesion.jsp");
                return;
            }
            out.println("    <div class='titulo-bienvenida'>BIENVENIDO: <span style='border-bottom:2px solid #fff; padding:0 2rem;'>" + alumno.getNombre() + "</span></div>");
            out.println("    <header class='header'>");
            out.println("        <img src='imagenes/logo.png' alt='Logo' class='logo' style='height:60px;'>");
            out.println("        <nav class='nav'>");
            out.println("            <a href='home' class='nav-link'>HOME</a>");
            out.println("            <a href='registroAsesoria' class='nav-link'>SOLICITAR ASESORIAS</a>");
            out.println("            <a href='citas_asesoria' class='nav-link nav-link-activo'>ASESORIAS APROBADAS</a>");
            out.println("            <a href='login/iniciarsesion.jsp' class='nav-link cerrar-sesion'>CERRAR SESIÓN</a>");
            out.println("        </nav>");
            out.println("    </header>");
            out.println("    <main class='main-content'>");
            out.println("        <h2>Tus citas de asesoría</h2>");
            out.println("        <table border='1'><tr><th>Materia</th><th>Fecha</th><th>Hora</th><th>Estado</th><th>Comentario</th></tr>");
            int idAlumno = alumno.getIdEstudiante();
            List<Map<String, Object>> citas = ProcesaAsesoria.getAsesoriasPorAlumno(idAlumno);
            for (Map<String, Object> cita : citas) {
                out.println("<tr>");
                out.println("<td>" + cita.get("materia") + "</td>");
                out.println("<td>" + cita.get("fecha_solicitud") + "</td>");
                out.println("<td>" + cita.get("hora_solicitud") + "</td>");
                out.println("<td>" + cita.get("estado") + "</td>");
                out.println("<td>" + (cita.get("comentario") != null ? cita.get("comentario") : "") + "</td>");
                out.println("</tr>");
            }
            out.println("        </table>");
            out.println("    </main>");
            out.println("    <footer class='footer'>");
            out.println("        &copy; 2025 Asesorías Web | Mentorízate");
            out.println("    </footer>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
