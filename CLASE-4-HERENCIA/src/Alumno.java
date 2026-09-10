import java.util.ArrayList;

public class Alumno extends Persona {

    private String matricula;
    private Double nota;
    private ArrayList<String> materias;


    public Alumno() {
        super();
    }

    public Alumno(String nombre, String apellido, String matricula){

        super(nombre,apellido);
        this.matricula = matricula;
        this.nota= 0.0;
        this.materias = new ArrayList<>();


    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public ArrayList<String> getMaterias() {
        return materias;
    }


    public void agregarMaterias(String materia){

        this.materias.add(materia);
    }
}
