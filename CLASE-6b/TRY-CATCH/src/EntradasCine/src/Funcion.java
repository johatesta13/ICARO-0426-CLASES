package EntradasCine.src;

public class Funcion {

    private boolean peliculaComenzada;
    private boolean asientoOcupado;

    public Funcion(boolean peliculaComenzada) {
        this.peliculaComenzada = peliculaComenzada;
        this.asientoOcupado = false;
    }

    public void reservarAsiento() throws AsientoOcupadoException, FuncionFinalizadaException {

        if (peliculaComenzada) {
            throw new FuncionFinalizadaException("La película ya comenzó. No se pueden comprar entradas.");
        }

        if (asientoOcupado) {
            throw new AsientoOcupadoException("El asiento seleccionado ya está ocupado.");
        }

        asientoOcupado = true;
        System.out.println("Entrada comprada correctamente.");
    }
}
