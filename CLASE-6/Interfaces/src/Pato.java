public class Pato implements Ivolador,INadador{

    private String nomnbre;


    public Pato(String nomnbre) {
        this.nomnbre = nomnbre;
    }

    @Override
    public void volar(){

        System.out.println("Soy un pato y estoy volando");
    }

    @Override
    public void nadar(){
        System.out.println("Soy un pato y estoy nadando");
    }


    public String getNomnbre() {
        return nomnbre;
    }

    public void setNomnbre(String nomnbre) {
        this.nomnbre = nomnbre;
    }
}
