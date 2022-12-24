package e1.equipos.Artistico;

import e1.equipos.EquipoArtistico;

public class Doblador extends EquipoArtistico {

    public  Doblador(String nombre,String apellido,String DNI,String nacionalidad){
        super(nombre,apellido,DNI,nacionalidad);
        importePorHora = 20;

    }
    @Override
    public float extraSalary(float baseSalary) {
        return baseSalary;
    }
    @Override
    public String printSalary() {

        return  String.format("( Doblador ): %.2f euro", getSalary());

    }
}
