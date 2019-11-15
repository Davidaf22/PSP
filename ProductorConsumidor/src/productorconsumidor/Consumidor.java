package productorconsumidor;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Consumidor extends Thread {
    
    public ProductorConsumidor srtm;
    
    public Consumidor (String nombre,ProductorConsumidor srtm){
        super(nombre);
        this.srtm=srtm;
    }
    
    @Override
    public void run(){
        for(int i =0;i<10;i++){
            try {
                srtm.comer();
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
}
