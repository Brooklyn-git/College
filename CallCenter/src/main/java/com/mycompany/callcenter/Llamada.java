package com.mycompany.callcenter;

import java.util.Random;

public class Llamada {
    public enum Tipo {
        normal, prioritaria
    }
    
    private int id;
    private String cliente;
    private Tipo tipo;
    private double duracion;
    private static Random random = new Random();
    
    public Llamada(int id, String cliente, Tipo tipo, double duracion) {
        this.id = id;
        this.cliente = cliente;
        this.tipo = tipo;
        this.duracion = duracion;
    }
    
    public int obtenerPuntuacion() {
        return random.nextInt(10) + 1;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getCliente() {
        return cliente;
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    public Tipo getTipo() {
        return tipo;
    }
    
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    public double getDuracion() {
        return duracion;
    }
    
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
    
    @Override
    public String toString() {
        return "Llamada{" + "id=" + id + ", cliente='" + cliente + '\'' + ", tipo=" + tipo + ", duracion=" + duracion + '}';
    }
}
