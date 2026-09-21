/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidad;

public class Estudiante extends Persona {
    private String carrera;
    private int semestre;

    public Estudiante(String nombre, String id, String correo, String carrera, int semestre) {
        super(nombre, id, correo);
        this.carrera = carrera;
        this.semestre = semestre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public String getRol() {
        return "Estudiante";
    }

    @Override
    public String toString() {
        return nombre + " (" + id + ")";
    }
}