import java.util.ArrayList;

public class Profesor extends Persona{

    private ArrayList<Alumno> alumnos;



    public Profesor(){
        super();
        this.alumnos = new ArrayList<>();
    }

    public Profesor(String nombre, String apellido){

        super(nombre,apellido);

        this.alumnos = new ArrayList<>();
    }


    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void AgregarAlumno(Alumno a){
        this.alumnos.add(a);
    }


}
