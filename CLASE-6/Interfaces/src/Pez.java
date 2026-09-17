public class Pez implements INadador {

    public String nombre;


    public Pez(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void nadar(){

        System.out.println("Soy un pez y estoy nadando");

    }
}
