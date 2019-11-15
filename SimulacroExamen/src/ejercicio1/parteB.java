package ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

class parteB extends Thread {
    
    public static int contador=0;
    
    public parteB(String nombre){
        super(nombre);
    }
    
    @Override
    public void run() {
        
        if(contador==0||contador==1||contador==2){
            contador++;
            String hilo = "hiloSecundario"+contador;
            parteB hiloSecundario = new parteB(hilo);
            
            hiloSecundario.start();
            
            try {
                hiloSecundario.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(parteB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for(int x=1;x<9;x++){
            int numero = (int) (Math.random() * 5000) + 1000;
            System.out.println(this.getName()+" Interacion numero "+x);
            try {
                sleep(numero);
            } catch (InterruptedException ex) {
                Logger.getLogger(parteB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
    }
    
    public static void main(String[] args) throws InterruptedException {
        parteB hiloPrincipal = new parteB("hiloPrincipal");
        hiloPrincipal.start();
    }
    
}
