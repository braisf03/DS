package e2.Alertas;

public class AlertaRoja extends Alerta {


    public  AlertaRoja(double min, double max){
        super(min, max);
        prioridad = 2;
        tipo = "Roja";

    }
}
