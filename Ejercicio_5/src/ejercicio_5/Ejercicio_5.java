/*
Escribe unha clase que cree dous fíos e force que a escritura dosegundo sexa sempre anterior á escritura por pantalla do primeiro.
Exemplo de ejecución:
Ola, son o fío número 2
Ola, son o fío número 1

 */
package ejercicio_5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_5 extends Thread{
    
    public Ejercicio_5(String nombre){
        super(nombre);
    }
    
    public void run(){
        
        if (getName().equals("1")){
            Ejercicio_5 h2 = new Ejercicio_5 ("2");
            h2.start();
            try {
                h2.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Ejercicio_5.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                
        for(int x=0;x<10;x++){
            System.out.println("Ola, son o fío número "+getName()); 
        }
        
    }
    

    public static void main(String[] args) throws InterruptedException {
        
        Ejercicio_5 h1 = new Ejercicio_5 ("1");
        
        h1.start();
        
    }
    
}
