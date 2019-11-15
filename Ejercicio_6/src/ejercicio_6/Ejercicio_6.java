/*
Simular a caixa dunha empresa con dous fíos. 
Un simulará o ingreso, ca compra deartigos por parte de clientes e ooutro a extracción de cartos da caixa co pago a proveedores. 
A conta teráun capital inicial. Realizar 10 ingresos e 5 extraccións.
 */
package ejercicio_6;

public class Ejercicio_6 extends Thread{
    
    public static int capital=0;
    
    public Ejercicio_6(String nombre){
        super(nombre);
    }
    
    public void run(){
        
        if (getName().equals("transacciones")){
            capital=1000;
            Ejercicio_6 ingresos = new Ejercicio_6 ("ingresos");
            Ejercicio_6 extracciones = new Ejercicio_6 ("extracciones");
            ingresos.start();
            extracciones.start();
        }
        
        else if (getName().equals("ingresos")){
            for(int x=0;x<10;x++){
            int random =  (int)(Math.random()*50);
            capital=capital+random;
            System.out.println("Se ha producido un ingreso de "+random+". El saldo actual es de :"+capital); 
            }
        }
        
         //else if (getName().equals("extracciones")){
        else {
            for(int x=0;x<5;x++){
            int random =  (int)(Math.random()*150);
            capital=capital-random;
                System.out.println("Se ha producido una extraccion de "+random+". El saldo actual es de :"+capital); 
            }
        
        }
    }
    public static void main(String[] args) {
        
        Ejercicio_6 transacciones = new Ejercicio_6 ("transacciones");

        transacciones.start();
    }
    
}
