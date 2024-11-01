/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package unidad2.asignasion;

import java.util.ArrayList;

/** Ti301
 *   
 * @author Manuel Alejandro Gómez Molina
 */
public class PivoteoAsignacion {
    
 private int costos[][];
    
    public PivoteoAsignacion(int[][] matris) {
        this.costos = matris;
        
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

    



   public int[][] resolver() {
    LineasOptimas lineas = new LineasOptimas(costos);
    int[][] AsignacionTem = lineas.resolver();
    
    // Encontrar el valor mínimo en AsignacionTem
    int menor = Integer.MAX_VALUE;
    for (int[] fila : AsignacionTem) {
        for (int valor : fila) {
            if (valor < menor) {
                menor = valor;
            }
        }
    }

    // Restar el valor mínimo de cada elemento en AsignacionTem
    for (int i = 0; i < AsignacionTem.length; i++) {
        for (int j = 0; j < AsignacionTem[i].length; j++) {
            AsignacionTem[i][j] -= menor;
        }
    }

    // Crear una matriz para las intersecciones y sumar "menor" en posiciones bloqueadas
    boolean[] bloqueo_I = lineas.getBloqueo_I();
    boolean[] bloqueo_J = lineas.getBloqueo_J();
    int[][] intersecciones = new int[costos.length][costos[0].length];
    int coumna_menor=0;
    for (int i = 0; i < costos.length; i++) {
        if (bloqueo_I[i]) {
            for (int j = 0; j < costos[i].length; j++) {
                intersecciones[i][j] = bloqueo_J[j] ? menor : 0;
                coumna_menor=j;
            }
        }
    }

    // Sumar intersecciones a la matriz de costos original
    for (int i = 0; i < costos.length; i++) {
        for (int j = 0; j < costos[i].length; j++) {
            costos[i][j] += intersecciones[i][j];
        }
    }

     int c1=0,c2=0;
        for (int i = 0; i < costos.length; i++) {
            c2=0;
                for (int j = 0; j < costos[i].length; j++) {
                    if(bloqueo_I[i] ||bloqueo_J[j]){

                    
                     }else{
                        costos[i][j]=AsignacionTem[c1][c2];
                        c2++;
                        
                    }
                }
                if(c2!=0){
                    c1++;
                }
        }
      
        
        
        System.out.println(""+coumna_menor);
    
    

    return costos;
}

    
    
}