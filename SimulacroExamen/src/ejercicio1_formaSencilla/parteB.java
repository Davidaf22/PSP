package ejercicio1_formaSencilla;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

class parteB extends Thread {
    
    public parteB(String nombre){
        super(nombre);
    }
    
    @Override
    public void run() {
        
        for(int x=1;x<9;x++){
            int numero = (int) (Math.random() * 5000) + 1000;
            System.out.println(this.getName()+" Interacion numero "+x);
            try {
                sleep(numero);
            } catch (InterruptedException ex) {
                Logger.getLogger(parteA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("Empieza Hilo Main");

        parteB hiloSecundario1 = new parteB("hiloSecundario1");
        parteB hiloSecundario2 = new parteB("hiloSecundario2");
        parteB hiloSecundario3 = new parteB("hiloSecundario3");
            
        hiloSecundario1.start();
        hiloSecundario1.join();
        
        hiloSecundario2.start();
        hiloSecundario2.join();
        
        hiloSecundario3.start();        
        hiloSecundario3.join();
        
        System.out.println("Termina Hilo Main");
    }
    
}
