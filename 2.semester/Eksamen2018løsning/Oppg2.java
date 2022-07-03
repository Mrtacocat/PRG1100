import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
import java.util.*;
import java.io.*;
// Oppg2 Født År statistikk
public class Oppg2 {
    public static void main(String[] args) {
        String melding = "";                        // Statusmelding til bruker om resultat.
        String fornavn = showInputDialog("Skriv fornavn: ");
        Scanner leser = null;
        PrintWriter skriver = null;
        try {
            File fil = new File("PRG1100B.txt");
            leser = new Scanner(fil);
            int laveste = 2018;
            int høyeste = 1900;
            while ( leser.hasNext() ) {
                String dato = leser.next();  
                String[] dataTab = dato.split("\\.");  
                System.out.println(dato + "  -  " + Arrays.toString(dataTab));
                int år = Integer.parseInt(dataTab[2]);
                if (år < laveste) laveste = år;
                if (år > høyeste) høyeste = år;  
              }  
              leser.close();
              int[] antallAv = new int[høyeste-laveste+1];  
              leser = new Scanner(fil);   
              while ( leser.hasNext() ) {
                String dato = leser.next();  
                String[] dataTab = dato.split("\\.");  
                int år = Integer.parseInt(dataTab[2]);
                år = år - laveste;  // Finner indeksen til året
                antallAv[år]++;  
              }
              leser.close();
            skriver = new PrintWriter("res"+"PRG1100B.txt");
            for (int år=0; år<høyeste-laveste+1; år++) 
                skriver.println(laveste+år + ": " + antallAv[år]);
            skriver.close();
            melding = "fødselsårstelling fullførst!";
        } 
        catch (IOException e) {
            melding = "Problemer med fila:  " + "PRG1100B.txt";   
          }
          catch (NumberFormatException e) {
            melding = "Datoformatet er ulesbart!";   
    }
        catch (Exception e) {
            melding = "Problem: " + e.toString();
        } 
        finally {
            showMessageDialog(null, melding);  
            if ( leser != null )   leser.close();
            if ( skriver != null ) skriver.close();
          }
    }
}
