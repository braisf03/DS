package e2;

public class Actuador implements  Observer{


    public String actMessage;
    public void actuar(Tanque t){

       actMessage =  ("Actuando en " + t.nombre + "\n");

    }


    @Override
    public void update(Informe informe) {

        actuar(informe.tanque);
    }
}
