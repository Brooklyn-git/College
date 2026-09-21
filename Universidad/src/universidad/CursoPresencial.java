package universidad;

public class CursoPresencial extends Curso {
    
    private String aula;

    public CursoPresencial(String nombreCurso, String codigoCurso, Profesor profesor, String aula) {
        super(nombreCurso, codigoCurso, profesor);
        this.aula = aula;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    @Override
    public String getModalidad() {
        return "Presencial - Aula: " + aula;
    }
}