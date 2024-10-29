package unidad2.transporte;

/** Ti301
 *   
 * @author Manuel Alejandro Gómez Molina
 */

public class TransporteCMTest {
    public static void main(String[] args) {
        // Definir la matriz de costos, oferta y demanda como en la entrada de la imagen
        int[][] costos = {
           
            {2, 3, 5, 6}, // Segunda fila de la oferta
            {2, 1, 3, 5}, // Tercera fila de la oferta
            {3, 8, 4, 6}  // Cuarta fila de la oferta
        };

        // Cambiar la oferta y demanda según los nuevos datos
        int[] oferta = {5, 10, 15}; // Ofertas
        int[] demanda = {12, 8, 4, 6}; // Demandas

        // Crear una instancia de TransporteCM
        TransporteCM transporte = new TransporteCM(costos, oferta, demanda);

        // Resolver el problema de transporte
        int[][] resultado = transporte.resolver();

        // Imprimir la salida esperada en formato similar a la imagen
        System.out.println("Salida:");
        transporte.im_ma(resultado);
    }
}
