package unidad2.asignasion;

import java.util.ArrayList;

public class LineasOptimas {
    private int costos[][];
    private boolean[] bloqueo_I;
    private boolean[] bloqueo_J;
    private int []Matriz_J;
    private int []Matriz_I;
       private boolean [] []Matriz_0;
    public LineasOptimas(int[][] matris) {
        this.costos = matris;
        this.bloqueo_I = new boolean[matris.length];
        this.bloqueo_J = new boolean[matris[0].length];
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

    public boolean[] getBloqueo_I() {
        return bloqueo_I;
    }

    public boolean[] getBloqueo_J() {
        return bloqueo_J;
    }

    void imprimirMatriz(boolean[][] a) {
        System.out.println("_________________________________________________________");
        for (boolean[] row : a) {
            for (boolean cell : row) {
                System.out.print(String.format("%-13s| ", cell));
            }
            System.out.println();
        }
        System.out.println("_________________________________________________________");
    }
     void bloquearMaxCeros(int[] Matriz_I, int[] Matriz_J,boolean[][] Matriz_0) {
    int maximosCeros = -1;
    int indice_i = -1;
    int indice_j = -1;
    boolean bloqueo_estandar = true;
    
    
    for (int i = 0; i < Matriz_0.length; i++) {
    for(int j = 0; j < Matriz_0[0].length; j++){
        
      if(Matriz_0[i][j]==true){
    
        if (!bloqueo_I[i] && Matriz_I[i] > maximosCeros) {
            maximosCeros = Matriz_I[i];
            indice_i = i;
            indice_j = j;
            bloqueo_estandar = true;
        }
      }
    }
    }
    for (int i = 0; i < Matriz_0.length; i++) {
    for(int j = 0; j < Matriz_0[0].length; j++){
        
    if(Matriz_0[i][j]==true){
    
        if (!bloqueo_J[j] && Matriz_J[j] > maximosCeros) {
            maximosCeros = Matriz_J[j];
             indice_i = i;
             indice_j = j;
            bloqueo_estandar = false;
        }
    }
    }
    }
    

    
    if (indice_i != -1 &&bloqueo_estandar) {
        bloqueo_I[indice_i] = true;
        this.Matriz_I[indice_i]=0;
        for(int j = 0; j < Matriz_0.length; j++){//intento de restar -1 a Matriz_J
            Matriz_0[indice_i][j]=false;
        }
       
    } else if (indice_j != -1) {
        bloqueo_J[indice_j] = true;
        this.Matriz_J[indice_j]=0;
        for(int j = 0; j < Matriz_J.length; j++){//intento de restar -1 a Matriz_I
            Matriz_0[j][indice_j]=false;
        }
       
    }
}



    public int[][] resolver() {
        int[][] asignacion = this.costos;
        Matriz_I = new int[asignacion.length];
       Matriz_J = new int[asignacion[0].length];
       Matriz_0=new boolean[asignacion.length][asignacion[0].length];
        // Contar ceros en cada fila y columna
        for (int i = 0; i < asignacion.length; i++) {
            for (int j = 0; j < asignacion[i].length; j++) {
                if (asignacion[i][j] == 0) {
                    Matriz_I[i] += 1;
                    Matriz_J[j] += 1;
                    
                    Matriz_0[i][j]=true;
                }
            }
        }

        boolean existenCerosNoBloqueados = true;

        // Bucle para bloquear filas y columnas hasta que no queden ceros no bloqueados
        while (existenCerosNoBloqueados) {
            bloquearMaxCeros(Matriz_I, Matriz_J,Matriz_0);

            // Comprobar si quedan ceros no bloqueados
            existenCerosNoBloqueados = false;
            for (int i = 0; i < asignacion.length; i++) {
                for (int j = 0; j < asignacion[i].length; j++) {
                    if (asignacion[i][j] == 0 && bloqueo_I[i] == false && bloqueo_J[j] == false) {
                        existenCerosNoBloqueados = true;
                        break;
                    }
                }
                if (existenCerosNoBloqueados) break;
            }
        }

int tamR_I=0,tamR_J=0;
        // Imprimir filas y columnas bloqueadas
        
        System.out.print("F:  ");
        for (int i = 0; i < bloqueo_I.length; i++) {
            if (bloqueo_I[i] == true) {
                System.out.print( i+"   ");
               
                tamR_I++;
            }
        }
        
        
        System.out.println("");
        System.out.print("C:  ");
        for (int j = 0; j < bloqueo_J.length; j++) {
            if (bloqueo_J[j] == true) {
                System.out.print(j+"   ");
                
                tamR_J++;
            }
        }
        
        int [][]asignacion_2=new int[asignacion.length-tamR_I][asignacion[0].length-tamR_J];
        
       int c1=0,c2=0;
        for (int i = 0; i < asignacion.length; i++) {
            c2=0;
                for (int j = 0; j < asignacion[i].length; j++) {
                    if(bloqueo_I[i] ||bloqueo_J[j]){

                    
                     }else{
                        asignacion_2[c1][c2]=asignacion[i][j];
                        c2++;
                        
                    }
                }
                if(c2!=0){
                    c1++;
                }
        }
        
        
        return asignacion_2;
    }
    
    
    
    
    
    
    
    
}