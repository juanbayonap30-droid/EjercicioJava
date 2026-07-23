package vista;

import modelo.ValidadorEntradas;
import java.util.Scanner;

public class vista_motor {
    private String tipo = "";
    private String combustible = "";
    private String serial = "";

    public void registrar_motor() {
        Scanner obj_teclado = new Scanner(System.in);
        System.out.println("\n--- REGISTRO DE MOTOR ---");
        this.tipo = ValidadorEntradas.leerAlfanumerico(obj_teclado, "Ingrese tipo de motor (ej. V8, Eléctrico): ");
        this.combustible = ValidadorEntradas.leerSoloLetras(obj_teclado, "Ingrese tipo de combustible: ");
        this.serial = ValidadorEntradas.leerSerialMotor(obj_teclado, "Ingrese número de serie del motor (5-20 alfanumérico): ");
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
