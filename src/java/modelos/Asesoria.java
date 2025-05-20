package modelos;

/**
 *
 * @author aleja
 */
public class Asesoria {
    private int idAsesoria;
    private int alumnoId;
    private int profesorId;
    private String materia;
    private boolean esTuDocente;
    private java.sql.Date fechaSolicitud;
    private java.sql.Time horaSolicitud;
    private String asunto;
    private String estado;
    private String comentario;

    public Asesoria() {}

    public Asesoria(int idAsesoria, int alumnoId, int profesorId, String materia, boolean esTuDocente, java.sql.Date fechaSolicitud, java.sql.Time horaSolicitud, String asunto, String estado, String comentario) {
        this.idAsesoria = idAsesoria;
        this.alumnoId = alumnoId;
        this.profesorId = profesorId;
        this.materia = materia;
        this.esTuDocente = esTuDocente;
        this.fechaSolicitud = fechaSolicitud;
        this.horaSolicitud = horaSolicitud;
        this.asunto = asunto;
        this.estado = estado;
        this.comentario = comentario;
    }

    public int getIdAsesoria() { return idAsesoria; }
    public void setIdAsesoria(int idAsesoria) { this.idAsesoria = idAsesoria; }

    public int getAlumnoId() { return alumnoId; }
    public void setAlumnoId(int alumnoId) { this.alumnoId = alumnoId; }

    public int getProfesorId() { return profesorId; }
    public void setProfesorId(int profesorId) { this.profesorId = profesorId; }

    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }

    public boolean isEsTuDocente() { return esTuDocente; }
    public void setEsTuDocente(boolean esTuDocente) { this.esTuDocente = esTuDocente; }

    public java.sql.Date getFechaSolicitud() { return fechaSolicitud; }
    public void setFechaSolicitud(java.sql.Date fechaSolicitud) { this.fechaSolicitud = fechaSolicitud; }

    public java.sql.Time getHoraSolicitud() { return horaSolicitud; }
    public void setHoraSolicitud(java.sql.Time horaSolicitud) { this.horaSolicitud = horaSolicitud; }

    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
}
