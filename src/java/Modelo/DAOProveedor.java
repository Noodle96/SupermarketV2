/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Uml.Proveedor;
import java.sql.CallableStatement;
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
public class DAOProveedor {
    Database db = new Database();
    public List<Proveedor> consultarProveedor() throws SQLException{
        List<Proveedor> datos = new ArrayList();
        String sql = "select * from \"Proveedor\";";
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
            datos.add(new Proveedor(
                rs.getInt("idProveedor"),
                rs.getString("nameProveedor"),
                rs.getString("pais"),
                rs.getString("departamento"),
                rs.getString("provincia"),
                rs.getString("direccion"),
                rs.getString("homepage"),
                rs.getString("telefono"),
                rs.getString("personaContacto") )
                                           
                    );
          }
        }
        catch (ClassNotFoundException|SQLException e)
        {
          System.out.println(e);
        }
        return datos;
  }
  //insertando nuevos proveedores
  public boolean insertarProveedor(Proveedor p) throws ClassNotFoundException, SQLException{
        //select f_insertar_Proveedor('keniaSoya','Colombia','Bogota','Bogota','arces 454',
        //                             'www.keniasoya.com','343534','Jorge');

        String sql = "select f_insertar_Proveedor(?,?,?,?,?,?,?,?);";
        try {
          Class.forName(db.getDriver());
          Connection conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()
          );
          CallableStatement cs = conn.prepareCall(sql);
          cs.setString(1, p.getNameProveedor());
          cs.setString(2, p.getPaisP());
          cs.setString(3, p.getDepartamentoP());
          cs.setString(4, p.getProvinciaP());
          cs.setString(5, p.getDireccionP());
          cs.setString(6, p.getHomepageP());
          cs.setString(7, p.getTelefonoP());
          cs.setString(8, p.getPersonaContacto());
          return cs.execute();
        } catch (ClassNotFoundException|SQLException e) {
            System.out.println("ERROR ENCONTRADO EN insertarMercaderista: ");
            System.out.println(e);
            //eR.r  = (SQLException) e;
        }
        return false;
    }
}
