package Patrones.Strategy;

public class CompresionImagen extends CompresionArchivo{

    public CompresionImagen(String nombreArchivo) {
        super(nombreArchivo);

    }

    @Override
    public String comprimirArchivo() {
        return  super.getNombreArchivo()+".Zip";
    }

}
