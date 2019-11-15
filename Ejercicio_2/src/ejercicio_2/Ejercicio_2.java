/*
Programa en Java que cree dous fíos e os executa. Os fíos escriben dez veces un número de iteración do bucle eseu nome. En cada iteración, despois de 
escribir o seu nome, se bloquean durante un tempo aleatorio de segundos e después volven a estar dispoñibles para a súa execución.
 */
package ejercicio_2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_2 extends Thread {
    
    String nombre;
    
    public Ejercicio_2 (String nombre) {
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
                Logger.getLogger(Ejercicio_2.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Acabo thread : "+getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Ejercicio_2 juan = new Ejercicio_2 ("Juan");
        juan.start();
        juan.join();
        
        Ejercicio_2 pepe = new Ejercicio_2 ("Pepe");
        pepe.start();
        pepe.join();
        
        //new Ejercicio_2 ("Pepe").start();
        //new Ejercicio_2 ("Juan").start();
        System.out.println("Acaba main");
    }
    
}
