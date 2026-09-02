public class Estudiante {

   private String id;
   private String nombre_completo;
   private float promedio;


    public Estudiante(String id, String nombre_completo, float promedio) {
        this.id = id;
        this.nombre_completo = nombre_completo;
        this.promedio = promedio;
    }


    public Estudiante() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }




}
