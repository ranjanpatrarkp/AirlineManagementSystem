
package airlinemanagementsystem;
import java.sql.*;

/**
 *
 * @author Ranjan Kumar Patra
 */
public class Conn {
    Connection c;
  public  Statement s;
    
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem", "root", "Ranjan1234");
            s = c.createStatement(); 
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
