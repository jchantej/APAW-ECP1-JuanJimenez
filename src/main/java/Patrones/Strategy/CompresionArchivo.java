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

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public abstract String comprimirArchivo();

    
}
