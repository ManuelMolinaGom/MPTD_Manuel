/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad1.proglineal;

/**
 *
 * @author IK
 */
public class mejoras {
    static void simplex2(double[][] x, double[] z , double[] olirginal_z) {
     

       
        
    }
static void simplex3(double[][] x, double[] z , double[] olirginal_z) {
     

       
        
    }
 static void simplexNega(double[][] x, double[] z , double[] olirginal_z) {
     

       
        
    }   
 
 // Métodos para imprimir las matrices
    static void imprimirMatriz_P1(double[] X) {
        System.out.print("z     |  ");
        for (int i = 0; i < X.length; i++) {
            System.out.printf("X[%d] |  ", i + 1);
        }
        System.out.println();
        System.out.println("________________________________________________________________________________");
    }

    static void imprimirMatriz_P2(double[] X, double[] S) {
        System.out.print("z     |  ");
        for (int i = 0; i < X.length; i++) {
            System.out.printf("X[%d] |  ", i + 1);
        }
        for (int i = 0; i < S.length; i++) {
            System.out.printf("S[%d] |  ", i + 1);
        }
        System.out.println();
        System.out.println("________________________________________________________________________________");
    }

    static void imprimirMatriz_P3(double[] X, double[] S, double[] C) {
        System.out.print("z     |  ");
        for (int i = 0; i < X.length; i++) {
            System.out.printf("X[%d] |  ", i + 1);
        }
        for (int i = 0; i < S.length; i++) {
            System.out.printf("S[%d] |  ", i + 1);
        }
        for (int i = 0; i < C.length; i++) {
            System.out.printf("C[%d] |  ", i + 1);
        }
        System.out.println();
        System.out.println("________________________________________________________________________________");
    }

    static void imprimirMatriz_Nega(double[] X, double[] S) {
        System.out.print("z     |  ");
        for (int i = 0; i < X.length; i++) {
            System.out.printf("X[%d] |  ", i + 1);
        }
        for (int i = 0; i < S.length; i++) {
            System.out.printf("C[%d] |  ", i + 1);
        }
        System.out.println();
        System.out.println("________________________________________________________________________________");
    }

 
 
 
}
