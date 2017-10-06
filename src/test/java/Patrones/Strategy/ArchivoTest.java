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

            assertEquals("video.7Zip", archivo.comprimirArchivo());
        }

        if ("AUDIO".equals(tipoArchivo.AUDIO.toString())) {

            archivo = new Archivo(new CompresionAudio("audio"));

            assertEquals("audio.WinRar", archivo.comprimirArchivo());
        }

        if (!"OTRO".equals(tipoArchivo.NOT_SOPORTED.toString())) {

            archivo = new Archivo(new CompresionNoSoportada("nombre"));
            archivo.comprimirArchivo();
            assertEquals("NO SOPORTADA", archivo.comprimirArchivo());
        }

    }

    @Test
    public void compresionVideoTest() {
        Archivo archivo = new Archivo(new CompresionVideo("video"));
        
        assertEquals("video.7Zip", archivo.comprimirArchivo());

    }

    @Test
    public void compresionAudioTest() {
        Archivo archivo = new Archivo(new CompresionAudio("audio"));
        assertEquals("audio.WinRar", archivo.comprimirArchivo());

    }

    @Test
    public void compresionNoSoportadaTest() {
        Archivo archivo = new Archivo(new CompresionNoSoportada("nombre"));
        assertEquals("NO SOPORTADA", archivo.comprimirArchivo());

    }

}
