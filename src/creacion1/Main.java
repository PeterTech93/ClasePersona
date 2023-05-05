/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package creacion1;

import java.time.format.DateTimeParseException;
import java.util.Scanner;
/**
 * Metodo principal que procesa diferentes personas que introducen o no fecha de nacimiento
 * @author peter
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int personaConInfo = sc.nextInt();
        int personaSinInfo = sc.nextInt();
        sc.nextLine();
        String nombre, fecha, apellidos;

        // Tratamiento de las personas que introducen fecha de nacimiento
        for (int i = 0; i < personaConInfo; i++) {
            nombre = sc.nextLine();
            apellidos = sc.nextLine();
            fecha = sc.nextLine();
            try {
                Persona unaPersona = new Persona(nombre, apellidos, fecha);
                System.out.println("Procesado: " + unaPersona.getNombre() + " " + unaPersona.getApellidos() + ", nacido el " + unaPersona.getFechaNacimiento().substring(8, unaPersona.getFechaNacimiento().length()) + " del " + unaPersona.getFechaNacimiento().substring(5, 7) + " de " + unaPersona.getFechaNacimiento().substring(0, 4));
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR. Procesando siguiente persona");
            } catch (DateTimeParseException e1) {
                System.out.println("ERROR. Procesando siguiente persona");
            }
        }

        // Tratamiento de personas que no introducen fecha de nacimiento
        for (int i = 0; i < personaSinInfo; i++) {
            nombre = sc.nextLine();
            apellidos = sc.nextLine();
            Persona unaPersona = new Persona(nombre, apellidos);
            System.out.println("Procesado: " + unaPersona.getNombre() + " " + unaPersona.getApellidos() + ", nacido el null");
            if (i == personaSinInfo - 1) {
                fecha = sc.nextLine();
                boolean fechaCorrecta = false;
                while (!fechaCorrecta) {
                    try {
                        String nuevaFecha = unaPersona.setFechaNacimiento(fecha);
                        fechaCorrecta = true;
                        System.out.println("Procesado: " + unaPersona.getNombre() + " " + unaPersona.getApellidos() + ", nacido el " + nuevaFecha.substring(8, nuevaFecha.length()) + " del " + nuevaFecha.substring(5, 7) + " de " + nuevaFecha.substring(0, 4));
                    } catch (IllegalArgumentException e3) {
                        System.out.println("Fecha Incorrecta");
                        fecha = sc.nextLine();
                    }
                }
            }
        }
    }
}

