/*
Programa en Java que cree dous fíos e os executa. Os fíos escriben dez veces un número de iteración do bucle eseu nome. En cada iteración, despois de 
escribir o seu nome, se bloquean durante un tempo aleatorio de segundos e después volven a estar dispoñibles para a súa execución.
 */
package ejercicio_1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_1 extends Thread {
    
    String nombre;
    
    public Ejercicio_1 (String nombre) {
        
        super(nombre);
    }
    
    public void run(){
        Random rand = new Random();
        int verRandom;
        for(int x=0;x<=10;x++){
            System.out.println(x+" : "+getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ejercicio_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        new Ejercicio_1 ("Pepe").start();
        new Ejercicio_1 ("Juan").start();
        System.out.println("Acaba main");
    }
    
}
