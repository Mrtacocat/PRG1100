/* Kapittel 7, Obligatorisk Innlevering 3
   Lage ett medlemsregister for en landsdekkende organisasjon.
   Christoffer W. Riis - 31.03.2022 In.Frist
*/

import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import java.io.*;
import java.io.PrintWriter;
import java.sql.*;
import javax.naming.spi.DirStateFactory.Result;

public class Medlemsregister {
    public static void main(String[] args) {
      String url = "jdbc:sqlite:medlemmer.db";
      Connection conn = null;
      try {
         conn = DriverManager.getConnection(url);
         String sql; // = "create table Medlem(Nr integer primary key, Fornavn varchar(20), Etternavn varchar(20), Adresse varchar(50), Tlf integer);";
         Statement stmt = conn.createStatement();
         //stmt.executeUpdate(sql);

         // insert en linje om gangen 
         
      }
      catch (SQLException e) {
         out.println("Connection Fail: " + e.toString());
      }
    }
}
