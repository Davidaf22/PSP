package ejercicio2;

public class ejercicio2Main {
    
    public static void main(String[] args) throws InterruptedException {
        
        String linea = "Esto es una línea de prueba";
        
        vocales hiloVocal = new vocales("hiloVocal",linea);
        consonantes hiloConsonante = new consonantes("hiloConsonante",linea);
        contador hiloContador = new contador("hiloContador");
        hiloContador.setHiloConsonantes(hiloConsonante);
        hiloContador.setHiloVocales(hiloVocal);
        
        hiloVocal.run();
        hiloConsonante.run();
        
        hiloVocal.join();
        hiloConsonante.join();
        
        hiloContador.start();
        
        
    }  
}
