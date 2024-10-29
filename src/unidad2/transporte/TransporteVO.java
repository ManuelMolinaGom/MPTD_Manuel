/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package unidad2.transporte;
import java.util.*;
/** Ti301
 *   
 * @author Manuel Alejandro Gómez Molina
 */
public class TransporteVO {

    private int[][] costos;
    private int[] oferta;
    private int[] demanda;

    public TransporteVO(int[][] costos, int[] oferta, int[] demanda) {
        this.costos = costos;
        this.oferta = oferta;
        this.demanda = demanda;
    }

    private int[] ing_ma(int[] a) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingresa un número entero: ");
                scanner.next();
            }
            a[i] = scanner.nextInt();
        }
        return a;
    }

    private int[][] ing_ma(int[][] a) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Por favor, ingresa un número entero: ");
                    scanner.next();
                }
                a[i][j] = scanner.nextInt();
            }
        }
        return a;
    }

    void im_ma(int[][] a) {
        System.out.println("_________________________________________________________");
        for (int[] row : a) {
            for (int cell : row) {
                System.out.print(String.format("%-13d| ", cell));
            }
            System.out.println();
        }
        System.out.println("_________________________________________________________");
    }

    private void im_ma(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    private int calcularPenalizacion(int[][] costos, int row, int col) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        // Encontrar los dos menores costos en la fila
        for (int j = 0; j < costos[row].length; j++) {
            if (costos[row][j] < min1) {
                min2 = min1;
                min1 = costos[row][j];
            } else if (costos[row][j] < min2) {
                min2 = costos[row][j];
            }
        }

        // Encontrar los dos menores costos en la columna
        for (int i = 0; i < costos.length; i++) {
            if (costos[i][col] < min1) {
                min2 = min1;
                min1 = costos[i][col];
            } else if (costos[i][col] < min2) {
                min2 = costos[i][col];
            }
        }

        return min2 - min1;
    }

    public int[][] resolver() {
        int[][] matrizAsignacion = new int[oferta.length][demanda.length];
        boolean[] filaSeleccionada = new boolean[oferta.length];
        boolean[] colSeleccionada = new boolean[demanda.length];

        while (true) {
            int maxPenalizacion = Integer.MIN_VALUE;
            int filaElegida = -1;
            int colElegida = -1;

            // Calcular penalizaciones y seleccionar la mayor
            for (int i = 0; i < costos.length; i++) {
                if (!filaSeleccionada[i]) {
                    for (int j = 0; j < costos[i].length; j++) {
                        if (!colSeleccionada[j]) {
                            int penalizacion = calcularPenalizacion(costos, i, j);
                            if (penalizacion > maxPenalizacion) {
                                maxPenalizacion = penalizacion;
                                filaElegida = i;
                                colElegida = j;
                            }
                        }
                    }
                }
            }

            if (filaElegida == -1 || colElegida == -1) {
                break; // No hay más celdas seleccionables
            }

            // Asignación de oferta y demanda mínima posible
            if (oferta[filaElegida] < demanda[colElegida]) {
                matrizAsignacion[filaElegida][colElegida] = oferta[filaElegida];
                demanda[colElegida] -= oferta[filaElegida];
                oferta[filaElegida] = 0;
            } else if (oferta[filaElegida] == demanda[colElegida]) {
                matrizAsignacion[filaElegida][colElegida] = oferta[filaElegida];
                oferta[filaElegida] = 0;
                demanda[colElegida] = 0;
            } else {
                matrizAsignacion[filaElegida][colElegida] = demanda[colElegida];
                oferta[filaElegida] -= demanda[colElegida];
                demanda[colElegida] = 0;
            }

            // Marcar la fila o columna como seleccionada
            if (oferta[filaElegida] == 0) {
                filaSeleccionada[filaElegida] = true;
            }
            if (demanda[colElegida] == 0) {
                colSeleccionada[colElegida] = true;
            }
        }

        return matrizAsignacion;
    }
}


