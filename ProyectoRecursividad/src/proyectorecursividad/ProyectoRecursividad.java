/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectorecursividad;

/**
 *
 * @author brooklyn
 */
public class ProyectoRecursividad {
    public static int resolverEcuacion(String expresion) {
        if (expresion == null) {
            throw new IllegalArgumentException("La expresión no puede ser null");
        }

        validarEspacios(expresion);

        String expr = expresion.replaceAll("\\s+", "");

        if (expr.isEmpty()) {
            throw new IllegalArgumentException("La expresión está vacía o incompleta");
        }

        validarParentesis(expr);

        // Caso 1: última suma o resta que esté FUERA de paréntesis
        int pos = ultimoOperador(expr, "+-");
        if (pos != -1) {
            int izquierda = resolverEcuacion(expr.substring(0, pos));
            int derecha = resolverEcuacion(expr.substring(pos + 1));
            return (expr.charAt(pos) == '+') ? izquierda + derecha
                                             : izquierda - derecha;
        }

        // Caso 2: última multiplicación que esté FUERA de paréntesis
        pos = ultimoOperador(expr, "*");
        if (pos != -1) {
            return resolverEcuacion(expr.substring(0, pos))
                    * resolverEcuacion(expr.substring(pos + 1));
        }

        // Caso 3: la expresión completa está entre paréntesis
        if (estaEntreParentesis(expr)) {
            return resolverEcuacion(expr.substring(1, expr.length() - 1));
        }

        // Caso base: la expresión tiene que ser un número entero
        return convertirNumero(expr);
    }

    private static int ultimoOperador(String expr, String operadores) {
        int ultimo = -1;
        int profundidad = 0;

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '(') {
                profundidad++;
            } else if (c == ')') {
                profundidad--;
            } else if (profundidad == 0 && operadores.indexOf(c) != -1) {
                ultimo = i; // se queda con el último encontrado
            }
        }
        return ultimo;
    }

    private static boolean estaEntreParentesis(String expr) {
        if (expr.length() < 2 || expr.charAt(0) != '('
                || expr.charAt(expr.length() - 1) != ')') {
            return false;
        }

        int profundidad = 0;
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(') {
                profundidad++;
            } else if (expr.charAt(i) == ')') {
                profundidad--;
            }
            if (profundidad == 0 && i < expr.length() - 1) {
                return false;
            }
        }
        return true;
    }

    private static int convertirNumero(String expr) {
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) < '0' || expr.charAt(i) > '9') {
                throw new IllegalArgumentException(
                        "Expresión inválida: se esperaba un número pero se encontró '"
                        + expr.charAt(i) + "'");
            }
        }
        try {
            return Integer.parseInt(expr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Número fuera de rango: " + expr);
        }
    }

    private static void validarEspacios(String expresion) {
        for (int i = 0; i < expresion.length(); i++) {
            if (Character.isWhitespace(expresion.charAt(i))) {
                int antes = i - 1;
                int despues = i + 1;
                while (antes >= 0 && Character.isWhitespace(expresion.charAt(antes))) {
                    antes--;
                }
                while (despues < expresion.length()
                        && Character.isWhitespace(expresion.charAt(despues))) {
                    despues++;
                }
                if (antes >= 0 && despues < expresion.length()
                        && Character.isDigit(expresion.charAt(antes))
                        && Character.isDigit(expresion.charAt(despues))) {
                    throw new IllegalArgumentException(
                            "Expresión inválida: espacios dentro de un número");
                }
            }
        }
    }

    private static void validarParentesis(String expr) {
        int profundidad = 0;
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(') {
                profundidad++;
            } else if (expr.charAt(i) == ')') {
                profundidad--;
            }
            if (profundidad < 0) {
                throw new IllegalArgumentException(
                        "Expresión inválida: hay un ')' sin '(' que lo abra");
            }
        }
        if (profundidad > 0) {
            throw new IllegalArgumentException(
                    "Expresión inválida: hay un '(' sin ')' que lo cierre");
        }
    }

    public static void main(String[] args) {
        System.out.println("---- Expresiones válidas ----");
        String[] validas = {
            "7+10+2",
            "1+5*(7-1)+10",
            "5+7+(1+2*(8-9)+2)-10",
            "9-2*(75-9+(6+3+(1+2)*1)+7)+9"
        };
        for (String expr : validas) {
            System.out.println("\"" + expr + "\" = " + resolverEcuacion(expr));
        }

        System.out.println("\n---- Expresiones inválidas (deben lanzar excepción) ----");
        String[] invalidas = {
            "5++1+10", // operador repetido
            "-5+10",   // signo al inicio
            "74-7/7",  // operación no soportada
            "10+9-A",  // carácter inválido
            "(1+2",    // paréntesis sin cerrar
            "1+2)"     // paréntesis sin abrir
        };
        for (String expr : invalidas) {
            try {
                resolverEcuacion(expr);
                System.out.println("\"" + expr + "\" -> ERROR: no lanzó excepción");
            } catch (IllegalArgumentException e) {
                System.out.println("\"" + expr + "\" -> Excepción: " + e.getMessage());
            }
        }
    }
}
