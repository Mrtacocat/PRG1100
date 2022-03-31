/* Obligatorisk oppgave V-2022: Medlemsregister
   Lag et medlemsregister for en landsdekkende organisasjon.
   Christoffer W. Riis - Levert: 30.03.2022
*/
import static java.lang.System.*;
import static javax.swing.JOptionPane.*; 
import static java.lang.Integer.*;
import java.util.*; 
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.xml.*;
import javafx.application.*;
import javafx.event.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*; // FlowPane
import javafx.scene.control.*; // Button, TextField
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.text.*;

public class MedlemsregisterJavaFX extends Application { 
  Button alleEtternavn, alleTlf, addMedlem, editMedlem, deleteMedlem, takeBackUp, getBackUp, exit;
  TextField topText;
  final String FIL = "register.txt";
  private static String driver   = "org.sqlite.JDBC"; 
  private static String url      = "jdbc:sqlite:medlemmer.db";
  private static Connection conn = null;  
  private static File register   = new File("register.txt");
  private static File dbFil      = new File("medlemmer.db");



  public void start(Stage primaryStage) {    

    if (!dbFil.exists())   
        lagNyTabell(); 

    primaryStage.setTitle("Medlemsregister"); 
    primaryStage.show(); 

    GridPane panel = new GridPane();
    panel.setAlignment(Pos.CENTER);
    panel.setHgap(10);
    panel.setVgap(10);
    panel.setPadding(new Insets(25, 25, 25, 25));

  
    Scene scene = new Scene(panel, 300, 400);
    primaryStage.setScene(scene);

    Text sceneTitle = new Text("Medlemsregister");
    sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
    panel.add(sceneTitle, 0, 0, 2, 1);

    alleEtternavn = new Button("Alle Etternavn");
    alleEtternavn.setMaxWidth(Double.MAX_VALUE);
    panel.add(alleEtternavn, 0, 1);

    alleTlf = new Button("Alle TelefonNR");
    alleTlf.setMaxWidth(Double.MAX_VALUE);
    panel.add(alleTlf, 0, 2);

    addMedlem = new Button("Legg til Medlem");
    addMedlem.setMaxWidth(Double.MAX_VALUE);
    panel.add(addMedlem, 0, 3);

    editMedlem = new Button("Rediger Medlem");
    editMedlem.setMaxWidth(Double.MAX_VALUE);
    panel.add(editMedlem, 0, 4);

    deleteMedlem = new Button("Slett Medlem");
    deleteMedlem.setMaxWidth(Double.MAX_VALUE);
    panel.add(deleteMedlem, 0, 5);

    takeBackUp = new Button("Ta Backup");
    takeBackUp.setMaxWidth(Double.MAX_VALUE);
    panel.add(takeBackUp, 0, 6);

    getBackUp = new Button("Hent Backup");
    getBackUp.setMaxWidth(Double.MAX_VALUE);
    panel.add(getBackUp, 0, 6);

    exit = new Button("Exit");
    exit.setMaxWidth(Double.MAX_VALUE);
    panel.add(exit, 0, 7);


   }
   
  // databasen blir settet opp og tabellen medlem blir lagd
  private static void lagNyTabell() {  

    try {  

      // Koble opp med db-fil
      conn = DriverManager.getConnection(url);   
      Statement stmt = conn.createStatement();  

      // Oppretter en tabell Medlem i db
        String sql = "drop table if exists Medlem; create table Medlem(Nr integer, Fornavn varchar(20), Etternavn varchar(20), Adresse varchar(50), Telefon integer);"; 
        stmt.executeUpdate(sql);

      conn.close(); // kobler av

    }
    // catch error melding
    catch (SQLException e) { 
      out.println("Feil: " + e.toString()); 
    }

    showMessageDialog(null, "Start: Lager db-tabellen Medlem"); 
    out.println("Start: Lager db-tabellen Medlem");

  } 

  // Vise alle Etternavn sortert i alfabetisk rekkefølge
  public static void visAlleEtternavn() {  
    
    showMessageDialog(null, "1: Alle medlemmer, sortert på etternavn");
   
    int antMedlem = 0;
    String utskrift = "";

    try {      

      // Koble opp med db-fil
      conn = DriverManager.getConnection(url);   
      Statement stmt = conn.createStatement(); 

      // lager en array for å få inn data fra databasen
      Medlem[] medlemtabell = new Medlem[antMedlem]; // Har brukt student.java som objekt
      
      // Bruker ResultSet når man skal printe ut en executeQuery
      ResultSet rs = stmt.executeQuery("select * from Medlem order by Etternavn"); 
      
      // looper igjennom medlemtabellen (kun nr og tlf)
      for(int j = 0; j<antMedlem; j++) {
        utskrift += medlemtabell[j].getNr() + ",'" + medlemtabell[j].getTlf();
      }

      // printer ut Etternavn i consolet
      while ( rs.next()) {
        int nr = rs.getInt("Nr");
        String eNavn = rs.getString("Etternavn");
        out.println(nr + " - " + eNavn);
      } 
      
      conn.close(); // kobler av
      
    } 
    // catch error melding
    catch (SQLException sqlex) {  
      out.print("Feilet i visAlleEtternavn();, grunn: " + sqlex.toString()); 
    }
  
  }

