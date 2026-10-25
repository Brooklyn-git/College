package com.mycompany.callcenter;

import java.util.LinkedList;

public class Cola<T> {
    private LinkedList<T> lista;
    
    public Cola() {
        lista = new LinkedList<>();
    }
    
    public void enqueue(T dato) {
        lista.addLast(dato);
    }
    
    public void enqueuePrioritario(T dato) {
        lista.addFirst(dato);
    }
    
    public T dequeue() {
        if (empty()) {
            return null;
        }
        return lista.removeFirst();
    }
    
    public T peek() {
        if (empty()) {
            return null;
        }
        return lista.getFirst();
    }
    
    public boolean empty() {
        return lista.isEmpty();
    }
    
    public int size() {
        return lista.size();
    }
    
    public LinkedList<T> getLista() {
        return lista;
    }
}
