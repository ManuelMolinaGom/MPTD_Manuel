/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package araujo_ac2;

import java.util.Stack;

/**
 *
 * @author Manue Alejandro Gomez Molina
 */
public class p1 {
 public static void main(String[] args) {
        Stack<String> pi = new Stack<>(); 
        System.out.println("____________________________________________________________\n"
                         + "operacion               salida                   contenido\n"
                         + "____________________________________________________________\n");
        
        pi.push("5");
        System.out.printf("%-25s %-25s %-25s%n", "push(5)", "-", pi);
        
        pi.push("3");
        System.out.printf("%-25s %-25s %-25s%n", "push(3)", "-", pi);
        
        String poppedValue = pi.pop();
        System.out.printf("%-25s %-25s %-25s%n", "pop()", poppedValue, pi);
        
        pi.push("7");
        System.out.printf("%-25s %-25s %-25s%n", "push(7)", "-", pi);    
        
        String a = pi.pop();
        System.out.printf("%-25s %-25s %-25s%n", "pop()", a, pi);
        
        a = pi.peek(); 
        System.out.printf("%-25s %-25s %-25s%n", "peek()", a, pi);
        a = pi.pop();
        System.out.printf("%-25s %-25s %-25s%n", "pop()", a, pi);
        
        System.out.printf("%-25s %-25s %-25s%n", "pop()", "error", pi);
        boolean b=pi.empty();
        System.out.printf("%-25s %-25s %-25s%n", "pop()", b, pi);
        
         pi.push("9");
        System.out.printf("%-25s %-25s %-25s%n", "push(9)", "-", pi);
        
        pi.push("7");
        System.out.printf("%-25s %-25s %-25s%n", "push(7)", "-", pi);
        
        pi.push("3");
        System.out.printf("%-25s %-25s %-25s%n", "push(3)", "-", pi);
        
        pi.push("5");
        System.out.printf("%-25s %-25s %-25s%n", "push(5)", "-", pi);
        a=pi.size()+"";
        System.out.printf("%-25s %-25s %-25s%n", "size(5)", a, pi);
        
         a = pi.pop();
        System.out.printf("%-25s %-25s %-25s%n", "pop()", a, pi);
        
        pi.push("8");
        System.out.printf("%-25s %-25s %-25s%n", "push(5)", "-", pi);
        
        a = pi.pop();
        System.out.printf("%-25s %-25s %-25s%n", "pop()", a, pi);
        a = pi.pop();
        System.out.printf("%-25s %-25s %-25s%n", "pop()", a, pi);
    }
}