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

public class Oppg2 {
    public static void main(String[] args) {
        String melding = "";
        String fornavn = showInputDialog("Skriv fornavn: ");
        Scanner leser = null;
        PrintWriter skriver = null;
        
        try {
            File fil = new File("PRG1100B.txt");
            leser = new Scanner(fil);
            int[] antallAv = new int[12];
            while ( leser.hasNext() ) {
                String dato = leser.next();
                String[] dataTab = dato.split("\\.");
                out.println(dato + " - " + Arrays.toString(dataTab));
                int mndNr = parseInt(dataTab[1]);
                antallAv[mndNr]++;
            }
            leser.close();
            String[] mnd = {"Jan", "Feb", "Mar", "Apr", "Mai", "Jun", "Jul", 
                            "Aug", "Sep", "Okt", "Nov", "Des"};
            skriver = new PrintWriter("res"+"PRG1100B.txt");
            for (int nr=0; nr<12; nr++) {
                skriver.println(mnd[nr] + ": " + antallAv[nr]);
            }
            skriver.close();
            melding = "Månedstelling fullført!";
        }
        catch(Exception e) {
            melding = "Problem: " + e.toString();
        }
    }
}
