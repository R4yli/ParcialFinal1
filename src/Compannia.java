public class Compannia {
    private String nombre;
    private ListaVuelos listaVuelos;

    public Compannia(String nombre) {
        this.nombre = nombre;
        listaVuelos = new ListaVuelos();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaVuelos getListaVuelos() {
        return listaVuelos;
    }

    public void setListaVuelos(ListaVuelos listaVuelos) {
        this.listaVuelos = listaVuelos;
    }

}
