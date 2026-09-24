package listaarreglo;

import java.util.Iterator;

public class ArrayList<T> implements IList<T>, Iterable<T>{
    
    protected int nElementos;
    private final int tamLista;
    private final T lista[];    
    
    public ArrayList(Class<T> tipoDato, int tamLista){
        this.tamLista = tamLista;
        nElementos = 0;
        lista = (T[]) java.lang.reflect.Array.newInstance(tipoDato, tamLista);
    }

    @Override
    public java.util.Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private class ListIterator <T> implements Iterator<T>{
        private int actual = 0;

        @Override
        public boolean hasNext() {
            return actual < nElementos; 
        }

        @Override
        public T next() {
            return (T) lista[actual++];
        }
        
    }

    @Override
    public void append(T elemento) throws ListException {
        if(nElementos >= tamLista) {
            throw new ListException("Lista llena");
        }
    
        lista[nElementos] = elemento;
        nElementos++;
    }

    @Override
    public void insert(T elemento, int index) throws ListException {
        if (nElementos >= tamLista) {
            throw new ListException("Lista llena");
        }
        
        if (index < 0 || index > nElementos) {
            throw new ListException("Indice fuera de limite");
        }
        
        for (int j = nElementos;j>index;j--) {
            lista[j] = lista[j-1];
        }
        
        lista[index] = elemento;
        nElementos++;
    }

    @Override
    public T remove(int index) throws ListException {
        T o = get(index);
        
        for(int j = index; j < nElementos -1; j++){
            lista[j] = lista[j+1];
        }
        
        nElementos--;
        return o;
    }

    @Override
    public boolean removeObj(T elemento) throws ListException {
        int idx = indexOf(elemento);
        if (idx == -1) {
            return false;
        }
        remove(idx);
        return true;
    }

    @Override
    public int indexOf(T elemento) {
        for (int i = 0; i < nElementos; i++) {
            if (lista[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T get(int index) throws ListException {
        if(empty()){
            throw new ListException("Lista vacia");
        }
        
        if(index <0 || index > nElementos){
            throw new ListException("Indice fuera de limites");
        }
        
        return lista[index];
    }

    @Override
    public void set(T elemento, int index) throws ListException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
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
        return new ListIterator();
    }

    @Override
    public String toString() {
        String s = "[";
        
        for (int i = 0; i <nElementos; i++){
            s += lista[i];
            if(i < nElementos -1) s+=", ";
        }
        
        s+="]";
        return s;
    }    
    
}
