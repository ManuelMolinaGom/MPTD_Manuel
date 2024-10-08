package araujo_ac2;
import java.util.*;

public class p2 {
    
    public static void main(String[] args) {
        Scanner tel = new Scanner(System.in);   
        Stack<String> Pi_1 = new Stack<>();
        
        System.out.println("Escribe el numero de datos que vas a ingresar:");
        String input = tel.nextLine();
        
        if (esNumeroEntero(input)) {
            int numDatos = Integer.parseInt(input);
            String[] a = new String[numDatos]; 
            
            System.out.println("Ingresa los datos:");
            for (int i = 0; i < numDatos; i++) {
                System.out.print(i+1+".- ");
                a[i] = tel.nextLine(); 
               Pi_1.push(a[i]); 
            }
            for (int i = a.length - 1; i >= 0; i--) {
            //    Pi_1.push(a[i]); 
            }
            System.out.println("Datos ingresados en la pila:");
            pilaimpr(Pi_1);
            System.out.println("Datos ingresados en el arreglo:");
            aimpr(a);
        } else {
            System.out.println("La entrada no es un número entero válido.");
        }
    }

    static void pilaimpr(Stack<String> pila) {
        while (!pila.isEmpty()) {
            System.out.println(pila.pop()); 
        }
    }

    static void aimpr(String[] arreglo) {
        for (String dato : arreglo) {
            System.out.println(dato);
        }
    }

    static boolean esNumeroEntero(String input) {
        return input.matches("\\d+");
    }
}
