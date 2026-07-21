package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tiendaParking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Estructura de datos externa temporal
        List<FichaViaje> estructuraTemporal = new ArrayList<>();
        
        // Simulación de la base de datos final
        List<FichaViaje> baseDeDatos = new ArrayList<>();

        System.out.println("=== Sistema Tienda Parking - Registro de Fichas ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Registrar nueva Ficha de Viaje (Almacenamiento Temporal)");
            System.out.println("2. Enviar Ficha del Temporal a la Base de Datos (Requiere Validación)");
            System.out.println("3. Ver Fichas en Almacenamiento Temporal");
            System.out.println("4. Ver Fichas en Base de Datos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            String opcion = scanner.nextLine().trim();
            switch (opcion) {
                case "1":
                    registrarFichaTemporal(scanner, estructuraTemporal);
                    break;
                case "2":
                    enviarABaseDatos(scanner, estructuraTemporal, baseDeDatos);
                    break;
                case "3":
                    mostrarFichas("ALMACENAMIENTO TEMPORAL", estructuraTemporal);
                    break;
                case "4":
                    mostrarFichas("BASE DE DATOS", baseDeDatos);
                    break;
                case "5":
                    salir = true;
                    System.out.println("¡Gracias por usar el sistema!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    private static void registrarFichaTemporal(Scanner scanner, List<FichaViaje> estructuraTemporal) {
        System.out.println("\n--- REGISTRO DE FICHA DE VIAJE (Temporal) ---");
        
        // 1. Datos del Carro
        System.out.println("\n[Datos del Carro]");
        System.out.print("Placa: ");
        String placa = scanner.nextLine().trim();
        System.out.print("Marca: ");
        String marca = scanner.nextLine().trim();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine().trim();
        carro_modelo carro = new carro_modelo(marca, modelo, placa);

        // 2. Datos del Motor
        System.out.println("\n[Datos del Motor]");
        System.out.print("Número de serie: ");
        String serial = scanner.nextLine().trim();
        System.out.print("Tipo (ej. V8, Eléctrico): ");
        String tipo = scanner.nextLine().trim();
        System.out.print("Combustible (opcional): ");
        String combustible = scanner.nextLine().trim();
        motor_modelo motor = new motor_modelo(tipo, combustible, serial);

        // 3. Datos del Chofer
        System.out.println("\n[Datos del Chofer]");
        System.out.print("Cédula: ");
        String cedulaChofer = scanner.nextLine().trim();
        System.out.print("Nombre completo: ");
        String nombreChofer = scanner.nextLine().trim();
        System.out.print("Licencia (ej. Activa, A2): ");
        String licencia = scanner.nextLine().trim();
        chofer_modelo chofer = new chofer_modelo(nombreChofer, licencia, cedulaChofer);

        // 4. Datos del Pasajero
        System.out.println("\n[Datos del Pasajero]");
        System.out.print("Cédula: ");
        String cedulaPasajero = scanner.nextLine().trim();
        System.out.print("Nombre completo: ");
        String nombrePasajero = scanner.nextLine().trim();
        // El constructor de pasajero_modelo espera (nombre, apellido, cedula)
        pasajero_modelo pasajero = new pasajero_modelo(nombrePasajero, "", cedulaPasajero);

        // Crear Ficha de Viaje
        FichaViaje ficha = new FichaViaje(carro, motor, chofer, pasajero);
        estructuraTemporal.add(ficha);
        System.out.println("\n[Éxito] Ficha registrada temporalmente en la estructura externa.");
    }

    private static void enviarABaseDatos(Scanner scanner, List<FichaViaje> estructuraTemporal, List<FichaViaje> baseDeDatos) {
        if (estructuraTemporal.isEmpty()) {
            System.out.println("\n[Info] No hay fichas en el almacenamiento temporal para enviar.");
            return;
        }

        System.out.println("\n--- ENVÍO A BASE DE DATOS (Validación del Encargado) ---");
        System.out.println("Seleccione la ficha a guardar (1 - " + estructuraTemporal.size() + "):");
        for (int i = 0; i < estructuraTemporal.size(); i++) {
            System.out.println((i + 1) + ". Carro Placa: " + estructuraTemporal.get(i).getCarro().getPlaca() + 
                               " | Chofer: " + estructuraTemporal.get(i).getChofer().getNombre_chofer());
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
