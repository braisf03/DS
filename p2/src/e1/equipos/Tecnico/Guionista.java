package e1.equipos.Tecnico;

import e1.equipos.EquipoTecnico;

public class Guionista extends EquipoTecnico {

    public boolean isGuionOrginal() {
        return guionOrginal;
    }

    public void setGuionOrginal(boolean guionOrginal) {
        this.guionOrginal = guionOrginal;
    }

    private boolean guionOrginal;

    public  Guionista(String nombre,String apellido,String DNI,String nacionalidad,boolean guionOrginal){
        super(nombre,apellido,DNI,nacionalidad);

        this.guionOrginal = guionOrginal;
        importePorHora = 70;
        derechosAutor = 5;
    }

    @Override
    public float extraSalary(float baseSalary) {
        return guionOrginal ? baseSalary + 4000 : baseSalary;
    }

    @Override
    public String printSalary() {

        return  String.format("( Guionista %s): %.2f euro", guionOrginal ? "con guion orignal " : "", getSalary());

    }
}
