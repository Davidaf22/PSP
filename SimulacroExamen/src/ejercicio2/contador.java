package ejercicio2;

public class contador extends Thread {
    
    public vocales hiloVocales;
    public consonantes hiloConsonantes;
    
    public contador(String nombre){
        super(nombre);
    }

    public void setHiloVocales(vocales hiloVocales) {
        this.hiloVocales = hiloVocales;
    }

    public void setHiloConsonantes(consonantes hiloConsonantes) {
        this.hiloConsonantes = hiloConsonantes;
    }

    @Override
    public void run() {
        
        int totales = hiloVocales.getContador() + hiloConsonantes.getContador();
        System.out.println("El numero de letras totales es : "+totales);
        
        
    }
    
}
