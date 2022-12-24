package e2;

import e2.Alertas.AlertaNaranja;
import e2.Alertas.AlertaRoja;
import e2.Sensores.Sensor;
import e2.Sensores.SensorO2;
import e2.Sensores.SensorPH;
import e2.Sensores.SensorTemp;

import java.util.ArrayList;

public class Tanque {

    public String nombre;
    private ArrayList<Sensor> sensores = new ArrayList<>();
    private ArrayList<Actuador> actuadores = new ArrayList<>();


    public Tanque(String nombre) {

        this.nombre = nombre;

    }

    public void addSensor(Sensor sensor) {

        sensores.add(sensor);
        sensor.tanque = this;

        Actuador ac = new Actuador();

        sensor.actuador = ac;
        actuadores.add(ac);

    }


}
