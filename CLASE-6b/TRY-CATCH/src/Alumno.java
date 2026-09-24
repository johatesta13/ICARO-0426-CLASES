public class Alumno extends Persona{
    protected String escuela;
    protected boolean inscripto;


    public Alumno(String nombre, int edad){

        super(nombre,edad);
        this.inscripto=false;

    }


    public boolean incribir(String escuela){
        if(edad < 18){
            System.out.println("No se puede inscribir solo porque es menor a 18 años");
            return false;
        }

        this.escuela = escuela;
        this.inscripto =true;
        System.out.println(nombre + "Felicitaciones, ya estas inscripto en" + escuela);

        return true;
    }
}
