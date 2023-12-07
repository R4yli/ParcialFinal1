public class Vuelo {
    private String origen;
    private String destino;
    private int plazas;
    private String duracion;

    private String fecha;

    public Vuelo(String origen, String destino, int plazas, String duracion, String fecha) {
        this.origen = origen;
        this.destino = destino;
        this.plazas = plazas;
        this.duracion = duracion;
        this.fecha = fecha;

    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
