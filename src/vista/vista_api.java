package vista;

import java.util.Scanner;

public class vista_api {
    private String clave = "";
    private String root = "";
    private String url = "";

    public void registrar_api() {
        Scanner obj_teclado = new Scanner(System.in);
        System.out.println("\n--- REGISTRO DE CONEXIÓN API ---");
        System.out.print("Ingrese clave API: ");
        this.clave = obj_teclado.nextLine().trim();
        System.out.print("Ingrese root/usuario API: ");
        this.root = obj_teclado.nextLine().trim();
        System.out.print("Ingrese URL de la API: ");
        this.url = obj_teclado.nextLine().trim();
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
