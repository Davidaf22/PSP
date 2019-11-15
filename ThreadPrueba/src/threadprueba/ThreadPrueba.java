
package threadprueba;

public class ThreadPrueba extends Thread {

    public ThreadPrueba (String str){
        super(str);
    }
    
    public void run (){
        for (int i=0;i<10;i++){
            System.out.println(i+" "+getName());
        }
        System.out.println("Termina Thread "+getName());
       
    }
    public static void main(String[] args) {
        
        new ThreadPrueba("Pepe").start();
        new ThreadPrueba("Jose").start();
        System.out.println("Termina Thread Main");
    }
    
}
