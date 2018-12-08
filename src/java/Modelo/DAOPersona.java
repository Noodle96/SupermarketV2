package Modelo;

import Uml.Persona;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOPersona
  implements Operaciones
{
  Database db = new Database();
  
  public DAOPersona() {}
  
  public String register(Persona p) { int filas = 0;
    
    String sql = "INSERT INTO public.\"Persona\"(\n\t\"dniPersona\", names, apellido1, apellido2, \"emailPersona\",sexo, password)\n\tVALUES (?,?,?,?,?,?,MD5('" + p.getPassword() + "'));";
    String respuesta = null;
    try {
      Class.forName(db.getDriver());
      Connection conn = DriverManager.getConnection(db.getUrl(),
         db.getUsuario(),
         db.getContraseña());
      
      PreparedStatement pst = conn.prepareStatement(sql);
      pst.setString(1, p.getDniPersona());
      pst.setString(2, p.getNames());
      pst.setString(3, p.getApellido1());
      pst.setString(4, p.getApellido2());
      pst.setString(5, p.getEmail());
      pst.setString(6, p.getSexo());
      



      filas = pst.executeUpdate();
      respuesta = "Se insertaron " + filas + " elementos";
      conn.close();
    } catch (ClassNotFoundException|SQLException e) {
      System.out.println("error en register Persona");
    }
    return respuesta;
  }
  @Override
  public String insertar(Object obj)
  {
    Persona p = (Persona)obj;
    

    String sql = "INSERT INTO public.\"Persona\"(\n\t\"dniPersona\", names, apellido1, apellido2, \"emailPersona\",  telefono, \"fechaNacimiento\", direccion, sexo, \"idTienda_Tienda\")\n\tVALUES (?,?,?,?,?,?,?,?,?,?);";
    

    String respuesta = null;
    try {
      Class.forName(db.getDriver());
      Connection conn = DriverManager.getConnection(db
        .getUrl(), db
        .getUsuario(), db
        .getContraseña());
      
      PreparedStatement pst = conn.prepareStatement(sql);
      pst.setString(1, p.getDniPersona());
      pst.setString(2, p.getNames());
      pst.setString(3, p.getApellido1());
      pst.setString(4, p.getApellido2());
      pst.setString(5, p.getEmail());
      pst.setString(6, p.getTelefono());
      pst.setDate(7, (Date)p.getFechaNacimiento());
      pst.setString(8, p.getDireccion());
      pst.setString(9, p.getSexo());
      pst.setInt(10, p.getIdTienda());
      int filas = pst.executeUpdate();
      respuesta = "Se insertaron " + filas + " elementos";
      conn.close();
    }
    catch (ClassNotFoundException|SQLException localClassNotFoundException) {}
    return respuesta;
  }
  
  
  @Override
  public String eliminar(Object obj)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
  
  
  @Override
  public String modificar(Object obj)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
  
  
  @Override
  public List<Persona> consultar()
  {
    List<Persona> datos = new ArrayList();
    


    String sql = "select * from \"Persona\";";
    try {
      Class.forName(db.getDriver());
      Connection conn = DriverManager.getConnection(db
        .getUrl(), db.getUsuario(), db.getContraseña());
      
      PreparedStatement pst = conn.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        datos.add(new Persona(rs
          .getString("dniPersona"), rs
          .getString("names"), rs
          .getString("image"), rs
          .getString("apellido1"), rs
          .getString("apellido2"), rs
          .getString("emailPersona"), rs
          .getBoolean("isWorking"), rs
          .getString("telefono"), rs
          .getDate("fechaInicioContrato"), rs
          .getDate("fechaFinalContrato"), rs
          .getDate("fechaNacimiento"), rs
          .getString("direccion"), rs
          .getString("sexo"), rs
          .getInt("idTienda_Tienda"), rs
          .getString("password")));
      }
    }
    catch (ClassNotFoundException|SQLException e)
    {
      System.out.println(e);
    }
    return datos;
  }
  
  @Override
  public List<?> filtrar(String Campo, String criterio)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  



  public boolean Autentificacion(String user, String pass, TestReferencia tr)
    throws SQLException
  {
    ResultSet rs = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    ResultSet rs3 = null;
    


    String sql = " SELECT * FROM \"Persona\" WHERE \"emailPersona\" = '" + user + "' and  \"password\" = MD5('" + pass + "'); ";
    String passTemp = " SELECT \"password\" FROM \"Persona\" WHERE \"emailPersona\" = '" + user + "' ;";
    String recursos = "SELECT * FROM \"AdminRecursos\";";
    String Humanidades = "SELECT * FROM \"AdminHumanidades\";";
    try {
      Class.forName(db.getDriver());
      Connection conn = DriverManager.getConnection(db
        .getUrl(), db.getUsuario(), db.getContraseña());
      
      PreparedStatement pst = conn.prepareStatement(sql);
      PreparedStatement pst1 = conn.prepareStatement(passTemp);
      PreparedStatement pst2 = conn.prepareStatement(recursos);
      PreparedStatement pst3 = conn.prepareStatement(Humanidades);
      rs = pst.executeQuery();
      rs1 = pst1.executeQuery();
      rs2 = pst2.executeQuery();
      rs3 = pst3.executeQuery();
      rs1.next();
      String Valor = "alguno";
      while (rs.next()) {
        String dniPersonaActual = rs.getString("dniPersona");
        
        while (rs2.next()) {
          if (dniPersonaActual.equals(rs2.getString("dniPersona_Persona_Administrador"))) {
            Valor = "adminRecursos";
          }
        }
        
        while (rs3.next()) {
          if (dniPersonaActual.equals(rs3.getString("dniPersona_Persona_Administrador"))) {
            Valor = "adminHumanidades";
          }
        }
        
        if ((user.equals(rs.getString("emailPersona"))) && (rs1.getString("password").equals(rs.getString("password")))) {
          return true;
        }
      }
    } catch (ClassNotFoundException|SQLException e) {
      System.out.println(e);
      System.out.println("y error en la autentificacion");
    }
    return false;
  }
}