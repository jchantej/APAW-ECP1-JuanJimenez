package Patrones.Strategy;

public class Archivo {

    private CompresionArchivo compresionArchivo;

    public Archivo(CompresionArchivo compresionArchivo) {
        super();
        this.compresionArchivo = compresionArchivo;
    }

    public void comprimirArchivo() {
        
        compresionArchivo.comprimirArchivo();
  
    }

    public String mostrarCompresion() {
        return compresionArchivo.comprimirArchivo();

    }

}
