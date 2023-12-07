import java.util.ArrayList;
import java.util.List;

public class ListaAeropuertos {
    private List<Aeropuerto> aeropuertos;

    public ListaAeropuertos() {
        aeropuertos = new ArrayList<>();
    }

    public List<Aeropuerto> getAeropuertos() {
        return aeropuertos;
    }

    public void setAeropuertos(List<Aeropuerto> aeropuertos) {
        this.aeropuertos = aeropuertos;
    }

    public void agregarAeropuerto(Aeropuerto aeropuerto) {
        aeropuertos.add(aeropuerto);
    }

    public String getListaAeropuertosString() {
        StringBuilder texto = new StringBuilder(
                String.format("%s %21s %10s %13s %4s", "Código", "Nombre", "Población", "País", "GMT")
                        + "\n-----------------------------------------------------------");
        for (Aeropuerto aeropuerto : aeropuertos) {
            texto.append(String.format("\n%s %22s %10s %13s %4s", aeropuerto.getCodigo(), aeropuerto.getNombre(),
                    aeropuerto.getPoblacion(), aeropuerto.getPais(), aeropuerto.getGMT()));
        }

        texto.append("\n-----------------------------------------------------------\nNúmero de aeropuertos: " + aeropuertos.size());

        return texto.toString();
    }

    public void mostrarAeropuertos() {
        System.out.println(getListaAeropuertosString());
    }

    public String generarStringListaVuelos(ListaCompannias listaCompannias, String tipo) {
        StringBuilder texto = new StringBuilder();
        for (Aeropuerto aeropuerto : getAeropuertos()) {
            boolean aeropuertoTieneVuelosSalientes = false;
            boolean aeropuertoTieneVuelosEntrantes = false;
            texto.append("--------------------------------------------------------");
            texto.append("\nAeropuerto: " + aeropuerto.getNombre() + " (" + aeropuerto.getCodigo() + ")");

            for (Compannia compannia : listaCompannias.getCompannias()) {
                List<Vuelo> vuelosDesdeAeropuerto = aeropuerto.getVuelosSalientesPorCompannia(compannia);
                List<Vuelo> vuelosHastaAeropuerto = aeropuerto.getVuelosEntrantesPorCompannia(compannia);

                if (!vuelosDesdeAeropuerto.isEmpty() || !vuelosHastaAeropuerto.isEmpty()) {

                    if (tipo.equals("Ambas") || (!vuelosDesdeAeropuerto.isEmpty() && tipo.equals("Salientes"))
                            || (!vuelosHastaAeropuerto.isEmpty() && tipo.equals("Entrantes"))) {
                        texto.append("\n  Compañía: " + compannia.getNombre() + "\n");
                    }

                    if (!vuelosDesdeAeropuerto.isEmpty() && (tipo.equals("Salientes") || tipo.equals("Ambas"))) {
                        aeropuertoTieneVuelosSalientes = true;
                        texto.append(String.format("\n  SALIDAS:\n  %s %10s %10s %13s %20s", "Origen", "Destino", "Plazas", "Duración", "Fecha"));

                        for (Vuelo vuelo : vuelosDesdeAeropuerto) {
                            texto.append(String.format("\n  %s %10s %10s %13s %20s", vuelo.getOrigen(), vuelo.getDestino(),
                                    vuelo.getPlazas(), vuelo.getDuracion(), vuelo.getFecha()));
                        }
                    }

                    if (tipo.equals("Ambas") && !vuelosDesdeAeropuerto.isEmpty()){
                        texto.append("\n");
                    }

                    if (!vuelosHastaAeropuerto.isEmpty() && (tipo.equals("Entrantes") || tipo.equals("Ambas"))) {
                        aeropuertoTieneVuelosEntrantes = true;
                        texto
                                .append(String.format("\n  ENTRADAS:\n  %s %10s %10s %13s %20s", "Origen", "Destino", "Plazas", "Duración", "Fecha"));

                        for (Vuelo vuelo : vuelosHastaAeropuerto) {
                            texto.append(String.format("\n  %s %10s %10s %13s %20s", vuelo.getOrigen(), vuelo.getDestino(),
                                    vuelo.getPlazas(), vuelo.getDuracion(), vuelo.getFecha()));
                        }
                    }
                    if (tipo.equals("Ambas") || (!vuelosDesdeAeropuerto.isEmpty() && tipo.equals("Salientes"))
                            || (!vuelosHastaAeropuerto.isEmpty() && tipo.equals("Entrantes"))) {
                        texto.append("\n  ------------------------------------------------------");
                    }
                }
            }
            if (!aeropuertoTieneVuelosEntrantes && tipo.equals("Entrantes")) {
                texto.append("\nEl aeropuerto no tiene vuelos entrantes...");
            }

            if (!aeropuertoTieneVuelosSalientes && tipo.equals("Salientes")) {
                texto.append("\nEl aeropuerto no tiene vuelos salientes...");
            }

            if (!aeropuertoTieneVuelosEntrantes && !aeropuertoTieneVuelosSalientes && tipo.equals("Ambas")) {
                texto.append(
                        "\nEl aeropuerto no tiene vuelos registrados...");
            }

            texto.append("\n--------------------------------------------------------\n\n");
        }
        return texto.toString();
    }

}
