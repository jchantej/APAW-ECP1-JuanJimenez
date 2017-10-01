package Patrones.Strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArchivoTest {
    
    private enum tipoArhivo {VIDEO,AUDIO};
    
    @Test
    public void compresionVideoTest() {
        Archivo archivo = new Archivo(tipoArhivo.VIDEO.toString(),"video");
        archivo.comprimirArchivo();
        archivo.mostrarCompresion();
        assertEquals("video.7Zip", archivo.mostrarCompresion());
        
    }
    
    @Test
    public void compresionAudioTest() {
        Archivo archivo = new Archivo(tipoArhivo.AUDIO.toString(),"audio");
        archivo.comprimirArchivo();
        archivo.mostrarCompresion();
        assertEquals("audio.WinRar", archivo.mostrarCompresion());
        
    }
    
    @Test
    public void compresionNoSoportadaTest() {
        Archivo archivo = new Archivo("DESCONOCIDO","nombre");
        archivo.comprimirArchivo();
        archivo.mostrarCompresion();
        assertEquals("NO SOPORTADA", archivo.mostrarCompresion());
        
    }

}
