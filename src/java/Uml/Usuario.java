package Uml;

import java.util.Date;

public class Usuario
{
  String name;
  String lastName;
  Date fechaNacimiento;
  boolean status;
  String image;
  String email;
  String password;
  String sexo;
  String direccion;
  String eliminate;
  Date created_at;
  Date lastSesion;
  
  public Usuario(String name, String lastName, Date fechaNacimiento, boolean status, String image, String email, String password, String sexo, String direccion, String eliminate, Date created_at, Date lastSesion)
  {
    this.name = name;
    this.lastName = lastName;
    this.fechaNacimiento = fechaNacimiento;
    this.status = status;
    this.image = image;
    this.email = email;
    this.password = password;
    this.sexo = sexo;
    this.direccion = direccion;
    this.eliminate = eliminate;
    this.created_at = created_at;
    this.lastSesion = lastSesion;
  }
  

  public Usuario() {}
  
  public String getName()
  {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }
  
  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }
  
  public boolean isStatus() {
    return status;
  }
  
  public void setStatus(boolean status) {
    this.status = status;
  }
  
  public String getImage() {
    return image;
  }
  
  public void setImage(String image) {
    this.image = image;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getSexo() {
    return sexo;
  }
  
  public void setSexo(String sexo) {
    this.sexo = sexo;
  }
  
  public String getDireccion() {
    return direccion;
  }
  
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
  
  public String getEliminate() {
    return eliminate;
  }
  
  public void setEliminate(String eliminate) {
    this.eliminate = eliminate;
  }
  
  public Date getCreated_at() {
    return created_at;
  }
  
  public void setCreated_at(Date created_at) {
    this.created_at = created_at;
  }
  
  public Date getLastSesion() {
    return lastSesion;
  }
  
  public void setLastSesion(Date lastSesion) {
    this.lastSesion = lastSesion;
  }
}