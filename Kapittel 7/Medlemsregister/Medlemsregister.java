/* Kodeskjelett test
 */ 
import static java.lang.System.*;
import static javax.swing.JOptionPane.*; 
import static java.lang.Integer.*;
import java.util.*; 
import java.io.*;
import java.sql.*;

public class Medlemsregister { 
          
  private static File dbFil = new File("medlemmer.db");
  public static void main(String[] args) { 
      Connection conn = null; 
    try {  
      conn = DriverManager.getConnection(dbFil);
      Statement stmt = conn.createStatement();
      
    if (!dbFil.exists())   
      lagNyTabell();               
    int valg = 0;
    do {
      valg = visMeny(); 
      if (valg != 0 )  
        switch ( valg ) { 
          case 1: visAlleEtternavn(); break;
          case 2: visAlleTlf();       break;
          case 3: registrereMedlem();    break;
          case 4: endreMedlem();      break;
          case 5: slettMedlem();      break;
          case 6: taBackup();         break;
          case 7: hentBackup();       break;
          default: break;
        }
    } while ( valg != 0);  
  } catch (SQLException e) {
    out.println("Tilkobling feilet: " + e.toString());
  }
  }  
  // Hjelpemetoder kun til bruk i dette programmet
  public static int visMeny() {   
    String meny = "[1] Vis alle etternavn" + "\n" 
                + "[2] Vis alle tlf.nr" + "\n"  
                + "[3] Legg til medlem" + "\n"   
                + "[4] Endre medlem" + "\n"   
                + "[5] Slett medlem" + "\n" 
                + "[6] Ta backup" + "\n"   
                + "[7] Hent backup" + "\n"
                + "[0] Avslutt";    
    return parseInt(showInputDialog(meny + "\n" + "Velg et nr. (0-7):"));
   }

  private static void lagNyTabell() {  
      stmt.executeUpdate("DROP TABLE IF EXISTS Medlemtest;");
      stmt.executeUpdate("CREATE TABLE Medlem(Nr INTEGER PRIMARY KEY, Fornavn CHAR(20), Etternavn CHAR(20), Adresse CHAR(50), Telefon INTEGER);");
    showMessageDialog(null, "Start: Lager db-tabellen Medlem"); 
  } 
  public static void visAlleEtternavn() {   
    showMessageDialog(null, "1: Alle medlemmer, sortert på etternavn");
  }
  public static void visAlleTlf() { 
    showMessageDialog(null, "2: Alle medlemmer med tlf, sortert på tlf.nr");
  }  
  // Husk å skrive logg-meldinger i konsollet for endringsmetoder!
  private static void registrereMedlem() { 
    showMessageDialog(null, "3: registrere nytt medlem");
  }  
  private static void endreMedlem() { 
    showMessageDialog(null, "4: Endre eller legge til tlf.nr"); 
  }  
  private static void slettMedlem() { 
    showMessageDialog(null, "5: Slette medlem"); 
  }
  private static void taBackup() { 
    showMessageDialog(null, "6: Ta backup");
  }
  private static void hentBackup() { 
    showMessageDialog(null, "7: Hent backup");
  }
}