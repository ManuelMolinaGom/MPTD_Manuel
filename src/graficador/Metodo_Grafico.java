package graficador;
/*
Autores: [Manuel Alejandro Gomez Molina], [Gallardo Jiménez Adrian Antonio]
Carrera: Ingeniería en Tics
*/
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Metodo_Grafico {
    private JPanel p;
    private int w;
    private int h;
    private int largo;

    public Metodo_Grafico(JPanel p, int escala) {
        this.p = p;
        this.largo = escala;
        w = p.getWidth();
        h = p.getHeight();  
    }

    public void dibujo() {
        Graphics2D g = (Graphics2D) p.getGraphics();
        g.clearRect(0, 0, w, h);
        g.setColor(Color.GRAY);

       
        for (int i = largo; i < h; i += largo) {
            g.drawLine(w / 2 + i, h, w / 2 + i, 0);
            g.drawLine(w / 2 - i, h, w / 2 - i, 0);
        }
        for (int i = largo; i < w; i += largo) {
            g.drawLine(0, h / 2 + i, w, h / 2 + i);
            g.drawLine(0, h / 2 - i, w, h / 2 - i);
        }

        
        g.setColor(Color.BLACK);
        g.drawLine(w / 2, 0, w / 2, h);
        g.drawLine(0, h / 2, w, h / 2);

      
        funcionLinea();
        funcionRellenar();

        g.dispose();
    }

    public void funcionLinea() {
        Graphics2D g = (Graphics2D) p.getGraphics();
        double y;

      
        g.setColor(Color.RED);
        for (double x1 = 0; x1 <= 20; x1 += 0.2) {
            double x2 = (120 - 3 * x1) / 2; // Resolviendo para x2
            if (x2 >= 0) {
                g.drawOval(w / 2 + (int)x1 - 3, h / 2 - (int)x2 - 3, 6, 6);
            }
        }

        
        g.setColor(Color.GREEN);
        for (double x2 = 0; x2 <= 30; x2 += 0.2) {
            double x1 = 20; // x1 es constante
            g.drawOval(w / 2 + (int)x1 - 3, h / 2 - (int)x2 - 3, 6, 6);
        }

        
        g.setColor(Color.BLUE);
        for (double x1 = 0; x1 <= 20; x1 += 0.2) {
            double x2 = 30; // x2 es constante
            g.drawOval(w / 2 + (int)x1 - 3, h / 2 - (int)x2 - 3, 6, 6);
        }
    }

    public void funcionRellenar() {
        Graphics2D g = (Graphics2D) p.getGraphics();
        double y;

        
        g.setColor(new Color(0, 55, 255, 55));

        
        java.awt.geom.Path2D.Double path = new java.awt.geom.Path2D.Double();

        
        path.moveTo(w / 2, h / 2); 

       
        for (double x1 = 0; x1 <= 20; x1 += 0.2) {
            double x2 = (120 - 3 * x1) / 2; 
            if (x2 >= 0) {
                path.lineTo(w / 2 + (int)x1, h / 2 - (int)x2);
            }
        }
        path.lineTo(w / 2 + 20, h / 2 - 30); 
        path.lineTo(w / 2, h / 2 - 30); 
        path.closePath(); 

       
        g.fill(path);
    }

    public static double funcion(double a) {
        return a;
    }
}
