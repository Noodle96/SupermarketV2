package Modelo;



public class Database
{
  private final String driver;
  private final String url;
  private final String usuario;
  private final String contraseña;
  
  public Database()
  {
    driver = "org.postgresql.Driver";
    url = "jdbc:postgresql://localhost:5432/SupermarketV1";
    usuario = "postgres";
    contraseña = "123";
  }
  
  public String getDriver() {
    return driver;
  }
  
  public String getUrl() {
    return url;
  }
  
  public String getUsuario() {
    return usuario;
  }
  
  public String getContraseña() {
    return contraseña;
  }
}