package unidad1.proglineal;
/*
Autores: [Manuel Alejandro Gomez Molina], [Gallardo Jiménez Adrian Antonio]
Carrera: Ingeniería en Tics
*/
import java.util.Scanner;

public class Metodo_Simplex {
    static int contMayorIgual = 0, contMenorIgual = 0, contIgual = 0;
static mejoras m=new mejoras();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige la opcion:\n1. Maximizar\n2. Minimizar");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > 2) {
            System.out.println("Opcion no valida");
            System.exit(0);
        }

        boolean esMinimizar = (choice == 2);

        System.out.println("Ingresa el numero maximo de variables:");
        int maxVariables = scanner.nextInt();

        System.out.println("Ingresa el numero maximo de restricciones:");
        int restricciones = scanner.nextInt();

        double[] Z = new double[maxVariables + 2];
        double[][] X = new double[restricciones][maxVariables + 2];
        int[] operadores = new int[restricciones];

        if (esMinimizar) {
            Z[0] = -1;
        } else {
            Z[0] = 1;
        }

     
        for (int i = 1; i <= maxVariables; i++) {
            System.out.printf("Ingresa coeficiente Z para X[%d]: ", i);
            Z[i] = scanner.nextDouble();
        }

        Z[maxVariables + 1] = 0;
        double[] olirginal_z = Z.clone(); 

       
        for (int i = 0; i < restricciones; i++) {
            System.out.printf("Ingresa coeficientes para R[%d]:\n", i+1 );
            
            for (int j = 0; j < maxVariables; j++) {
                X[i][0] = 0.0;
                System.out.printf("Coeficiente R[%d] de X[%d]: ", i+1 , j+1 );
                X[i][j+1] = scanner.nextDouble();
            }
            System.out.println("Tipo de inecuación (1: <= , 2: >= , 3: = , 4: > , 5: <):");
            operadores[i] = scanner.nextInt();
            System.out.printf("Valor de la inecuación R[%d]: ", i+1 );
            X[i][maxVariables+1] = scanner.nextDouble();
        }
        
        boolean s1 = false, s2 = false, s3 = false, s4 = false;

        // Contar tipos de restricciones
        for (int i = 0; i < restricciones; i++) {
            if (operadores[i] == 1 || operadores[i] == 4) {
                contMenorIgual++;
            } else if (operadores[i] == 2 || operadores[i] == 5) {
                contMayorIgual++;
            } else if (operadores[i] == 3) {
                contIgual++;
            }
        }

        // Establecer condiciones según el tipo de restricciones
        if (contMenorIgual != 0) {
            s1 = true;
            s2 = true;
        } else if (contMayorIgual != 0) {
            s1 = true;
            s3 = true;
        } else if (contIgual != 0) {
            s1 = true;
            s4 = true;
        }

        // Inicializar variables base según las condiciones
        double[] xBase = new double[maxVariables];
        double[] sBase = new double[contMenorIgual];
        double[] cBase = new double[contMayorIgual];

        // Ejecutar Simplex según el tipo de problema (si tambien fuese el simples con la gran  peno asi que solo sirve el simplex 1)
        if (s1) {
            if (!s2 && !s3) {
                m.imprimirMatriz_P1(xBase);
                simplex1(X, Z, olirginal_z);/// solo sirve este pero de jame el coddigo por dsdi lo utilizo luego 
            } else if (s2) {
                imprimirMatriz_P2(xBase, sBase);
                simplex1(X, Z, olirginal_z);
            } else if (s3) {
                m.imprimirMatriz_P3(xBase, sBase, cBase);
                simplex1(X, Z, olirginal_z);
            } else {
                m.imprimirMatriz_Nega(xBase, cBase);
                simplex1(X, Z, olirginal_z);
            }
        } else {
            System.out.println("No se cumplen las condiciones para ejecutar el método simplex.");
        }
    }

   

    static void imprimirMatriz_P2(double[] X, double[] S) {
        System.out.printf("%10s | ", "R[N]");
    System.out.printf("%10s | ", "z"); 
    
    
    for (int i = 0; i < X.length; i++) {
        System.out.printf("%10s | ", "X[" + (i + 1) + "]"); 
    }
    
   
    for (int i = 0; i < S.length; i++) {
        System.out.printf("%10s | ", "S[" + (i + 1) + "]"); 
    }
    
    System.out.printf("%10s |%n", "="); 
    System.out.println("________________________________________________________________________________");
}
    // Método Simplex
    public static void simplex1(double[][] a, double[] b, double[] original_z) {
        int numRestricciones = a.length;
        int numVariables = a[0].length ;  
        double[][] x = new double[numRestricciones][numVariables + contMenorIgual];
        double[] z = new double[b.length + contMenorIgual];  // Copia de la función objetivo
        z[0]=1;
        // Inicializamos la función objetivo Z
        for (int j = 1; j < z.length; j++) {
            if (j < b.length - 1) {
                z[j] = -b[j];
            } else {
                z[j] = 0;
            }
        }
        
        // Inicializamos la matriz de restricciones 'x'
        int varOrguriaPocitiva = 0;
        for (int i = 0; i < x.length; i++) {
        if (i >= a.length) {
          // Manejar el caso donde no hay suficientes filas en 'a'
          break; // o lanzar una excepción o imprimir un mensaje
         }

         for (int j = 0; j < x[i].length; j++) {
              if (j < a[i].length - 1) {
                 x[i][j] = a[i][j]; // Copiamos los coeficientes de las restricciones
             } else {
             x[i][j] = 0;
               }
             }
                    if (numVariables + varOrguriaPocitiva < x[i].length) {
                         x[i][numVariables-1 + varOrguriaPocitiva] = 1;  // Añadimos la variable de holgura
                     }
         varOrguriaPocitiva++;
         x[i][x[0].length-1] = a[i][numVariables-1];  // Copiamos el término independiente
    
  }
       double Xvariables_sulucion[]=new double[x.length];
       for (int i = 0; i < Xvariables_sulucion.length; i++) {
    Xvariables_sulucion[i] = 0; // Inicializamos todas las filas como no usadas
}
       boolean fila_llausada[] = new boolean[x.length]; // No es necesario +1 ya que las filas van de 0 a x.length - 1
for (int i = 0; i < fila_llausada.length; i++) {
    fila_llausada[i] = false; // Inicializamos todas las filas como no usadas
}

boolean var = true;
while (var) {
    imprimirMatriz1(z);  // Imprimir la función objetivo
    imprimirMatriz2(x);

    // 1. Identificamos la columna pivote
    double minimo = 0;
    int indiceColumnaPivote = 0;

    for (int i = 0; i < z.length - 1; i++) {
        if (z[i] < minimo) {
            minimo = z[i];
            indiceColumnaPivote = i;
        }
    }
    System.out.println("indiceColumnaPivote:  "+indiceColumnaPivote);
    if (indiceColumnaPivote == 0) {
        System.out.println("Solución óptima no existe alcanzada.");
        System.exit(0);
    }

    // 2. Identificamos la fila pivote
    
 double mini1 = 0.000;
 double mini2 = 999999999;
int indiceFilaPivote = -1;

for (int i = 0; i < x.length; i++) { // Empezamos desde 0, no 1, para evaluar todas las filas
    if (!fila_llausada[i] && x[i][indiceColumnaPivote] > 0) { // Nos aseguramos de que el divisor no sea cero y que la fila no esté usada
        mini1 = x[i][x[0].length - 1] / x[i][indiceColumnaPivote];
        System.out.println( x[i][x[0].length - 1]+"/"+ x[i][indiceColumnaPivote]);
        
        if (mini2 > mini1) { // Si encontramos un cociente menor, lo actualizamos
            mini2 = mini1;
            indiceFilaPivote = i;
        }
    }
}

    System.out.println("ra:"+ mini2+"         indice:"+indiceFilaPivote);

    if (indiceFilaPivote == -1) {
        System.out.println("Solución no acotada.");
        break;
    } else {
        System.out.println("Fila con la razón mínima: " + indiceFilaPivote);
    }

    // Marcamos la fila pivote como usada
    fila_llausada[indiceFilaPivote] = true;
    
double artasgo=x[indiceFilaPivote][indiceColumnaPivote];
    // Normalizamos la fila pivote
    for (int j = 0; j <= x[indiceFilaPivote].length-1; j++) {
 if (x[indiceFilaPivote][j] > 0) {
           x[indiceFilaPivote][j] = x[indiceFilaPivote][j] / artasgo;
        System.out.println("   dento del if:"+x[indiceFilaPivote][j]);  
    }
    }
   
    // Actualizar las otras filas
for (int i = 0; i < x.length; i++) {
    if (i != indiceFilaPivote) {
        for (int j = 0; j < x[0].length; j++) {
            x[i][j] -= (x[i][indiceColumnaPivote] * x[indiceFilaPivote][j]);
        }
    }
}

artasgo=z[indiceColumnaPivote];
    // Actualizar la función objetivo
    for (int j = 0; j < z.length; j++) {
        z[j] = z[j] - (artasgo * x[indiceFilaPivote][j]);
    }

    // Verificar si se ha alcanzado la solución óptima
    // Verificar la fila Z para condiciones de terminación
boolean hayNegativos = false;
for (int j = 1; j < z.length; j++) {
    if (z[j] < 0) {
        hayNegativos = true;
        break;
    }
}

if (!hayNegativos) {
    var = false; // Se ha alcanzado la solución óptima
}

Xvariables_sulucion[indiceFilaPivote]=x[indiceFilaPivote][x[0].length-1];
    System.out.println("a1: "+Xvariables_sulucion[indiceFilaPivote]+"a2: "+x[indiceFilaPivote][x[0].length-1]);
    imprimirMatriz1(z);
    imprimirMatriz2(x);
}

System.out.println("Tabla actualizada:");
imprimirMatriz1(z);
imprimirMatriz2(x);
System.out.println("Solución optima alcanzada.");

double suma = 0;
for (int j = 0; j < Xvariables_sulucion.length ; j++) {
    suma += original_z[j+1] * Xvariables_sulucion[j];  // j+1 para alinearlo correctamente
    System.out.println(original_z[j+1]+" * "+Xvariables_sulucion[j]);
}
System.out.println("Solucion: " + suma + " es igual a Z: " + z[z.length - 1]);

    }
 
        
    

    // Métodos para imprimir matrices
   static void imprimirMatriz1(double[] a) {
     System.out.printf("%10s | ", "R[0]");
     for (double v : a) {
        System.out.printf("%10.2f | ", v); 
    }
    System.out.println();
}

static void imprimirMatriz2(double[][] a) {
    int i=1;
    for (double[] row : a) {
         System.out.printf("%10s | ", "R["+i+"]");
         i++;
        for (double v : row) {
            System.out.printf("%10.2f | ", v); 
        }
        System.out.println();
    }
    System.out.println("________________________________________________________________________________");
}

}
