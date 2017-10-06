package Patrones.Strategy;

public class Archivo {

    private CompresionArchivo compresionArchivo;

    public Archivo(CompresionArchivo compresionArchivo) {
        super();
        this.compresionArchivo = compresionArchivo;
    }

    public String comprimirArchivo() {
        
        return compresionArchivo.comprimirArchivo();
  
    }


}
