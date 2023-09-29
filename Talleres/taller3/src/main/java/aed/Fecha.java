package aed;

public class Fecha {
    private int diaa;
    private int mess;

    public Fecha(int dia, int mes) {
        diaa = dia;
        mess = mes;
    }

    public Fecha(Fecha fecha) {
      this.diaa = fecha.dia();
      this.mess = fecha.mes();
    }

    public Integer dia() {
        return diaa;
    }

    public Integer mes() {
        return mess;
    }

    public String toString() {
        return diaa + "/" + mess;
    }

    @Override
    public boolean equals(Object otra) {
        boolean oen = (otra == null);
        boolean cd = (otra.getClass() != this.getClass());
        if (oen || cd) {
            return false;
        }
        Fecha otraFecha = (Fecha) otra;
        return (otraFecha.dia()==this.dia() && otraFecha.mes() == this.mes());       
    }

    public void incrementarDia() {
        if (diaa == diasEnMes(mess)){
                if (mess != 12){
                    mess++;
                    diaa = 1;
               }
               else{
                diaa = 1;
                mess = 1;
               }
        }
        else{
            diaa++;            
        } 
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
