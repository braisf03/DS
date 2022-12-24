package e1.equipos.Artistico;

import e1.equipos.EquipoArtistico;

public class Interprete extends EquipoArtistico {

    public boolean isEsProtagonista() {
        return esProtagonista;
    }

    public void setEsProtagonista(boolean esProtagonista) {
        this.esProtagonista = esProtagonista;
    }

    private boolean esProtagonista;

    public Interprete(String nombre,String apellido,String DNI,String nacionalidad,boolean esProtagonista){
        
        super(nombre,apellido,DNI,nacionalidad);
        this.esProtagonista = esProtagonista;
        importePorHora = 200;
    }

    @Override
    public float extraSalary(float baseSalary) {
        return esProtagonista ? (baseSalary *3) :baseSalary;
    }

    @Override
    public String printSalary() {

        return  String.format("( Interprete %s): %.2f euro", esProtagonista ? "protagonista " :"", getSalary());

    }
}
