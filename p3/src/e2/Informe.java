package e2;

import e2.Alertas.Alerta;
import e2.Sensores.Sensor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDateTime.*;

public class Informe {

    public Tanque tanque;
    public Sensor sensor;
    public Alerta alerta;
    public LocalDateTime fecha;

    public Informe(Sensor sensor, Tanque tanque){

        this.sensor = sensor;
        this.tanque = tanque;

        fecha = now();
    }

    public String montarInforme(boolean noDate){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        return String.format("""
                * Alerta %s :
                %s
                Control de %s : parametro %s , nivel %f
                %s
                
                """, alerta.getTipo(), tanque.nombre, sensor.getTipo(), sensor.getTipo(), sensor.getParametro(), (noDate  ? "no date for test" : dtf.format(fecha)));
    }
}
