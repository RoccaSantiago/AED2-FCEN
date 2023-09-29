package aed;

public class Recordatorio {
    Fecha fecha;
    Horario horario;
    String mensaje;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.fecha = new Fecha(fecha.dia(), fecha.mes()); 
        this.horario = new Horario(horario.hora(),horario.minutos());
        this.mensaje = mensaje;
    }

    public Horario horario() {
        return new Horario(horario.hora(),horario.minutos());
    }

    public Fecha fecha() {
        return new Fecha(fecha.dia(), fecha.mes());
    }

    public String mensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        return  mensaje + " @ " + fecha.toString() + " " + horario.toString();
    }

}
