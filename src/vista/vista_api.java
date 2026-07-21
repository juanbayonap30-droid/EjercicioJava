/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class vista_api {
    public void registrar_api(){
    Scanner obj_teclado = new Scanner(System.in);
    String clave = obj_teclado.nextLine();
    String root = obj_teclado.nextLine();
    String url = obj_teclado.nextLine();
    
    Controlar obj_controlador = new controlador();
    }
    
    
}
