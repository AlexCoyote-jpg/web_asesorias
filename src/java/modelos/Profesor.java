/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author aleja
 */
public class Profesor {
    private int idProfesor;
    private String nombre;
    private String claveProfesor;
    private String contrasena;
    private String programa;

    public Profesor() {
    }

    public Profesor(int idProfesor, String nombre, String claveProfesor, String contrasena, String programa) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.claveProfesor = claveProfesor;
        this.contrasena = contrasena;
        this.programa = programa;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClaveProfesor() {
        return claveProfesor;
    }

    public void setClaveProfesor(String claveProfesor) {
        this.claveProfesor = claveProfesor;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }
}
