/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package unidad2.transporte;

/** Ti301
 *   
 * @author Manuel Alejandro Gómez Molina
 */
public class TrasporteNOTest {
   public static void main(String[] args) {
        TransporteNOE noe = new TransporteNOE();
        int oferta[]={5     ,    1     ,    3    };
        int demanda[]={2     ,   4    ,     2    ,    1};
        
        

        int[][] asignacion = noe.ReNOE(oferta, demanda);

       
        noe.im_ma(asignacion);
    }

   

}
