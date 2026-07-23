package vista;

import modelo.ValidadorEntradas;
import java.util.Scanner;

public class vista_api {
    private String clave = "";
    private String root = "";
    private String url = "";

    public void registrar_api() {
        Scanner obj_teclado = new Scanner(System.in);
        System.out.println("\n--- REGISTRO DE CONEXIÓN API ---");
        this.clave = ValidadorEntradas.leerTextoNoVacio(obj_teclado, "Ingrese clave API: ");
        this.root = ValidadorEntradas.leerTextoNoVacio(obj_teclado, "Ingrese root/usuario API: ");
        this.url = ValidadorEntradas.leerTextoNoVacio(obj_teclado, "Ingrese URL de la API: ");
    }

    public String getClave() {
        return clave;
    }

    public String getRoot() {
        return root;
    }

    public String getUrl() {
        return url;
    }
}
