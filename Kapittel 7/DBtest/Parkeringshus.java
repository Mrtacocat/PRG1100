import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
import java.util.*;
import java.sql.*;

public class Parkeringshus {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:parkeringshus.db";
        Connection conn = null; 

        try{
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            
            /*stmt.executeQuery("string");
            stmt.executeUpdate("string");*/
            
            stmt.executeUpdate("drop table if exists Parkeringshus;");
            stmt.executeUpdate("create table Parkeringshus(PNr integer PRIMERY KEY, Farge varchar(20), RegNr varchar(7));");

            String rows = "insert into Parkeringshus values(1, 'Rød', 'EL40660');"
                        + "insert into Parkeringshus values(2, 'Sort', 'NF43839');";
            stmt.executeUpdate(rows);

            ResultSet result = stmt.executeQuery("select RegNr, PNr from Parkeringshus where Farge = 'Sort' and RegNr like 'NF%';");
           while( result.next() ) {
            out.println(result.getString("RegNr") + " er sort, og er parkert på plass nr. " + result.getInt("PNr"));

           }
        } catch (SQLException e) {
            out.println("Connection failed: " + e.toString());
        }
        finally {
            if( conn != null) {
                try{
                    conn.close();
                    showMessageDialog(null, "Forbindelsen til databasen er lukket igjen.");
                } catch(Exception e) {
                    out.println("Failed to close db: " + e.toString());
                }
            }
        }
    }
}
