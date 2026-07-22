package vista;

import java.util.Scanner;

public class vista_motor {
    private String tipo = "";
    private String combustible = "";
    private String serial = "";

    public void registrar_motor() {
        Scanner obj_teclado = new Scanner(System.in);
        System.out.println("\n--- REGISTRO DE MOTOR ---");
        System.out.print("Ingrese tipo de motor (ej. V8, Eléctrico): ");
        this.tipo = obj_teclado.nextLine().trim();
        System.out.print("Ingrese tipo de combustible: ");
        this.combustible = obj_teclado.nextLine().trim();
        System.out.print("Ingrese número de serie del motor: ");
        this.serial = obj_teclado.nextLine().trim();
    }

    public String getTipo() {
        return tipo;
    }

    public String getCombustible() {
        return combustible;
    }

    public String getSerial() {
        return serial;
    }
}
