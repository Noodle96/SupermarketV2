/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uml;

/**
 *
 * @author russel
 */
public class ContratoEspecial {
    String nombre;
    String descripcion;

    public ContratoEspecial(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    ContratoEspecial(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
