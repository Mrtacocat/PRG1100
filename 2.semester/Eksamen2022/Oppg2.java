
import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
import java.util.*;
import java.io.*;
/*  Eksamen mai 2022
    Oppgave 2
    Christoffer Riis
*/
public class Oppg2 {
    public static void main(String[] args) {
        String melding = ""; 
        Scanner leser = null;
        PrintWriter skriver = null;
        try {
            File fil = new File("bilder.txt");
            leser = new Scanner(fil);
            while( leser.hasNext() ) {
                String linje = leser.nextLine();
                String[] dataTab = linje.split(";");
                out.println(linje + " - " + Arrays.toString(dataTab));

            }
            leser.close();
            int årstall = 2022;
            skriver = new PrintWriter(årstall + ".txt");
            for (int år=2022; år<0; år++) {
                skriver.println(år);
            }
        
        } catch (IOException eo) {
            melding = "Problemer med fil:  " + eo.toString();   
          }
          catch (NumberFormatException en) {
            melding = "Datoformatet er ulesbart!" + en.toString();   
        } catch (Exception e) {
            melding = "Problem: " + e.toString();
        } 
    }
}
