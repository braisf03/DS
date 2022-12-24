package e2.Alertas;

import e2.Informe;
import e2.Observer;
import e2.Sensores.Sensor;
import e2.Subject;
import e2.Tanque;

import java.util.EventListener;
import java.util.Vector;

public abstract class Alerta extends Subject implements Observer {

    protected int prioridad;
    private final double max;
    private final double min;

    protected String tipo;

    public boolean atached;


    public Alerta(double min, double max) {






        this.max = max;
        this.min = min;
    }

    @Override
    public void update(Informe i) {

        Informe informe = new Informe(i.sensor,i.tanque);

        if (informe.sensor.getParametro() > max || informe.sensor.getParametro() < min) {
            informe.alerta = this;
            notifyObservers(informe);
        }


    }
    public int getPrioridad(){
        return prioridad;
    }
    public String getTipo(){return tipo;}

}
