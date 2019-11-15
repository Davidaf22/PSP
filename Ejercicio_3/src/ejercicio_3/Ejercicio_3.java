/*
Realizar un programa que cree un fío, que a súa vez cree outro fío, easí consecutivamente, 
ataun total de cinco fíos. Cada fíodebe presentar o seu nome indicando que comenzou, crear o seu fío fillo epresentar o seu nome
10 veces indicando que se está procesando, esperando un tempo aleatorio entre 100 e 600 milisegundos entre cada presentación. 
Cada fíodeberá esperar a que o seu fillotermine antes de presentar o seu último mensaxe indicando o seu nome e que rematou.
 */
package ejercicio_3;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_3 extends Thread {
    
      String nombre;
    
    public Ejercicio_3 (String nombre) {
        
        super(nombre);
    }
    
    public void run(){
        ArrayList<String> array = new ArrayList<String>();
        array.add(getName());
        array.add("Conchita");
        array.add("Fran");
        array.add("David");
        array.add("Javi");
        
        
        for(int x=(array.size()-1);x>0;x--){
            String nombrecillo = array.get(x);
            Ejercicio_3 hilo = new Ejercicio_3 (nombrecillo);
            System.out.println("Hola, comienza el hilo "+nombrecillo);
            for(int k=0;k<=10;k++){
                System.out.println(k+" : "+hilo.getName());
                try {
                    hilo.sleep(600);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ejercicio_3.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
            System.out.println(nombrecillo);
            hilo.start();
            try {
                hilo.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Ejercicio_3.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Acabo thread : "+getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        
        Ejercicio_3 juan = new Ejercicio_3 ("Juan");
        juan.start();
        juan.join();
        System.out.println("Acabo todo");
    }
    
}
