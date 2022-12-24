package e2.Sensores;

import e2.*;
import e2.Alertas.Alerta;

import java.util.ArrayList;

public abstract class Sensor extends Subject {

    public Tanque tanque;

    protected String tipo;
    private double parametro;
    public Actuador actuador;


    public void setParametro(double valor) {

        parametro = valor;

        notifyObservers(new Informe(this,tanque));
    }
    public double getParametro(){
        return parametro;
    }
    public String getTipo(){return  tipo;}



}
