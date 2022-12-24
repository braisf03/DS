package e1.equipos.Tecnico;

import e1.equipos.EquipoTecnico;

public class Musico extends EquipoTecnico {

    public  Musico(String nombre,String apellido,String DNI,String nacionalidad){
        super(nombre,apellido,DNI,nacionalidad);
        importePorHora = 60;
        derechosAutor = 4;

    }
    @Override
    public float extraSalary(float baseSalary) {
        return baseSalary;
    }

    @Override
    public String printSalary() {

        return  String.format("( Musico ): %.2f euro", getSalary());

    }
}
