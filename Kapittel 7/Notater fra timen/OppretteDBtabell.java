import static java.lang.System.*;
import java.sql.*;

public class OppretteDBtabell {

    public static void main(String[] args) throws Exception {
        
            // opprette tabellen Vare
            String sql = "create table Vare(Nr integer primary key, "
            + "Navn varchar(50), Pris decimal(8, 2); Antall integer);";
            stmt.executeUpdate(sql);

            // Legge inn data i tabellen
            sql = "insert into Vare values(1, 'Spade', 220.50, 23);"
                + "insert into Vare values(2, 'Hakke', 199.00, 17);"
                + "insert into Vare values(3, 'Spett', 170, 58);";
            stmt.executeUpdate(sql);
    }
}