package unidad2.asignasion;

public class MatrizReducidaTest {
    
    public static void main(String[] args) {
        int[][] costos = {
            {14, 5, 8, 7},
            {2, 12, 6, 5},
            {7, 8, 3, 9},
            {2, 4, 6, 10}
        };

        MatrizReducida transporte = new MatrizReducida(costos);
        int[][] resultado = transporte.resolver();

        System.out.println("Salida:");
        transporte.imprimirMatriz(resultado);
    }
}
