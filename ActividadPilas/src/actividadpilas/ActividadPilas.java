/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividadpilas;

/**
 *
 * @author brooklyn
 */
public class ActividadPilas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pila<String> libros = new Pila<>();
        System.out.println("Pila vacia: " + libros.empty());
        System.out.println("peek en pila vacia: " + libros.peek());
        System.out.println("pop en pila vacia: " + libros.pop());

        libros.push("Orgullo y Prejuicio");
        libros.push("Estudio en Escarlata");
        libros.push("El Conde de Montecristo");

        System.out.println("Cantidad de libros: " + libros.size());
        System.out.println("========================================");
        System.out.println("Tope: " + libros.peek());
        System.out.println("Elemento extraido: " + libros.pop());
        System.out.println("Nuevo tope: " + libros.peek());
        System.out.println("========================================");
        System.out.println("Elemento extraido: " + libros.pop());
        System.out.println("Elemento extraido: " + libros.pop());
        System.out.println("Pila vacia al final: " + libros.empty());
    }
    
}
