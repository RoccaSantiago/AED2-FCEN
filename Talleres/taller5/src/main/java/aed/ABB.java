package aed;

import java.util.*;

import javax.net.ssl.TrustManager;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    int cardinal;
    Nodo primero;

    private class Nodo {
        Nodo izq;
        Nodo der;
        Nodo padre;
        T valor;

        public Nodo(T i) {
            valor = i;
            izq = null;
            der = null;
            padre = null;
        }
    }

    public ABB() {
       cardinal = 0;
       primero = null; 
    }

    public int cardinal() {
        return cardinal;
    }

    public T minimo(){
        Nodo actual = primero;
        while (actual.izq !=null){
            actual = actual.izq;
        }
        return actual.valor;
    }

    public T maximo(){
        Nodo actual = primero;
        while (actual.der !=null){
            actual = actual.der;
        }
        return actual.valor;
    }

    public void insertar(T elem){
        Nodo nuevo = new Nodo(elem);
        if (primero == null){
            primero = nuevo;
            cardinal++;
        }
        else{
            Nodo actual = primero;
            while (actual.der!=null || actual.izq !=null) {
                if  (actual.valor.compareTo(elem)==0){
                    return;
                }
                else if (actual.valor.compareTo(elem)>0 && actual.izq!=null) {
                    actual = actual.izq;
                }
                else if (actual.valor.compareTo(elem)<0 && actual.der!=null){
                    actual = actual.der;
                    }
                else{
                    break;
                }
            }

            if (actual.valor.compareTo(elem)==0){
                return;
            }
            else if (actual.valor.compareTo(elem)>0){
                actual.izq = nuevo;
                nuevo.padre = actual;
                cardinal++;
            }
            else{
                actual.der = nuevo;
                nuevo.padre = actual;
                cardinal++;
            }
        }
    }

    public boolean pertenece(T elem){
        boolean flag = true;
        Nodo actual = primero;
        if (primero == null){
            return false;
        }
        while (actual.valor.compareTo(elem)!=0) {
            if (actual.valor.compareTo(elem)>0){
                if (actual.izq != null){
                    actual = actual.izq;
                }
                else{
                    flag = false;
                    break;
                }
            }
            else{
                if (actual.der != null){
                    actual = actual.der;
                }
                else{
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private Nodo minimoDesde(Nodo q){
        while (q.izq != null){
            q = q.izq;
        }
        return q;
    }

    private void  eliminardes(Nodo p,int u){

        if (p.der == null && p.izq == null){
            if (u == 0){
                p.padre.izq = null;
            }
            else{
                p.padre.der = null;
            }        
        }

        else if (p.der == null && p.izq != null){
            if (u==0){
                p.padre.izq = p.izq;
            }
            else{
                p.padre.der = p.izq;
                
            }
            p.izq.padre = p.padre;
        }

        else if (p.der != null && p.izq == null){
            if (u==0) {
                p.padre.izq = p.der;
            }
            else{
                p.padre.der = p.der;
                
            }
            p.der.padre = p.padre;
        }

        else{
            Nodo min = minimoDesde(p.der);
            if (min == p.der){
                eliminardes(min, 1);
            }
            else{
                eliminardes(min, 0);
            }
            
            p.valor = min.valor;
        }
    }




    public void eliminar(T elem){
        if (primero == null) {
            return;
        }
        Nodo a = primero;
        int u = 0;

        if (primero.valor.compareTo(elem)==0){
            if (primero.der == null && primero.izq == null){
                primero = null;
            }
            else if (primero.der == null && primero.izq != null){
                primero.izq.padre =null;
                primero = primero.izq;
            }
            else if (primero.der != null && primero.izq == null) {
                primero.der.padre = null; 
                primero = primero.der;
            }
            else{
                Nodo min = minimoDesde(primero.der);
                if (min == primero.der){
                    eliminardes(min, 1);
                }
                else{
                    eliminardes(min, 0);
                }   
            
                primero.valor = min.valor;
            }
        }
        else{
            while (a.valor.compareTo(elem) !=0){
                if (a.valor.compareTo(elem)>0){
                    a = a.izq;
                    u = 0;
                }
                else{
                    a = a.der;
                    u = 1;
                }
        }

        eliminardes(a, u);
        }
        
        cardinal--;
    }



    private String trianguloa(Nodo a){
        String c = "" + a.valor;
        if (a.izq != null){
            c = trianguloa(a.izq)+ "," + c;
        }
        if (a.der != null){
            c = c + ","  + trianguloa(a.der);
        }
        return c;
    }


    public String toString(){
        String res = "{" + trianguloa(primero) +"}";
        return res;
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo x;

        public boolean haySiguiente() {            
            return (x.valor.compareTo(maximo()) !=0);
        }

        public T siguiente() {
            T res = x.valor;
            if (x.der != null){
                x = minimoDesde(x.der);
            }
            else{
                Nodo y = x.padre;
                while (y != null && x == y.der) {
                    x = y;
                    y = y.padre;
                    }
                x=y;
            }
            
            return res;
        }
    }

    public Iterador<T> iterador() {
        ABB_Iterador nuevo = new ABB_Iterador();
        nuevo.x = minimoDesde(primero);
        return nuevo;
    }
    
}
