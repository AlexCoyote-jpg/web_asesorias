package Profesor;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Profesor;

/**
 * @author aleja
 */
public class homeprofesorr extends HttpServlet {

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
            //Validar sesión
            Profesor profesor = (Profesor) request.getSession().getAttribute("profesor");
            if (profesor == null) {
                response.sendRedirect("login/iniciarsesion.jsp");
                return;
            }
            //HTML Completo
            out.println("<!DOCTYPE html>");
            out.println("<html lang='es'>");
            out.println("<head>");
            out.println("    <meta charset='UTF-8'>");
            out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("    <title>Inicio Profesor</title>");
            out.println("    <link rel='stylesheet' href='estilos.css'>");
            out.println("</head>");
            out.println("<body>");
            //Bienvenida
            out.println("    <div class='titulo-bienvenida'>BIENVENIDO: <span style='border-bottom:2px solid #fff; padding:0 2rem;'>" + profesor.getNombre() + "</span></div>");
            //Menu
            out.println("    <header class='header'>");
            out.println("        <img src='imagenes/logo.png' alt='Logo' class='logo' style='height:60px;'>");
            out.println("        <nav class='nav'>");
            out.println("            <a href='homeprofesorr' class='nav-link nav-link-activo'>HOME</a>");
            out.println("            <a href='VerSolicitudes' class='nav-link'>VER SOLICITUDES</a>");
            out.println("            <a href='SolicitudesProximas' class='nav-link'> SOLICITUDES PROXIMAS</a>");
            out.println("            <a href='login/iniciarsesion.jsp' class='nav-link cerrar-sesion'>CERRAR SESIÓN</a>");
            out.println("        </nav>");
            out.println("    </header>");
            //Cuerpo
            out.println("    <main class='main-content'>");
            out.println("        <div class='contenedor-alumno'>");
            out.println("            <div class='info-alumno'>");
            out.println("            <strong>Nombre completo:</strong><br>" + profesor.getNombre() + "<br><br>");
            out.println("            <strong>Clave:</strong><br>" + profesor.getClaveProfesor());
            out.println("            </div>");
            out.println("            <div class='foto-alumno'>");
            out.println("                <img src='imagenes/profesor.png' alt='Foto predeterminada del alumno' width='180' height='180' '>");
            out.println("            </div>");
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
        return "Página de inicio del profesor con navegación y datos básicos";
    }// </editor-fold>

}
