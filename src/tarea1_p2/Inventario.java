/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1_p2;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import tarea1_p2.Carritos;

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
        while (opcion != 0) {
            switch (opcion) {

                case 1: {
                    //agregar 
                    Agregar();

                    break;
                }// corchete de case 1 

                case 2: {
                    //Listar 
                    Listar();
                    break;
                }// corchete de case 2

                case 3: {
                    //Modificar 
                    modificar();
                    break;
                }// corchete de case 3

                case 4: {
                    //Eliminar 
                    remove();
                    break;
                }// corchete de case 4

                case 5: {
                    // Vehiculo mas antiguo
                    másAntiguo();
                    break;
                }// corchete de case 5

                case 6: {
                    //Vehiculos de color rojo 
                    listarRojo();
                    break;
                }// corchete de case 6

                case 7: {
                    //Diferencia de años entre 2 vehículos

                    break;
                }// corchete de case 7

                default:
                    try {
                        throw new Exception();
                    } catch (Exception e) {

                        String mensajeExcception = "";
                        for (int i = 0; i < 51; i++) {
                            mensajeExcception += "Nuh huh, exception \n";

                        }
                        JOptionPane.showMessageDialog(null, mensajeExcception);
                        break;
                    }

            } //corchete del switch

            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menuInven));

        } //corchete de opcion
    } // corchete del metodo

    private void Agregar() {
        char resp = 's';

        while (resp == 's') {
            if (inventario.size() > 50) {
                JOptionPane.showMessageDialog(null, "El inventatrio esta lleno no se puede agregar un auto más");
                return;  //no se preocupe inge, se que cuando pongo esto es pq me va a sacar del metodo inmediatamente cuando entre al if

            } else {
                String matricula = JOptionPane.showInputDialog("Ingrese la matricula del auto: ");

                while (matricula.isBlank() || matricula.isEmpty() || matricula.length() < 6 || matricula.length() > 7) {
                    matricula = JOptionPane.showInputDialog(null, "Invalido! No se puede dejar vacío o en blanco.\nIngrese la matrícula del auto:");

                }

                String marca = JOptionPane.showInputDialog("Ingrese la marca del auto: ");
                while (marca.isBlank() || marca.isEmpty()) {
                    marca = JOptionPane.showInputDialog(null, "Invalido! No se puede dejar vacío o en blanco.\nIngrese la marca del auto:");

                }
                String modelo = JOptionPane.showInputDialog("Ingrese la modelo del auto: ");
                while (modelo.isBlank() || modelo.isEmpty()) {
                    modelo = JOptionPane.showInputDialog(null, "Invalido! No se puede dejar vacío o en blanco.\nIngrese la modelo del auto:");

                }

                String color = JOptionPane.showInputDialog("Ingrese la color del auto: ");
                while (color.isBlank() || color.isEmpty()) {
                    color = JOptionPane.showInputDialog(null, "Invalido! No se puede dejar vacío o en blanco.\nIngrese la color del auto:");

                }
                int año_fabricase = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de fabricacion"));
                while (año_fabricase < 1886 || año_fabricase > 2026) {
                    año_fabricase = Integer.parseInt(JOptionPane.showInputDialog(null, "Invalido! O no se habia ni creado el auto o estas viviendo en el futuro.\n Ingrese el año de fabricacion del auto:"));

                }

                float precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio"));
                while (precio < 0) {
                    precio = Float.parseFloat(JOptionPane.showInputDialog(null, "¡Invalido! El precio no puede ser negativo.\n Ingrese el precio del auto:"));

                }

                Carritos carro = new Carritos();
                carro.setMatricula(matricula);
                carro.setMarca(marca);
                carro.setModelo(modelo);
                carro.setColor(color);
                carro.setAñoFabicacion(año_fabricase);
                carro.setPrecio(precio);

                inventario.add(carro);

                if (color.equalsIgnoreCase("rojo")) {
                    autoRojo.add(carro);

                }

                String agregarFinalizado = "Carrito agregado! \n --------------------------\n\n  " + "matricula: " + matricula + "\n marca: " + marca + "\n color: " + color + "\n modelo: " + modelo + "\n añoFabicacion: " + año_fabricase + "\n precio: " + precio;;
                JOptionPane.showMessageDialog(null, agregarFinalizado);

            }//corchete del else

            String respuesta = JOptionPane.showInputDialog(null, "Desea agregar otro auto? ");
            resp = respuesta.charAt(0);

        }//corchete del resp

    }  // corchete del metodo agregar  

    public void Listar() {

        if (verificar() == true) {
            JOptionPane.showMessageDialog(null, "Error, no se puede por que el inventario esta vacio");
            return;
        }
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
            mensaje += inventarioCopia.get(i) + "\n\n";
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }

    private void modificar() {
        if (verificar() == true) {
            JOptionPane.showMessageDialog(null, "Error, no se puede por que el inventario esta vacio");
            return;
        }
        int opcion = 0;
        String listaMatricula = "-----------------------\n\n";
        for (int i = 0; i < inventario.size(); i++) {
            listaMatricula += (i + 1) + inventario.get(i).getMatricula() + "\n";
            

        }
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null, listaMatricula + "\n Ingrese el numero de la matricula que desea modificar"));
        if (opcion < 1 || opcion > inventario.size()) {
        JOptionPane.showMessageDialog(null, "Número inválido.");
        return;
    }
        
        inventario.get((opcion - 1));
        char resp = 's';

        while (resp == 's') {
            String menu_cambios = """
                             ------------------------------
                             1. Marca
                             2. Modelo
                             3. Color
                             4. Año de Fabricacion 
                             5. Precio
                             0. salir 
                             
                             Ingrese el numero del cual quiere modificar...
                             """;

            int nue_opcion = opcion - 1;
            int op = Integer.parseInt(JOptionPane.showInputDialog(null, menu_cambios));

            switch (op) {

                case 1: {
                    inventario.get(nue_opcion).getMarca();
                    String nueva_marca = JOptionPane.showInputDialog(null, "Ingrese la nueva marca");
                    while (nueva_marca.isBlank() || nueva_marca.isEmpty()) {
                        nueva_marca = JOptionPane.showInputDialog(null, "Invalido! No se puede dejar vacío o en blanco.\nIngrese la matrícula del auto:");

                    }

                    inventario.get(nue_opcion).setMarca(nueva_marca);
                    JOptionPane.showMessageDialog(null, " --------------------------- \n" + inventario.get(nue_opcion));
                    break;
                }

                case 2: {
                    inventario.get(nue_opcion).getModelo();
                    String nuevo_modelo = JOptionPane.showInputDialog(null, "Ingrese el nuevo modelo");

                    while (nuevo_modelo.isBlank() || nuevo_modelo.isEmpty()) {
                        nuevo_modelo = JOptionPane.showInputDialog(null, "Invalido! No se puede dejar vacío o en blanco.\nIngrese la matrícula del auto:");

                    }

                    inventario.get(nue_opcion).setModelo(nuevo_modelo);
                    JOptionPane.showMessageDialog(null, " --------------------------- \n" + inventario.get(nue_opcion));
                    break;
                }
                case 3: {
                    inventario.get(nue_opcion).getColor();
                    String nuevo_color = JOptionPane.showInputDialog(null, "Ingrese el nuevo color");

                    while (nuevo_color.isBlank() || nuevo_color.isEmpty()) {
                        nuevo_color = JOptionPane.showInputDialog(null, "Invalido! No se puede dejar vacío o en blanco.\n Ingrese la matrícula del auto:");

                    }
                    if (nuevo_color.equalsIgnoreCase("rojo")) {
                        inventario.get(nue_opcion).setColor(nuevo_color);
                        autoRojo.add(inventario.get(nue_opcion));
                        break;
                    } 
                    else if (inventario.get(nue_opcion).getColor().equalsIgnoreCase("rojo")) {
                        boolean encontrar = false;

                        String matricula_buscar = inventario.get(nue_opcion).getMatricula();
                        for (int i = 0; i < autoRojo.size(); i++) {
                            String matriculaActual = autoRojo.get(i).getMatricula();

                            if (matriculaActual.equalsIgnoreCase(matricula_buscar)) {
                                System.out.println("¡Carro encontrado!\n\n" + autoRojo.get(i));
                                encontrar = true;
                                autoRojo.remove(i);
                                break;
                            }
                        }
                    }
                    inventario.get(nue_opcion).setColor(nuevo_color);
                    JOptionPane.showMessageDialog(null, " --------------------------- \n" + inventario.get(nue_opcion));

                    break;

                }

                case 4: {
                    inventario.get(nue_opcion).getAñoFabicacion();
                    int nuevo_añoF = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo Año de Fabricacion"));

                    while (nuevo_añoF < 1886 || nuevo_añoF > 2026) {
                        nuevo_añoF = Integer.parseInt(JOptionPane.showInputDialog(null, "Invalido! O no se habia ni creado el auto o estas viviendo en el futuro.\n Ingrese el año de fabricacion del auto:"));

                    }

                    inventario.get(nue_opcion).setAñoFabicacion(nuevo_añoF);
                    JOptionPane.showMessageDialog(null, " --------------------------- \n" + inventario.get(nue_opcion));
                    break;
                }

                case 5: {
                    inventario.get(nue_opcion).getPrecio();
                    float nuevo_precio = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el nuevo precio"));
                    while (nuevo_precio < 0) {
                        nuevo_precio = Float.parseFloat(JOptionPane.showInputDialog(null, "¡Invalido! El precio no puede ser negativo.\n Ingrese el precio del auto:"));

                    }

                    inventario.get(nue_opcion).setPrecio(nuevo_precio);
                    JOptionPane.showMessageDialog(null, " --------------------------- \n" + inventario.get(nue_opcion));
                    break;
                }

                case 0: {
                    break;
                }

                default:
                    try {
                        throw new Exception();
                    } catch (Exception e) {

                        String mensajeExcception = "";
                        for (int i = 0; i < 51; i++) {
                            mensajeExcception += "Nuh huh, exception \n";

                        }
                        JOptionPane.showMessageDialog(null, mensajeExcception);
                        break;

                    }

            }// corchete del switch

            String respuesta = JOptionPane.showInputDialog(null, "Desea modificar otro auto? s/n ");
            resp = respuesta.charAt(0);

        }//coechwte del while 

    }   //corchete del metodo 
    
    
    private void remove(){
          if (verificar() == true) {
            JOptionPane.showMessageDialog(null, "Error, no se puede por que el inventario esta vacio");
            return;
        }
          
          if (inventario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El inventario se ha quedado vacío.");
            return;
        }
        
 char resp = 's';

        while (resp == 's') {
          
        int opcion = 0;
        String listaMatricula = "-----------------------\n\n";
        for (int i = 0; i < inventario.size(); i++) {
            listaMatricula += (i + 1) + inventario.get(i).getMatricula() + "\n";
            

        }
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null, listaMatricula + "\n Ingrese el numero de la matricula que desea eliminar"));
        
        if (opcion < 1 || opcion > inventario.size()) {
        JOptionPane.showMessageDialog(null, "Número inválido.");
       continue; //lo vimos con el inge rafa
    }
        
        
          int nue_opcion = opcion - 1;
        inventario.get((nue_opcion));
       
             
            JOptionPane.showMessageDialog(null, "eliminando vehiculo....");
            
            if(inventario.get(nue_opcion).getColor().equalsIgnoreCase("rojo")){
                 boolean encontrar = false;

                        String matricula_buscar = inventario.get(nue_opcion).getMatricula();
                        for (int i = 0; i < autoRojo.size(); i++) {
                            String matriculaActual = autoRojo.get(i).getMatricula();

                            if (matriculaActual.equalsIgnoreCase(matricula_buscar)) {
                                System.out.println("¡Carro encontrado!\n\n" + autoRojo.get(i));
                                encontrar = true;
                                autoRojo.remove(i);
                                break;
                            }
                        }
                    }
            
                inventario.remove(nue_opcion);
            JOptionPane.showMessageDialog(null, "¡Vehículo eliminado con éxito!");
            }
        
        String respuesta = JOptionPane.showInputDialog(null, "Desea eliminar otro auto? s/n ");
            resp = respuesta.charAt(0);
            
        }
    
    
    private void listarRojo(){
    if (verificar() == true) {
            JOptionPane.showMessageDialog(null, "Error, no se puede por que el inventario esta vacio");
            return;
        }
        ArrayList<Carritos> rojosCopia = new ArrayList<>(autoRojo);

        int n = rojosCopia.size();
        for (int i = 0; i < n - 1; i++) { // las vueltas de comparar 
            for (int j = 0; j < n - i - 1; j++) { // las letras a comparar

                String modelo1 = rojosCopia.get(j).getModelo().toLowerCase();
                String modelo2 = rojosCopia.get(j + 1).getModelo().toLowerCase();

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
                    Carritos temporal = rojosCopia.get(j);
                    rojosCopia.set(j, rojosCopia.get(j + 1));
                    rojosCopia.set(j + 1, temporal);
                }

            }
        }
         String mensaje = "-------------------\n";
        for (int i = 0; i < rojosCopia.size(); i++) {
            mensaje += rojosCopia.get(i) + "\n\n";
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    
    private void másAntiguo(){
        if (verificar() == true) {
        JOptionPane.showMessageDialog(null, "Error, no se puede por que el inventario esta vacio");
        return;
    }
    

    ArrayList<Carritos> inventarioCopia = new ArrayList<>(inventario);

    int n = inventarioCopia.size();
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {

            int anio1 = inventarioCopia.get(j).getAñoFabicacion();
            int anio2 = inventarioCopia.get(j + 1).getAñoFabicacion();

         
            if (anio1 < anio2) {
                Carritos temporal = inventarioCopia.get(j);
                inventarioCopia.set(j, inventarioCopia.get(j + 1));
                inventarioCopia.set(j + 1, temporal);
            }
        }
    }
    
    int last = inventarioCopia.size() - 1;


    String mens = "--- El carro más clasico ---\n";
    mens += inventarioCopia.get(last) + "\n\n";
    
    JOptionPane.showMessageDialog(null, mens);
}

