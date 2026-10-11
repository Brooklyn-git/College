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
    protected int nElementos;
    
    public ListaEnlazada(){
        inicio = null;
        nElementos = 0;
    }

    private class NodoSimple {
        private T dato;
        private NodoSimple sig;
        
        private NodoSimple(T dato) {
            this.dato = dato;
        }
        
    }
    
   
    
    @Override
    public void append(T elemento) throws ListException {
        NodoSimple nodoNuevo = new NodoSimple(elemento);
        NodoSimple nodo = inicio;
        
        if (nodo == null) {
            inicio = nodoNuevo;
        
        } else {
            
            while (nodo.sig != null) {
                nodo = nodo.sig;
            }
            
            nodo.sig = nodoNuevo;
            
        }
        
        nElementos++;
                
    }

    @Override
    public void insert(T elemento, int index) throws ListException {
        if (index < 0 || index > nElementos) {
            throw new ListException("Index out of bounds: " + index);
        }

        NodoSimple nodoNuevo = new NodoSimple(elemento);
        if (index == 0) {
            nodoNuevo.sig = inicio;
            inicio = nodoNuevo;
        } else {
            NodoSimple anterior = nodoEn(index - 1);
            nodoNuevo.sig = anterior.sig;
            anterior.sig = nodoNuevo;
        }
        nElementos++;
    }

    @Override
    public T remove(int index) throws ListException {
        validarIndice(index);
        NodoSimple eliminado;
        if (index == 0) {
            eliminado = inicio;
            inicio = inicio.sig;
        } else {
            NodoSimple anterior = nodoEn(index - 1);
            eliminado = anterior.sig;
            anterior.sig = eliminado.sig;
        }
        nElementos--;
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
        for (int index = 0; nodo != null; index++, nodo = nodo.sig) {
            if (Objects.equals(nodo.dato, elemento)) {
                return index;
            }
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
    public java.util.Iterator<T> Iterator() {
        return iterator();
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new Iterator<T>() {
            private NodoSimple siguiente = inicio;

            @Override
            public boolean hasNext() {
                return siguiente != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T dato = siguiente.dato;
                siguiente = siguiente.sig;
                return dato;
            }
        };
    }

    public void invertir() {
        NodoSimple anterior = null;
        NodoSimple actual = inicio;
        while (actual != null) {
            NodoSimple siguiente = actual.sig;
            actual.sig = anterior;
            anterior = actual;
            actual = siguiente;
        }
        inicio = anterior;
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
        while (nodo != null) {
            if (nodo != inicio) {
                resultado.append(", ");
            }
            resultado.append(nodo.dato);
            nodo = nodo.sig;
        }
        return resultado.append(']').toString();
    }

    private NodoSimple nodoEn(int index) {
        validarIndice(index);
        NodoSimple nodo = inicio;
        for (int i = 0; i < index; i++) {
            nodo = nodo.sig;
        }
        return nodo;
    }

    private void validarIndice(int index) {
        if (index < 0 || index >= nElementos) {
            throw new ListException("Index out of bounds: " + index);
        }
    }
}
