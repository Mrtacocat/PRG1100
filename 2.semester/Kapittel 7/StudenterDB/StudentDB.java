import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import java.io.*;
import java.io.PrintWriter;
import java.sql.*;
import javax.naming.spi.DirStateFactory.Result;
 
 
/**  TEST AV DATABASE
  *  Programmet demonstrerer oppkobling og bruk av en SQLite-database.
  *  Vi kobler Student-klassen med en Student-tabell i en db. 
  */
public class StudentDB {
 
  public static void main(String[] args) throws Exception { 
    String url = "jdbc:sqlite:studenter.db";
    Connection conn = null;
    try { 
      conn = DriverManager.getConnection(url);
      // Oppretter en tabell Student i db
      String sql;// = "create table Student(Nr integer primary key, År integer, Kjønn char(1), Fornavn varchar(20), Etternavn varchar(20));";
      Statement stmt = conn.createStatement();
      //stmt.executeUpdate(sql);
 
      // Legger inn studentdata
      //sql = "insert into Student values(987544,1998,'M', 'Ole', 'Mannen');"
      //    + "insert into Student values(787544,1995,'k', 'Kari', 'Nordmann');"
      //    + "insert into Student values(387444,1992,'M', 'Kåre', 'Kål');"; // flere på samme måte
      //stmt.executeUpdate(sql);
      
      // Slette en student fra registeret 
      sql = "delete from Student where Nr=787544;";
      stmt.executeUpdate(sql);

      // Avleser tabellen sortet på fornavn
      sql = "select * from Student order by Fornavn;";
      ResultSet rs = stmt.executeQuery(sql);
      while ( rs.next() ) {
        int nr = rs.getInt("Nr");
        int år = rs.getInt("År");
        char kjønn = rs.getString("Kjønn").charAt(0);
        String fNavn = rs.getString("Fornavn");
        String eNavn = rs.getString("Etternavn");
        out.println(nr + " - " + år + " - " + kjønn + " - " + fNavn + " " + eNavn);
      }

      // Tar backup av tabellen, skriver til en txt-fil
      PrintWriter skriver = new PrintWriter("bupStudent.txt");
      sql = "select * from Student;";
      stmt.executeQuery(sql);
      while ( rs.next() ) {
        int nr = rs.getInt("Nr");
        int år = rs.getInt("År");
        char kjønn = rs.getString("Kjønn").charAt(0);
        String fNavn = rs.getString("Fornavn");
        String eNavn = rs.getString("Etternavn");
        skriver.println(nr + ";" + år + ";" + kjønn + ";" + fNavn + ";" + eNavn);
      }
      skriver.close();

      if (conn != null) {
        showMessageDialog(null,"Oppkobling til databasen " + url + " var vellykket. ");
      }
 
    }  
    catch (SQLException e) {
      showMessageDialog(null,"Oppkobling til databasen feilet! \n Se detaljer i konsollet");
      out.println("Oppkobling til databasen " + url + " feilet.\n" + e.toString());
    }
    finally {
      try {
        conn.close();
        showMessageDialog(null,"Forbindelsen til databasen er lukket igjen." + "\n"
                             + "Se filen studenter.db  i mappen merket db"); 
      }
      catch (SQLException e) {
        showMessageDialog(null,"Klarte ikke å lukke forbindelsen til databasen! \n Se detaljer i konsollet");
        out.println("Klarte ikke å lukke forbindelsen til databasen " + url + "\n" + e.toString());
      }
    }
  }
 
}
