package Patrones.Strategy;

public class Archivo {

    private CompresionArchivo compresionArchivo;

    private String tipoArchivo;
    private String nombreArchivo;

    public Archivo(String tipoArchivo, String nombreArchivo) {
        super();
        this.tipoArchivo = tipoArchivo;
        this.nombreArchivo = nombreArchivo;
    }

    public void comprimirArchivo() {

        switch (this.tipoArchivo) {
        case "VIDEO":
            compresionArchivo = new CompresionVideo(nombreArchivo);
            break;
        case "AUDIO":
            compresionArchivo = new CompresionAudio(nombreArchivo);
            break;
        default:
            compresionArchivo = new CompresionNoSoportada(nombreArchivo);
        }
    }

    public String mostrarCompresion() {
        return compresionArchivo.comprimirArchivo();

    }

}
