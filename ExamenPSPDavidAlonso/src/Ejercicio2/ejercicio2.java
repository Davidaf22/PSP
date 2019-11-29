/*
Modifica el programa del ejercicio 1 para que los hilos se comporten de forma secuencial inverso,
(espera a que el tercer hilo acabe para que se ejecute el segundo y a su vez, que el segundo acabe
para que se ejecute el primero) y termina por último el programa principal escribiendo un mensaje que
indique que terminó. (2 punto)
 */
package Ejercicio2;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author David Alonso Fernández
 */
public class ejercicio2 extends Thread {
    //creamos constructor con un único parámetro que es nombre que cogemos de la clase superior o padre (Thread)
    public ejercicio2(String nombre){
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
                Logger.getLogger(ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
    }
    //En el main instanciamos los 3 hilos que se vamos a usar, los ejeutamos con start y les aplicamos el metodo join para que antes de continuar con el codifo principal
    //acaben con sus ejecuciones.
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("Empieza Hilo Main");

        ejercicio2 hiloSecundario1 = new ejercicio2("hiloSecundario1");
        ejercicio2 hiloSecundario2 = new ejercicio2("hiloSecundario2");
        ejercicio2 hiloSecundario3 = new ejercicio2("hiloSecundario3");
            
        hiloSecundario3.start();
        hiloSecundario3.join();
        
        hiloSecundario2.start();
        hiloSecundario2.join();
        
        hiloSecundario1.start();
        hiloSecundario1.join();
        
        
        
        System.out.println("Termina Hilo Main"); 
        
    }    
}
