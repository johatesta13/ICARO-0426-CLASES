

public class Main {
    public void main(){
        Perro perro1=new Perro("Max", 4);
        Gato gato1=new Gato("Michi", 2);



        System.out.println("SOBREESCRITURA");
        System.out.println(perro1.comunicarse());
        System.out.println(gato1.comunicarse());


        //Demostracion polimorfica

        Animal animal1 = new Perro("Perrito",5);
        Animal animal2 = new Gato("Gatito",6);


        Animal animal = new Animal("pajaro",8);
        System.out.println(animal1.comunicarse());
        System.out.println(animal2.comunicarse());
        System.out.println(animal.comunicarse());

    }
}
