
import java.util.Scanner;

public class Switchejemplo {

    public void main(){

        Scanner scanner= new Scanner(System.in);

        System.out.println("Ingrese el numero de talle (1 al 2)");
        int size = scanner.nextInt();

        switch (size){

            case 1:
                System.out.println("TALLE S");
                break;


            case 2:
                System.out.println("TALLE M");
                break;

            default:
                System.out.println("Intente nuevamente");
                break;
        }


    }

}
