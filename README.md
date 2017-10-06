# Patrones de Diseño
#### Asignatura: *Ingeniería Web: Visión General*
#### [Máster en Ingeniería Web por la U.P.M.](http://miw.etsisi.upm.es)

### Tecnologías necesarias
* Java
* Maven
* Eclipse
* GitHub

### Descripción
En proyecto se  implementan algunos patrones de diseño, entre ellos:    
1.- Factoria y Singleton  
2.- Builder  
3.- Composide  
4.- Strategy  

# Descripción Patrón Strategy (Estrategia), [WiKi..](https://github.com/jchantej/APAW-ECP1-JuanJimenez/wiki/Patron-Strategy#patron-strategy-estrategia)

## Definición
>_Patrón que define un colección de algoritmos,a los cuales encapsula y los hace intercambiables. Permitiendo de esta manera que el algoritmo pueda variar independientemente de los clientes que lo utilicen, tomado de [Helm, Johnson and Vlissides]_
## Cuando aplicar el patrón Strategy?
1. Existan muchas clases relacionadas pero estas difieren solo en su comportamiento.
2. Se necesitan aplicar diferentes procesos o algoritmos a un determindo comportamiento.
3. Una clase define compartamientos con muchas sentencias condicionales (IF/ELSE SWITCH).

