package universidad;

public abstract class Persona {
    
    protected String nombre;
    protected String id;
    protected String correo;

    
    public Persona(String nombre, String id, String correo) {
        this.nombre = nombre;
        this.id = id;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public abstract String getRol();
    
    @Override
    public String toString() {
        return nombre + " (" + id + ")";
    }
}