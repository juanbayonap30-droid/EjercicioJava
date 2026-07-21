package vista;

import java.util.Scanner;

public class vista_chofer {
    // Escáner a nivel de clase para que los métodos lo puedan usar
    Scanner obj_teclado = new Scanner(System.in);

    // Campos para almacenar los datos capturados
    private String nombre;
    private String cedula;
    private String licencia;

    // Método principal que agrupa la captura de todos los datos del chofer
    public void registrar_chofer() {
        System.out.print("Ingrese nombre del chofer: ");
        this.nombre = obj_teclado.nextLine();
        System.out.print("Ingrese cédula del chofer: ");
        this.cedula = obj_teclado.nextLine();
        System.out.print("Ingrese licencia del chofer: ");
        this.licencia = obj_teclado.nextLine();
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
        System.out.print("Ingrese nombre del chofer: ");
        return obj_teclado.nextLine();
    }

    public String tomarcedula() {
        System.out.print("Ingrese cédula del chofer: ");
        return obj_teclado.nextLine();
    }

    public String tomarlicencia() {
        System.out.print("Ingrese licencia del chofer: ");
        return obj_teclado.nextLine();
    }
}
