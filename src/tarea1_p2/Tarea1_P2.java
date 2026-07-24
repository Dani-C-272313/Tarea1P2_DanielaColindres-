/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea1_p2;
import javax.swing.JOptionPane; 


/**
 *
 * @author Daniela
 */
public class Tarea1_P2 {

    /**
     * @param args the command line arguments
     */
     
    
    public static void main(String[] args) {
     Menu(); 
    }
    
    public static void Menu(){
     String menu = """
                   1. Inventario de Autos 
                   2. Recursion
                   0. Salir 
                   """;
    
  
        // 2. Lo muestras en UN SOLO panel (texto arriba, cajita abajo)
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
        
        
     while(opcion !=0){
         switch(opcion){
             
             case 1:{
                 Inventario inventario = new Inventario();
                inventario.menuInventario();
                 System.out.println("jaja");
                 break; 
             }// corchete de case 1 
             
             case 2:{
                 Recursion recursion = new Recursion(); 
                 recursion.menuRecursion();
                 
             }
            
             default:
                 try {
                    throw new Exception();
            } catch (Exception e) {
            
                String mensajeExcception = "";
            for(int i = 0; i<51; i++){
               mensajeExcception += "Nuh huh, exception \n";
            
            }  
            JOptionPane.showMessageDialog(null,mensajeExcception);
                break; 
            }
                 
         }// corchete del switch
         
         
         opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
       
     }//corchete de la opcion 
     
     
     
}// corchete del metodo menu
    
}// corchete de la clase 
