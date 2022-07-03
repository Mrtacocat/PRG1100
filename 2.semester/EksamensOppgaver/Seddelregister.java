// Oppgave 2 - Eksamen Okt 2019

import java.io.*;
import java.util.*;
import static javax.swing.JOptionPane.*;
import static java.lang.System.*;

public class Seddelregister {

    public static void main(String[] args) {

        String land = showInputDialog("Gi landsnavn (f.eks. Norge): ");
        String filnavn = land + ".txt";
        
        try {
            File fil = new File(filnavn);
            Scanner leser = new Scanner(fil);
            String[] seddelTab = new String[500];
            int i = 0;
            while ( leser.hasNextLine() ) {
                seddelTab[i++] = leser.nextLine();
            }
            leser.close();
            int antSedler = i;
            // Sortere på årstall - som ligger først 
            Arrays.sort(seddelTab, 0, antSedler); // mye tomt i tabellen
            String ut = "Sedler fra " + land + "\n";
            for (i=0; i<antSedler; i++) 
                ut += seddelTab[i] + "\n";
            showMessageDialog(null, ut);
            // Registrerer en ny seddel
            String nySeddel = showInputDialog("Gi seddelinfo på kompakt format: ");
            FileWriter skrivekobling = new FileWriter(filnavn, true); // append = true
            PrintWriter skriver = new PrintWriter(skrivekobling);
            skriver.println(nySeddel);
            skriver.close();
            out.println("Filbehandling ferdig, ok!");
        }
        catch (Exception e) {
            out.println("Feilet: " + e.toString());
        }

    }
}
