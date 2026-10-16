package actividadpilas;

public class Pila<T> {
    private Nodo tope;
    private int nElementos;

    private class Nodo {
        private final T elemento;
        private final Nodo siguiente;

        private Nodo(T elemento, Nodo siguiente) {
            this.elemento = elemento;
            this.siguiente = siguiente;
        }
    }

    public Pila() {
        tope = null;
        nElementos = 0;
    }

    public void push(T elemento) {
        tope = new Nodo(elemento, tope);
        nElementos++;
    }

    public T pop() {
        if (empty()) {
            return null;
        }

        T elemento = tope.elemento;
        tope = tope.siguiente;
        nElementos--;
        return elemento;
    }

    public T peek() {
        return empty() ? null : tope.elemento;
    }

    public boolean empty() {
        return nElementos == 0;
    }

    public int size() {
        return nElementos;
    }
}
