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
public class vista_motor {
    public void registrar_motor(){
    Scanner obj_teclado = new Scanner(System.in);
    String tipo = obj_teclado.nextLine();
    String combustible = obj_teclado.nextLine();
    String serial = obj_teclado.nextLine();
    
    Controlar obj_controlador = new controlador();
    }
    
    
}
