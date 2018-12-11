package Modelo;

import Uml.Persona;
import java.sql.CallableStatement;
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
            tr.Valor = "adminRecursos";
          }
        }
        
        while (rs3.next()) {
          if (dniPersonaActual.equals(rs3.getString("dniPersona_Persona_Administrador"))) {
            tr.Valor = "adminHumanidades";
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
  
  
  public boolean insertarAdminHumanidades(Persona p, String tipoC) throws ClassNotFoundException, SQLException{
        String sql = "select f_insertar_admin_human(?,?,?,?,?,?,?,?,?,?,?, MD5('"+p.getNames()+"'),?);";
        try {
          Class.forName(db.getDriver());
          Connection conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()
          );
          CallableStatement cs = conn.prepareCall(sql);
          cs.setString(1, p.getDniPersona());
          cs.setString(2, p.getNames());
          cs.setString(3, p.getApellido1());
          cs.setString(4, p.getApellido2());
          cs.setString(5, p.getEmail());
          cs.setString(6, p.getTelefono());
          cs.setDate(7, (Date) p.getFechaInicioCon());
          cs.setDate(8, (Date) p.getFechaNacimiento());
          cs.setString(9, p.getDireccion());
          cs.setString(10, p.getSexo());
          cs.setInt(11, p.getIdTienda());
          cs.setString(12, tipoC);
          return cs.execute();
        } catch (ClassNotFoundException|SQLException e) {
            System.out.println("ERROR ENCONTRADO: ");
            System.out.println(e);
            //eR.r  = (SQLException) e;
        }
        return false;
    }
  
  
  
  
  
  public boolean insertarAdminRecursos(Persona p,String nameC) throws ClassNotFoundException, SQLException{
        //here
        String sql = "select f_insertar_admin_Recursos(?,?,?,?,?,?,?,?,?,?,?, MD5('"+p.getNames()+"'),?);";
        try {
          Class.forName(db.getDriver());
          Connection conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()
          );
          CallableStatement cs = conn.prepareCall(sql);
          cs.setString(1, p.getDniPersona());
          cs.setString(2, p.getNames());
          cs.setString(3, p.getApellido1());
          cs.setString(4, p.getApellido2());
          cs.setString(5, p.getEmail());
          cs.setString(6, p.getTelefono());
          cs.setDate(7, (Date) p.getFechaInicioCon());
          cs.setDate(8, (Date) p.getFechaNacimiento());
          cs.setString(9, p.getDireccion());
          cs.setString(10, p.getSexo());
          cs.setInt(11, p.getIdTienda());
          cs.setString(12, nameC);
          return cs.execute();
        } catch (ClassNotFoundException|SQLException e) {
            System.out.println("ERROR ENCONTRADO: ");
            System.out.println(e);
            //eR.r  = (SQLException) e;
        }
        return false;
    }
  
  
  
  
  public boolean insertarPersonal(Persona p,int idSistema) throws ClassNotFoundException, SQLException{
        //here
        String sql = "select f_insertar_Personal(?,?,?,?,?,?,?,?,?,?,?, MD5('"+p.getNames()+"'),?);";
        try {
          Class.forName(db.getDriver());
          Connection conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()
          );
          CallableStatement cs = conn.prepareCall(sql);
          cs.setString(1, p.getDniPersona());
          cs.setString(2, p.getNames());
          cs.setString(3, p.getApellido1());
          cs.setString(4, p.getApellido2());
          cs.setString(5, p.getEmail());
          cs.setString(6, p.getTelefono());
          cs.setDate(7, (Date) p.getFechaInicioCon());
          cs.setDate(8, (Date) p.getFechaNacimiento());
          cs.setString(9, p.getDireccion());
          cs.setString(10, p.getSexo());
          cs.setInt(11, p.getIdTienda());
          cs.setInt(12, idSistema);
          return cs.execute();
        } catch (ClassNotFoundException|SQLException e) {
            System.out.println("ERROR ENCONTRADO: ");
            System.out.println(e);
            //eR.r  = (SQLException) e;
        }
        return false;
    }
  
  
  
  
  
   public List<Persona> consultarPersonal() throws ClassNotFoundException, SQLException{
        List<Persona> datos = new ArrayList();
        String sql = "select * from  reportePersonal()";
        try {
          Class.forName(db.getDriver());
          Connection conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()
          );
          CallableStatement cs = conn.prepareCall(sql);
          ResultSet rs = cs.executeQuery();
         while (rs.next()) {
            datos.add(new Persona(
               rs.getString("dni"),
               rs.getString("nam"),
               rs.getString("apell1"),
               rs.getString("correo"),
               rs.getDate("fechaic"),
               rs.getDate("fechan"),
               rs.getString("sex"),
               rs.getString("namesiste")   
            ));
      }
        } catch (ClassNotFoundException|SQLException e) {
            System.out.println("ERROR ENCONTRADO: ");
            System.out.println(e);
            //eR.r  = (SQLException) e;
        }
         return datos;
    }
  
  
  
  
  
  
  
  
   public List<Persona> consultarAdminRecursos(){
    List<Persona> datos = new ArrayList();
    String sql = "select PER.\"dniPersona\", PER.\"names\", PER.\"emailPersona\",\n" +
                "PER.\"fechaInicioContrato\" , PER.\"fechaNacimiento\",\n" +
                "PER.\"sexo\", ADM.\"nameContrato_ContratoEspecial\"\n" +
                "from \"Persona\" as PER\n" +
                "inner Join \"Administrador\" as ADM on PER.\"dniPersona\" = ADM.\"dniPersona_Persona\"\n" +
                "inner join \"AdminRecursos\" as ADMR on ADM.\"dniPersona_Persona\" = ADMR.\"dniPersona_Persona_Administrador\";";
    
    try {
      Class.forName(db.getDriver());
      Connection conn = DriverManager.getConnection(db
        .getUrl(), db.getUsuario(), db.getContraseña());
      
      PreparedStatement pst = conn.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        datos.add(new Persona(
           rs.getString("dniPersona"),
           rs.getString("names"),
           rs.getString("emailPersona"),
           rs.getDate("fechaInicioContrato"),
           rs.getDate("fechaNacimiento"),
           rs.getString("sexo"),
           rs.getString("nameContrato_ContratoEspecial")   
        ));
      }
    }
    catch (ClassNotFoundException|SQLException e)
    {
      System.out.println(e);
    }
    return datos;
  }
  
   
   public List<Persona> consultarAdminHumanidades(){
    List<Persona> datos = new ArrayList();
    String sql = "select PER.\"dniPersona\", PER.\"names\", PER.\"emailPersona\",\n" +
                "PER.\"fechaInicioContrato\" , PER.\"fechaNacimiento\",\n" +
                "PER.\"sexo\", ADM.\"nameContrato_ContratoEspecial\"\n" +
                "from \"Persona\" as PER\n" +
                "inner Join \"Administrador\" as ADM on PER.\"dniPersona\" = ADM.\"dniPersona_Persona\"\n" +
                "inner join \"AdminHumanidades\" as ADMR on ADM.\"dniPersona_Persona\" = ADMR.\"dniPersona_Persona_Administrador\";";
    
    try {
      Class.forName(db.getDriver());
      Connection conn = DriverManager.getConnection(db
        .getUrl(), db.getUsuario(), db.getContraseña());
      
      PreparedStatement pst = conn.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        datos.add(new Persona(
           rs.getString("dniPersona"),
           rs.getString("names"),
           rs.getString("emailPersona"),
           rs.getDate("fechaInicioContrato"),
           rs.getDate("fechaNacimiento"),
           rs.getString("sexo"),
           rs.getString("nameContrato_ContratoEspecial")   
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