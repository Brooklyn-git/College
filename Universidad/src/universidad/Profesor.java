package universidad;

public class Profesor extends Persona {
    private String departamento;

    public Profesor(String nombre, String id, String correo, String departamento) {
        super(nombre, id, correo);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String getRol() {
        return "Profesor";
    }

    @Override
    public String toString() {
        return nombre + " (" + id + ")";
    }
}