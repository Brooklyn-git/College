
package com.mycompany.recursiva;

/**
 *
 * @author brooklyn
 */
public class Recursiva {

    public static int sumaHastaN(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumaHastaN(n - 1);
    }

    public static String invertirString(String texto) {
        if (texto.length() <= 1) {
            return texto;
        }
        return texto.charAt(texto.length() - 1) 
                + invertirString(texto.substring(0, texto.length() - 1));
    }

    public static int contarDigitos(int numero) {
        if (numero < 10) {
            return 1;
        }
        return 1 + contarDigitos(numero / 10);
    }

    
    
    
    
    public static void main(String[] args) {
        int n = 5;
        System.out.println("1. Suma de 1 hasta " + n + " = " + sumaHastaN(n));

        String texto = "Murcielago";
        System.out.println("2. Invertir \"" + texto + "\" = \"" 
                + invertirString(texto) + "\"");

        int numero = 78951;
        System.out.println("3. Dígitos de " + numero + " = " 
                + contarDigitos(numero));
    }
}
