/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioficheros;

/**
 *
 * @author dam2
 */
public class EjercicioFicheros extends Thread {

    public EjercicioFicheros(String nombre){
        super(nombre);
    }
    
    
    
    public static void main(String[] args) {

        EjercicioFicheros hiloQuijote = new EjercicioFicheros ("hiloQuijote");
        EjercicioFicheros hiloSheckpire = new EjercicioFicheros ("hiloSheckpire");

        
    }
    
}
