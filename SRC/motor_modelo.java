
public class motor_modelo {
    private String tipo = "";
    private String combustible = "";
    private String potencia = "";

    // Constructor
    public motor_modelo(String tipo, String combustible, String potencia) {
        this.tipo = tipo;
        this.combustible = combustible;
        this.potencia = potencia;
    }

    // Getters
    public String getTipo() {
        return tipo;
    }

    public String getCombustible() {
        return combustible;
    }

    public String getPotencia() {
        return potencia;
    }

    // Setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + " Combustible: " + combustible + " Potencia: " + potencia;
    }
}
