package Patrones.Strategy;

public  abstract class  CompresionArchivo  {

    private String nombreArchivo;

    public CompresionArchivo(String nombreArchivo) {
        super();
       this.nombreArchivo = nombreArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public abstract String comprimirArchivo();
  
}
