package ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

class parteA extends Thread {
    
    public static int contador=0;
    
    public parteA(String nombre){
        super(nombre);
    }
    
    @Override
    public void run() {
        
        if(contador==0){
            contador=1;
            parteA hiloSecundario1 = new parteA("hiloSecundario1");
            parteA hiloSecundario2 = new parteA("hiloSecundario2");
            parteA hiloSecundario3 = new parteA("hiloSecundario3");
            
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
        }       
    }
    
    public static void main(String[] args) throws InterruptedException {
        parteA hiloPrincipal = new parteA("hiloPrincipal");
        hiloPrincipal.start();
    }
    
}
