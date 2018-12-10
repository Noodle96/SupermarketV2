/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Uml.Tienda;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
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
public class DAOTienda {
    Database db = new Database();
    
    
    
    public boolean insertTienda(Tienda t) throws ClassNotFoundException, SQLException{
        String sql = "select f_insertar_tienda(?,?,?,?,?);"; //funcion
        try {
          Class.forName(db.getDriver());
          Connection conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()
          );
          CallableStatement cs = conn.prepareCall(sql);
          cs.setString(1, t.getNameTienda());
          cs.setString(2, t.getDepartamento());
          cs.setString(3, t.getProvincia());
          cs.setString(4, t.getDireccion());
          cs.setString(5, t.getTelefono());
          return cs.execute();
        } catch (ClassNotFoundException|SQLException e) {
            System.out.println("ERROR ENCONTRADO: ");
            System.out.println(e);
        }
        return false;
    }
    
    
    
    public List<Tienda> consultarTienda(){
        List<Tienda> datos = new ArrayList();
        String sql = "select * from \"Tienda\";";
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
            datos.add(new Tienda(
                rs.getInt("idTienda"), 
                rs.getString("nameTienda"), 
                rs.getString("departamentoT"), 
                rs.getString("provinciaT"), 
                rs.getString("direccionT"),
                rs.getString("telefono")
            ));
          }
        }
        catch (ClassNotFoundException|SQLException e)
        {
          System.out.println(e);
        }
        return datos;
  }
    
    
    
    //other function
    
    
    
}