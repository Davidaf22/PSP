/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioaccesovariable;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2
 */
public class EjercicioAccesoVariable extends Thread  {    
    
    public static Integer contador=0;
    
    public EjercicioAccesoVariable (String nombre) {
        super(nombre);
    }
     public void run(){
            synchronized(contador){
            contador++;
            contador++;
            contador++;
            }  
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(EjercicioAccesoVariable.class.getName()).log(Level.SEVERE, null, ex);
        }         
     }
    public static void main(String[] args) throws InterruptedException {
        EjercicioAccesoVariable hilo1 = new EjercicioAccesoVariable ("hilo1");
        EjercicioAccesoVariable hilo2 = new EjercicioAccesoVariable ("hilo2");
        EjercicioAccesoVariable hilo3 = new EjercicioAccesoVariable ("hilo3");
        EjercicioAccesoVariable hilo4 = new EjercicioAccesoVariable ("hilo4");
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        
        hilo1.join();
        hilo2.join();
        hilo3.join();
        hilo4.join();
        
        System.out.println(contador);
    }
    
}
