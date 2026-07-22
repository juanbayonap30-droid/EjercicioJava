package modelo;

public class api_modelo {
    String clave = "";
    String root = "";
    String url = "";


    public api_modelo(String clave, String usuario, String url) {
        this.clave = clave;
        this.root = usuario;
        this.url = url;
    }

    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Clave: " + clave + " Root: " + root + " Url: " + url;
    }
    public boolean validar_conexion(){
        if(this.clave.equals("1234")){
            return true;
        }
        else{
            return false;
        }
    }
    public void desconexion(){
        System.out.println("Desconexion exitosa");
    }
    public void  buscar_chofer(String info_cedula){
        System.out.println("Cliente se está buscando...");
    }
}
