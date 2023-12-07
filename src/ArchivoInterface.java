public interface ArchivoInterface {
    //crea el file en el sistema de archivos
    void crear();
    //abre los archivos en txt
    void abrir();
    //lee el archivo linea por linea
    void leer();
    // sirve para llenar datos en un archivo
    void escribir(String texto, boolean sobreescribir);


}
