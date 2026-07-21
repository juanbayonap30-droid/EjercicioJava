package modelo;


public class chofer_modelo {
   private String nombre_chofer = "Juan";
   String licencia = "activa";
   String cedula_chofer = "123456789";

   // Constructor
   public chofer_modelo(String dato_nombre, String licencia, String dato_cedula) {
      this.nombre_chofer = dato_nombre;
      this.licencia = licencia;
      this.cedula_chofer = dato_cedula;

   }

   // Getters
   public String getNombre_chofer() {
      return nombre_chofer;
   }

   public String getLicencia() {
      return licencia;
   }

   public String getCedula_chofer() {
      return cedula_chofer;
   }

   // Setters
   public void setNombre_chofer(String nombre_chofer) {
      this.nombre_chofer = nombre_chofer;
   }

   public void setLicencia(String licencia) {
      this.licencia = licencia;
   }

   public void setCedula_chofer(String cedula_chofer) {
      this.cedula_chofer = cedula_chofer;
   }
   //metodos de responsabilidad
   //son los que van directamente a interactuar con la base de datos o con las apis
   //..son los atributos --> reglas del negocio
   //1. la cedula sea valida
   //2. validar la licencia
   //3. validar nombre y apellido
   

   @Override
   public String toString() {
      return "Nombre: " + nombre_chofer + " Licencia: " + licencia + " Cedula: " + cedula_chofer;
   }
}
