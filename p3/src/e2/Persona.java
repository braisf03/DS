package e2;

import e2.Alertas.Alerta;

import java.util.*;

public class Persona implements Observer {


    private final String name;


    public Persona(String nombre){

        name = nombre;

    }
    private PriorityQueue<Informe> informes = new PriorityQueue<>((o1, o2) -> {

        if (o1.alerta.getPrioridad() > o2.alerta.getPrioridad()) {

            return -1;
        } else if (o1.alerta.getPrioridad() < o2.alerta.getPrioridad()) {

            return 1;
        }
        return 0;

    });

    @Override
    public void update(Informe informe) {


        informes.add(informe);

    }

    public String printInformes(boolean noDate){


        StringBuilder informeEntero = new StringBuilder();

        if(informes.size() == 0) {

            throw  new NoSuchElementException();
        }

        String tipo = "NONE";

        informeEntero.append("**** Informe de " + name + " ****\n");

        for (Informe informe : informes) {

            if (!Objects.equals(tipo, informe.alerta.getTipo())) {
                tipo = informe.alerta.getTipo();
                informeEntero.append("\nALERTAS ").append(informe.alerta.getTipo().toUpperCase()).append(": \n");
            }
           informeEntero.append(informe.montarInforme(noDate));
        }

        informeEntero.append("-----------------------------------------------------------------\n\n");


        return informeEntero.toString();
    }

}
