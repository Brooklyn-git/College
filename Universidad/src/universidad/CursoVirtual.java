package universidad;

public class CursoVirtual extends Curso {
    
    private String plataforma;

    public CursoVirtual(String nombreCurso, String codigoCurso, Profesor profesor, String plataforma) {
        super(nombreCurso, codigoCurso, profesor);
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    @Override
    public String getModalidad() {
        return "Virtual - Plataforma: " + plataforma;
    }
}