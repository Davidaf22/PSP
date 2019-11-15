package ejercicio1;

public class Ejercicio1 extends Thread {
    
    int numero;
    
    public Ejercicio1 (int numero){
        numero=this.numero;
    }

    public int getNumero() {
        return numero;
    }
    
    public void run (){
        
       int vueltas = this.getNumero();
        
        int x =1;
        int y =1;
        System.out.println(x);
        System.out.println(y);
        for (int i=0;i<vueltas;i++){
            int z = x+y;
            System.out.println(z);
            x = y;
            y=z;
        }
    }

    public static void main(String[] args) {
         new Ejercicio1(6).start();
    }
    
}
