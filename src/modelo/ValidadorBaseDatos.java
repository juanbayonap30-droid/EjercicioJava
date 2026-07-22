package modelo;

import java.util.Scanner;

public class ValidadorBaseDatos {

    public static boolean validarFicha(FichaViaje ficha) {
        if (ficha == null) {
            System.out.println("[Error - BD] La ficha de viaje es nula.");
            return false;
        }

        boolean completo = true;

        // 1. Validar Carro
        carro_modelo carro = ficha.getCarro();
        if (carro == null || isEmpty(carro.getPlaca()) || isEmpty(carro.getMarca()) || isEmpty(carro.getModelo())) {
            System.out.println("[Incompleto - BD] Faltan datos del Carro (se requiere Placa, Marca y Modelo).");
            completo = false;
        }

        // 2. Validar Motor
        motor_modelo motor = ficha.getMotor();
        if (motor == null || isEmpty(motor.getSerial()) || isEmpty(motor.getTipo())) {
            System.out.println("[Incompleto - BD] Faltan datos del Motor (se requiere Número de Serie y Tipo).");
            completo = false;
        }

        // 3. Validar Chofer
        chofer_modelo chofer = ficha.getChofer();
        if (chofer == null || isEmpty(chofer.getCedula_chofer()) || isEmpty(chofer.getNombre_chofer()) || isEmpty(chofer.getLicencia())) {
            System.out.println("[Incompleto - BD] Faltan datos del Chofer (se requiere Cédula, Nombre completo y Licencia).");
            completo = false;
        }

        // 4. Validar Pasajero
        pasajero_modelo pasajero = ficha.getPasajero();
        if (pasajero == null || isEmpty(pasajero.getCedula()) || isEmpty(pasajero.getNombre())) {
            System.out.println("[Incompleto - BD] Faltan datos del Pasajero (se requiere Cédula y Nombre completo).");
            completo = false;
        }

        return completo;
    }

    private static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean confirmarGuardado(FichaViaje ficha, Scanner scanner) {
        if (!validarFicha(ficha)) {
            System.out.println("[Error - BD] Guardado rechazado. Los 4 conjuntos de datos deben estar completos.");
            return false;
        }

        System.out.println("\n[Validador BD] Todos los datos están completos.");
        System.out.print("[Validador BD] ¿Confirmar guardado en Base de Datos? (S/N): ");
        String respuesta = scanner.nextLine().trim();
        if (respuesta.equalsIgnoreCase("S")) {
            System.out.println("[BD] Guardado confirmado exitosamente.");
            return true;
        } else {
            System.out.println("[BD] Guardado cancelado por el Encargado de la Base de Datos.");
            return false;
        }
    }
}
