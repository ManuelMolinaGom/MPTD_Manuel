/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package unidad2.transporte;

/** Ti301
 *   
 * @author Manuel Alejandro Gómez Molina
 */
public class TransporteVOTets {
    
    public static void main(String[] args) {
        // Definir la matriz de costos, oferta y demanda como en la entrada de la imagen
        int[][] costos = {
           
            {6, 7, 8}, // Segunda fila de la oferta
            {15, 80 ,78} // Tercera fila de la oferta
             // Cuarta fila de la oferta
        };

        // Cambiar la oferta y demanda según los nuevos datos
        int[] oferta = {10 ,15}; // Ofertas
        int[] demanda = {15, 5, 5}; // Demandas

        // Crear una instancia de TransporteCM
        TransporteVO transporte = new TransporteVO(costos, oferta, demanda);

        // Resolver el problema de transporte
        int[][] resultado = transporte.resolver();

        // Imprimir la salida esperada en formato similar a la imagen
        System.out.println("Salida:");
        transporte.im_ma(resultado);
   }
}
