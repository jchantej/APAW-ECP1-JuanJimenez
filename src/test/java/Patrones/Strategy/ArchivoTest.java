package Patrones.Strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArchivoTest {

    private enum tipoArchivo {
        VIDEO, AUDIO, NOT_SOPORTED
    };

    private Archivo archivo;

    @Test
    public void compresionSegunTipoArchivoTest() {

        
        if ("VIDEO".equals(tipoArchivo.VIDEO.toString())) {

            archivo = new Archivo(new CompresionVideo("video"));
            archivo.comprimirArchivo();
            archivo.mostrarCompresion();
            assertEquals("video.7Zip", archivo.mostrarCompresion());
        }
        
        
        if ("AUDIO".equals(tipoArchivo.AUDIO.toString())) {

            archivo = new Archivo(new CompresionAudio("audio"));
            archivo.comprimirArchivo();
            archivo.mostrarCompresion();
            assertEquals("audio.WinRar", archivo.mostrarCompresion());
        }

        if (!"OTRO".equals(tipoArchivo.NOT_SOPORTED.toString())) {

            archivo = new Archivo(new CompresionNoSoportada("nombre"));
            archivo.comprimirArchivo();
            archivo.mostrarCompresion();
            assertEquals("NO SOPORTADA", archivo.mostrarCompresion());
        }


    }

    @Test
    public void compresionVideoTest() {
        Archivo archivo = new Archivo(new CompresionVideo("video"));
        archivo.comprimirArchivo();
        archivo.mostrarCompresion();
        assertEquals("video.7Zip", archivo.mostrarCompresion());

    }

    @Test
    public void compresionAudioTest() {
        Archivo archivo = new Archivo(new CompresionAudio("audio"));
        archivo.comprimirArchivo();
        archivo.mostrarCompresion();
        assertEquals("audio.WinRar", archivo.mostrarCompresion());

    }

    @Test
    public void compresionNoSoportadaTest() {
        Archivo archivo = new Archivo(new CompresionNoSoportada("nombre"));
        archivo.comprimirArchivo();
        archivo.mostrarCompresion();
        assertEquals("NO SOPORTADA", archivo.mostrarCompresion());

    }

}
