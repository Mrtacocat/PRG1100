/* Kodeskjelett test
 */ 
import static java.lang.System.*;
import static javax.swing.JOptionPane.*; 
import static java.lang.Integer.*;
import java.util.*; 
import java.io.*;
import java.sql.*;


public class Medlemsregister { 
  final int MAX_ANT = 2;
  final String FIL = "register.txt";
  private static String driver   = "org.sqlite.JDBC"; 
  private static String url      = "jdbc:sqlite:medlemmer.db";
  private static Connection conn = null;  
  private static File register = new File("register.txt");
  private static File dbFil = new File("medlemmer.db");
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
      String sql; // = "create table Medlem(Nr integer primary key, Fornavn varchar(20), Etternavn varchar(20), Adresse varchar(50), Telefon integer);"; 
      //stmt.executeUpdate(sql);   
      conn.close(); 
    }
    catch (SQLException e) { 
      out.println("Feil: " + e.toString()); 
    }
   
    showMessageDialog(null, "Start: Lager db-tabellen Medlem"); 
  } 

  public static void visAlleEtternavn() {  
    /*
    try { 
      
    conn = DriverManager.getConnection(url);   
    Statement stmt = conn.createStatement(); 
      String sql = "select Etternavn from Medlem order by Etternavn;";
      ResultSet rs = stmt.executeQuery(sql);
      while ( rs.next()) {
        String eNavn = rs.getString("Etternavn"); 
        out.println(eNavn);
      }
      showMessageDialog(null, "1: Alle medlemmer, sortert på etternavn");
    
    } 
    catch (SQLException sqlex) {  
      out.print("Feilet i visAlleEtternavn();, grunn: " + sqlex.toString());
    }
    catch (FileNotFoundException e) {
      out.print("Fil ikke funnet: " + e.toString());
    }*/
  }

  public static void visAlleTlf() { 
    /*hentBackup();
    try {
      conn = DriverManager.getConnection(url);
      Statement stmt = conn.createStatement();
      String sql = "select distinct Telefon from Medlem;";
      stmt.executeQuery(sql);
      conn.close();
    } 
    catch (SQLException sqlex) {  
      out.print("Feilet i visAlleTlf();, grunn: " + sqlex.toString());
    } 
    catch (FileNotFoundException e) {
      out.print(e.toString());
    }
    showMessageDialog(null, "2: Alle medlemmer med tlf, sortert på tlf.nr");*/
  }  

  // Husk å skrive logg-meldinger i konsollet for endringsmetoder!
  private static void registrereMedlem() { 
    try {
    conn = DriverManager.getConnection(url);   
    Statement stmt = conn.createStatement(); 
    stmt.executeUpdate("insert into Medlem values(40,'Per','Nilsen','Mellomvegen 2', 'Bergen'");
    showMessageDialog(null, "3: registrere nytt medlem");
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
    stmt.executeUpdate("delete from Medlem where Nr=5");
    showMessageDialog(null, "5: Slette medlem"); 
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
      int telefon = rs.getInt("Telefon");
      skriver.println(nr + ";" + fNavn + ";" + eNavn + ";" + telefon);
    }
    skriver.close();
  } catch (FileNotFoundException e) {
    out.println(" Feilet, grunn: " + e.toString());
  } catch (SQLException sqlex) {
    out.println(" Feilet SQL, grunn: " + sqlex.toString());
  } 

    showMessageDialog(null, "6: Ta backup");
  
  }

  private static void hentBackup() { 
    Scanner leser = null; 
    int antMedlem = 0;
    try {
      // Koden vi ønsker utført
      Medlem[] medlemtabell = new Medlem[MAX_VALUE];
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
          int tlf = parseInt(datatab[4]);
          medlemtabell[i++] = new Medlem(nr,fornavn,etternavn,adresse,tlf);
      }
      leser.close();
      antMedlem = i;

      // Kvitterer medlemsliste
      String liste = "Registrerte Medlemmer" + "\n";
      for (i=0; i<antMedlem; i++) 
          liste += medlemtabell[i].toString() + "\n";
          showMessageDialog(null, liste);

    } catch (FileNotFoundException e) {
      out.println(e.toString());
    }
   catch (NumberFormatException ex) {
      out.println("Feilet grunn: " + ex.toString());
    }
    finally {
      // Avslutter kontrollertB
      if ( leser != null )
      leser.close();
  }
    showMessageDialog(null, "7: Hent backup");
  }

  public static void connect() {
  }
}