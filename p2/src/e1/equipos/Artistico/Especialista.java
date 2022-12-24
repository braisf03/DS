package e1.equipos.Artistico;

import e1.equipos.EquipoArtistico;

public class Especialista extends EquipoArtistico {

    public boolean isEscenasPeligrosas() {
        return escenasPeligrosas;
    }

    public void setEscenasPeligrosas(boolean escenasPeligrosas) {
        this.escenasPeligrosas = escenasPeligrosas;
    }

    private boolean escenasPeligrosas;

    public  Especialista(String nombre,String apellido,String DNI,String nacionalidad,boolean escenasPeligrosas){
        super(nombre,apellido,DNI,nacionalidad);
        this.escenasPeligrosas = escenasPeligrosas;
        importePorHora = 40;
    }

    @Override
    public float extraSalary(float baseSalary) {
        return escenasPeligrosas ? 1000 + baseSalary : baseSalary;
    }

    @Override
    public String printSalary() {

        return  String.format("( Especialista %s): %.2f euro", escenasPeligrosas ? "con escenas peligrosas " : "", getSalary());

    }
}
