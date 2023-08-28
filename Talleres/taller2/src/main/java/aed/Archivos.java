package aed;

import java.util.Scanner;
import java.io.PrintStream;

class Archivos {


    float[] leerVector(Scanner entrada, int largo) {
        float[] res = new float[largo];
        for (int i = 0; i<largo;i++){
            res[i]=entrada.nextFloat();
        }
        return res;
    }

    float[][] leerMatriz(Scanner entrada, int filas, int columnas) {
        float[][] res = new float[filas][columnas];
        for (int fila = 0; fila <filas ; fila++){
            for (int columna=0 ; columna<columnas; columna++) {
                res[fila][columna] = entrada.nextFloat();
            }
        }
        return res;
    }

    void imprimirPiramide(PrintStream salida, int alto) {
        for (int altura=1; altura<=alto; altura++){
            String fila = "";
            int asteriscos = (2*altura) - 1;
            int espacios = alto - altura;
            for (int a=0; a<espacios;a++){
                fila+=" ";
            }
            for (int b=0; b<asteriscos;b++){
                fila+="*";
            }
            for (int c=0; c<espacios;c++){
                fila+=" ";
            }
            if (alto ==altura){
                fila+= "\n";
            }
            salida.println(fila);
            fila = "";
        }  
    }
}
