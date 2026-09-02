import java.util.Scanner;

public class ejemplodowhile {


    public void main(){

       int numero= 0;

        do{
            Scanner scanner= new Scanner(System.in);

            System.out.println("Ingrese un numero positivo");
            numero = scanner.nextInt();

        }while (numero <0);
    }
}

