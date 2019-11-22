package ejercicio3;

public class ejercicio3Main extends Thread {
    
    int mayusculas;
    int minusculas;
    int numeros;
    
    public ejercicio3Main(String nombre){
        super(nombre);
    }
    
    public synchronized void sumarMayus() throws InterruptedException{   
        mayusculas++;
        System.out.println("Suma mayuscula, total : "+mayusculas);
        System.out.println("Suma minuscula, total : "+minusculas);
        System.out.println("Suma minuscula, total : "+numeros);
        System.out.println("");
        
    }
    public synchronized void sumarMinus() throws InterruptedException{   
        minusculas++;
        System.out.println("Suma mayuscula, total : "+mayusculas);
        System.out.println("Suma minuscula, total : "+minusculas);
        System.out.println("Suma minuscula, total : "+numeros);
        System.out.println("");
    }
    public synchronized void sumarNum() throws InterruptedException{   
        numeros++;
        System.out.println("Suma mayuscula, total : "+mayusculas);
        System.out.println("Suma minuscula, total : "+minusculas);
        System.out.println("Suma minuscula, total : "+numeros);
        System.out.println("");
    } 
    
    public static void main(String[] args) {
        
        String linea = "Esta7 es una4 frase4 de6 prueba7";
        
        ejercicio3Main hiloPrincipal = new ejercicio3Main("hiloPrincipal");
        mayusculas hiloMayus = new mayusculas("hiloMayus",hiloPrincipal,linea);
        minusculas hiloMinus = new minusculas("hiloMinus",hiloPrincipal,linea);
        numeros hiloNum = new numeros("hiloNum",hiloPrincipal,linea);
        
        hiloMayus.start();
        hiloMinus.start();
        hiloNum.start();
    }
}
