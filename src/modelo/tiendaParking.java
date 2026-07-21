package modelo;

import vista.vista_chofer;
import controlador.controlador_general;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class tiendaParking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        controlador_general obj_controlador = new controlador_general();
        List<FichaViaje> baseDeDatos = new ArrayList<>();
        List<FichaViaje> estructuraTemporal = new ArrayList<>();

        System.out.println("=== Sistema Tienda Parking - MVC ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ PRINCIPAL (MVC) ---");
            System.out.println("1. Registrar nueva Ficha de Viaje (MVC completo)");
            System.out.println("2. Registrar Chofer de forma rápida (MVC)");
            System.out.println("3. Validar y Enviar Ficha a la Base de Datos");
            System.out.println("4. Probar Conexión API");
            System.out.println("5. Ver Fichas en Almacenamiento Temporal");
            System.out.println("6. Ver Fichas en Base de Datos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            
            String opcion = scanner.nextLine().trim();
            switch (opcion) {
                case "1":
                    FichaViaje nuevaFicha = obj_controlador.procesar_viaje_completo();
                    estructuraTemporal.add(nuevaFicha);
                    System.out.println("\n[Éxito] Ficha registrada temporalmente en la estructura externa.");
                    break;
                case "2":
                    obj_controlador.procesar_datos();
                    break;
                case "3":
                    enviarABaseDatos(scanner, estructuraTemporal, baseDeDatos);
                    break;
                case "4":
                    obj_controlador.procesar_api();
                    break;
                case "5":
                    mostrarFichas("ALMACENAMIENTO TEMPORAL", estructuraTemporal);
                    break;
                case "6":
                    mostrarFichas("BASE DE DATOS", baseDeDatos);
                    break;
                case "7":
                    salir = true;
                    System.out.println("¡Gracias por usar el sistema!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    private static void enviarABaseDatos(Scanner scanner, List<FichaViaje> estructuraTemporal, List<FichaViaje> baseDeDatos) {
        if (estructuraTemporal.isEmpty()) {
            System.out.println("\n[Info] No hay fichas en el almacenamiento temporal para enviar.");
            return;
        }

        System.out.println("\n--- ENVÍO A BASE DE DATOS (Validación del Encargado) ---");
        System.out.println("Seleccione la ficha a guardar (1 - " + estructuraTemporal.size() + "):");
        for (int i = 0; i < estructuraTemporal.size(); i++) {
            System.out.println((i + 1) + ". Carro Placa: " + (estructuraTemporal.get(i).getCarro() != null ? estructuraTemporal.get(i).getCarro().getPlaca() : "N/A") + 
                               " | Chofer: " + (estructuraTemporal.get(i).getChofer() != null ? estructuraTemporal.get(i).getChofer().getNombre_chofer() : "N/A"));
        }
        System.out.print("Selección: ");
        int index;
        try {
            index = Integer.parseInt(scanner.nextLine().trim()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("[Error] Entrada inválida.");
            return;
        }

        if (index < 0 || index >= estructuraTemporal.size()) {
            System.out.println("[Error] Selección fuera de rango.");
            return;
        }

        FichaViaje fichaSeleccionada = estructuraTemporal.get(index);
        
        // Validar y Confirmar con el Encargado de la Base de Datos
        boolean confirmado = ValidadorBaseDatos.confirmarGuardado(fichaSeleccionada, scanner);
        if (confirmado) {
            baseDeDatos.add(fichaSeleccionada);
            estructuraTemporal.remove(index);
        }
    }

    private static void mostrarFichas(String titulo, List<FichaViaje> lista) {
        System.out.println("\n=== FICHAS EN " + titulo + " ===");
        if (lista.isEmpty()) {
            System.out.println("No hay registros.");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("\n[Registro #" + (i + 1) + "]");
            System.out.println(lista.get(i).toString());
        }
    }
}
