import static java.lang.System.*;
import java.sql.*;

public class SeDataDB {

    // Kode i lsiting 7.8 på side 305 i læreboka

    public static void visVare(double prisGrense, String url) throws Exception {
        String sql = "select * from Vare where Pris < " + prisGrense;

        // Opprett forbindelse til databasen
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();

        //Utfører SQL-spørringen
        ResultSet rs = stmt.executeQuery(sql);
        Vare[] vareliste = new Vare[MAX_ANT];

        // Java-Behandle SQL-data
        while( rs.next() ) { //Behandle hver rad
            int VareNr      = rs.getInt("Nr");
            String varenavn = rs.getString("Navn");
            double pris     = rs.getDouble("Pris");
            int antall      = rs.getInt("Antall");

            out.println("Nr: " + VareNr 
                       + ", Navn: " + varenavn
                       + ", Pris: " + Math.round(pris)
                       + ", Antall: " + antall);

            // Fanger vareobjekt i tabellen
            vareliste[i++] = new Vare(VareNr,varenavn,pris,antall);
        }

        // Java-behandle SQL-data
        
        con.close(); // lukk forbindelsen til databasen
            
    }
}