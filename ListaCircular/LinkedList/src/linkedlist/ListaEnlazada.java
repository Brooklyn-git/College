/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 *
 * @author labitson
 */
public class ListaEnlazada<T> implements IList<T>, Iterable<T> {
    protected NodoSimple inicio;
    protected NodoSimple fin;
    protected int nElementos;
    private NodoSimple cursor;

    private class NodoSimple {
        private T dato;
        private NodoSimple sig;
        private NodoSimple ant;

        private NodoSimple(T dato) {
            this.dato = dato;
        }
    }

    @Override
    public void append(T elemento) throws ListException {
        insert(elemento, nElementos);
    }

    @Override
    public void insert(T elemento, int index) throws ListException {
        if (index < 0 || index > nElementos) {
            throw new ListException("Index out of bounds: " + index);
        }

        NodoSimple nuevo = new NodoSimple(elemento);
        if (nElementos == 0) {
            nuevo.sig = nuevo;
            nuevo.ant = nuevo;
            inicio = nuevo;
            fin = nuevo;
        } else if (index == 0) {
            nuevo.sig = inicio;
            nuevo.ant = fin;
            inicio.ant = nuevo;
            fin.sig = nuevo;
            inicio = nuevo;
        } else if (index == nElementos) {
            nuevo.sig = inicio;
            nuevo.ant = fin;
            fin.sig = nuevo;
            inicio.ant = nuevo;
            fin = nuevo;
        } else {
            NodoSimple siguiente = nodoEn(index);
            NodoSimple anterior = siguiente.ant;
            nuevo.sig = siguiente;
            nuevo.ant = anterior;
            anterior.sig = nuevo;
            siguiente.ant = nuevo;
        }
        nElementos++;
    }

    @Override
    public T remove(int index) throws ListException {
        validarIndice(index);
        NodoSimple eliminado = nodoEn(index);

        if (nElementos == 1) {
            inicio = null;
            fin = null;
            cursor = null;
        } else {
            eliminado.ant.sig = eliminado.sig;
            eliminado.sig.ant = eliminado.ant;
            if (eliminado == inicio) {
                inicio = eliminado.sig;
            }
            if (eliminado == fin) {
                fin = eliminado.ant;
            }
            if (cursor == eliminado) {
                cursor = eliminado.sig;
            }
        }
        nElementos--;
        eliminado.sig = null;
        eliminado.ant = null;
        return eliminado.dato;
    }

    @Override
    public boolean removeObj(T elemento) throws ListException {
        int index = indexOf(elemento);
        if (index < 0) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public int indexOf(T elemento) {
        NodoSimple nodo = inicio;
        for (int index = 0; index < nElementos; index++) {
            if (Objects.equals(nodo.dato, elemento)) {
                return index;
            }
            nodo = nodo.sig;
        }
        return -1;
    }

    @Override
    public T get(int index) throws ListException {
        return nodoEn(index).dato;
    }

    @Override
    public void set(T elemento, int index) throws ListException {
        nodoEn(index).dato = elemento;
    }

    @Override
    public void clear() {
        inicio = null;
        fin = null;
        cursor = null;
        nElementos = 0;
    }

    @Override
    public boolean empty() {
        return nElementos == 0;
    }

    @Override
    public int size() {
        return nElementos;
    }

    @Override
    public Iterator<T> Iterator() {
        return iterator();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private NodoSimple siguiente = inicio;
            private int restantes = nElementos;

            @Override
            public boolean hasNext() {
                return restantes > 0;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T dato = siguiente.dato;
                siguiente = siguiente.sig;
                restantes--;
                return dato;
            }
        };
    }

    public void irInicio() {
        cursor = inicio;
    }

    public void irFinal() {
        cursor = fin;
    }

    @Override
    public T next() {
        validarCursor();
        T dato = cursor.dato;
        cursor = cursor.sig;
        return dato;
    }

    @Override
    public T previous() {
        validarCursor();
        T dato = cursor.dato;
        cursor = cursor.ant;
        return dato;
    }

    public void invertir() {
        if (nElementos < 2) {
            return;
        }

        NodoSimple nodo = inicio;
        for (int i = 0; i < nElementos; i++) {
            NodoSimple siguiente = nodo.sig;
            nodo.sig = nodo.ant;
            nodo.ant = siguiente;
            nodo = siguiente;
        }
        NodoSimple anteriorInicio = inicio;
        inicio = fin;
        fin = anteriorInicio;
    }

    public void concatenar(ListaEnlazada<T> otraLista) {
        Objects.requireNonNull(otraLista, "otraLista no puede ser null");
        int elementosPorCopiar = otraLista.nElementos;
        NodoSimple nodo = otraLista.inicio;
        for (int i = 0; i < elementosPorCopiar; i++) {
            append(nodo.dato);
            nodo = nodo.sig;
        }
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder("[");
        NodoSimple nodo = inicio;
        for (int i = 0; i < nElementos; i++) {
            if (i > 0) {
                resultado.append(", ");
            }
            resultado.append(nodo.dato);
            nodo = nodo.sig;
        }
        return resultado.append(']').toString();
    }

    private NodoSimple nodoEn(int index) {
        validarIndice(index);
        if (index <= nElementos / 2) {
            NodoSimple nodo = inicio;
            for (int i = 0; i < index; i++) {
                nodo = nodo.sig;
            }
            return nodo;
        }
        NodoSimple nodo = fin;
        for (int i = nElementos - 1; i > index; i--) {
            nodo = nodo.ant;
        }
        return nodo;
    }

    private void validarIndice(int index) {
        if (index < 0 || index >= nElementos) {
            throw new ListException("Index out of bounds: " + index);
        }
    }

    private void validarCursor() {
        if (cursor == null) {
            throw new ListException("La lista esta vacia o el cursor no esta posicionado");
        }
    }
}
