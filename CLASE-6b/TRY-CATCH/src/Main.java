public class Main {

    void main(){

        /*Alumno alumno1 = new Alumno("Bruno", 16);

        Alumno alumno2 = new Alumno("Victoria",19);


        System.out.println("No se pudo inscribir");
        boolean resultado1 = alumno1.incribir("Manuel belgrano");

        System.out.println("Si se pudo inscribir");
        boolean resultado = alumno2.incribir("Manuel Belgrano");*/



        //Bloque try and catch con nuestra exception
        Alumno2 alumno3 = new Alumno2("Joaquin", 16);

        Alumno2 alumno4 = new Alumno2("Lucia",19);

        try {
            alumno3.incribir("Escuela tecnica n1");
            System.out.println("Te pudiste inscribir exitosamente");

        }catch (MenorDeEdasExeption e){
            System.out.println("Error: " + e.getMessage());
        }

        try {
            alumno4.incribir("Escuela tecnica n1");
            System.out.println("Te pudiste inscribir exitosamente");


        }catch (MenorDeEdasExeption e){
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            System.out.println("Proceso de inscripcion finalizado");
        }



    }
}