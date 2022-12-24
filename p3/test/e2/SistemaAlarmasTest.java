package e2;

import e2.Alertas.AlertaNaranja;
import e2.Alertas.AlertaRoja;
import e2.Sensores.Sensor;
import e2.Sensores.SensorO2;
import e2.Sensores.SensorPH;
import e2.Sensores.SensorTemp;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

 class SistemaAlarmasTest {


    @Test
    public void TestBase() {


        Tanque t1 = new Tanque("Tanque Focas");
        Tanque t2 = new Tanque("Tanque Brais");
        Tanque t3 = new Tanque("Tanque Loros");

        Persona p1 = new Persona("Jose");
        Persona p2 = new Persona("Bisbi");

        Sensor o1 = new SensorO2();
        Sensor o2 = new SensorPH();
        Sensor o3 = new SensorTemp();

        AlertaNaranja a1 = new AlertaNaranja(-1, 2);
        AlertaRoja a2 = new AlertaRoja(-5, 5);
        AlertaRoja a3 = new AlertaRoja(-15, 15);
        AlertaNaranja a4 = new AlertaNaranja(-10, 10);
        AlertaNaranja a5 = new AlertaNaranja(-15, 15);


        //Añadir sensores a tanques

        t1.addSensor(o1);

        t2.addSensor(o2);

        t3.addSensor(o3);

        //Añadir alarmas como observadores de sensores

        o1.attach(a1);
        o1.attach(a2);

        o2.attach(a3);
        o2.attach(a4);

        o3.attach(a5);

        //Añadir personas como observadores de alarmas

        a1.attach(p1);
        a2.attach(p1);

        a3.attach(p2);
        a4.attach(p2);
        a5.attach(p2);

        //Añadir actuadores como observadores de alarmas (asociados ya a sus sensores)

        a1.attach(o1.actuador);
        a2.attach(o1.actuador);

        a3.attach(o2.actuador);
        a4.attach(o2.actuador);
        a5.attach(o3.actuador);


        //Setter de estados
        o1.setParametro(6);
        o2.setParametro(-32132);
        o3.setParametro(-12213);

        assertEquals("Actuando en Tanque Focas\n", o1.actuador.actMessage);
        assertEquals("Actuando en Tanque Brais\n", o2.actuador.actMessage);
        assertEquals("Actuando en Tanque Loros\n", o3.actuador.actMessage);

        assertEquals("""
                **** Informe de Jose ****
                                
                ALERTAS ROJA:\s
                * Alerta Roja :
                Tanque Focas
                Control de O2 : parametro O2 , nivel 6,000000
                no date for test
                                
                                
                ALERTAS NARANJA:\s
                * Alerta Naranja :
                Tanque Focas
                Control de O2 : parametro O2 , nivel 6,000000
                no date for test
                                
                -----------------------------------------------------------------
                                
                """, p1.printInformes(true));
        assertEquals("""
                **** Informe de Bisbi ****
                                
                ALERTAS ROJA:\s
                * Alerta Roja :
                Tanque Brais
                Control de PH : parametro PH , nivel -32132,000000
                no date for test
                                
                                
                ALERTAS NARANJA:\s
                * Alerta Naranja :
                Tanque Brais
                Control de PH : parametro PH , nivel -32132,000000
                no date for test
                                
                * Alerta Naranja :
                Tanque Loros
                Control de Temperatura : parametro Temperatura , nivel -12213,000000
                no date for test
                                
                -----------------------------------------------------------------
                                
                """, p2.printInformes(true));


    }

    @Test
    public void TestAlarmas() {


        Sensor o1 = new SensorO2();

        AlertaNaranja a1 = new AlertaNaranja(-1, 2);
        AlertaRoja a2 = new AlertaRoja(-5, 5);

        o1.attach(a1);
        assertThrows(IllegalArgumentException.class, () -> o1.attach(a1));

        o1.detach(a1);
        o1.attach(a2);

    }

    @Test
    public void TestPersonas() {


        Persona p1 = new Persona("Marta");

        assertThrows(NoSuchElementException.class, () -> p1.printInformes(false));

    }
}