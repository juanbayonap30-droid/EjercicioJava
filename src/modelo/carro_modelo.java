package modelo;


public class carro_modelo {

    private String marca = "";
    String modelo = "";
    String placa = "";

    // Constructor
    public carro_modelo(String dato_marca, String dato_modelo, String dato_placa) {
        this.marca = dato_marca;
        this.modelo = dato_modelo;
        this.placa = dato_placa;
    }

    // Getters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    // Setters
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Marca: " + marca +
         " Modelo: " + modelo +
               " Placa: " + placa;
    }
    public void buscar_placa(String info_placa){
        System.out.println("buscando placa..");
    }
            
}
