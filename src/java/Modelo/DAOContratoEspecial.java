/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Uml.ContratoEspecial;
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
public class DAOContratoEspecial {
     Database db = new Database();
    
    public List<ContratoEspecial> consultar() throws SQLException{
        List<ContratoEspecial> datos = new ArrayList();
        String sql = "select * from \"ContratoEspecial\";";
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
            datos.add(new ContratoEspecial(
                rs.getString("nameContrato"),
                rs.getString("descripcion")
                                          )   
                    );
          }
        }
        catch (ClassNotFoundException|SQLException e)
        {
          System.out.println(e);
        }
        return datos;
  }
}
