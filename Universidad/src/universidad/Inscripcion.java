package universidad;

import java.util.ArrayList;
import java.util.List;

public class Inscripcion<T extends Curso> {
    private T curso;
    private List<Estudiante> estudiantesInscritos;

    public Inscripcion(T curso) {
        this.curso = curso;
        this.estudiantesInscritos = new ArrayList<>();
    }

    public void inscribirEstudiante(Estudiante e) {
        if (e == null) {
            System.out.println("Error: El estudiante no puede ser nulo.");
            return;
        }
        
        if (estudiantesInscritos.contains(e)) {
            System.out.println("El estudiante " + e.getNombre() + " ya está inscrito en este curso.");
            return;
        }
        
        estudiantesInscritos.add(e);
        System.out.println("Estudiante " + e.getNombre() + " inscrito exitosamente en " + curso.getNombreCurso());
    }

    public void removerEstudiante(Estudiante e) {
        if (estudiantesInscritos.remove(e)) {
            System.out.println("Estudiante " + e.getNombre() + " removido exitosamente.");
        } else {
            System.out.println("El estudiante " + e.getNombre() + " no está inscrito en este curso.");
        }
    }

    public void mostrarInscritos() {
        System.out.println("\n========================================");
        System.out.println("Curso: " + curso.getNombreCurso() + " (" + curso.getCodigoCurso() + ")");
        System.out.println("Profesor: " + curso.getProfesor().getNombre());
        System.out.println("Modalidad: " + curso.getModalidad());
        System.out.println("========================================");
        System.out.println("Estudiantes inscritos:");
        
        if (estudiantesInscritos.isEmpty()) {
            System.out.println("- No hay estudiantes inscritos.");
        } else {
            for (Estudiante e : estudiantesInscritos) {
                System.out.println("- " + e.getNombre() + " (" + e.getId() + ")");
            }
        }
        
        System.out.println("Total inscritos: " + estudiantesInscritos.size());
        System.out.println("========================================\n");
    }

    public T getCurso() {
        return curso;
    }

    public List<Estudiante> getEstudiantesInscritos() {
        return estudiantesInscritos;
    }
}