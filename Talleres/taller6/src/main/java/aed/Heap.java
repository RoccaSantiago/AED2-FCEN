package aed;

public class Heap {
        private Router[] heap;
        private int size;
    
        public Heap(int _size) {
            size = _size;
            heap = new Router[_size];
        }

        public Heap(Router[] array) {
            size = array.length;
            heap = new Router[size];
            for (int i = 0; i < size; i++) {
                heap[i] = array[i];
            }
    
            for (int i = (size - 1)/ 2; i >= 0; i--) {
                heapifyBajar(i);
            }
        }
        private int padre(int i) {
            return (i-1) / 2;
        }
    
        private int izq(int i) {
            return 2 * i + 1;
        }
    
        private int der(int i) {
            return 2 * i + 2;
        }
    
        private void cambiar(int i, int j) {
            Router aux = heap[i];
            heap[i] = heap[j];
            heap[j] = aux;
        }
    
        private void heapifySubir(int i) {
            int daddy = padre(i);
            while (i > 0 && heap[i].compareTo(heap[daddy])>0){
                cambiar(i, daddy);
                i = daddy;
                daddy = padre(i);
            }
        }
    
        private void heapifyBajar(int i) {
            int indiceMaximo = i;
            int izquierda = izq(i);
            int derecha = der(i);
    
            if (izquierda < size && heap[izquierda].compareTo(heap[indiceMaximo])>0) {
                indiceMaximo = izquierda;
            }
    
            if (derecha < size && heap[derecha].compareTo(heap[indiceMaximo])>0) {
                indiceMaximo = derecha;
            }
    
            if (i != indiceMaximo) {
                cambiar(i, indiceMaximo);
                heapifyBajar(indiceMaximo);
            }
        }
        
        public void agregar(Router valor, int indice) {
            heap[size] = valor;
            size ++;
            heapifySubir(size - 1);
        }
        
        public Router extraerMaximo() {
            Router valorMaximo = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapifyBajar(0);
            return valorMaximo;
        }
    }