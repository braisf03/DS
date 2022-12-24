package e2;

import e2.Alertas.Alerta;
import e2.Sensores.Sensor;

public interface Observer {


    default void update(Informe i) {
    }


}
