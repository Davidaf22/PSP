package ejercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

public class numeros extends Thread {
    
    public ejercicio3Main stmr;
    public String linea;
    
    public numeros(String nombre, ejercicio3Main stmr,String linea){
        super(nombre);
        this.stmr=stmr;
        this.linea=linea;
    }
    
    @Override
    public void run(){
        
                String[] parts = linea.split("");
        for(int x=0; x<parts.length;x++){
            char letra=parts[x].charAt(0);
            int asciiLetra=letra;  
            if(asciiLetra>=49 && asciiLetra<=57){
                try {
                    stmr.sumarNum();
                } catch (InterruptedException ex) {
                    Logger.getLogger(mayusculas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
        
    }  
}
