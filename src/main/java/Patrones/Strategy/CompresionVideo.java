package Patrones.Strategy;

public class CompresionVideo extends CompresionArchivo {

    private String nombreArchivo;

    public CompresionVideo(String nombreArchivo) {
        super(nombreArchivo);
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public String comprimirArchivo() {
        return nombreArchivo + ".7Zip";
    }

}
