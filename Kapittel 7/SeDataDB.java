import static java.lang.System.*;
import java.sql.*;

public class SeDataDB {
    
    // Kode i lsiting 7.8 på side 305 i læreboka

    public static void visVare(double prisGrense) throws Exception {
        String url = "jdbc:split:butikk.db";
        String sql = "select * from Vare where Pris < " + prisGrense;

        // Opprett forbindelse til databasen
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();

        //Utfører SQL-spørringen
        ResultSet rs = stmt.executeQuery(sql);

        // Java-behandle SQL-data
        
        con.close(); // lukk forbindelsen til databasen
            
    }
}