import java.util.List;
import java.util.stream.Collectors;

public class Aeropuerto {
    private String codigo;
    private String nombre;
    private String poblacion;
    private String pais;
    private String GMT;

    public Aeropuerto(String codigo, String nombre, String poblacion, String pais, String gMT) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.pais = pais;
        GMT = gMT;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getGMT() {
        return GMT;
    }

    public void setGMT(String gMT) {
        GMT = gMT;
    }

    public List<Vuelo> getVuelosSalientesPorCompannia(Compannia compannia){
        ListaVuelos vuelosCompannia = compannia.getListaVuelos();
        List<Vuelo> vuelosDesdeAeropuerto = vuelosCompannia.getVuelos().stream()
                .filter(vuelo -> vuelo.getOrigen().equals(getCodigo()))
                .collect(Collectors.toList());

        return vuelosDesdeAeropuerto;
    }

    public List<Vuelo> getVuelosEntrantesPorCompannia(Compannia compannia){
        ListaVuelos vuelosCompannia = compannia.getListaVuelos();
        List<Vuelo> vuelosHastaAeropuerto = vuelosCompannia.getVuelos().stream()
                .filter(vuelo -> vuelo.getDestino().equals(getCodigo()))
                .collect(Collectors.toList());

        return vuelosHastaAeropuerto;
    }
}

