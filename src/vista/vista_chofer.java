package vista;

import modelo.ValidadorEntradas;
import java.util.Scanner;

public class vista_chofer {
    // Escáner a nivel de clase para que los métodos lo puedan usar
    private Scanner obj_teclado = new Scanner(System.in);

    // Campos para almacenar los datos capturados
    private String nombre;
    private String cedula;
    private String licencia;

    // Método principal que agrupa la captura de todos los datos del chofer
    public void registrar_chofer() {
        System.out.println("\n--- REGISTRO DE CHOFER ---");
        this.nombre = ValidadorEntradas.leerSoloLetras(obj_teclado, "Ingrese nombre del chofer: ");
        this.cedula = ValidadorEntradas.leerCedula(obj_teclado, "Ingrese cédula del chofer (6-10 dígitos): ");
        this.licencia = ValidadorEntradas.leerLicencia(obj_teclado, "Ingrese licencia del chofer: ");
    }

    // Getters esperados por el controlador
    public String getNombreChofer() {
        return nombre;
    }

    public String getCedulaChofer() {
        return cedula;
    }

    public String getLicencia() {
        return licencia;
    }

    // Métodos originales individuales (mantenidos por compatibilidad)
    public String tomarnombre() {
        return ValidadorEntradas.leerSoloLetras(obj_teclado, "Ingrese nombre del chofer: ");
    }

    public String tomarcedula() {
        return ValidadorEntradas.leerCedula(obj_teclado, "Ingrese cédula del chofer (6-10 dígitos): ");
    }

    public String tomarlicencia() {
        return ValidadorEntradas.leerLicencia(obj_teclado, "Ingrese licencia del chofer: ");
    }
}
