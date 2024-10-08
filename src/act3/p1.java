package act3;

import java.util.LinkedList;
import java.util.Queue;

public class p1 {
    public static void main(String[] args) {
        Queue<String> m1 = new LinkedList<>();

 
        m1.add("a");
        m1.add("b");
        m1.add("c");
        m1.add("d");
        m1.add("e");

       
        imQue(m1);
        System.out.println("====");

        m1.poll();
        System.out.println(" poll(a):");
        imQue(m1);
        System.out.println("====");

        
        String headElement = m1.element();
        System.out.println("  (element): " + headElement);
        imQue(m1);
        System.out.println("====");

       
        String peekElement = m1.peek();
        System.out.println("  (peek): " + peekElement);
        imQue(m1);
        System.out.println("====");

       
       
        imQue(m1);
    }

    static void imQue(Queue<?> a) {
        for (Object object : a) {
            System.out.println(object);
        }
    }
}
