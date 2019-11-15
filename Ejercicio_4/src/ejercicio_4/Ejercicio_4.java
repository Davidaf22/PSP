/*
Realiza un programa en java que execute tres fíosde forma concurrente. Un de eles debe sumar os números pares del 1 ao1000, outro os impares, eoutro, os que terminen en dous 
ou en tres.
 */
package ejercicio_4;

public class Ejercicio_4 extends Thread {
      
    public Ejercicio_4(String nombre){
        super(nombre);
    }
    
    public void run(){
        int contPares=0;
        int contInpares=0;
        int contTermin=0;
        if ("pares".equals(getName())){
            for(int x=0;x<1000;x++){
              if(x%2==0){
                    contPares=contPares+x;
                    System.out.println("Hilo de pares: "+x+"  Suma total:"+contPares);
              }  
            }   
        }
        
        else if ("impares".equals(getName())){
            for(int x=0;x<1000;x++){
                if(x%2!=0){
                    contInpares=contInpares+x;
                    System.out.println("Hilo de impares: "+x+"  Suma total:"+contInpares);
                }  
            }
        }
        
        else{
            for(int x=0;x<1000;x++){
                String palabras = Integer.toString(x);
                String[] cadena=palabras.split("");
                if(cadena[cadena.length-1].equals("2")|| cadena[cadena.length-1].equals("3")){
                    contTermin=contTermin+x;
                    System.out.println("Hilo de doses y treses: "+x+"  Suma total:"+contTermin);
                }
            }
        }
        
    }

    public static void main(String[] args) {
        
        Ejercicio_4 pares = new Ejercicio_4 ("pares");
        Ejercicio_4 impares = new Ejercicio_4 ("impares");
        Ejercicio_4 terminados = new Ejercicio_4 ("terminados");
        pares.start();
        impares.start();
        terminados.start();
    }
    
}
