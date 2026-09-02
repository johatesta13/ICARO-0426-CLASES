public class practica7OperadoresLogicos {

    public void main(){

        int edad=20;
        boolean tieneDni=true;
        //ANDS
        System.out.println(edad >=18 && tieneDni);
        System.out.println(edad < 20 && tieneDni);

        //AND incluyo al 20 para que la condicion sea verdadera
        System.out.println(edad <= 20 && tieneDni);
        //or primera condicion es falsa y la segunda es verdadera
        System.out.println(edad < 20 || tieneDni);

        System.out.println(!tieneDni);





    }
}
