public class Persona{

    private int edad;
    private int altura;
    private String nombre;
    private String apellido;

    public Persona() {
    }

    public Persona(int edad, int altura, String nombre, String apellido) {

        this.edad = edad;
        this.altura = altura;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
