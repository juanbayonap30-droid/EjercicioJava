package modelo;

import java.util.Scanner;

public class tiendaParking {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Sistema Tienda Parking ---");

        
        // OBJETO CHOFER
        chofer_modelo obj_chofer = new chofer_modelo("Juan", "activa", "123456789");

        obj_chofer.setNombre_chofer("Carlos");

        System.out.println("Nombre del chofer: " + obj_chofer.getNombre_chofer());
        System.out.println("Licencia del chofer: " + obj_chofer.getLicencia());
        System.out.println("Cédula del chofer: " + obj_chofer.getCedula_chofer());

        System.out.println();

        
        // OBJETO CARRO
        carro_modelo obj_carro = new carro_modelo("Toyota", "Corolla", "ABC123");

        obj_carro.setMarca("Mazda");

        System.out.println("Marca: " + obj_carro.getMarca());
        System.out.println("Modelo: " + obj_carro.getModelo());
        System.out.println("Placa: " + obj_carro.getPlaca());

        System.out.println();

    
        // OBJETO MOTOR
        motor_modelo obj_motor = new motor_modelo("V8", "Gasolina", "1234567");

        obj_motor.setTipo("V6");

        System.out.println("Tipo de motor: " + obj_motor.getTipo());
        System.out.println("Combustible: " + obj_motor.getCombustible());
        System.out.println("serial: " + obj_motor.getSerial());

        scanner.close();
    }
}
