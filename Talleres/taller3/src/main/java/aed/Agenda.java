package aed;

import java.util.Vector;

import javafx.scene.control.Separator;

public class Agenda {
    private Fecha fechaActual;
    private Recordatorio[] recordatorios;
    private int elementos = 0; 

    public Agenda(Fecha fechaActual) {
        this.fechaActual = new Fecha(fechaActual);
        this.recordatorios = new Recordatorio[1];
    
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        if (elementos == recordatorios.length){
            int lenNArray = recordatorios.length + 1;
            Recordatorio[] nrRecordatorios = new Recordatorio[lenNArray];
            for (int j = 0; j<recordatorios.length; j++){
                nrRecordatorios[j] = recordatorios[j];
            }
            nrRecordatorios[recordatorios.length] = recordatorio;
            recordatorios = nrRecordatorios;
            elementos = lenNArray;
        }
        else{
            recordatorios[elementos] = recordatorio;
            elementos+=1;
        }
    }

    @Override
    public String toString() {
        String recordatorioss="";
        for(int j=0; j<recordatorios.length; j++){
            if (recordatorios[j].fecha().equals(fechaActual)){
                recordatorioss = recordatorioss + recordatorios[j].toString() + "\n" ; 
            }
        }   
        return fechaActual.toString() + "\n" + "=====\n" + recordatorioss;
    }

    public void incrementarDia() {
        fechaActual.incrementarDia();

    }

    public Fecha fechaActual() {
        return new Fecha(fechaActual);
    }

}
