package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;

    private class Nodo {
        T valor; 
        Nodo sig;
        public Nodo(T i) {
            valor = i;
            sig = null;
        }
    }

    public ListaEnlazada() {
        primero = null;
    }

    public int longitud() {
        int longitud = 0; 
        Nodo actual = primero;
        while (actual != null){
            longitud++;
            actual = actual.sig;
        }
        return longitud;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        Nodo actual = primero;
        actual.sig = actual;
        actual = nuevo;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        Nodo actual = primero;
        if (primero == null){
            primero = nuevo;
        }
        else{
            while (actual.sig !=null){
                actual = actual.sig;
            }
            actual.sig = nuevo;
        }
    }

    public T obtener(int i) {
        Nodo actual = primero;
        for (int j=0; j<i; j++){
            actual = actual.sig;
        }
        return actual.valor;
    }

    public void eliminar(int i) {
        Nodo actual = primero;
        if (actual==null){
            return;
        }
        else{
            while (actual.sig !=null){
                if (obtener(i) != actual){
                    actual = actual.sig;
                }
            }
        }
    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada<T> copiar() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}