## Estructura
Se identifican 3 componentes:  
* Contexto
* Estrategia
* Estrategias Concretas  
![](https://github.com/jchantej/APAW-ECP1-JuanJimenez/blob/develop/docs/StrategyEstructura.PNG)  

## Caso Práctico
> Partiendo de la idea en la cual existen muchos tipos de archivos (Audio, Video, Imagen, Texto, etc), y estos necesitan un trato especial a la hora de ser compresos, es decir que se necesitan algoritmos de compresión diferentes para tratar cada uno de ellos y en consecuencia de ello comprimirlos con una extension determinada (.7Zip, .ZIP, .RAR).  
> 
> Asumiendo que se realizaron mediciones y comparativas de varios programas de software dedicados a la compresión de archivos, obtuvieron que:
> - Los archivos de VIDEO deben usar el algoritmo .7Zip
> - Los archivos de AUDIO deben usar el algoritmo .WINRAR
> - Los archivos de IMAGEN deben usar el algoritmo  .ZIP  

## Aplicar el patron Strategy:
**1.** Se deben identificar los tres componentes del patron (Contexto, Estrategia y Estrategias Concretas), del problema en cuestión, en este caso se han encontrado los siguiente relaciones:
> - Contexto: **__Archivos__** a comprimir.
> - Estrategia:  Encargado de mostrar un interfaz común para realizar el proceso de compresión, se la a definido como **__CompresionArchivo__**.
> - Estrategias Concretas: Los Archivos que van a aplicar un algoritmo determinado de acuardo a su tipo AUDIO, VIDEO, IMAGEN, etonnces se tiene: **__CompresionVideo__**, **__CompresionAudio__**, y **__CompresionImagen__**. En la imagen a continiación se puede apreciar el diagrama: 

 ![](https://github.com/jchantej/APAW-ECP1-JuanJimenez/blob/develop/docs/modeloarchivo.PNG)  

**2.** Implementación.
- Construir la interfaz común (Estrategia), que en este caso sera una clase abstracta, con un atributo _nombre_, el método _getNombre_, y un método abstracto _comprimirArchivo_ que devuelve un String.  
~~~
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
~~~
***
- Construir las estrategias concretas, las mismas que deben heredar de _**CompresionArchivo**_.  
Estrategia concreta **_CompresionVideo_**
~~~
public class CompresionVideo extends CompresionArchivo {
    public CompresionVideo(String nombreArchivo) {
        super(nombreArchivo);
    }
    @Override
    public String comprimirArchivo() {
        return super.getNombreArchivo()+".7Zip";
    }
}
~~~
***
Estrategia concreta **_CompresionAudio_**
~~~
public class CompresionAudio extends CompresionArchivo{
    public CompresionAudio(String nombreArchivo) {
        super(nombreArchivo);
    }
    @Override
    public String comprimirArchivo() {
        return  super.getNombreArchivo()+".WinRar";
    }
}
~~~

***
Estrategia concreta **_CompresionImagen_**
~~~
public class CompresionImagen extends CompresionArchivo{
    public CompresionAudio(String nombreArchivo) {
        super(nombreArchivo);
    }
    @Override
    public String comprimirArchivo() {
        return  super.getNombreArchivo()+".Zip";
    }
}
~~~
***
Estrategia concreta **_CompresionNoSoportada_**  
Por lo general se recomienda implementar un estrategia concreta que no se puede contemplar dentro del dominio para algun problema en particular, para el caso en cuestión, se crea la estrategia concreta **_CompresionNoSoportada_**, dado el caso que requieran una compresión para un tipo de archivo inexitente, o la compresión para ese tipo de archivo no este soportada aún.
~~~
public class CompresionNoSoportada extends CompresionArchivo {
    public CompresionNoSoportada(String nombreArchivo) {
        super(nombreArchivo);
    }
    @Override
    public String comprimirArchivo() {
        return "NO SOPORTADA";
    }
}
~~~
***
- Construir el contexto que este caso sera la clase Archivo, la cual mediante agregación hace referencia a la estrategia(Clase abstracta CompresionArchivo). En este al constructor es a quien le llega un tipo de compresion especifica por medio de la interfaz (clase abstracta), es decir ahi se construirá un objeto de una estrategia concreta, y la enviara a comprimir dependiendo del objeto que le llegue (Video, Audio, Imagen, o no soportado)  
Contexto **_Archivo_**
~~~
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
~~~

**2.** Pruebas.
- Para consumir el patron se relizara un test de pruebas unitarias (JUnit), el cual imprimira en consola los distintos resultados.
Entonces se debe hacer uso del contexto que en este caso sera la clase **_Archivo_**, la cual en el constructor se le debe pasar la strategia concreta dependiendo el tipo de archivo que se quierea comprimir (AUDIO, VIDEO, IMAGEN.). Adicional a esto se ha creado un enumerado para simular los distintos tipos de arvhivo.
~~~
public class ArchivoTest {
    private enum tipoArchivo {
        VIDEO, AUDIO, IMAGEN, NOT_SOPORTED
    };
    private Archivo archivo;
    @Test
    public void compresionSegunTipoArchivoTest() {
        if ("VIDEO".equals(tipoArchivo.VIDEO.toString())) {
            archivo = new Archivo(new CompresionVideo("video"));
            assertEquals("video.7Zip", archivo.comprimirArchivo());
            System.out.println("VIDEO>>Resultado de Commpresion: "+ archivo.comprimirArchivo());
        }
        if ("AUDIO".equals(tipoArchivo.AUDIO.toString())) {
            archivo = new Archivo(new CompresionAudio("audio"));
            assertEquals("audio.WinRar", archivo.comprimirArchivo());
            System.out.println("AUDIO>>Resultado de Commpresion: "+ archivo.comprimirArchivo());
        }
        if ("IMAGEN".equals(tipoArchivo.IMAGEN.toString())) {
            archivo = new Archivo(new CompresionImagen("imagen"));
            assertEquals("imagen.Zip", archivo.comprimirArchivo());
            System.out.println("IMAGEN>>Resultado de Commpresion: "+ archivo.comprimirArchivo());
        }
        if (!"OTRO".equals(tipoArchivo.NOT_SOPORTED.toString())) {
            archivo = new Archivo(new CompresionNoSoportada("nombre"));
            archivo.comprimirArchivo();
            assertEquals("NO SOPORTADA", archivo.comprimirArchivo());
            System.out.println("NO SOPORTADO>>Resultado de Commpresion: "+ archivo.comprimirArchivo());
        }
    }
}
~~~
> DONDE IDENTIFICAR EL USO DE ESTRATEGY: Se debe poner atención en la siguiente lineas  
>archivo = new Archivo(new CompresionVideo("video"));  
>archivo = new Archivo(new CompresionAudio("audio"));  
>archivo = new Archivo(new CompresionImagen("imagen"));  
>  
----**_RESULTADO_**---  
Consola  
![](https://github.com/jchantej/APAW-ECP1-JuanJimenez/blob/develop/docs/resultado-consola.PNG)  
Junit  
![](https://github.com/jchantej/APAW-ECP1-JuanJimenez/blob/develop/docs/resultado-unit-test.PNG)

### Elaborado Por: Juan Pablo Jiménez Ramos
