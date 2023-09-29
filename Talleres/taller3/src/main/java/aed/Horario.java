package aed;

public class Horario {
    private int hora;
    private int minutos;

    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public int hora() {
        return hora;
    }

    public int minutos() {
        return minutos;
    }

    @Override
    public String toString() {
        return hora + ":" + minutos;
    }

    @Override
    public boolean equals(Object otro) {
        boolean cd = (otro == null);
        boolean objeto = (otro.getClass() != this.getClass());
        if (cd || objeto){
            return false;
        }
        Horario otra = (Horario) otro;
        return (( otra.hora() == this.hora() ) && (otra.minutos() == this.minutos()));
    }

}
