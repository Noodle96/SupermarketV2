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
public class SistemaPrevisional {
    int idSistema;
    String nameSistema;
    double porcentaje;
    String descripcion;

    public SistemaPrevisional(int idSistema, String nameSistema, double porcentaje, String descripcion) {
        this.idSistema = idSistema;
        this.nameSistema = nameSistema;
        this.porcentaje = porcentaje;
        this.descripcion = descripcion;
    }
    public SistemaPrevisional(){}

    public int getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(int idSistema) {
        this.idSistema = idSistema;
    }

    public String getNameSistema() {
        return nameSistema;
    }

    public void setNameSistema(String nameSistema) {
        this.nameSistema = nameSistema;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
