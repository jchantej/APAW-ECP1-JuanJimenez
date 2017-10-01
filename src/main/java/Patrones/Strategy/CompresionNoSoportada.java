package Patrones.Strategy;

public class CompresionNoSoportada extends CompresionArchivo {

    public CompresionNoSoportada(String nombreArchivo) {
        super(nombreArchivo);
    }

    @Override
    public String comprimirArchivo() {
        return "NO SOPORTADA";
    }

}
