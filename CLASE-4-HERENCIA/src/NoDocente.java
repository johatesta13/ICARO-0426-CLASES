public class NoDocente extends Persona{

    private String area;


    public NoDocente() {
        super();
    }

    public NoDocente(String nombre, String apellido, String area) {
        super(nombre,apellido);
        this.area = area;


    }


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
