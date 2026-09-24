package listaarreglo;

public class ListaArreglo {

    public static void main(String[] args) {

        ArrayList<String> array = new ArrayList<String>(String.class, 10);

        array.append("Mouse");
        array.insert("teclado", 0);
        array.append("Monitor");
        array.append("Termo de agua");
        array.remove(2);

        System.out.println("===================================");
        System.out.println("         LISTA Actual    ");
        System.out.println("===================================");
        System.out.println(array.toString());

        System.out.println("\n===================================");
        System.out.println("         IndexOf");
        System.out.println("===================================");

        System.out.println("indexOf(\"Mouse\"): " + array.indexOf("Mouse")); // 1
        System.out.println("indexOf(\"X\"): " + array.indexOf("X"));        // -1

        System.out.println("\n===================================");
        System.out.println("         RemoveObj");
        System.out.println("===================================");
        System.out.println("removeObj(\"Mouse\"): " + array.removeObj("Mouse")); // true
        System.out.println("removeObj(\"X\"): " + array.removeObj("X"));         // false

        System.out.println("\n===================================");
        System.out.println("            Clear");
        System.out.println("===================================");
        array.clear();
        System.out.println("clear -> " + array.toString()); // []
        System.out.println("size -> " + array.size());      // 0
    }
}