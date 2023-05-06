/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package creacion1;

import java.util.Scanner;
import java.util.Objects;

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
        sc.nextLine();
        String nombre = "";
        String apellidos = "";
        String fechaNacimiento = "";
        String fecha;
        boolean personaAsignada = false;

        while (!personaAsignada) {
            nombre = sc.nextLine();
            apellidos = sc.nextLine();
            fechaNacimiento = sc.nextLine();
            try {
                Persona persona1 = new Persona(nombre, apellidos, fechaNacimiento);
                personaAsignada = true;
                personas--;
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR. Procesando siguiente persona");
                personas--;
            }

        }
        Persona persona1 = new Persona(nombre, apellidos, fechaNacimiento);
        for (int i =0; i < personas; i++) {
            nombre = sc.nextLine();
            apellidos = sc.nextLine();
            fechaNacimiento = sc.nextLine();
            try {
                Persona persona2 = new Persona(nombre, apellidos, fechaNacimiento);
                if (persona1.equals(persona2)) {
                    System.out.println(persona2.toString() + " y " + persona1.toString() + " son la misma");
                    persona1 = persona2;
                } else {
                    System.out.println(persona2.toString() + " y " + persona1.toString() + " son distintas");
                    persona1 = persona2;
                }
            } catch (IllegalArgumentException e1) {
                System.out.println("ERROR. Procesando siguiente persona");
            }

        }
    }
}
