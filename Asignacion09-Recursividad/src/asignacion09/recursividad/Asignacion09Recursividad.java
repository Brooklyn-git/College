/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asignacion09.recursividad;

/**
 *
 * @author brooklyn
 */
public class Asignacion09Recursividad {


    public static long fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int mcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return mcd(b, a % b);
    }


    public static int count(Object datos[], int n, Object o) {
        if (n <= 0) {
            return 0;
        }
        if (datos[n - 1] == null && o == null) {
            return 1 + count(datos, n - 1, o);
        } else if (datos[n - 1] != null && datos[n - 1].equals(o)) {
            return 1 + count(datos, n - 1, o);
        } else {
            return count(datos, n - 1, o);
        }
    }

    public static void reverse(Object datos[], int inicio, int fin) {
        if (inicio >= fin) {
            return;
        }
        Object temp = datos[inicio];
        datos[inicio] = datos[fin];
        datos[fin] = temp;
        reverse(datos, inicio + 1, fin - 1);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Fibonacci de 5: " + fibonacci(5));        
        System.out.println("Fibonacci de 40: " + fibonacci(40));
        
        System.out.println("MCD de 45 y 75: " + mcd(45, 75));
        System.out.println("MCD de 47 y 91: " + mcd(47, 91));
        
        Integer[] arr1 = {1, 2, 3, 3, 2, 3, 1};
        System.out.println("Ocurrencias de 3 en [1, 2, 3, 3, 2, 3, 1]: " + count(arr1, arr1.length, 3));
        System.out.println("Ocurrencias de 1 en [1, 2, 3, 3, 2, 3, 1]: " + count(arr1, arr1.length, 1));
        
        Character[] arr2 = {'A', 'B', 'C', 'B', 'A', 'B', 'D'};
        System.out.println("Ocurrencias de 'C' en ['A', 'B', 'C', 'B', 'A', 'B', 'D']: " + count(arr2, arr2.length, 'C'));
        System.out.println("Ocurrencias de 'E' en ['A', 'B', 'C', 'B', 'A', 'B', 'D']: " + count(arr2, arr2.length, 'E'));
        
        Integer[] arr3 = {1, 2, 3, 4, 5};
        reverse(arr3, 0, arr3.length - 1);
        System.out.print("Arreglo [1,2,3,4,5] invertido: ");
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i]);
            if (i < arr3.length - 1) System.out.print(", ");
        }
        System.out.println();
        
        Character[] arr4 = {'A', 'B', 'C', 'D'};
        reverse(arr4, 0, arr4.length - 1);
        System.out.print("Arreglo ['A','B','C','D'] invertido: ");
        for (int i = 0; i < arr4.length; i++) {
            System.out.print("'" + arr4[i] + "'");
            if (i < arr4.length - 1) System.out.print(", ");
        }
        System.out.println();
    }
    
}
