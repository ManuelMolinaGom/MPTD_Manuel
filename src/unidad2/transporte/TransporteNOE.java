/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package unidad2.transporte;

import java.util.Scanner;

/** Ti301
 *   
 * @author Manuel Alejandro Gómez Molina
 */
public class TransporteNOE {
   private int[][] costos;
   private int[] oferta;      
     private   int[] demanda;
    private int nOferta;
            private int nDemanda;
     
   void aser() {
        Scanner scanner = new Scanner(System.in);
       
         nOferta = scanner.nextInt();
        
         nDemanda = scanner.nextInt();
        
        costos = new int[nOferta][nDemanda];  
        oferta = new int[nOferta];       
        demanda = new int[nDemanda];   
    }
   
   private  int[] ing_ma(int[]a) {
        Scanner scanner = new Scanner(System.in);
        int[] matriz = a;
        
        
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            matriz[i] = scanner.nextInt();
        }
        
        return matriz;
     }
    private int[][] ing_ma(int[][]a) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = a;
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
        
        return matriz;
     }
 
    void im_ma(int[][] a){
        int [][]asignacion=a;
        System.out.println("_________________________________________________________");
         for (int i = 0; i < asignacion.length; i++) {
            for (int j = 0; j < asignacion[i].length; j++) {
                System.out.print(asignacion[i][j] +"       |   "+ "\t");
            }
            System.out.println();
        }
         System.out.println("_________________________________________________________");
     }
    private void im_ma(int []a){
        int []asignacion=a;
         for (int i = 0; i < asignacion.length; i++) {
                System.out.print(asignacion[i] + "\t");
            System.out.println();
        }
     }
  int[][] ReNOE(int[] oferta, int[] demanda) {
    int[][] asignacion = new int[oferta.length][demanda.length];

    for (int i = 0; i < oferta.length; i++) {
        for (int j = 0; j < demanda.length; j++) {
            // Si la oferta es menor que la demanda
            if (oferta[i] < demanda[j]) {
                asignacion[i][j] = oferta[i];
                demanda[j] -= oferta[i];
                oferta[i] = 0;
            }
            // Si la oferta es igual a la demanda
            else if (oferta[i] == demanda[j]) {
                asignacion[i][j] = oferta[i];
                oferta[i] = 0;
                demanda[j] = 0;
            }
            // Si la oferta es mayor que la demanda
            else {
                asignacion[i][j] = demanda[j];
                oferta[i] -= demanda[j];
                demanda[j] = 0;
            }

            // Salir del bucle interno si la oferta actual se ha agotado
            if (oferta[i] == 0) {
                break;
            }
        }
        TransporteNOE noe=new TransporteNOE();
        noe.im_ma(asignacion);
        
    }

    return asignacion;
}


    
}
