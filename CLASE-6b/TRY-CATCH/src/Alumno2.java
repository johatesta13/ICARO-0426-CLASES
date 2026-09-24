public class Alumno2  extends Persona{

    protected String escuela;
    protected boolean inscripto;


    public Alumno2(String nombre, int edad){

        super(nombre,edad);
        this.inscripto=false;

    }


    public boolean incribir(String escuela) throws MenorDeEdasExeption {
        if(edad < 18){
            throw new MenorDeEdasExeption("No te podes inscribir solo porque sos menor de edad");
        }

        this.escuela = escuela;
        this.inscripto =true;
        System.out.println(nombre + "Felicitaciones, ya estas inscripto en" + escuela);

        return true;
    }
}
