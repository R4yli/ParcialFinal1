import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {
        ArchivoVuelos archivoVuelos = new ArchivoVuelos("vuelos.txt");
        archivoVuelos.crear();
        archivoVuelos.leer();

        menu(archivoVuelos);
    }

    public static void menu(ArchivoVuelos archivoVuelos) {
        ListaAeropuertos listaAeropuertos = archivoVuelos.getListaAeropuertos();
        ListaCompannias listaCompannias = archivoVuelos.getListaCompannias();

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Menú:");
            System.out.println("1. Mostrar listado de aeropuertos");
            System.out.println("2. Mostrar vuelos de salida por aeropuerto");
            System.out.println("3. Mostrar vuelos de entrada por aeropuerto");
            System.out.println("4. Abrir archivos de resultados");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    listaAeropuertos.mostrarAeropuertos();
                    break;
                case 2:
                    System.out.println(listaAeropuertos.generarStringListaVuelos(listaCompannias, "Salientes"));
                    break;
                case 3:
                    System.out.println(listaAeropuertos.generarStringListaVuelos(listaCompannias, "Entrantes"));
                    break;
                case 4:
                    Archivo archivoAeropuertos = new Archivo("lista aeropuertos.txt");
                    archivoAeropuertos.crear();
                    archivoAeropuertos.escribir(listaAeropuertos.getListaAeropuertosString(), true);
                    archivoAeropuertos.abrir();

                    Archivo archivoResultados = new Archivo("lista vuelos.txt");
                    archivoResultados.crear();
                    archivoResultados.escribir(listaAeropuertos.generarStringListaVuelos(listaCompannias, "Ambas"), true);
                    archivoResultados.abrir();
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }

        } while (option != 0);

        scanner.close();
    }
}
