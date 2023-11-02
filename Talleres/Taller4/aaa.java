class HelloWorld { 
    public static void main(String args[]) 
    { 
        int trans = 0;
        int primero = 0;
        int segundo = 0;
        int[] votos = {500,166,40,200};
        int index = 0;
        while(votos.length > index) {
            if (segundo < votos[index]) {
                segundo = votos[index];
            }

            if (primero < segundo) {
                trans = primero;
                primero = segundo;
                segundo = trans;
            }

            index++;
        }
        System.out.println(primero);
        System.out.println(segundo);

    } 
}