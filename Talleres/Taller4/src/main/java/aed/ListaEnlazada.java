package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;
    private Nodo ultimo;
    private int longitud;

    private class Nodo {
        T valor; 
        Nodo sig;
        Nodo ant;
        public Nodo(T i) {
            valor = i;
            sig = null;
            ant = null;
        }
    }

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
        longitud = 0;

    }

    public int longitud() {
        return longitud;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem); 
        if (primero == null){
            this.primero = nuevo;
            ultimo = nuevo;
        }
        else{
            nuevo.sig = primero;
            primero.ant = nuevo;
            this.primero = nuevo;
        }
        longitud++;
    }

    public void agregarAtras(T elem) {
       Nodo nuevo = new Nodo(elem);
       if (ultimo == null){
        ultimo = nuevo;
        primero = nuevo;
       }
       else{
        nuevo.ant = ultimo;
        ultimo.sig = nuevo;
        this.ultimo = nuevo;
       }
       longitud++;
    }

    public T obtener(int i) {
        
        Nodo actual = this.primero;
        for(int j =0; j!=i; j++){
            actual = actual.sig;
        }
        return actual.valor;
    }

    public void eliminar(int i) {
        if (longitud <= 1){
            primero = null;
            ultimo = null;
        }
        else{
            if (i == longitud-1){
                ultimo.ant.sig = null;
                ultimo = ultimo.ant;
            }
            else if (i == 0){
                primero.sig.ant=null;
                primero = primero.sig;
            }
            else{
                Nodo actual = this.primero;
                for (int j = 0; j!=i;j++){
                actual = actual.sig;
                }
            actual.ant.sig = actual.sig;
            actual.sig.ant = actual.ant;
            }
        }
        longitud--;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = primero;
        for (int j=0; j!=indice; j++){
            actual= actual.sig;
        }
        actual.valor = elem;
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> nueva = new ListaEnlazada<T>();
        Nodo actual = this.primero;
        while(actual!=null){
            nueva.agregarAtras(actual.valor);
            actual =actual.sig;
        }
        return nueva;
    }   

    public ListaEnlazada(ListaEnlazada<T> lista) {
        primero = new Nodo(lista.primero.valor);   
        Nodo actual = lista.primero.sig;
        actual.ant = primero;
        primero.sig = actual;

        if (lista.longitud == 1){
                ultimo = new Nodo(lista.primero.valor);
                primero = new Nodo(lista.primero.valor);   
            }
        else{
            while(actual.sig != null){ 
                actual = actual.sig;
            }
            ultimo = actual;
        }
        longitud = lista.longitud;


    }
    
    @Override
    public String toString() {
        String sBuilder = "["+ primero.valor;
        Nodo actual = primero.sig;
        for(int j=0; j!=longitud-1; j++){
            sBuilder = sBuilder + ", "+ actual.valor;
            actual =actual.sig;
        }
        return sBuilder + "]";
    }

    private class ListaIterador implements Iterador<T> {
    	int pointer;

        public boolean haySiguiente() {
	        return (pointer<longitud);
        }
        
        public boolean hayAnterior() {
            return (pointer>0);
        }

        public T siguiente() {
            T anterior = obtener(pointer);
            pointer++;
            return anterior;
        }
        

        public T anterior() {
            T anterior = obtener(pointer-1);
            pointer--;
            return anterior;
        }
    }

    public Iterador<T> iterador() {
	    ListaIterador nuevo = new ListaIterador();
        nuevo.pointer=0;
        return nuevo;
    }
}