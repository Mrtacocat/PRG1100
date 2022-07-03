/* Kapittel X, oppgave Y
   Tekst om programmet
   Navn - Dato
*/

import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class test {

    private static String driver   = "org.sqlite.JDBC"; 
    private static String url      = "jdbc:sqlite:medlemmer.db";
    private static Connection conn = null; 
    //private static File register = new File("register.txt");
    private static File dbFil = new File("medlemmer.db"); 

    public static void main(String[] args) throws FileNotFoundException {

        try {
            FileReader fr = new FileReader("register.txt");
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sql = "select * from Medlem order by Etternavn;";
            stmt.executeQuery(sql);
            char[] a = new char[50];
            fr.read(a);

            for(char c : a) {
                out.println(c);
                fr.close();
            }
    } 
    catch (SQLException e) {
        out.println(e.toString());
    } 
    catch (IOException ex) {
        out.println(ex.toString());
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