private void diferenciaAños(){
if (verificar() == true) {
        JOptionPane.showMessageDialog(null, "Error, no se puede porque el inventario está vacío");
        return;
    }

    // 1. Mostrar la lista con sus índices o matrículas para que el usuario elija
    String listaAutos = "--- SELECCIONE EL PRIMER AUTO ---\n";
    for (int i = 0; i < inventario.size(); i++) {
        listaAutos += i + ". " + inventario.get(i).getModelo() + " - Matrícula: " + inventario.get(i).getMatricula() + "\n";
    }

    int indice1 = Integer.parseInt(JOptionPane.showInputDialog(null, listaAutos + "\nIngrese el índice o número del primer auto:"));

    // 2. Mostrar la lista de nuevo para el segundo auto
    listaAutos = "--- SELECCIONE EL SEGUNDO AUTO ---\n";
    for (int i = 0; i < inventario.size(); i++) {
        listaAutos += i + ". " + inventario.get(i).getModelo() + " - Matrícula: " + inventario.get(i).getMatricula() + "\n";
    }

    int indice2 = Integer.parseInt(JOptionPane.showInputDialog(null, listaAutos + "\nIngrese el índice o número del segundo auto:"));

    // 3. Validar que los índices existan
    if (indice1 >= 0 && indice1 < inventario.size() && indice2 >= 0 && indice2 < inventario.size()) {
        Carritos auto1 = inventario.get(indice1);
        Carritos auto2 = inventario.get(indice2);

        // 4. Calcular la diferencia (por ejemplo, diferencia de años en valor absoluto)
        int diferenciaAnios = Math.abs(auto1.getAñoFabicacion()- auto2.getAñoFabicacion());
        
        // Si quieres diferencia de precios, puedes cambiarlo por: double diferenciaPrecio = Math.abs(auto1.getPrecio() - auto2.getPrecio());

        // 5. Mostrar el resultado
        JOptionPane.showMessageDialog(null, 
            "--- DIFERENCIA ENTRE AUTOS ---\n" +
            "Auto 1: " + auto1.getModelo() + " (Año: " + auto1.getAñoFabicacion() + ")\n" +
            "Auto 2: " + auto2.getModelo() + " (Año: " + auto2.getAñoFabicacion() + ")\n\n" +
            "Diferencia de años: " + diferenciaAnios + " años"
        );
    } else {
        JOptionPane.showMessageDialog(null, "Error: Uno o ambos índices son inválidos.");
    }
}    
    
    private boolean verificar() {
        boolean ver = false;
        if (inventario.size() == 0 || inventario.size() < 0) {
            ver = true;
        }
        return ver;
    }
    
    
    

}// corchete principal
