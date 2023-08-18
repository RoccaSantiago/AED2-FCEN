package aed;

import org.omg.CORBA.FloatSeqHelper;

class Funciones {
    int cuadrado(int x) {
        return x*x;
    }

    double distancia(double x, double y) {
        return Math.sqrt(y*y+x*x);
        }


    boolean esPar(int n) {
        return (n%2 == 0);
    }

    boolean esBisiesto(int n) {
        if ((n % 400 == 0) || ( (n % 4 ==0) && (n % 100 !=0) )){
            return true;
        }
        return false;
    }
    

    int factorialIterativo(int n) {
        int res = 1;
        for (int i = 1;i < n + 1; i++){
            res = res * i;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        int res = 1;
        if (n>1){
            res = res * n * factorialRecursivo(n-1);
        }
        return res;
    }

    
    boolean esPrimo(int n) {
        if (n<2){ 
            return false;
        }
        else {
            for (int i = 2; i < n; i++){
            if (n%i==0){
                return false;
            } 
        }
        return true;
    }
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int i = 0; i < numeros.length; i++){
            res = res + numeros[i];
        }
        return res;
    }

    //si o si tiene que estar el return 0 pq si no se rompe?
    int busqueda(int[] numeros, int buscado) {
        for (int i = 0; i < numeros.length; i++){
            if (numeros[i] == buscado){
                return i;
            }
        }
        return 0;
    }


    boolean tienePrimo(int[] numeros) {
        for (int i=0; i < numeros.length; i++){
            if (esPrimo(numeros[i])){
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for (int i=0; i < numeros.length; i++){
            if (numeros[i]%2!=0){
                return false;
            }
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        return s2.startsWith(s1);
    }

    boolean esSufijo(String s1, String s2) {
        return s2.endsWith(s1);
    }
}
