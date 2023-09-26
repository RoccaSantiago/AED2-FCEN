package aed;

class VectorDeInts implements SecuenciaDeInts {
    private static final int CAPACIDAD_INICIAL = 1;
    private int[] array;
    private int nElementos;

    public VectorDeInts() {
        array = new int[CAPACIDAD_INICIAL];
        nElementos = 0;        
    }
    

    public int longitud() {
        return nElementos;
    }

    public void agregarAtras(int i) {
        if (nElementos == array.length){
            int lenNArray = array.length + 1;
            int[] nArray = new int[lenNArray];
            for (int j = 0; j<array.length; j++){
                nArray[j] = array[j];
            }
            nArray[array.length] = i;
            array = nArray;
            nElementos = lenNArray;
        }
        else{
            array[nElementos] = i;
            nElementos+=1;
        }
    }

    public int obtener(int i) {
        if (i<array.length){
            return array[i];
        }
        else{
            return -1;
        }
    }

    public void quitarAtras() {
        int[] nArray = new int[array.length];
        for (int j=0; j<array.length-1;j++){
            nArray[j]=array[j];
        }
        array = nArray;
        nElementos -=1;

    }

    public void modificarPosicion(int indice, int valor) {
        if (indice<array.length){
            array[indice] = valor;
        }
    }

    public VectorDeInts copiar() {
        VectorDeInts copia = new VectorDeInts();
        for (int j=0; j<array.length; j++){
            copia.agregarAtras(array[j]);            
        }
        return copia;
    }

}
