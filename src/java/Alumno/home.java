/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Alumno;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Estudiante;

/**
 *
 * @author aleja
 */
public class home extends HttpServlet {

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
            out.println("    <title>Inicio Alumno</title>");
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
            out.println("            <a href='home' class='nav-link nav-link-activo'>HOME</a>");
            out.println("            <a href='registroAsesoria' class='nav-link'>SOLICITAR ASESORIAS</a>");
            out.println("            <a href='citas_asesoria' class='nav-link'>ASESORIAS APROBADAS</a>");
            out.println("            <a href='login/iniciarsesion.jsp' class='nav-link cerrar-sesion'>CERRAR SESIÓN</a>");
            out.println("        </nav>");
            out.println("    </header>");
            out.println("    <main class='main-content'>");
            out.println("        <div class='contenedor-alumno'>");
            out.println("            <div class='info-alumno'>");
            out.println("                Nombre completo del alumno: <strong>" + alumno.getNombre() + "</strong><br><br>");
            out.println("                Matrícula: <strong>" + alumno.getMatricula() + "</strong>");
            out.println("            </div>");
            out.println("            <div class='foto-alumno'>");
            out.println("                <img src='imagenes/estudiante.png' alt='Foto predeterminada del alumno' width='180' height='180' '>");
            out.println("            </div>");
            out.println("        </div>");
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
