package e1.equipos.Tecnico;

import e1.equipos.EquipoTecnico;

public class Productor  extends EquipoTecnico {


    public Productor(String nombre,String apellido,String DNI,String nacionalidad){
        super(nombre,apellido,DNI,nacionalidad);
        importePorHora = 90;
        derechosAutor = 2;
    }

    @Override
    public float extraSalary(float baseSalary) {
        return baseSalary;
    }

    @Override
    public String printSalary() {

        return  String.format("( Productor ): %.2f euro", getSalary());

    }

}
