/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

public class ProductorConsumidor extends Thread {
    
    public  int pastelitos = 0;
    
    public ProductorConsumidor(String nombre){
        super(nombre);
    }
    
    public synchronized void comer() throws InterruptedException{   
        while(pastelitos==0){
          wait();
        }
        pastelitos--;
        sleep(1000);
        System.out.println("Pastelito comido");
        notify();
    }
    
    public synchronized void  hornear() throws InterruptedException{
        while(pastelitos!=0){
            wait();
        }
        pastelitos++;
        sleep(3000);
        System.out.println("Pastelito horneado");
        notify();
    }
    
    

    public static void main(String[] args) {
        
        ProductorConsumidor hiloPrincipal = new ProductorConsumidor("hiloPrincipal");
        Productor pastelero = new Productor("pastelero",hiloPrincipal);
        Consumidor gloton = new Consumidor("gloton",hiloPrincipal);
        pastelero.start();
        gloton.start();
        
        

     

    }
    
}
