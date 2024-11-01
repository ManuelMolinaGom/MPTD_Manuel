package unidad2.asignasion;

import java.util.Arrays;

public class MatrizReducida {
    private int[][] costos;
    
    

    public MatrizReducida(int[][] costos) {
        this.costos = costos;
        
    }

    void imprimirMatriz(int[][] a) {
        System.out.println("_________________________________________________________");
        for (int[] row : a) {
            for (int cell : row) {
                System.out.print(String.format("%-13d| ", cell));
            }
            System.out.println();
        }
        System.out.println("_________________________________________________________");
    }
static int indice(int[] costoMinimo) {
        int menor = Integer.MAX_VALUE;
        int indice = 0;

        for (int i = 0; i < costoMinimo.length; i++) {
            
                if (costoMinimo[i] < menor) {
                    menor = costoMinimo[i];
                    indice = i;
                    
                }
            
        }
        return indice;
    } 
static int indice2(int[][] costo,int a) {
        int menor = Integer.MAX_VALUE;
        int indice = 0;
int[] costoMinimo=new int[costo.length];
    for (int i = 0; i < costo.length; i++) {
        costoMinimo[i]=costo[i][a];
    }
        for (int i = 0; i < costoMinimo.length; i++) {
            
                if (costoMinimo[i] < menor) {
                    menor = costoMinimo[i];
                    indice = i;
                    
                }
            
        }
        return indice;
    }
    public int[][] resolver() {
       int [][]asignacion=this.costos;
       int costo=0;
        for(int i=0;i<asignacion.length;i++){
            costo=asignacion[i][indice(asignacion[i])];
            
            for(int j=0;j<asignacion[i].length;j++){
               asignacion[i][j]-=costo; 
            }
        }
        
        for (int i = 0; i < asignacion[0].length; i++) {
           costo= asignacion[indice2(asignacion,i)][i];
            for (int j = 0; j < asignacion.length; j++) {
                asignacion[j][i]-=costo; 
            }
     }
        
        
       return asignacion;
}
}