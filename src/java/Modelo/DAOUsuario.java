package Modelo;

import Uml.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;







public class DAOUsuario
{
  public DAOUsuario() {}
  
  Database db = new Database();
  
  public String register(Usuario p) {
    int filas = 0;
    String sql = "INSERT INTO public.\"Usuario\"(\n\t\"nameUsuario\", \"lastNameUsuario\",  \"fechaNacimiento\","
            + "  email, password,sexo, direccion,created_at, \"lastSession\")\n\tVALUES (?,?,?,?,MD5('" + p.getPassword() + "'),?,?,'" + p.getCreated_at() + "', '" + p.getLastSesion() + "');";
    String respuesta = null;
    try {
      Class.forName(db.getDriver());
        try (Connection conn = DriverManager.getConnection(
                db.getUrl(),
                db.getUsuario(),
                db.getContraseña())) {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, p.getName());
            pst.setString(2, p.getLastName());
            pst.setDate(3, (Date) p.getFechaNacimiento());
            pst.setString(4, p.getEmail());
            pst.setString(5,p.getSexo());
            pst.setString(6, p.getDireccion());
            
            
            filas = pst.executeUpdate();
            respuesta = "Se insertaron " + filas + " elementos";
        }
    } catch (ClassNotFoundException|SQLException e) {
      System.out.println("error en register Usuario");
        System.out.println(e);
    }
    return respuesta;
  }
  
  
  
  
  
  public boolean AutentificacionUsuario(String email, String pass)
    throws SQLException {
    ResultSet rs = null;
    ResultSet rs1 = null;
    String sql = "SELECT * FROM \"Usuario\" WHERE"
            + " \"email\" = '"+email+"' AND"
            + "  \"password\"=MD5('"+pass+"');";
    String sql1 = "SELECT \"password\" FROM \"Usuario\" WHERE"
            + " \"email\" = '"+email+"';";
    try {
      Class.forName(db.getDriver());
      Connection conn = DriverManager.getConnection(
        db.getUrl(),
        db.getUsuario(),
        db.getContraseña()
      );
      PreparedStatement pst = conn.prepareStatement(sql);
      PreparedStatement pst1 = conn.prepareStatement(sql1);
      rs = pst.executeQuery();
      rs1 = pst1.executeQuery();
      rs1.next();
      while (rs.next()) {
        if (   (email.equals(rs.getString("email")))  && (rs1.getString("password").equals(rs.getString("password")))   ) {
          return true;
        }
      }
    } catch (ClassNotFoundException|SQLException e) {
        System.out.println("ERROR ENCONTRADO: ");
        System.out.println(e);
    }
    return false;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
