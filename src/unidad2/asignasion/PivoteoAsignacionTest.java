/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package unidad2.asignasion;

/** Ti301
 *   
 * @author Manuel Alejandro Gómez Molina
 */
public class PivoteoAsignacionTest {

    public static void main(String[] args) {
        int[][] costos = {
            {9, 0, 3, 0},
            {0, 10, 4, 1},
            {4, 5, 0, 4},
            {0, 2, 4, 6}
        };

        PivoteoAsignacion transporte = new PivoteoAsignacion(costos);
        int[][] resultado = transporte.resolver();

        System.out.println("");
        System.out.println("Salida:");
        transporte.imprimirMatriz(resultado);
        
        
        
    }
}

