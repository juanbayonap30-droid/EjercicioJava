package modelo;

public class FichaViaje {
    private carro_modelo carro;
    private motor_modelo motor;
    private chofer_modelo chofer;
    private pasajero_modelo pasajero;

    public FichaViaje(carro_modelo carro, motor_modelo motor, chofer_modelo chofer, pasajero_modelo pasajero) {
        this.carro = carro;
        this.motor = motor;
        this.chofer = chofer;
        this.pasajero = pasajero;
    }

    public carro_modelo getCarro() {
        return carro;
    }

    public void setCarro(carro_modelo carro) {
        this.carro = carro;
    }

    public motor_modelo getMotor() {
        return motor;
    }

    public void setMotor(motor_modelo motor) {
        this.motor = motor;
    }

    public chofer_modelo getChofer() {
        return chofer;
    }

    public void setChofer(chofer_modelo chofer) {
        this.chofer = chofer;
    }

    public pasajero_modelo getPasajero() {
        return pasajero;
    }

    public void setPasajero(pasajero_modelo pasajero) {
        this.pasajero = pasajero;
    }

    @Override
    public String toString() {
        return "=== Ficha de Viaje ===\n" +
               "--- Carro ---\n" + (carro != null ? carro.toString() : "No registrado") + "\n" +
               "--- Motor ---\n" + (motor != null ? motor.toString() : "No registrado") + "\n" +
               "--- Chofer ---\n" + (chofer != null ? chofer.toString() : "No registrado") + "\n" +
               "--- Pasajero ---\n" + (pasajero != null ? pasajero.toString() : "No registrado") + "\n" +
               "======================";
    }
}