  // Vise alle Telefonnummere sortert på nr
  public static void visAlleTlf() {

    showMessageDialog(null, "2: Alle medlemmer med tlf, sortert på tlf.nr");

    int antMedlem = 0;
    String utskrift = "";

    try {

      // Koble opp med db-fil
      conn = DriverManager.getConnection(url);   
      Statement stmt = conn.createStatement(); 

      // lager en array for å få inn data fra databasen
      Medlem[] medlemtabell = new Medlem[antMedlem]; // Har brukt student.java som objekt

      // Bruker ResultSet når man skal printe ut en executeQuery
      ResultSet rs = stmt.executeQuery("select * from Medlem order by Nr");

      // looper igjennom medlemtabellen (kun nr og tlf)
      for(int j = 0; j<antMedlem; j++) {
        utskrift += medlemtabell[j].getNr() + ",'" + medlemtabell[j].getTlf();
      }

      // printer ut telefonnr i consolet
        while ( rs.next() ) {
          int nr = rs.getInt("Nr");
          int tlf = rs.getInt("Telefon");
          out.println(nr + " - " + tlf);
        }

      conn.close(); // kobler av

    } 
    // catch error melding
    catch (SQLException sqlex) {  
      out.print("Feilet i visAlleTlf();, grunn: " + sqlex.toString());
    } 
    
  }  

  // Registrere ny medlem i db
  private static void registrereMedlem() { 

    showMessageDialog(null, "3: registrere nytt medlem");

    String utskrift = "";
    int antMedlem = 0;

    try {

      // Koble opp med db-fil
      conn = DriverManager.getConnection(url);   
      Statement stmt = conn.createStatement(); 

      // lager en array for å få inn data fra databasen
      Medlem[] medlemtabell = new Medlem[antMedlem]; // Har brukt student.java som objekt

      // selecter hele medlems tabellen
      stmt.executeQuery("select * from Medlem");

      // looper igjennom medlemtabellen 
      for(int j = 0; j<antMedlem; j++) {
        utskrift += medlemtabell[j].getNr() + ",'" + medlemtabell[j].getFornavn() + "','" 
                  + medlemtabell[j].getEtternavn() + "','" + medlemtabell[j].getAdresse() + "','" 
                  + medlemtabell[j].getTlf();
      }

      // legger inn data til ny medlem
      int nrNy = parseInt(showInputDialog("Skriv Nr: " + utskrift));
      out.println("Nummer: " + nrNy);
      String fornavnNy = showInputDialog("Skriv fornavn", utskrift);
      out.println("Fornavn: " + fornavnNy);
      String etternavnNy = showInputDialog("Skriv etternavn: " + utskrift);
      out.println("Etternavn: " + etternavnNy);
      String adresseNy = showInputDialog("Skriv adresse:" + utskrift);
      out.println("Adresse: " + adresseNy);
      int telefonNy = parseInt(showInputDialog("Skriv Telefon: " + utskrift));
      out.println("Telefon: " + telefonNy);
      
      // legger inn nytt medlem med en executeUpdate
      stmt.executeUpdate("insert into Medlem values(" + nrNy + ",'" + fornavnNy + "','" 
      + etternavnNy + "','" + adresseNy + "','" + telefonNy + "')");

      // driftsmelding
      out.println("Lagt til: " + nrNy + ";" + fornavnNy + ";" + etternavnNy + ";" + adresseNy + ";" + telefonNy);

    conn.close(); // kobler av

    }
    // catch error melding
    catch (SQLException sqlex) {
      out.println(sqlex.toString());
    }
  } 

  // Endre telefonr eller legg til telefonnr
  private static void endreMedlem() { 

    showMessageDialog(null, "4: Endre eller legge til tlf.nr"); 

    String utskrift = "";
    int antMedlem = 0;

    try {

      // Koble opp med db-fil
      conn = DriverManager.getConnection(url);   
      Statement stmt = conn.createStatement(); 
      
      // lager en array for å få inn data fra databasen
      Medlem[] medlemtabell = new Medlem[antMedlem]; // Har brukt student.java som objekt
      
      // selecter hele medlems tabellen
      stmt.executeQuery("select * from Medlem");

      // looper igjennom medlemtabellen (kun nr og tlf)
      for(int j = 0; j<antMedlem; j++) {
        utskrift += medlemtabell[j].getNr() + ",'" + medlemtabell[j].getTlf();
      }

      // endre medlem ved å skrive først nr deretter skrive nytt nr
      int selected = parseInt(showInputDialog("Skriv nummer på medlem for endring: ", utskrift));
      out.println("Du har valgt nummer: " + selected); // driftsmelding
      int endring = parseInt(showInputDialog("Legg til nytt nummer eller endre ditt gamle: "));
      stmt.executeUpdate("update Medlem set Telefon = " + endring + " where Nr = " + selected);
      
      // driftsmelding
      showMessageDialog(null, "Endret til: " + endring);
      out.println("Endret til: " + endring); 
      
      conn.close(); // kobler av

    }
    // catch error melding
    catch (SQLException sqlex) {
      out.println("SQL feilet: " + sqlex.toString());
    }
  }  

