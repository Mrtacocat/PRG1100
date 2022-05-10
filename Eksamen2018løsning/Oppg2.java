import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

// Oppg2 Født År statistikk
public class Oppg2 {
    public static void main(String[] args) {
        String melding = "";                        // Statusmelding til bruker om resultat.
        String fornavn = showInputDialog("Skriv fornavn: ");
        Scanner leser = null;
        PrintWriter skriver = null;
        try {
            File fil = new File(PRG1100B.txt);
            leser = new Scanner(fil);
            int laveste = 2018;
            int høyeste = 1900;
            while( leser.hasNext() ) {
                String dato = leser.next();
                String[] dataTab = dato.split("\\.");
                System.out.println(dato + " - " Arrays.toString(dataTab));
                int år = Integer.parseInt(dataTab[2]);
                if (år < laveste) laveste = år;
                if (år > høyeste) høyeste = år;   
            }
            leser.close();
            skriver = new PrintWriter("res"+PRG1100B.txt);
            for (int år=0; år<høyeste-laveste+1; år++) 
                skriver.println(laveste+år )

        }
    }
}
