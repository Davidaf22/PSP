/*
Modifica el programa del ejercicio 1 para que después de cada iteración, después de escribir su
nombre, dejen paso al otro hilo. Para resolver este programa, solo puede existir el programa principal
y un único código para los hilos (el programa principal crea un único hilo y el resto son creados
recurrentemente en el código del hilo).
 */
package Ejercicio3;

import static java.lang.Thread.sleep;
import static java.lang.Thread.yield;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author David Alonso Fernández
 */
public class ejercicio3 extends Thread {
    
    public static int contador=0;
    
    public ejercicio3(String nombre){
        super(nombre);
    }
    
    @Override
    public void run() {
        
        if(contador==0){
            contador=1;
            ejercicio3 hiloSecundario1 = new ejercicio3("hiloSecundario1");
            ejercicio3 hiloSecundario2 = new ejercicio3("hiloSecundario2");
            
            hiloSecundario1.start();
            hiloSecundario2.start();
        }
        
        for(int x=1;x<26;x++){
            int numero = (int) (Math.random() * 5000) + 1000;
            System.out.println(this.getName()+"-Interacion "+x);
            try {
                sleep(numero);
            } catch (InterruptedException ex) {
                Logger.getLogger(ejercicio3.class.getName()).log(Level.SEVERE, null, ex);
            }
            yield();
        }       
    }
    
    public static void main(String[] args) throws InterruptedException {
        ejercicio3 hiloPrincipal = new ejercicio3("hiloPrincipal");
        hiloPrincipal.start();
    }
    
}
