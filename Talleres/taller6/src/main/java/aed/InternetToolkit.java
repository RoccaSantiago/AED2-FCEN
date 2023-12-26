package aed;

public class InternetToolkit {
    public InternetToolkit() {
    }

    private class Heap {
        private Router[] heap;
        private int size;

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
    
        private void heapifyBajar(int i) {
            int indiceMaximo = i;
            int izquierda = izq(i);
            int derecha =    der(i);
    
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
        
        
        public Router extraerMaximo() {
            Router valorMaximo = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapifyBajar(0);
            return valorMaximo;
        }
    }


    public Fragment[] tcpReorder(Fragment[] fragments) {
        
        //Reccore la lista   O(n)
        for (int i=1 ; i < fragments.length ; i++){
            
            //verifica si esta mal posicionado
            if (fragments[i].compareTo(fragments[i-1])<0){
                Fragment a;
                int j=i;
                
                //Swapeo en caso de estar mal posicionado
                while (j>=1 && fragments[j].compareTo(fragments[j-1])<0) {
                    a = fragments[j];   
                    fragments[j] = fragments[j-1];
                    fragments[j-1] = a;
                    j--;
                } 
            }
        }
        return fragments;
    }

        
    
    
    // Heap Sort
    public Router[] kTopRouters(Router[] routers, int k, int umbral) {
        // Convierto el array en un heap y creo el array que voy a retornar
        Heap routers1 = new Heap(routers); 
        Router[] res = new Router[k];


        
        for(int i = 0 ; i<k ; i++){
            // Extraigo el maximp k veces
            Router actual = routers1.extraerMaximo();

            //Lo agrego si supera el umbral
            if(actual.getTrafico() > umbral){
                res[i] = actual;
            }
        }
        return res;
    }
    
    public IPv4Address[] ordernar(IPv4Address[] ips, int k) {
        
        //Reccore la lista   O(n^2)
        for (int i=1 ; i < ips.length ; i++){
            
            //verifica si esta mal posicionado
            if (ips[i].getOctet(k)<ips[i-1].getOctet(k)){
                IPv4Address a;
                int j=i;
                
                //Swapeo en caso de estar mal posicionado
                while (j>=1 && ips[j].getOctet(k)<ips[j-1].getOctet(k)) {
                    a = ips[j];
                    ips[j] = ips[j-1];
                    ips[j-1] = a;
                    j--;
                } 
            }
        }
        return ips;
    }
    

    //radix sort
    public IPv4Address[] sortIPv4(String[] ipv4) {    
        IPv4Address[] res = new IPv4Address[ipv4.length]; 
        
        for (int i = 0 ; i< ipv4.length ; i++){
            res[i] = new IPv4Address(ipv4[i]);
        }

        for (int i = 3; i>-1 ; i--){
            ordernar(res, i);
        }

        return res;
    }
}   
