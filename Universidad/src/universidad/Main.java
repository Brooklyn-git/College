package universidad;

public class Main {
    public static void main(String[] args) {
        
        Profesor profi = new Profesor("Dr. Leyen", "P001", "leyen@itson.edu", "ISW");

        Curso cursoPOO = new CursoPresencial("Programación OO", "CS101", profi, "Aula 203");
        Curso cursoWeb = new CursoVirtual("Desarrollo Web", "CS102", profi, "Zoom");

        Estudiante e1 = new Estudiante("Luis", "123456", "luis@itson.edu", "ISW", 3);
        Estudiante e2 = new Estudiante("María", "792367", "maria@itson.edu", "ISW", 2);
        Estudiante e3 = new Estudiante("Carlos", "456789", "carlos@itson.edu", "ISW", 1);

        Inscripcion<CursoPresencial> inscripcionPOO = new Inscripcion<CursoPresencial>((CursoPresencial) cursoPOO);
        Inscripcion<CursoVirtual> inscripcionWeb = new Inscripcion<CursoVirtual>((CursoVirtual) cursoWeb);

        System.out.println(">>> Inscribiendo estudiantes en Programación OO...");
        inscripcionPOO.inscribirEstudiante(e1);
        inscripcionPOO.inscribirEstudiante(e2);
        inscripcionPOO.inscribirEstudiante(e3);

        System.out.println("\n>>> Inscribiendo estudiantes en Desarrollo Web...");
        inscripcionWeb.inscribirEstudiante(e1);
        inscripcionWeb.inscribirEstudiante(e2);

        System.out.println("\n>>> Mostrando inscritos en Programación OO:");
        inscripcionPOO.mostrarInscritos();

        System.out.println(">>> Mostrando inscritos en Desarrollo Web:");
        inscripcionWeb.mostrarInscritos();

        System.out.println(">>> Removiendo a Carlos de Programación OO...");
        inscripcionPOO.removerEstudiante(e3);
        inscripcionPOO.mostrarInscritos();

        System.out.println(">>> Intentando inscribir a Luis nuevamente...");
        inscripcionPOO.inscribirEstudiante(e1);
    }
}