package e1.equipos;

public abstract class EquipoTecnico extends  EquipoHumano {

    public EquipoTecnico(String nombre,String apellido,String DNI,String nacionalidad){
        super(nombre,apellido,DNI,nacionalidad);
    }

    public void setDerechosAutor(float derechosAutor) {
        this.derechosAutor = derechosAutor;
    }

     protected float derechosAutor;

     float getCopyRights(float recaudacion){

        return  recaudacion * (derechosAutor/ 100);

    }
    public  String printCopyRights(float recaudacion){


        return String.format("( %s ): %.2f euro", this.getClass().getSimpleName(),getCopyRights(recaudacion));

    }



}
