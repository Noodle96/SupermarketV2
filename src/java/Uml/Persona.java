package Uml;

import java.util.Date;

public class Persona
{
  String dniPersona;
  String names;
  String image;
  String apellido1;
  String apellido2;
  String email;
  boolean isWorking;
  String telefono;
  Date fechaInicioCon;
  Date fechaFinalCon;
  Date fechaNacimiento;
  String direccion;
  String sexo;
  int idTienda;
  String password;
  String nameSistema;
  
  //de Admin Humanidades
  String tipoContrato;
  
  public Persona() {}
  
  public Persona(String dniPersona, String names, String image, String apellido1, String apellido2, String email, boolean isWorking, String telefono, Date fechaInicioCon, Date fechaFinalCon, Date fechaNacimiento, String direccion, String sexo, int idTienda, String password)
  {
    this.dniPersona = dniPersona;
    this.names = names;
    this.image = image;
    this.apellido1 = apellido1;
    this.apellido2 = apellido2;
    this.email = email;
    this.isWorking = isWorking;
    this.telefono = telefono;
    this.fechaInicioCon = fechaInicioCon;
    this.fechaFinalCon = fechaFinalCon;
    this.fechaNacimiento = fechaNacimiento;
    this.direccion = direccion;
    this.sexo = sexo;
    this.idTienda = idTienda;
    this.password = password;
  }

    public Persona(String dni, String names, String email, java.sql.Date fechaInicioC,
            java.sql.Date fechaNac, String sexo, String nameCon) {
        this.dniPersona = dni;
        this.names = names;
        this.email = email;
        this.fechaInicioCon = fechaInicioC;
        this.fechaNacimiento = fechaNac;
        this.sexo = sexo;
        this.tipoContrato = nameCon;
    }
    public Persona(String dni, String names,String apell1, String email, java.sql.Date fechaInicioC,
            java.sql.Date fechaNac, String sexo, String namesiste) {
        this.dniPersona = dni;
        this.names = names;
        this.apellido1 = apell1;
        this.email = email;
        this.fechaInicioCon = fechaInicioC;
        this.fechaNacimiento = fechaNac;
        this.sexo = sexo;
        this.nameSistema = namesiste;
    }

    public String getNameSistema() {
        return nameSistema;
    }

    public void setNameSistema(String nameSistema) {
        this.nameSistema = nameSistema;
    }
  
  public String getPassword() { return password; }
  
  public void setPassword(String pass) {
    password = pass;
  }
  
  public String getDniPersona() {
    return dniPersona;
  }
  
  public void setDniPersona(String dniPersona) {
    this.dniPersona = dniPersona;
  }
  
  public String getNames() {
    return names;
  }
  
  public void setNames(String names) {
    this.names = names;
  }
  
  public String getImage() {
    return image;
  }
  
  public void setImage(String image) {
    this.image = image;
  }
  
  public String getApellido1() {
    return apellido1;
  }
  
  public void setApellido1(String apellido1) {
    this.apellido1 = apellido1;
  }
  
  public String getApellido2() {
    return apellido2;
  }
  
  public void setApellido2(String apellido2) {
    this.apellido2 = apellido2;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public boolean isIsWorking() {
    return isWorking;
  }
  
  public void setIsWorking(boolean isWorking) {
    this.isWorking = isWorking;
  }
  
  public String getTelefono() {
    return telefono;
  }
  
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
  
  public Date getFechaInicioCon() {
    return fechaInicioCon;
  }
  
  public void setFechaInicioCon(Date fechaInicioCon) {
    this.fechaInicioCon = fechaInicioCon;
  }
  
  public Date getFechaFinalCon() {
    return fechaFinalCon;
  }
  
  public void setFechaFinalCon(Date fechaFinalCon) {
    this.fechaFinalCon = fechaFinalCon;
  }
  
  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }
  
  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }
  
  public String getDireccion() {
    return direccion;
  }
  
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
  
  public String getSexo() {
    return sexo;
  }
  
  public void setSexo(String sexo) {
    this.sexo = sexo;
  }
  
  public int getIdTienda() {
    return idTienda;
  }
  
  public void setIdTienda(int idTienda) {
    this.idTienda = idTienda;
  }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

  
}