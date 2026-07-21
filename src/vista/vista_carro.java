package vista;

import java.util.Scanner;

public class vista_carro {
    private String marca = "";
    private String modelo = "";
    private String placa = "";

    public void registrar_carro() {
        Scanner obj_teclado = new Scanner(System.in);
        System.out.println("\n--- REGISTRO DE CARRO ---");
        System.out.print("Ingrese marca del carro: ");
        this.marca = obj_teclado.nextLine().trim();
        System.out.print("Ingrese modelo del carro: ");
        this.modelo = obj_teclado.nextLine().trim();
        System.out.print("Ingrese placa del carro: ");
        this.placa = obj_teclado.nextLine().trim();
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }
}
