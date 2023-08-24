class Funciones {
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
            res = n * factorialRecursivo(n-1);
        }
        return res;
    }
}
    