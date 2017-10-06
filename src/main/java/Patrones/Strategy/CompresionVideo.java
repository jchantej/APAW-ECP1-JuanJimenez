package Patrones.Strategy;

public class CompresionVideo extends CompresionArchivo {

    public CompresionVideo(String nombreArchivo) {
        super(nombreArchivo);
    }

    @Override
    public String comprimirArchivo() {
        return super.getNombreArchivo()+".7Zip";
    }

}
