import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class table {
     public static void main(String[] args){
         Connection connection = null;
         Statement statement = null;
         String GameN = "Grape";
         String PubN = "Mojang";
         try {
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/M226b", "root", "");
             statement = connection.createStatement();
             statement.execute("INSERT INTO GameLists VALUES('" + GameN + "', '" + PubN+ "', 1, 2011);");
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
}