/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete;

/**
 *
 * @author Arturo
 */
public class Estadistica {
    
    public String nombre;
    public String lugar;
    public float cantidad;

    public Estadistica(String nombre, String lugar, int cantidad) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.cantidad = cantidad;
    }

    public Estadistica() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
