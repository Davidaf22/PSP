/*
Programa en java que crea tres hilos y los ejecuta. Los hilos escriben 25 veces el número de iteración
del bucle y su nombre. En cada iteración, después de escribir su nombre, se bloquean durante un
tiempo aleatorio de segundos y después vuelven a estar disponibles para su ejecución. El programa
principal no terminará hasta que hayan terminado los tres hilos, escribiendo un mensaje que indique
que terminó.
 */
package Ejercicio1;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author David Alonso Fernández
 */
public class ejercicio1 extends Thread {
    //creamos constructor con un único parámetro que es nombre que cogemos de la clase superior o padre (Thread)
    public ejercicio1(String nombre){
        super(nombre);
    }
    
    //En el método run, hacemos al hilo recorrer un bucle que da 25 vueltas imprimiendo cada vez el nombre de el hilo y la vuelta en la que está
    @Override
    public void run() {
        
        for(int x=1;x<26;x++){
            int numero = (int) (Math.random() * 5000) + 1000;
            System.out.println(this.getName()+"-Interacion "+x);
            try {
                sleep(numero);
            } catch (InterruptedException ex) {
                Logger.getLogger(ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
    }
    //En el main instanciamos los 3 hilos que se vamos a usar, los ejeutamos con start y les aplicamos el metodo join para que antes de continuar con el codifo principal
    //acaben con sus ejecuciones.
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("Empieza Hilo Main");

        ejercicio1 hiloSecundario1 = new ejercicio1("hiloSecundario1");
        ejercicio1 hiloSecundario2 = new ejercicio1("hiloSecundario2");
        ejercicio1 hiloSecundario3 = new ejercicio1("hiloSecundario3");
            
        hiloSecundario1.start();
        hiloSecundario2.start();
        hiloSecundario3.start();
        
        hiloSecundario1.join();
        hiloSecundario2.join();
        hiloSecundario3.join();
        
        System.out.println("Termina Hilo Main"); 
        
    }    
}
