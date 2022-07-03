import static java.lang.System.*;
import java.sql.*;

public class SQLimport {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:splite:butikk.db";
            Connection con = DriverManager.getConnection(url);
            Statement stmt = con.createStatement();
            String sql = "create table Vare(Nr integer primary key, "
                       + "Navn varchar(50), Pris decimal(8, 2); Antall integer);";
            stmt.executeUpdate(sql);

            
            con.close();
            out.println("Vellykket oppkobling til databasen!");

            
        
    }
}