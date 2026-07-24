/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1_p2;

import javax.swing.JOptionPane;

/**
 *
 * @author Daniela
 */
public class Recursion {
    
      public void menuRecursion() {
        String menuInven = """
                --- ADMINISTRACIÓN DE INVENTARIO ---
                1. De decimal a binario
                2. Calcular el Maximo común divisor de dos números. 
                3. Serie de fibonacci
                4. Busqueda Binaria
                0. Salir
                """;

        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menuInven));
        while (opcion != 0) {
            switch (opcion) {

                case 1: {
                    int decimal = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el decimal"));
                
                    String resultadoBinario = decimal_a_Binario(decimal);
                    JOptionPane.showMessageDialog(null, "Binario:  " + resultadoBinario);
                    break;
                    
                }// corchete de case 1 

                case 2: {
                    int a = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el primer número:"));
                    int b = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el segundo número:"));
                    
                    int resultado = MCD(a, b);
                  
                    JOptionPane.showMessageDialog(null, "El MCD de " + a + " y " + b + " es: " + resultado);
                    break;
                 
                  
                }// corchete de case 2

                case 3: {
                    int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la posición (n) de la serie de Fibonacci:"));
                    
                    int res = Fibonacci(num);
                    JOptionPane.showMessageDialog(null, "El término " + num + " de Fibonacci es: " + res);
                    break;
                
               
                }// corchete de case 3

                case 4: {
                   int tamaño = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño del arreglo ordenado:"));
                    int[] arreglo = new int[tamaño];
                    
                    for (int i = 0; i < tamaño; i++) {
                        arreglo[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor para la posición " + i ));
                    }
                    ordenarBurbuja(arreglo);
                    
                    int buscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número que desea buscar:"));
                    int resBusqueda = busquedaBinaria(arreglo, 0, arreglo.length - 1, buscar);
                    
                    String mostrarArreglo = "Arreglo ordenado: ";
                    for (int i = 0; i < arreglo.length; i++) {
                        mostrarArreglo += "["+ arreglo[i]+"]";
                        if (i < arreglo.length - 1) {
                            mostrarArreglo += " ";
                        }
                    }
                    
                    if (resBusqueda != -1) {
                        JOptionPane.showMessageDialog(null,mostrarArreglo+ "Elemento se encontro en el índice: " + resBusqueda);
                        
                        
                    } 
                    
                    else {
                        JOptionPane.showMessageDialog(null, mostrarArreglo + "  Elemento no esta en el arreglo.");
                    }
                    break;
                   
                }// corchete de case 4

    
              
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
    
      private String decimal_a_Binario( int decimal){

  
if (decimal == 0) {
        return "0";
    }
    

    // Caso base 
    if (decimal / 2 == 0) {
        return String.valueOf(decimal % 2);
    }
    
    // caso recursivo
    return decimal_a_Binario(decimal/ 2) + (decimal % 2);
}

      
      
      private int MCD(int a, int b){
          if (b == 0) {
            return a;
        }
        return MCD(b, a % b);
      }
      
      
      private int Fibonacci(int num){
          if (num <= 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        }
        return Fibonacci(num - 1) + Fibonacci(num - 2);
      }
      
      
      
      private void ordenarBurbuja(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temporal = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temporal;
                }
            }
        }
    }
     
    private int busquedaBinaria(int[] arreglo, int izquierda, int derecha, int valorBuscado) {
        if (izquierda > derecha) {
            return -1;
        }

        int medio = izquierda + (derecha - izquierda) / 2;

        if (arreglo[medio] == valorBuscado) {
            return medio;
        }

        if (arreglo[medio] > valorBuscado) {
            return busquedaBinaria(arreglo, izquierda, medio - 1, valorBuscado);
        }

        return busquedaBinaria(arreglo, medio + 1, derecha, valorBuscado);
    }
    
}
