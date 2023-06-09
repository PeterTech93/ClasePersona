/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creacion1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

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
        } else if (fechaNacimiento.charAt(4) == fechaNacimiento.charAt(7)) {
            try {
                fechaCorrecta = LocalDate.parse(fechaNacimiento);
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

    public int getEdadEnFecha(String cadenaFecha) {
        int edad;

        if (this.fechaNacimiento == null) {
            return -1;
        }

        LocalDate nuevaFecha = generarFecha(cadenaFecha);
        try {
            edad = nuevaFecha.getYear() - this.fechaNacimiento.getYear();
            if (this.fechaNacimiento.getMonthValue() > nuevaFecha.getMonthValue()
                    || (this.fechaNacimiento.getMonthValue() == nuevaFecha.getMonthValue()
                    && this.fechaNacimiento.getDayOfMonth() > nuevaFecha.getDayOfMonth())) {
                edad--;
            }
            return edad;
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

    public int getEdad() {
        if (this.fechaNacimiento == null) {
            return -1;
        }
        int edad;
        edad = getEdadEnFecha(LocalDate.now().toString());
        return edad;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return "Persona{"
                + "nombre=" + nombre
                + ", apellidos=" + apellidos
                + ", fechaNacimiento=" + fechaNacimiento.format(formatter)
                + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Persona persona = (Persona) obj;
        return Objects.equals(nombre, persona.nombre)
                && Objects.equals(apellidos, persona.apellidos)
                && Objects.equals(fechaNacimiento, persona.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
