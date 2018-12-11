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
public class Proveedor {
    int idProveedor;
    String nameProveedor;
    String paisP;
    String departamentoP;
    String provinciaP;
    String direccionP;
    String homepageP;
    String telefonoP;
    String personaContacto;

    public Proveedor(int idProveedor, String nameProveedor, String paisP, String departamentoP, String provinciaP, String direccionP, String homepageP, String telefonoP, String personaContacto) {
        this.idProveedor = idProveedor;
        this.nameProveedor = nameProveedor;
        this.paisP = paisP;
        this.departamentoP = departamentoP;
        this.provinciaP = provinciaP;
        this.direccionP = direccionP;
        this.homepageP = homepageP;
        this.telefonoP = telefonoP;
        this.personaContacto = personaContacto;
    }
    
    public Proveedor(){}

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNameProveedor() {
        return nameProveedor;
    }

    public void setNameProveedor(String nameProveedor) {
        this.nameProveedor = nameProveedor;
    }

    public String getPaisP() {
        return paisP;
    }

    public void setPaisP(String paisP) {
        this.paisP = paisP;
    }

    public String getDepartamentoP() {
        return departamentoP;
    }

    public void setDepartamentoP(String departamentoP) {
        this.departamentoP = departamentoP;
    }

    public String getProvinciaP() {
        return provinciaP;
    }

    public void setProvinciaP(String provinciaP) {
        this.provinciaP = provinciaP;
    }

    public String getDireccionP() {
        return direccionP;
    }

    public void setDireccionP(String direccionP) {
        this.direccionP = direccionP;
    }

    public String getHomepageP() {
        return homepageP;
    }

    public void setHomepageP(String homepageP) {
        this.homepageP = homepageP;
    }

    public String getTelefonoP() {
        return telefonoP;
    }

    public void setTelefonoP(String telefonoP) {
        this.telefonoP = telefonoP;
    }

    public String getPersonaContacto() {
        return personaContacto;
    }

    public void setPersonaContacto(String personaContacto) {
        this.personaContacto = personaContacto;
    }
    
    
}