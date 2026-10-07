/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlist;

/**
 *
 * @author labitson
 */
public class LinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaEnlazada<String> materias = new ListaEnlazada<>();
        materias.append("Matematicas");
        materias.append("Programacion");
        materias.insert("Bases de datos", 1);
        System.out.println("Lista: " + materias);
        System.out.println("Elemento en indice 1: " + materias.get(1));
        System.out.println("Elemento removido: " + materias.remove(0));
        System.out.println("Tamano: " + materias.size());

        ListaEnlazada<String> optativas = new ListaEnlazada<>();
        optativas.append("Redes");
        optativas.append("Sistemas operativos");
        materias.concatenar(optativas);
        System.out.println("Listas concatenadas: " + materias);

        materias.invertir();
        System.out.println("Lista invertida: " + materias);
        materias.clear();
        System.out.println("Despues de clear, esta vacia: " + materias.empty());
    }
    
}
