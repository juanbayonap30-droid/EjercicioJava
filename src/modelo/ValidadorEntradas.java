package modelo;

import java.util.Scanner;

public class ValidadorEntradas {

    // Patrones Regex para validación
    private static final String REGEX_SOLO_LETRAS = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
    private static final String REGEX_SOLO_NUMEROS = "^[0-9]+$";
    private static final String REGEX_CEDULA = "^[0-9]{6,10}$";
    private static final String REGEX_PLACA = "^[a-zA-Z0-9]{6,7}$";
    private static final String REGEX_SERIAL_MOTOR = "^[a-zA-Z0-9]{5,20}$";

    // --- MÉTODOS DE VERIFICACIÓN BOOLEANOS BÁSICOS ---
    public static boolean esNoVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public static boolean esSoloLetras(String texto) {
        return esNoVacio(texto) && texto.trim().matches(REGEX_SOLO_LETRAS);
    }

    public static boolean esSoloNumeros(String texto) {
        return esNoVacio(texto) && texto.trim().matches(REGEX_SOLO_NUMEROS);
    }

    // --- MÉTODOS DE VERIFICACIÓN BOOLEANOS DE REGLAS DE NEGOCIO ---
    public static boolean esCedulaValida(String cedula) {
        return esNoVacio(cedula) && cedula.trim().matches(REGEX_CEDULA);
    }

    public static boolean esPlacaValida(String placa) {
        return esNoVacio(placa) && placa.trim().matches(REGEX_PLACA);
    }

    public static boolean esLicenciaValida(String licencia) {
        return esNoVacio(licencia) && licencia.trim().length() >= 3;
    }

    public static boolean esSerialMotorValido(String serial) {
        return esNoVacio(serial) && serial.trim().matches(REGEX_SERIAL_MOTOR);
    }

    // --- MÉTODOS DE VALIDACIÓN DE MODELOS COMPLETOS ---
    public static boolean validarChofer(chofer_modelo chofer) {
        if (chofer == null) return false;
        return esSoloLetras(chofer.getNombre_chofer()) &&
               esCedulaValida(chofer.getCedula_chofer()) &&
               esLicenciaValida(chofer.getLicencia());
    }

    public static boolean validarCarro(carro_modelo carro) {
        if (carro == null) return false;
        return esSoloLetras(carro.getMarca()) &&
               esNoVacio(carro.getModelo()) &&
               esPlacaValida(carro.getPlaca());
    }

    public static boolean validarMotor(motor_modelo motor) {
        if (motor == null) return false;
        return esNoVacio(motor.getTipo()) &&
               esSoloLetras(motor.getCombustible()) &&
               esSerialMotorValido(motor.getSerial());
    }

    public static boolean validarPasajero(pasajero_modelo pasajero) {
        if (pasajero == null) return false;
        return esSoloLetras(pasajero.getNombre()) &&
               esSoloLetras(pasajero.getApellido()) &&
               esCedulaValida(pasajero.getCedula());
    }

    public static boolean validarApi(api_modelo api) {
        if (api == null) return false;
        return esNoVacio(api.getClave()) &&
               esNoVacio(api.getRoot()) &&
               esNoVacio(api.getUrl());
    }

    public static boolean validarFichaViaje(FichaViaje ficha) {
        if (ficha == null) return false;
        return validarCarro(ficha.getCarro()) &&
               validarMotor(ficha.getMotor()) &&
               validarChofer(ficha.getChofer()) &&
               validarPasajero(ficha.getPasajero());
    }

    // --- MÉTODOS INTERACTIVOS DE LECTURA CON CONSOLA (VISTAS) ---
    public static String leerTextoNoVacio(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String entrada = scanner.nextLine().trim();
            if (esNoVacio(entrada)) {
                return entrada;
            }
            System.out.println("  [Error - Validación] El campo no puede estar vacío. Intente de nuevo.");
        }
    }

    public static String leerSoloLetras(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String entrada = scanner.nextLine().trim();
            if (!esNoVacio(entrada)) {
                System.out.println("  [Error - Validación] El campo no puede estar vacío. Intente de nuevo.");
            } else if (!esSoloLetras(entrada)) {
                System.out.println("  [Error - Validación] Este campo solo debe contener letras (no se permiten números ni caracteres especiales). Intente de nuevo.");
            } else {
                return entrada;
            }
        }
    }

    public static String leerSoloNumeros(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String entrada = scanner.nextLine().trim();
            if (!esNoVacio(entrada)) {
                System.out.println("  [Error - Validación] El campo no puede estar vacío. Intente de nuevo.");
            } else if (!esSoloNumeros(entrada)) {
                System.out.println("  [Error - Validación] Este campo solo debe contener números. Intente de nuevo.");
            } else {
                return entrada;
            }
        }
    }

    public static String leerAlfanumerico(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String entrada = scanner.nextLine().trim();
            if (!esNoVacio(entrada)) {
                System.out.println("  [Error - Validación] El campo no puede estar vacío. Intente de nuevo.");
            } else {
                return entrada;
            }
        }
    }

    public static String leerCedula(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String entrada = scanner.nextLine().trim();
            if (!esNoVacio(entrada)) {
                System.out.println("  [Error - Regla de Negocio] La cédula no puede estar vacía.");
            } else if (!esCedulaValida(entrada)) {
                System.out.println("  [Error - Regla de Negocio] La cédula debe ser numérica de 6 a 10 dígitos. Intente de nuevo.");
            } else {
                return entrada;
            }
        }
    }

    public static String leerPlaca(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String entrada = scanner.nextLine().trim();
            if (!esNoVacio(entrada)) {
                System.out.println("  [Error - Regla de Negocio] La placa no puede estar vacía.");
            } else if (!esPlacaValida(entrada)) {
                System.out.println("  [Error - Regla de Negocio] La placa debe ser alfanumérica de 6 a 7 caracteres (ej: ABC1234). Intente de nuevo.");
            } else {
                return entrada;
            }
        }
    }

    public static String leerLicencia(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String entrada = scanner.nextLine().trim();
            if (!esNoVacio(entrada)) {
                System.out.println("  [Error - Regla de Negocio] La licencia no puede estar vacía.");
            } else if (!esLicenciaValida(entrada)) {
                System.out.println("  [Error - Regla de Negocio] La licencia debe tener al menos 3 caracteres. Intente de nuevo.");
            } else {
                return entrada;
            }
        }
    }

    public static String leerSerialMotor(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String entrada = scanner.nextLine().trim();
            if (!esNoVacio(entrada)) {
                System.out.println("  [Error - Regla de Negocio] El serial del motor no puede estar vacío.");
            } else if (!esSerialMotorValido(entrada)) {
                System.out.println("  [Error - Regla de Negocio] El serial debe ser alfanumérico entre 5 y 20 caracteres. Intente de nuevo.");
            } else {
                return entrada;
            }
        }
    }
}

