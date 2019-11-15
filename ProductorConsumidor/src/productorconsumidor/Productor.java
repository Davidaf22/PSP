package productorconsumidor;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Productor extends Thread {
    
    public ProductorConsumidor srtm;
    
    public Productor (String nombre,ProductorConsumidor srtm){
        super(nombre);
        this.srtm=srtm;
    }
    
    @Override
    public void run(){
        for(int i =0;i<10;i++){
            try {
                srtm.hornear();
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
}
