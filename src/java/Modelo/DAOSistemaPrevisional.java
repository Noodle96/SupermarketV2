/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Uml.SistemaPrevisional;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author russel
 */
public class DAOSistemaPrevisional {
    Database db = new Database();
    public List<SistemaPrevisional> consultarSistemaPrevisional() throws SQLException{
        List<SistemaPrevisional> datos = new ArrayList();
        String sql = "select * from \"SistemaPrevisional\";";
        try {
          Class.forName(db.getDriver());
          Connection conn = DriverManager.getConnection(
            db.getUrl(), 
            db.getUsuario(),
            db.getContraseña()
          );

          PreparedStatement pst = conn.prepareStatement(sql);
          ResultSet rs = pst.executeQuery();
          while (rs.next()) {
            datos.add(new SistemaPrevisional(
                rs.getInt("idSistemaP"), 
                rs.getString("nameSistemaP"), 
                rs.getDouble("porcentajeAporte"), 
                rs.getString("descripcion")
            ));
          }
        }
        catch (ClassNotFoundException|SQLException e)
        {
          System.out.println(e);
        }
        return datos;
  }
}
