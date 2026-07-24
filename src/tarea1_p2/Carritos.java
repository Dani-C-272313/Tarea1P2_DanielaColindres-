/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1_p2;

/**
 *
 * @author Daniela
 */


//  matrícula, marca, modelo, color, año de fabricación y precio.
public class Carritos {
    
    private String matricula; 
    private String marca; 
    private String color; 
    private String modelo; 
    private int añoFabicacion; 
    private float precio; 
    
    //constructor vacio 
    public Carritos(){
        
    }

    //constructor 
    public Carritos(String matricula, String marca, String color, String modelo, int añoFabicacion, float precio) {
        this.matricula = matricula;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.añoFabicacion = añoFabicacion;
        this.precio = precio;
    }

    // getters
    
    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAñoFabicacion() {
        return añoFabicacion;
    }

    public float getPrecio() {
        return precio;
    }
    
    // Setters

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAñoFabicacion(int añoFabicacion) {
        this.añoFabicacion = añoFabicacion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "matricula: " + matricula + "\n marca: " + marca + "\n color: " + color + "\n modelo: " + modelo + "\n añoFabicacion: " + añoFabicacion + "\n precio: " + precio;
    }
    
    
    
}
