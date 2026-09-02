public class Main{


    public void main(){

        Estudiante estudiante1 = new Estudiante("10001", "Maria Gonzales", 8.5f);
        Estudiante estudiante2 = new Estudiante("10002", "Juan Prez", 9.0f);

        System.out.println("DATOS DEL ESTUDIANTE");

        System.out.println("ID: " + estudiante1.getId());
        System.out.println("Nombre completo: " + estudiante1.getNombre_completo());
        System.out.println("Promedio: " + estudiante1.getPromedio());



        //estudiante2.id

    }

}