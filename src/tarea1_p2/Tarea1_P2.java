/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea1_p2;
import javax.swing.JOptionPane; 
import java.util.ArrayList; 

/**
 *
 * @author Daniela
 */
public class Tarea1_P2 {

    /**
     * @param args the command line arguments
     */
     static ArrayList<Carritos> inventario = new ArrayList<>();
      static ArrayList<Carritos> autoRojo = new ArrayList<>();
    
    public static void main(String[] args) {
     Menu(); 
    }
    
    public static void Menu(){
     String menu = """
                   1. Inventario de Autos 
                   ..... 
                   // aqui van los de recursion
                   0. Salir 
                   """;
    
  
        // 2. Lo muestras en UN SOLO panel (texto arriba, cajita abajo)
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
        
        
     while(opcion !=0){
         switch(opcion){
             
             case 1:{
                 System.out.println("jaja");
                 break; 
             }// corchete de case 1 
             
            
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
       
     }
     
     
     
}
    
}
