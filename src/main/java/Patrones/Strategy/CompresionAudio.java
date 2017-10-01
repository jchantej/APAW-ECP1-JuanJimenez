package Patrones.Strategy;

public class CompresionAudio extends CompresionArchivo{

    public CompresionAudio(String nombreArchivo) {
        super(nombreArchivo);

    }

    @Override
    public String comprimirArchivo() {
        return  super.getNombreArchivo()+".WinRar";
    }

}
