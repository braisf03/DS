package e2.Alertas;

public class AlertaNaranja extends Alerta{

    public  AlertaNaranja(double min, double max){
        super(min, max);
        prioridad = 1;
        tipo = "Naranja";
    }

}
