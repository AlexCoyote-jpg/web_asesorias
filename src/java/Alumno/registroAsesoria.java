package Alumno;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import BD.ProcesaProfesor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Estudiante;
import modelos.Profesor;

/**
 *
 * @author aleja
 */
public class registroAsesoria extends HttpServlet {

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
            out.println("            <a href='registroAsesoria' class='nav-link nav-link-activo'>SOLICITAR ASESORIAS</a>");
            out.println("            <a href='citas_asesoria' class='nav-link nav-link'>ASESORIAS APROBADAS</a>");
            out.println("            <a href='login/iniciarsesion.jsp' class='nav-link cerrar-sesion'>CERRAR SESIÓN</a>");
            out.println("        </nav>");
            out.println("    </header>");
            out.println("    <main class='main-content'>");
            out.println("        <form class='form-solicitud' action='' method='post'>");
            out.println("            Nombre: <input type='text' name='nombre' value='" + alumno.getNombre() + "' class='input-alumno' readonly><br>");
            out.println("            Matricula: <input type='number' name='matricula' value='" + alumno.getMatricula() + "' class='input-alumno' readonly><br>");
            out.println("            Carrera: <select name=\"Programa_educativo\" class='input-alumno' required disabled>");
            out.println("                <option value='" + alumno.getPrograma() + "' selected>" + alumno.getPrograma() + "</option>");
            out.println("            </select><br>");
            out.println("            Asesoria: <input type='text' name='asesoria' placeholder='Tipo de asesoría' class='input-alumno' required><br>");
            out.println("            Profesor: <select name=\"select-profesor\" class='input-alumno' required>");
            out.println("                <option value=''>Seleccione un profesor</option>");
            List<Profesor> profesores = ProcesaProfesor.obtenerProfesores();
            for (Profesor prof : profesores) {
                out.println("                <option value='" + prof.getIdProfesor() + "'>" + prof.getNombre() + " (" + prof.getPrograma() + ")</option>");
            }
            out.println("            </select><br>");
            out.println("            Eres su Alumno?: ");
            out.println("            <input type='radio' name='pertenencia' value='si' class='input-alumno' required> Sí");
            out.println("            <input type='radio' name='pertenencia' value='no' class='input-alumno' required> No<br>");
            out.println("            Fecha: <input type='date' name='fecha' placeholder='Fecha de la asesoría' class='input-alumno' required><br>");
            out.println("            Hora: <input type='time' name='hora' placeholder='Hora de la asesoría' class='input-alumno' required><br>");
            out.println("            Asunto: <textarea name='descripcion' placeholder='Descripción de la asesoría' class='input-alumno' required></textarea><br>");
            out.println("            <button type='submit' class='input-alumno'>Enviar</button>");
            out.println("        </form>");
            boolean exito = false;
            String mensaje = null;
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                String nombre = request.getParameter("nombre");
                String matricula = request.getParameter("matricula");
                String programa = request.getParameter("Programa_educativo");
                String asesoria = request.getParameter("asesoria");
                int profesorId = Integer.parseInt(request.getParameter("select-profesor"));
                String pertenencia = request.getParameter("pertenencia");
                boolean esTuDocente = "si".equalsIgnoreCase(pertenencia);
                String fecha = request.getParameter("fecha");
                String hora = request.getParameter("hora");
                String asunto = request.getParameter("descripcion");
                try (Connection con = BD.Conexion.getConexion()) {
                    String sql = "INSERT INTO asesorias (alumno_id, profesor_id, materia, es_tu_docente, fecha_solicitud, hora_solicitud, asunto, estado) VALUES (?, ?, ?, ?, ?, ?, ?, 'en proceso')";
                    try (PreparedStatement ps = con.prepareStatement(sql)) {
                        ps.setInt(1, alumno.getIdEstudiante());
                        ps.setInt(2, profesorId);
                        ps.setString(3, asesoria);
                        ps.setBoolean(4, esTuDocente);
                        ps.setDate(5, java.sql.Date.valueOf(fecha));
                        ps.setTime(6, java.sql.Time.valueOf(hora + ":00"));
                        ps.setString(7, asunto);
                        ps.executeUpdate();
                        exito = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    mensaje = "<div style='color:red;'>Error al registrar la asesoría: " + e.getMessage() + "</div>";
                }
                if (exito) {
                    mensaje = "<div id='msg-exito' style='color:green;'>¡Solicitud de asesoría enviada correctamente!</div>";
                }
            }
            if (mensaje != null) {
                out.println(mensaje);
                out.println("<script>setTimeout(function(){ var m=document.getElementById('msg-exito'); if(m){ m.style.display='none'; } }, 2500);</script>");
            }
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
