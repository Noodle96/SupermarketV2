package Modelo;

import Uml.Usuario;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;







public class DAOUsuario
{
  public DAOUsuario() {}
  
  Database db = new Database();
  
  public String register(Usuario p) {
    int filas = 0;
    String sql = "INSERT INTO public.\"Usuario\"(\n\t\"nameUsuario\", \"lastNameUsuario\", email, password,created_at, \"lastSession\")\n\tVALUES (?,?,?,MD5('" + p.getPassword() + "'),'" + p.getCreated_at() + "', '" + p.getLastSesion() + "');";
    String respuesta = null;
    try {
      Class.forName(db.getDriver());
      Connection conn = DriverManager.getConnection(db
        .getUrl(), db
        .getUsuario(), db
        .getContraseña());
      
      PreparedStatement pst = conn.prepareStatement(sql);
      pst.setString(1, p.getName());
      pst.setString(2, p.getLastName());
      pst.setString(3, p.getEmail());
      
      filas = pst.executeUpdate();
      respuesta = "Se insertaron " + filas + " elementos";
      conn.close();
    } catch (ClassNotFoundException|SQLException e) {
      System.out.println("error en register Usuario");
    }
    return respuesta;
  }
}
