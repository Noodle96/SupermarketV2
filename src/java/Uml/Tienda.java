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
public class Tienda {
    int idTienda;
    String nameTienda;
    String departamento;
    String provincia;
    String direccion;
    String telefono;
    
    public Tienda(){}

    public Tienda(int idTienda ,String nameTienda, String departamento, String provincia, String direccion, String telefono) {
        this.idTienda = idTienda;
        this.nameTienda = nameTienda;
        this.departamento = departamento;
        this.provincia = provincia;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    
    
    public String getNameTienda() {
        return nameTienda;
    }

    public void setNameTienda(String nameTienda) {
        this.nameTienda = nameTienda;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
