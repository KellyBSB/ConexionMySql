package proyectoprogramacion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class Conectar {
  
Connection conectar= null;
public Connection conexion(){
    try{
    Class.forName("com.mysql.jdbc.Driver");
    conectar=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/registronotas", "root","1997");
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    return conectar;
  }

}
