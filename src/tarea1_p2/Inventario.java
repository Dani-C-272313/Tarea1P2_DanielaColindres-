/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1_p2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniela
 */
public class Inventario {
    private ArrayList<Carritos> inventario = new ArrayList<>();
      private ArrayList<Carritos> autoRojo = new ArrayList<>();
      
      public void menuInventario() {
        String menuInven = """
                --- ADMINISTRACIÓN DE INVENTARIO ---
                1. Agregar vehículo
                2. Listar vehículos
                3. Modificar vehículo
                4. Eliminar vehículo
                5. Vehículo más antiguo
                6. Vehículos de color rojo
                7. Diferencia de años entre 2 vehículos
                0. Salir
                """;
        
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menuInven));
       while(opcion !=0){
         switch(opcion){
             
             case 1:{
              //agregar 
              Agregar(); 
              
                 break; 
             }// corchete de case 1 
             
             case 2:{
              //Listar 
              Listar();
                 break; 
             }// corchete de case 2
             
             case 3:{
              //Modificar 
                 break; 
             }// corchete de case 3
             
             case 4:{
              //Eliminar  
                 break; 
             }// corchete de case 4
             
             
             case 5:{
              // Vehiculo mas antiguo 
                 break; 
             }// corchete de case 5
             
             
             case 6:{
              //Vehiculos de color rojo 
                 break; 
             }// corchete de case 6
             
             
             case 7:{
              //Diferencia de años entre 2 vehículos
              
              
                 break; 
             }// corchete de case 7
             
            
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
      
      
} //corchete del switch
         
    opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menuInven));
         
       } //corchete de opcion
      } // corchete del metodo
      
      
   private void Agregar(){ 
       char resp = 's';
       
       while(resp == 's'){
       if (inventario.size()>50){
           JOptionPane.showMessageDialog(null,"El inventatrio esta lleno no se puede agregar un auto más");
           return;  //no se preocupe inge, se que cuando pongo esto es pq me va a sacar del metodo inmediatamente cuando entre al if
           
       }
       else{
            String matricula = JOptionPane.showInputDialog("Ingrese la matricula del auto: ");
            
            while(matricula.isBlank() || matricula.isEmpty() || matricula.length()<6 || matricula.length()>7){
               matricula = JOptionPane.showInputDialog(null, "Invalido! No se puede dejar vacío o en blanco.\nIngrese la matrícula del auto:");
                
            }
            
            
            
            String marca = JOptionPane.showInputDialog("Ingrese la marca del auto: ");
            while(marca.isBlank() || marca.isEmpty()){
               marca = JOptionPane.showInputDialog(null, "Invalido! No se puede dejar vacío o en blanco.\nIngrese la marca del auto:");
                
            }
            String modelo = JOptionPane.showInputDialog("Ingrese la modelo del auto: ");
            while(modelo.isBlank() || modelo.isEmpty()){
               modelo = JOptionPane.showInputDialog(null, "Invalido! No se puede dejar vacío o en blanco.\nIngrese la modelo del auto:");
                
            }
            
            String color = JOptionPane.showInputDialog("Ingrese la color del auto: ");
            while(color.isBlank() || color.isEmpty()){
               color = JOptionPane.showInputDialog(null, "Invalido! No se puede dejar vacío o en blanco.\nIngrese la color del auto:");
                
            }
            int año_fabricase = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de fabricacion"));
            while(año_fabricase<1886 || año_fabricase>2026){
               año_fabricase = Integer.parseInt(JOptionPane.showInputDialog(null, "Invalido! O no se habia ni creado el auto o estas viviendo en el futuro.\n Ingrese el año de fabricacion del auto:"));
                
            }
            
            
            float precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio"));
            while(precio<0 ){
               precio = Float.parseFloat(JOptionPane.showInputDialog(null, "¡Invalido! El precio no puede ser negativo.\n Ingrese el precio del auto:"));
                
            }
            
       Carritos carro = new Carritos ();
       carro.setMatricula(matricula);
       carro.setMarca(marca);
       carro.setModelo(modelo);
       carro.setColor(color);
       carro.setAñoFabicacion(año_fabricase);
       carro.setPrecio(precio);
       
       inventario.add(carro);
       
       if(color.equalsIgnoreCase("rojo")){
            autoRojo.add(carro);
       
       }
       
       String agregarFinalizado = "Carrito agregado! \n --------------------------\n\n  " +"matricula: " + matricula + "\n marca: " + marca + "\n color: " + color + "\n modelo: " + modelo + "\n añoFabicacion: " + año_fabricase + "\n precio: " + precio;;
       JOptionPane.showMessageDialog(null, agregarFinalizado);
       
       }//corchete del else
      
       String respuesta = JOptionPane.showInputDialog(null, "Desea agregar otro auto? ");
       resp = respuesta.charAt(0);
       
       }//corchete del resp
       
       
   }  // corchete del metodo agregar  
      
      public void Listar() {
   
ArrayList<Carritos> inventarioCopia = new ArrayList<>(inventario);

int n = inventarioCopia.size();
for (int i = 0; i < n - 1; i++) { // las vueltas de comparar 
    for (int j = 0; j < n - i - 1; j++) { // las letras a comparar
       
       String modelo1 = inventarioCopia.get(j).getModelo().toLowerCase();
        String modelo2 = inventarioCopia.get(j + 1).getModelo().toLowerCase();
        
        // Banderas para comparar letra por letra
        int k = 0;
        boolean necesitaIntercambio = false; // por eso es falso
        boolean Identicos = true; //supongo aqui que son identicos
        
 
        while (k < modelo1.length() && k < modelo2.length()) {
            char letra1 = modelo1.charAt(k);
            char letra2 = modelo2.charAt(k);
            
            if (letra1 != letra2) {
                Identicos = false;
               
                if (letra1 > letra2) {
                    necesitaIntercambio = true;
                }
                break; 
            }
            
            k++;
        }
        

        if (Identicos && modelo1.length() > modelo2.length()) {
            necesitaIntercambio = true;
        }
      
        if (necesitaIntercambio) {
            Carritos temporal = inventarioCopia.get(j);
            inventarioCopia.set(j, inventarioCopia.get(j + 1));
            inventarioCopia.set(j + 1, temporal);
        }
    

    }
}
    

String mensaje = "-------------------\n";
for (int i = 0; i < inventarioCopia.size(); i++) {
    mensaje +=  inventarioCopia.get(i) + "\n\n";
}


JOptionPane.showMessageDialog(null, mensaje);
}
      
   
      
      
}// corchete principal