  // Slett medlem fra db
  private static void slettMedlem() { 

    showMessageDialog(null, "5: Slette medlem"); 

    String utskrift = "";
    int antMedlem = 0;

    try {

      // Koble opp med db-fil
      conn = DriverManager.getConnection(url);   
      Statement stmt = conn.createStatement(); 

      // lager en array for å få inn data fra databasen
      Medlem[] medlemtabell = new Medlem[antMedlem]; // Har brukt student.java som objekt
    
      // selecter hele medlems tabellen
      stmt.executeQuery("select * from Medlem");

      // looper igjennom medlemtabellen (kun nr)
      for(int j = 0; j<antMedlem; j++) {
        utskrift += medlemtabell[j].getNr() ;
      }


      // Sletting av medlem ved å skrive nr på hvilken du skal slette deretter skriver du 1 for å bekrefte
      int selected = parseInt(showInputDialog("Skriv nummer på medlem for sletting: " + utskrift));
      out.println("Du har valgt nummer: " + selected); // driftsmelding
      
      int bekreftelse = parseInt(showInputDialog("Sikker? trykk '1' for å gå videre."));

      // hvis bekreftelse er lik 1 så deleter du medlem
      if(bekreftelse == 1) {
        stmt.executeUpdate("delete from medlem where nr = " + selected + ";");
        out.println("Medlem NR: " + selected + " er fjernet fra lista"); // driftsmelding
      }
      else {
        // driftsmelding
        out.println("Failed to delete");
      }

    conn.close(); // kobler av
  } 
  // catch error melding
  catch (SQLException sqlex) {
    out.println(sqlex.toString());
  }
  }

  // Ta backup (.txt)
  private static void taBackup() { 
    
    try {

      // Koble opp med db-fil
      conn = DriverManager.getConnection(url);
      Statement stmt = conn.createStatement();

      // Tar backup av tabellen, skriver til en txt-fil
        PrintWriter skriver = new PrintWriter("BACKUPregister.txt");
        String sql = "select * from Medlem order by Nr;";
        ResultSet rs = stmt.executeQuery(sql); // Bruker ResultSet når du bruker executeQuery

      // Skriver backupfil looper igjennom alle medlemmer
      while ( rs.next() ) {
          int nr = rs.getInt("Nr");
          String fNavn = rs.getString("Fornavn");
          String eNavn = rs.getString("Etternavn");
          String adresse = rs.getString("Adresse");
          int telefon = rs.getInt("Telefon");
          skriver.println(nr + ";" + fNavn + ";" + eNavn + ";" + adresse + ";" + telefon);
      }

      // driftsmelding
      out.println("Backup er tatt!");

      // kobler av
    skriver.close(); 
    conn.close();
    

  // catch error melding
  } catch (FileNotFoundException e) {
    out.println(" Feilet, grunn: " + e.toString());
  } catch (SQLException sqlex) {
    out.println(" Feilet SQL, grunn: " + sqlex.toString());
  } 

    showMessageDialog(null, "6: Ta backup");
  
  }

  // Hente backup
  private static void hentBackup() { 

    
      
    int antMedlem = 0;

    try {

        Scanner leser = new Scanner( new File("register.txt") );
        while ( leser.hasNextLine() ) {
          leser.nextLine();
          antMedlem++;
        }
        leser.close();

      // Koble opp med db-fil
        conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();

      // lager en array for å få inn data fra databasen 
      Medlem[] medlemtabell = new Medlem[antMedlem]; // Har brukt student.java som objekt
      int i = 0;
      
      // leser register.txt filen
      leser = new Scanner( new File("register.txt") );
      // leser linje for linje med semikolon som split tegn
      while ( leser.hasNextLine() ) {
          String linje = leser.nextLine();
          // Splitter tekstlinja i enkeltelement
          String[] datatab = linje.split(";");
          int nr = parseInt(datatab[0]);
          String fornavn = datatab[1];
          String etternavn = datatab[2];
          String adresse  = datatab[3];
            
          // så lenge datatab.length er større enn 4 så skal den skrive ut tlf, hvis ikke så skriver du ut uten tlf
            if ( datatab.length > 4) {
              int tlf = parseInt(datatab[4]);
              medlemtabell[i] = new Medlem(nr,fornavn,etternavn,adresse,tlf);
            } else {
              medlemtabell[i] = new Medlem(nr,fornavn,etternavn,adresse);
            }
            i++;
      }

      leser.close(); // closer

      // setter inn alle verdiene inn i medlemtabellen
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
    // catch error melding
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
   
  public void behandleKlikk(ActionEvent e) {

  }
public static void main(String[] args) { launch(args); }
}
