package ejercicio1;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

class parteC extends Thread {
    
    public static int contador=0;
    
    public parteC(String nombre){
        super(nombre);
    }
    
    @Override
    public void run() {
        
        if(contador==0){
            contador=1;
            parteC hiloSecundario1 = new parteC("hiloSecundario1");
            parteC hiloSecundario2 = new parteC("hiloSecundario2");
            parteC hiloSecundario3 = new parteC("hiloSecundario3");
            
            hiloSecundario1.start();
            hiloSecundario2.start();
            hiloSecundario3.start();
            
            try {
                hiloSecundario1.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(parteA.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                hiloSecundario2.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(parteA.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                hiloSecundario3.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(parteA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for(int x=1;x<9;x++){
            int numero = (int) (Math.random() * 5000) + 1000;
            System.out.println(this.getName()+" Interacion numero "+x);
            try {
                sleep(numero);
            } catch (InterruptedException ex) {
                Logger.getLogger(parteA.class.getName()).log(Level.SEVERE, null, ex);
            }
            yield();
        }       
    }
    
    public static void main(String[] args) throws InterruptedException {
        parteC hiloPrincipal = new parteC("hiloPrincipal");
        hiloPrincipal.start();
    }
}
