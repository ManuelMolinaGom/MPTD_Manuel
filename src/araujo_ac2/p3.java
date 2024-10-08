package araujo_ac2;

import java.util.Scanner;
import java.util.Stack;

class Alumno {
    private String nombre;
    private double[] calificaciones;

    public Alumno(String nombre, double ca1, double ca2, double ca3, double ca4, double ca5) {
        this.nombre = nombre;
        this.calificaciones = new double[]{ca1, ca2, ca3, ca4, ca5};
    }

    public String getNombre() {
        return nombre;
    }

    public double calcularPromedio() {
        double suma = 0;
        for (double calificacion : calificaciones) {
            suma += calificacion;
        }
        return suma / calificaciones.length;
    }

    public double obtenerMaximaCalificacion() {
        double max = calificaciones[0];
        for (double calificacion : calificaciones) {
            if (calificacion > max) {
                max = calificacion;
            }
        }
        return max;
    }

    public double obtenerMinimaCalificacion() {
        double min = calificaciones[0];
        for (double calificacion : calificaciones) {
            if (calificacion < min) {
                min = calificacion;
            }
        }
        return min;
    }
}

public class p3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Alumno> pila = new Stack<>();
        double totalPromedio = 0;
        double maxPromedio = Double.NEGATIVE_INFINITY;
        double minPromedio = Double.POSITIVE_INFINITY;
        int contadorAlumnos = 0;

        while (true) {
            System.out.print("Ingrese el nombre del alumno (o 'salir' para terminar): ");
            String nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.print("Ingrese la calificacion 1: ");
            double ca1 = scanner.nextDouble();
            System.out.print("Ingrese la calificacion 2: ");
            double ca2 = scanner.nextDouble();
            System.out.print("Ingrese la calificacion 3: ");
            double ca3 = scanner.nextDouble();
            System.out.print("Ingrese la calificacion 4: ");
            double ca4 = scanner.nextDouble();
            System.out.print("Ingrese la calificacion 5: ");
            double ca5 = scanner.nextDouble();
            scanner.nextLine();  // Clear the buffer

            Alumno alumno = new Alumno(nombre, ca1, ca2, ca3, ca4, ca5);
            pila.push(alumno);
        }

        while (!pila.isEmpty()) {
            Alumno alumno = pila.pop();
            double promedio = alumno.calcularPromedio();
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Promedio: " + promedio);
            System.out.println();

            totalPromedio += promedio;
            if (promedio > maxPromedio) {
                maxPromedio = promedio;
            }
            if (promedio < minPromedio) {
                minPromedio = promedio;
            }
            contadorAlumnos++;
        }

        if (contadorAlumnos > 0) {
            System.out.println("Maximo promedio de todos los alumnos: " + maxPromedio);
            System.out.println("Minimo promedio de todos los alumnos: " + minPromedio);
            System.out.println("Promedio del salon: " + (totalPromedio / contadorAlumnos));
        } else {
            System.out.println("No se han ingresado alumnos.");
        }

        scanner.close();
    }
}
