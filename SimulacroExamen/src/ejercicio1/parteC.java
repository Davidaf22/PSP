package ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

class parteC extends Thread {
    
    public static int contador=0;
    public static int interacciones1=0;
    public static int interacciones2=0;
    public static int interacciones3=0;
    
    
    public parteC(String nombre){
        super(nombre);
    }
    
    @Override
    public void run() {
        
        if(contador==0){
            contador++;
            parteC hiloSecundario1 = new parteC("hiloSecundario1");
            parteC hiloSecundario2 = new parteC("hiloSecundario2");
            parteC hiloSecundario3 = new parteC("hiloSecundario3");
            
            hiloSecundario1.start();
            hiloSecundario2.start();
            hiloSecundario3.start();
            
            try {
                hiloSecundario1.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(parteC.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                hiloSecundario2.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(parteC.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                hiloSecundario3.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(parteC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for(int x=1;x<9;x++){
            int numero = (int) (Math.random() * 5000) + 1000;
            System.out.println(this.getName()+" Interacion numero "+x);
            try {
                sleep(numero);
            } catch (InterruptedException ex) {
                Logger.getLogger(parteC.class.getName()).log(Level.SEVERE, null, ex);
            }
            String nombre = this.getName();
            String[] parts = nombre.split("");
            
            if(parts[parts.length-1]=="1"){
                interacciones1=x;
            }
            else if(parts[parts.length-1]=="2"){
                interacciones2=x;
            }
             else if(parts[parts.length-1]=="3"){
                interacciones3=x;
            }
            
            if(interacciones1!=interacciones2||interacciones1!=interacciones3||interacciones2!=interacciones3){
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(parteC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                this.notify();
            }
        }       
    }
    
    public static void main(String[] args) throws InterruptedException {
        parteC hiloPrincipal = new parteC("hiloPrincipal");
        hiloPrincipal.start();
    }
    
}