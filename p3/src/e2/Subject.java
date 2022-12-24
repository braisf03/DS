package e2;

import e2.Alertas.Alerta;
import e2.Sensores.Sensor;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    protected List<Observer> observers = new ArrayList<>();
    public void attach(Observer o) {

        observers.add(o);
    }
    public void attach(Alerta a) {

        if(a.atached) throw  new IllegalArgumentException();
        a.atached = true;
        observers.add(a);
    }
    public void detach(Alerta a) {

        a.atached = false;
        observers.remove(a);
    }
    public void detach(Observer o) { observers.remove(o); }
    public void notifyObservers(Informe informe) {
        for (Observer o : observers)
            o.update(informe);
    }

}
