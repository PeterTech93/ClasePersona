/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creacion1;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 *
 * @author peter
 */
public class Persona {

    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;

    /**
     * Metodo constructor de las personas que introducen fecha de nacimiento
     *
     * @param nombre nombre de la persona que vamos a crear
     * @param apellidos apellidos de la persona que vamos a crear
     * @param fechaNacimiento fecha de nacimiento de la persona que vamos a
     * crear
     * @throws IllegalArgumentException excepcion que se lanzara cuando el
     * formato de fecha o el nombre sean incorrectos
     */
    public Persona(String nombre, String apellidos, String fechaNacimiento) throws IllegalArgumentException {
        if ("".equals(nombre) || "".equals(apellidos)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fechaNacimiento = generarFecha(fechaNacimiento);
        }
    }

    private LocalDate generarFecha(String fechaNacimiento) {
        LocalDate fechaCorrecta;
        String fechaOrdenada;

        if (fechaNacimiento.charAt(2) == fechaNacimiento.charAt(5)
                && ((fechaNacimiento.charAt(2) == '-' || fechaNacimiento.charAt(2) == '-')
                || (fechaNacimiento.charAt(2) == '/' || fechaNacimiento.charAt(5) == '/'))) {
            fechaOrdenada = getFechaNacimiento('-', fechaNacimiento);
            try {
                fechaCorrecta = LocalDate.parse(fechaOrdenada);
                return fechaCorrecta;
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Metodo constructor de las personas que no introducen fechas de nacimiento
     *
     * @param nombre
     * @param apellidos
     */
    public Persona(String nombre, String apellidos) {
        if ("".equals(nombre) || "".equals(apellidos)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
        }
    }

    /**
     * Metodo para obtener el nombre de la persona que se esta tratando
     *
     * @return devuelve el nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Metodo para obtener los apellidos de la persona que se esta tratando
     *
     * @return devuelve los apellidos
     */
    public String getApellidos() {
        return this.apellidos;
    }

    /**
     * Metodo para obtener la fecha de nacimiento de la persona que se esta
     * tratando
     *
     * @return devuelve la fecha de nacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento.toString();
    }

    /**
     * Metodo modificador del separador de las cadenas fecha de nacimiento
     *
     * @param separador que siempre sera un guion para adaptarnos al formato del
     * LocalDate
     * @param fechaNacimiento que será la fecha que queremos tratar
     * @return devuelve la fecha de nacimiento o null si no se ha podido generar
     */
    public String getFechaNacimiento(char separador, String fechaNacimiento) {
        String fechaCorrecta;
        try {
            fechaCorrecta = fechaNacimiento.substring(6, fechaNacimiento.length()) + separador + fechaNacimiento.substring(3, 5) + separador + fechaNacimiento.substring(0, 2);
        } catch (NullPointerException e) {
            fechaCorrecta = "null";
            return fechaCorrecta;
        }
        return fechaCorrecta;
    }

    /**
     * Metodo para modificar la fecha de nacimiento que lo que hace es comprobar
     * si es correcta
     *
     * @param fechaNacimiento fecha de nacimiento de la persona que se quiere
     * tratar
     * @return devuelve la nueva fecha de nacimiento con la que hay que trabajar
     */
    public String setFechaNacimiento(String fechaNacimiento) {
        String nuevaFecha;
        generarFecha(fechaNacimiento);
        nuevaFecha = generarFecha(fechaNacimiento).toString();
        return nuevaFecha;
    }

    public int getEdadEnFecha(String fecha) {
        int edad;
        int anioPersona, anioHoy;
        anioPersona = Integer.parseInt(fecha.substring(6, fecha.length()));
        anioHoy = Integer.parseInt(LocalDate.now().toString().substring(6, LocalDate.now().toString().length()));
        edad = anioHoy - anioPersona;
        System.out.println("Tercera modificacion");
        System.out.println("Cuarta modificacion");
        System.out.println("Quinta modificacion");
        System.out.println("Última modificación");
    }
    
}
