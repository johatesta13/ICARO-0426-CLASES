public class Main{

    public void main(){

        Alumno ALUMNO1 = new Alumno("Juan","Perez", "A-2026-periodoB");

        ALUMNO1.agregarMaterias("Matematica");
        ALUMNO1.agregarMaterias("Programacion");
        ALUMNO1.agregarMaterias("Base de datos");

        Alumno ALUMNO2 = new Alumno("Maria","Lopez","A-2026-periodoA");
        // CREAR UN OBJETO DE TIPO PROFESOR

        Profesor profesor1 = new Profesor("Ana","Martinez");

        profesor1.AgregarAlumno(ALUMNO1);
        profesor1.AgregarAlumno(ALUMNO2);


        //CREAR NO DOCENTE

        NoDocente noDocente = new NoDocente("Rosario","Ramirez","Administrativa");


        // Mostrar información
        System.out.println("=== ALUMNO ===");
        System.out.println("Nombre: " + ALUMNO1.getNombre() + " " + ALUMNO1.getApellido());
        System.out.println("Matrícula: " + ALUMNO1.getMatricula());
        System.out.println("Materias: " + ALUMNO1.getMaterias());

        System.out.println("=== ALUMNO ===");
        System.out.println("Nombre: " + ALUMNO2.getNombre() + " " + ALUMNO2.getApellido());
        System.out.println("Matrícula: " + ALUMNO2.getMatricula());
        System.out.println("Materias: "  + ALUMNO2.getMaterias());

        System.out.println("\n=== PROFESOR ===");
        System.out.println("Nombre: " + profesor1.getNombre() + " " + profesor1.getApellido());
        System.out.println("Cantidad de alumnos: " + profesor1.getAlumnos().size());

        System.out.println("\n=== NO DOCENTE ===");
        System.out.println("Nombre: " + noDocente.getNombre() + " " + noDocente.getApellido());
        System.out.println("Área: " + noDocente.getArea());



    }

}