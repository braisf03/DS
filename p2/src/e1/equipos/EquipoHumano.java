package e1.equipos;

public abstract class EquipoHumano {

    protected String nombre;
    protected String apellido;
    protected final String DNI;
    protected final String nacionalidad;

    protected int horas;
    protected int importePorHora;
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getHoras() {
        return horas;
    }

    public String getDNI() {
        return DNI;
    }



    public  EquipoHumano(String nombre,String apellido,String DNI,String nacionalidad){

        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.apellido = apellido;
        this.DNI = DNI;
    }


    public void addHours(int horas){

         this.horas+= horas;
         this.horas = Math.max(this.horas, 0);
    }

    protected  float getSalary(){

        return extraSalary(baseSalary());

    }

    float baseSalary(){
        return horas * importePorHora;
    }

    protected abstract float extraSalary(float baseSalary);


    public String printName(){

        return nombre + " " + apellido;

    }
    public  abstract  String printSalary();



}
