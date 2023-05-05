/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package creacion1;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Metodo principal que procesa diferentes personas que introducen o no fecha de
 * nacimiento
 *
 * @author peter
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int personas = sc.nextInt();
        int edad;
        sc.nextLine();
        String nombre, apellidos, fechaNacimiento, fecha;

        for (int i = 0; i < personas; i++) {
            nombre = sc.nextLine();
            apellidos = sc.nextLine();
            fechaNacimiento = sc.nextLine();

            try {
                Persona persona1 = new Persona(nombre, apellidos, fechaNacimiento);
                int cantidadFechas = sc.nextInt();
                sc.nextLine();
                for (int j = 0; j < cantidadFechas; j++) {
                    fecha = sc.nextLine();
                    try {
                        edad = persona1.getEdadEnFecha(fecha);
                        if (edad == -1) {
                            System.out.println(persona1.getNombre() + " " + persona1.getApellidos() + " aun no ha nacido a fecha " + fecha);
                        } else {
                            System.out.println(persona1.getNombre() + " " +persona1.getApellidos() + " tendra " + edad + " anyos en fecha " + fecha);
                        }
                    } catch (IllegalArgumentException e1) {
                        System.out.println("ERROR. Procesando siguiente fecha");
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR. Procesando siguiente persona");
            }
        }
    }
}
