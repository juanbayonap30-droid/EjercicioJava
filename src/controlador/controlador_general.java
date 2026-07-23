package controlador;

import modelo.*;
import vista.*;
import java.util.Scanner;

public class controlador_general {
    private vista_chofer vChofer;
    private vista_pasajero vPasajero;
    private vista_carro vCarro;
    private vista_motor vMotor;
    private vista_fichaviaje vFicha;
    private vista_api vApi;

    // Constructor sin parámetros
    public controlador_general() {
        this.vChofer = new vista_chofer();
        this.vPasajero = new vista_pasajero();
        this.vCarro = new vista_carro();
        this.vMotor = new vista_motor();
        this.vFicha = new vista_fichaviaje();
        this.vApi = new vista_api();
    }

    // Constructor con vista_chofer para compatibilidad
    public controlador_general(vista_chofer obj_vista) {
        this();
        this.vChofer = obj_vista;
    }

    // Procesa el registro simple de un Chofer
    public void procesar_datos() {
        this.vChofer.registrar_chofer();
        String dato_nombre = this.vChofer.getNombreChofer();
        String dato_cedula = this.vChofer.getCedulaChofer();
        String dato_licencia = this.vChofer.getLicencia();
        
        chofer_modelo obj_chofer = new chofer_modelo(dato_nombre, dato_licencia, dato_cedula);
        if (ValidadorEntradas.validarChofer(obj_chofer)) {
            System.out.println("\n[Controlador - Éxito] Chofer validado y registrado: " + obj_chofer.toString());
        } else {
            System.out.println("\n[Controlador - Error] El Chofer no cumple con las reglas del negocio.");
        }
    }

    // Orquesta la creación y validación completa de una FichaViaje
    public FichaViaje procesar_viaje_completo() {
        this.vFicha.registrar_fichaviaje();
        
        // 1. Registrar Carro
        this.vCarro.registrar_carro();
        carro_modelo carro = new carro_modelo(vCarro.getMarca(), vCarro.getModelo(), vCarro.getPlaca());
        
        // 2. Registrar Motor
        this.vMotor.registrar_motor();
        motor_modelo motor = new motor_modelo(vMotor.getTipo(), vMotor.getCombustible(), vMotor.getSerial());
        
        // 3. Registrar Chofer
        this.vChofer.registrar_chofer();
        chofer_modelo chofer = new chofer_modelo(vChofer.getNombreChofer(), vChofer.getLicencia(), vChofer.getCedulaChofer());
        
        // 4. Registrar Pasajero
        this.vPasajero.registrar_pasajero();
        pasajero_modelo pasajero = new pasajero_modelo(vPasajero.getNombre(), vPasajero.getApellido(), vPasajero.getCedula());
        
        FichaViaje ficha = new FichaViaje(carro, motor, chofer, pasajero);
        if (ValidadorEntradas.validarFichaViaje(ficha)) {
            System.out.println("\n[Controlador - Éxito] Ficha de Viaje validada correctamente por el ValidadorEntradas.");
        } else {
            System.out.println("\n[Controlador - Advertencia] La Ficha de Viaje contiene datos que violan las reglas del negocio.");
        }
        return ficha;
    }

    // Registra los parámetros de la API y valida conexión
    public void procesar_api() {
        this.vApi.registrar_api();
        api_modelo api = new api_modelo(vApi.getClave(), vApi.getRoot(), vApi.getUrl());
        System.out.println("\n[Controlador] Datos API: " + api.toString());
        if (!ValidadorEntradas.validarApi(api)) {
            System.out.println("[Controlador - Error] Datos de API no cumplen con las reglas del negocio.");
            return;
        }
        System.out.println("[Controlador] Probando conexión...");
        if (api.validar_conexion()) {
            System.out.println("[Controlador] ¡Conexión API exitosa!");
        } else {
            System.out.println("[Controlador] Error de conexión: Clave inválida.");
        }
    }
}
