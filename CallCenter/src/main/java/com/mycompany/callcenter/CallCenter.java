package com.mycompany.callcenter;

import java.util.LinkedList;

public class CallCenter {
    private Cola<Llamada> colaLlamadas;
    private double tiempoTotal;
    private LinkedList<Integer> puntuaciones;
    
    public CallCenter() {
        colaLlamadas = new Cola<>();
        tiempoTotal = 0.0;
        puntuaciones = new LinkedList<>();
    }
    
    public void recibirLlamada(Llamada llamada) {
        if (llamada.getTipo() == Llamada.Tipo.prioritaria) {
            colaLlamadas.enqueuePrioritario(llamada);
        } else {
            colaLlamadas.enqueue(llamada);
        }
    }
    
    public Llamada atenderLlamada() {
        if (colaLlamadas.empty()) {
            return null;
        }
        Llamada llamada = colaLlamadas.dequeue();
        if (llamada != null) {
            tiempoTotal += llamada.getDuracion();
            puntuaciones.add(llamada.obtenerPuntuacion());
        }
        return llamada;
    }
    
    public void cancelarLlamada() {
        if (!colaLlamadas.empty()) {
            colaLlamadas.dequeue();
        }
    }
    
    public void mostrarCola() {
        System.out.println("=== Llamadas Pendientes ===");
        if (colaLlamadas.empty()) {
            System.out.println("No hay llamadas pendientes.");
            return;
        }
        for (Llamada llamada : colaLlamadas.getLista()) {
            System.out.println("Cliente: " + llamada.getCliente() + ", Duración: " + llamada.getDuracion() + " min, Tipo: " + llamada.getTipo());
        }
        System.out.println("===========================");
    }
    
    public double tiempoTotalPendiente() {
        double total = 0.0;
        for (Llamada llamada : colaLlamadas.getLista()) {
            total += llamada.getDuracion();
        }
        return total;
    }
    
    public int llamadasPendientes() {
        return colaLlamadas.size();
    }
    
    public void atenderTodas() {
        System.out.println("=== Atendiendo Todas las Llamadas ===");
        while (!colaLlamadas.empty()) {
            Llamada llamada = colaLlamadas.dequeue();
            if (llamada != null) {
                tiempoTotal += llamada.getDuracion();
                int puntuacion = llamada.obtenerPuntuacion();
                puntuaciones.add(puntuacion);
                System.out.println("Atendido: " + llamada.getCliente() + " | Duración: " + llamada.getDuracion() + " min | Puntuación: " + puntuacion);
            }
        }
        System.out.println("=====================================");
    }
    
    public int obtenerpromedio() {
        if (puntuaciones.isEmpty()) {
            return 0;
        }
        int suma = 0;
        for (int p : puntuaciones) {
            suma += p;
        }
        return suma / puntuaciones.size();
    }
    
    public double getTiempoTotal() {
        return tiempoTotal;
    }
    
    public LinkedList<Integer> getPuntuaciones() {
        return puntuaciones;
    }
    
    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter();
        
        Llamada l1 = new Llamada(1, "Juan Pérez", Llamada.Tipo.normal, 5.5);
        Llamada l2 = new Llamada(2, "María García", Llamada.Tipo.prioritaria, 3.0);
        Llamada l3 = new Llamada(3, "Carlos López", Llamada.Tipo.normal, 7.2);
        Llamada l4 = new Llamada(4, "Ana Martínez", Llamada.Tipo.prioritaria, 2.5);
        
        System.out.println("=== Recibiendo Llamadas ===");
        callCenter.recibirLlamada(l1);
        callCenter.recibirLlamada(l2);
        callCenter.recibirLlamada(l3);
        callCenter.recibirLlamada(l4);
        System.out.println("Llamadas recibidas.\n");
        
        callCenter.mostrarCola();
        System.out.println("Llamadas pendientes: " + callCenter.llamadasPendientes());
        System.out.println("Tiempo total pendiente: " + callCenter.tiempoTotalPendiente() + " min\n");
        
        System.out.println("=== Atendiendo una llamada ===");
        Llamada atendida = callCenter.atenderLlamada();
        if (atendida != null) {
            System.out.println("Se atendió a: " + atendida.getCliente());
        }
        System.out.println("Tiempo total atendido: " + callCenter.getTiempoTotal() + " min\n");
        
        callCenter.mostrarCola();
        System.out.println("Llamadas pendientes: " + callCenter.llamadasPendientes() + "\n");
        
        System.out.println("=== Cancelando una llamada ===");
        callCenter.cancelarLlamada();
        System.out.println("Llamada cancelada.\n");
        
        callCenter.mostrarCola();
        System.out.println("Llamadas pendientes: " + callCenter.llamadasPendientes() + "\n");
        
        System.out.println("=== Atendiendo todas las restantes ===");
        callCenter.atenderTodas();
        System.out.println("Tiempo total: " + callCenter.getTiempoTotal() + " min");
        System.out.println("Promedio de puntuación: " + callCenter.obtenerpromedio());
    }
}
