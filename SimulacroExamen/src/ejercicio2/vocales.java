package ejercicio2;

public class vocales extends Thread {
    
    public String linea;
    public int contador;
    
    public vocales(String nombre,String linea){
        super(nombre);
        this.linea=linea;
        contador=0;
    }
    
    @Override
    public void run() {
        
        String[] parts = linea.split("");
        for(int x=0;x<parts.length;x++){
            if(parts[x].equals("a") || parts[x].equals("e") || parts[x].equals("i") || parts[x].equals("o") || parts[x].equals("u")){
                contador++;
                System.out.println("vocales: "+contador);
            }
        }  
    }
    public int getContador() {
        return contador;
    }
    
}
