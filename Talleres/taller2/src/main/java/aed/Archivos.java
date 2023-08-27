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
        
    }
}
