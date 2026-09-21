package universidad;

public abstract class Curso {
    protected String nombreCurso;
    protected String codigoCurso;
    protected Profesor profesor;
    
    public Curso(String nombreCurso, String codigoCurso, Profesor profesor) {
        this.nombreCurso = nombreCurso;
        this.codigoCurso = codigoCurso;
        this.profesor = profesor;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public abstract String getModalidad();

    @Override
    public String toString() {
        return nombreCurso + " (" + codigoCurso + ") - Profesor: " + profesor.getNombre();
    }
}