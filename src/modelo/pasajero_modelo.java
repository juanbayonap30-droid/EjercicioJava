package modelo;

public class pasajero_modelo {
    private String nombre = "";
    String apellido = "";
    String cedula = "";

    // Constructor
    public pasajero_modelo(String dato_nombre, String dato_apellido, String dato_cedula) {
        this.nombre = dato_nombre;
        this.apellido = dato_apellido;
        this.cedula = dato_cedula;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " Apellido: " + apellido + " Cedula: " + cedula;
    }
}
