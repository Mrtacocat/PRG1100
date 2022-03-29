/* Kodeskjelett test
 */ 
import static java.lang.System.*;
import static javax.swing.JOptionPane.*; 
import static java.lang.Integer.*;
import java.util.*; 
import java.io.*;
import java.sql.*;


public class Medlemsregister { 
  final String FIL = "register.txt";
  private static String driver   = "org.sqlite.JDBC"; 
  private static String url      = "jdbc:sqlite:medlemmer.db";
  private static Connection conn = null;  
  private static File register   = new File("register.txt");
  private static File dbFil      = new File("medlemmer.db");
    public static void main(String[] args) {

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
   
   
  // databasen blir settet opp og tabellen medlem blir lagd
  private static void lagNyTabell() {  

    try {  

      conn = DriverManager.getConnection(url);   
      Statement stmt = conn.createStatement();  

        String sql; //= "drop table if exists Medlem; create table Medlem(Nr integer, Fornavn varchar(20), Etternavn varchar(20), Adresse varchar(50), Telefon integer);"; 
       //stmt.executeUpdate(sql);

      conn.close(); 

    }
    catch (SQLException e) { 
      out.println("Feil: " + e.toString()); 
    }

    showMessageDialog(null, "Start: Lager db-tabellen Medlem"); 

  } 

  public static void visAlleEtternavn() {  
    
    showMessageDialog(null, "1: Alle medlemmer, sortert på etternavn");
   
    try {      

      conn = DriverManager.getConnection(url);   
      Statement stmt = conn.createStatement(); 

        String sql = "select Etternavn from Medlem order by Etternavn;";
        ResultSet rs = stmt.executeQuery(sql);

      while ( rs.next()) {
        String eNavn = rs.getString("Etternavn");
        out.println(eNavn);
      }

      conn.close();
      
    } 
    catch (SQLException sqlex) {  
      out.print("Feilet i visAlleEtternavn();, grunn: " + sqlex.toString());
    }
  
  }

  public static void visAlleTlf() { 

    showMessageDialog(null, "2: Alle medlemmer med tlf, sortert på tlf.nr");

    try {

      conn = DriverManager.getConnection(url);
      Statement stmt = conn.createStatement();

        String sql = "select Telefon from Medlem;";
        ResultSet rs = stmt.executeQuery(sql);
        
      conn.close();

    } 
    catch (SQLException sqlex) {  
      out.print("Feilet i visAlleTlf();, grunn: " + sqlex.toString());
    } 
    
  }  

  // Husk å skrive logg-meldinger i konsollet for endringsmetoder!
  private static void registrereMedlem() { 

    showMessageDialog(null, "3: registrere nytt medlem");
    
    try {

    conn = DriverManager.getConnection(url);   
    Statement stmt = conn.createStatement();

      stmt.executeUpdate("insert into Medlem values(39,'Anna','Sund','Kattegate 2, Stavanger', 49596979);");

    conn.close();

    }
    catch (SQLException sqlex) {
      out.println(sqlex.toString());
    }
  } 

  private static void endreMedlem() { 
    showMessageDialog(null, "4: Endre eller legge til tlf.nr"); 
  }  

  private static void slettMedlem() { 
    try {

    conn = DriverManager.getConnection(url);   
    Statement stmt = conn.createStatement(); 

      stmt.executeUpdate("delete from Medlem where Nr=40");
      showMessageDialog(null, "5: Slette medlem"); 

    conn.close();
  } 
  catch (SQLException sqlex) {
    out.println(sqlex.toString());
  }
  }

  private static void taBackup() { 
    
    try {

      conn = DriverManager.getConnection(url);
      Statement stmt = conn.createStatement();

        PrintWriter skriver = new PrintWriter("BACKUPregister.txt");
        String sql = "select * from Medlem;";
        ResultSet rs = stmt.executeQuery(sql);

      while ( rs.next() ) {
          int nr = rs.getInt("Nr");
          String fNavn = rs.getString("Fornavn");
          String eNavn = rs.getString("Etternavn");
          String adresse = rs.getString("Adresse");
          int telefon = rs.getInt("Telefon");
          skriver.println(nr + ";" + fNavn + ";" + eNavn + ";" + adresse + ";" + telefon);
      }

    skriver.close();
    conn.close();
    

  } catch (FileNotFoundException e) {
    out.println(" Feilet, grunn: " + e.toString());
  } catch (SQLException sqlex) {
    out.println(" Feilet SQL, grunn: " + sqlex.toString());
  } 

    showMessageDialog(null, "6: Ta backup");
  
  }

  private static void hentBackup() { 
    
    showMessageDialog(null, "7: Hent backup");
      
    int antMedlem = 0;

    try {
      
        Scanner leser = new Scanner( new File("register.txt") );
        while ( leser.hasNextLine() ) {
          leser.nextLine();
        antMedlem++;
        }
        leser.close();

        conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();

      // Koden vi ønsker utført
      Medlem[] medlemtabell = new Medlem[antMedlem];
      int i = 0;
      // Åpner datastrøm
      
      leser = new Scanner( new File("register.txt") );
      while ( leser.hasNextLine() ) {
          String linje = leser.nextLine();
          // Splitter tekstlinja i enkeltelement
          String[] datatab = linje.split(";");
          int nr = parseInt(datatab[0]);
          String fornavn = datatab[1];
          String etternavn = datatab[2];
          String adresse  = datatab[3];
            
            if ( datatab.length > 4) {
              int tlf = parseInt(datatab[4]);
              medlemtabell[i] = new Medlem(nr,fornavn,etternavn,adresse,tlf);
            } else {
              medlemtabell[i] = new Medlem(nr,fornavn,etternavn,adresse);
            }
            i++;
      }

      leser.close();

      for(int k = 0; k < medlemtabell.length; k++) {
        stmt.executeUpdate("insert into Medlem values(" + medlemtabell[k].getNr() + ",'" + medlemtabell[k].getFornavn() + "','" 
                                                        + medlemtabell[k].getEtternavn() + "','" + medlemtabell[k].getAdresse() + "','" 
                                                        + medlemtabell[k].getTlf() + "')");
      }

     

      antMedlem = i;

      // Kvitterer medlemsliste
      String liste = "Registrerte Medlemmer" + "\n";
      for (i=0; i<antMedlem; i++) 
          liste += medlemtabell[i].toString() + "\n";
          
          showMessageDialog(null, liste);

    } 
      catch (FileNotFoundException e) {
      out.println(e.toString());
    }
      catch (NumberFormatException ex) {
      out.println("Feilet grunn: " + ex.toString());
    }
      catch (SQLException sqlex) {
        out.println("Feilet grunn: " + sqlex.toString());
      }
      catch (Exception ee) {
        out.println("Skriver feil: " + ee.toString());
      }
    }

  public static void connect() {
  }
}