package modelo;


public class motor_modelo {
    private String tipo = "";
    private String combustible = "";
    private String serial = "";

    // Constructor
    public motor_modelo(String tipo, String combustible, String serial) {
        this.tipo = tipo;
        this.combustible = combustible;
        this.serial = serial;
    }

    // Getters
    public String getTipo() {
        return tipo;
    }

    public String getCombustible() {
        return combustible;
    }

    public String getSerial() {
        return serial;
    }

    // Setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + " Combustible: " + combustible + " Potencia: " + serial;
    }
}
