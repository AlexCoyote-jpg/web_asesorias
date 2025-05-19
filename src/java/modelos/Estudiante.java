/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author aleja
 */
public class Estudiante {
    private int idEstudiante;
    private String nombre;
    private String matricula;
    private String contrasena;
    private String programa;

    public Estudiante() {
    }

    public Estudiante(int idEstudiante, String nombre, String matricula, String contrasena, String programa) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.matricula = matricula;
        this.contrasena = contrasena;
        this.programa = programa;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
