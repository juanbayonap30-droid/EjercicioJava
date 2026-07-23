package vista;

import modelo.ValidadorEntradas;
import java.util.Scanner;

public class vista_carro {
    private String marca = "";
    private String modelo = "";
    private String placa = "";

    public void registrar_carro() {
        Scanner obj_teclado = new Scanner(System.in);
        System.out.println("\n--- REGISTRO DE CARRO ---");
        this.marca = ValidadorEntradas.leerSoloLetras(obj_teclado, "Ingrese marca del carro: ");
        this.modelo = ValidadorEntradas.leerAlfanumerico(obj_teclado, "Ingrese modelo del carro: ");
        this.placa = ValidadorEntradas.leerPlaca(obj_teclado, "Ingrese placa del carro (6-7 caracteres alfanuméricos): ");
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
