package e1;

import e1.equipos.EquipoHumano;
import e1.equipos.EquipoTecnico;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Pelicula {

    public String getTitulo() {
        return titulo;
    }

    private final String titulo;

    public float getRecaudacion() {
        return recaudacion;
    }
    private final float recaudacion;
    List<EquipoHumano> equipo = new LinkedList<>();


    public Pelicula(String titulo, float recaudacion) {

        if (recaudacion < 0 || titulo == null || titulo.isEmpty()) throw new IllegalArgumentException();

        this.titulo = titulo;
        this.recaudacion = recaudacion;
    }


    String printSalaries(){

        if(InvalidArgument()) throw new IllegalArgumentException();

        StringBuilder sal = new StringBuilder();


        for (EquipoHumano p : equipo) {

            sal.append(p.printName()).append(" ").append(p.printSalary()).append("\n");
        }


        return sal.toString();

    }
    String printRoyalties(){

        if(InvalidArgument()) throw new IllegalArgumentException();
        StringBuilder roy = new StringBuilder();

        for (EquipoHumano p : equipo) {

            if(p instanceof EquipoTecnico){
                roy.append(p.printName()).append(" ").append(((EquipoTecnico) p).printCopyRights(recaudacion)).append("\n");

            }

        }
        return roy.toString();
    }

    boolean InvalidArgument(){

        return equipo == null || equipo.size() == 0;
    }
    public void addMember(EquipoHumano member){

        if(member == null) throw new IllegalArgumentException();
        for (EquipoHumano p : equipo) {

            if(Objects.equals(p.getDNI(), member.getDNI())){
                throw  new IllegalArgumentException("Ya existe un miembro con ese DNI en el equipo");
            }
        }
        equipo.add(member);

    }
}
