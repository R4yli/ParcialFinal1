import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Desktop;

public class Archivo implements ArchivoInterface {

    protected String ruta;
    protected String nombre;
    private File file;

    public Archivo(String nombre) {
        ruta = "archivos/" + nombre;
        this.nombre = nombre;
        file = new File(ruta);
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void crear() {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void abrir() {
        try {
            if (!Desktop.isDesktopSupported()) {
                System.out.println("No soportado");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                desktop.open(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void leer() {}

    @Override
    public void escribir(String texto, boolean sobreescribir) {
        try {
            FileWriter fw = new FileWriter(ruta, !sobreescribir);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto);
            bw.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
