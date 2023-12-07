import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ArchivoVuelos extends Archivo {
    private ListaAeropuertos listaAeropuertos;
    private ListaVuelos listaVuelos;
    private ListaCompannias listaCompannias;

    public ArchivoVuelos(String nombre) {
        super(nombre);
        listaAeropuertos = new ListaAeropuertos();
        listaVuelos = new ListaVuelos();
        listaCompannias = new ListaCompannias();
    }

    public ListaAeropuertos getListaAeropuertos() {
        return listaAeropuertos;
    }

    public void setListaAeropuertos(ListaAeropuertos listaAeropuertos) {
        this.listaAeropuertos = listaAeropuertos;
    }

    public ListaVuelos getListaVuelos() {
        return listaVuelos;
    }

    public void setListaVuelos(ListaVuelos listaVuelos) {
        this.listaVuelos = listaVuelos;
    }

    public ListaCompannias getListaCompannias() {
        return listaCompannias;
    }

    public void setListaCompannias(ListaCompannias listaCompannias) {
        this.listaCompannias = listaCompannias;
    }

    @Override
    public void leer() {
        String linea;
        int apartado = 0; // #Aeropuertos, #Vuelos

        // Aeropuertos
        StringBuffer codigoAeropuerto, nombreAeropuerto, poblacionAeropuerto, paisAeropuerto, gmtAeropuerto;

        // Vuelos
        StringBuffer origenVuelo, destinoVuelo, duracionVuelo, plazasVuelo;
        StringBuffer primerCampoVuelo, sextoCampoVuelo, octavoCampoVuelo, fechaVuelo;

        // Compañias
        StringBuffer nombreCompannia;

        try {
            try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
                while ((linea = br.readLine()) != null) {

                    linea = linea.trim();
                    codigoAeropuerto = new StringBuffer();
                    nombreAeropuerto = new StringBuffer();
                    poblacionAeropuerto = new StringBuffer();
                    paisAeropuerto = new StringBuffer();
                    gmtAeropuerto = new StringBuffer();

                    origenVuelo = new StringBuffer();
                    destinoVuelo = new StringBuffer();
                    duracionVuelo = new StringBuffer();
                    plazasVuelo = new StringBuffer();

                    nombreCompannia = new StringBuffer();

                    primerCampoVuelo = new StringBuffer();
                    sextoCampoVuelo = new StringBuffer();
                    octavoCampoVuelo = new StringBuffer();
                    fechaVuelo = new StringBuffer();

                    if (nombre.equals("vuelos.txt")) {
                        if (linea.length() != 0) {
                            if (linea.charAt(0) == '.') {
                                // es comment
                                // System.out.println(linea.replace(".", ""));
                            } else if (linea.compareTo("#Aeropuertos") == 0) {
                                apartado = 1; // apartado 1 Aeropuertos
                            } else if (linea.compareTo("#Vuelos") == 0) {
                                apartado = 2; // apartado 2 Vuelos
                            } else {
                                if (apartado == 1) {// Estamos leyendo Aeropuertos
                                    asignarValores(linea, codigoAeropuerto, nombreAeropuerto, poblacionAeropuerto, paisAeropuerto,
                                            gmtAeropuerto);
                                    Aeropuerto aeropuerto = new Aeropuerto(codigoAeropuerto.toString(), nombreAeropuerto.toString(),
                                            poblacionAeropuerto.toString(), paisAeropuerto.toString(), gmtAeropuerto.toString());
                                    listaAeropuertos.agregarAeropuerto(aeropuerto);
                                } else if (apartado == 2) {// Estamos leyendo Vuelos
                                    asignarValores(linea, primerCampoVuelo, origenVuelo, destinoVuelo, duracionVuelo, nombreCompannia,
                                            sextoCampoVuelo, plazasVuelo, octavoCampoVuelo, fechaVuelo);
                                    Vuelo vuelo = new Vuelo(origenVuelo.toString(), destinoVuelo.toString(),
                                            Integer.parseInt(plazasVuelo.toString()), duracionVuelo.toString(), fechaVuelo.toString());
                                    listaVuelos.agregarVuelo(vuelo);

                                    int existeCompannia = 0;
                                    for (Compannia compannia : listaCompannias.getCompannias()) {
                                        if (compannia.getNombre().equals(nombreCompannia.toString())) {
                                            compannia.getListaVuelos().agregarVuelo(vuelo);
                                            existeCompannia = 1;
                                            break;
                                        }
                                    }

                                    if (existeCompannia == 0) {
                                        Compannia compannia = new Compannia(nombreCompannia.toString());
                                        compannia.getListaVuelos().agregarVuelo(vuelo);
                                        listaCompannias.agregarCompannia(compannia);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private void asignarValores(String linea, StringBuffer... arreglo) {
        StringTokenizer tokens;
        tokens = new StringTokenizer(linea, ";");

        for (StringBuffer e : arreglo) {
            e.append(tokens.nextToken().trim());
        }
    }
}

