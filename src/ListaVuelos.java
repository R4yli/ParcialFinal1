import java.util.ArrayList;
import java.util.List;

public class ListaVuelos {
    private List<Vuelo> vuelos;

    public ListaVuelos() {
        vuelos = new ArrayList<>();
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    public void agregarVuelo(Vuelo vuelo) {
        vuelos.add(vuelo);
    }
}
