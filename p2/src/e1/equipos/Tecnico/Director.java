package e1.equipos.Tecnico;

import e1.equipos.EquipoTecnico;

public class Director extends EquipoTecnico {

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    private int anosExperiencia;

    public  Director(String nombre,String apellido,String DNI,String nacionalidad,int anosExperiencia){

        super(nombre,apellido,DNI,nacionalidad);
        this.anosExperiencia = anosExperiencia;

        importePorHora = 100;
        derechosAutor = 5;

    }

    @Override
    public float extraSalary(float baseSalary) {
        return anosExperiencia * 1000  + baseSalary;
    }

    @Override
    public String printSalary() {

        return  String.format("( Director %s): %.2f euro",anosExperiencia > 0? ("con " + anosExperiencia + " años de experiencia " ): "", getSalary());

    }
}
