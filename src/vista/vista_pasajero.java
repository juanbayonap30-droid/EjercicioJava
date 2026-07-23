package vista;

import modelo.ValidadorEntradas;
import java.util.Scanner;

public class vista_pasajero {
    private String nombre = "";
    private String apellido = "";
    private String cedula = "";

    public void registrar_pasajero() {
        Scanner obj_teclado = new Scanner(System.in);
        System.out.println("\n--- REGISTRO DE PASAJERO ---");
        this.nombre = ValidadorEntradas.leerSoloLetras(obj_teclado, "Ingrese nombre del pasajero: ");
        this.apellido = ValidadorEntradas.leerSoloLetras(obj_teclado, "Ingrese apellido del pasajero: ");
        this.cedula = ValidadorEntradas.leerCedula(obj_teclado, "Ingrese cédula del pasajero (6-10 dígitos): ");
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }
}
