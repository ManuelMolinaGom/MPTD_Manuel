package unidad2.transporte;

import java.util.Scanner;

/** Ti301
 *   
 * @author Manuel Alejandro Gómez Molina
 */

public class TransporteCM {
    private int[][] costos;
    private int[] oferta;
    private int[] demanda;

    public TransporteCM(int[][] costos, int[] oferta, int[] demanda) {
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

    static int[] indices(int[][] costos) {
        int menor = Integer.MAX_VALUE;
        int[] pepe = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        for (int i = 0; i < costos.length; i++) {
            for (int j = 0; j < costos[i].length; j++) {
                if (costos[i][j] < menor) {
                    menor = costos[i][j];
                    pepe[0] = i;
                    pepe[1] = j;
                }
            }
        }
        return pepe;
    }

    public int[][] resolver() {
        int[][] matrizAsignacion = new int[oferta.length][demanda.length];
        int[][] costosTem = this.costos;
        

        while (true) {
            int[] indices = indices(costosTem);
            int i = indices[0], j = indices[1];
            
            if (i == Integer.MAX_VALUE || j == Integer.MAX_VALUE) {
                break;
            }

            // Asignación de oferta y demanda mínima posible
            if (oferta[i] < demanda[j]) {
                matrizAsignacion[i][j] = oferta[i];
                demanda[j] -= oferta[i];
                oferta[i] = 0;
            } else if (oferta[i] == demanda[j]) {
                matrizAsignacion[i][j] = oferta[i];
                oferta[i] = 0;
                demanda[j] = 0;
            } else {
                matrizAsignacion[i][j] = demanda[j];
                oferta[i] -= demanda[j];
                demanda[j] = 0;
            }

            costosTem[i][j] = Integer.MAX_VALUE;
        }

        return matrizAsignacion;
    }
}
