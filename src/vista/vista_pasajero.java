package vista;

import java.util.Scanner;

public class vista_pasajero {
    private String nombre = "";
    private String apellido = "";
    private String cedula = "";

    public void registrar_pasajero() {
        Scanner obj_teclado = new Scanner(System.in);
        System.out.println("\n--- REGISTRO DE PASAJERO ---");
        System.out.print("Ingrese nombre del pasajero: ");
        this.nombre = obj_teclado.nextLine().trim();
        System.out.print("Ingrese apellido del pasajero: ");
        this.apellido = obj_teclado.nextLine().trim();
        System.out.print("Ingrese cédula del pasajero: ");
        this.cedula = obj_teclado.nextLine().trim();
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
