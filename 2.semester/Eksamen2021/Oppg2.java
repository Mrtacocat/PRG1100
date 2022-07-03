// Oppg2
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

// OPPGAVE A
public class Oppg2 {
    
    private static Deltager[] hentDeltager(String filnavn) {
        Deltager[] delTab;
        // teller antall på fila
        try {
            File fil = new File("deltager2021.txt");
            Scanner leser = new Scanner(fil);
            int ant = 0;
            while( leser.hasNextLine() ) {
                String linje = leser.nextLine();
                ant++;
            }
            leser.close();
            
            delTab = new Deltager[ant];
            leser = new Scanner(fil);
            int i = 0;
            while( leser.hasNextLine() ) {
                String linje = leser.nextLine();
                String[] tab = linje.split(";");
                int idnr = parseInt(tab[0]);
                String navn = tab[1];
                //int[] liste = lagTabell(tab[2]);
                int n = tab[2].length()-1;
                String[] listTab = tab[2].substring(1,n).split(",");
                int[] liste = new int[listTab.length];
                for(int j = 0; j<listTab.length; j++)
                    liste[j] = parseInt(listTab[j]);
                delTab[i++] = new Deltager(idnr,navn,liste);
            }
            leser.close();
            return delTab;
        }
        catch(Exception e) {
            // trøbbel med data fra fil
            return null;
        }
    }
}

// hjelpe metode
/*
private static int int snittPoster(Deltager[] tab) {
    int sumPost = 0, ant = 0;
    for(int i = 0; i<tab.length; i++)
        if ( tab.getListe().length > 0 ) {
            sumPost += tab.getListe().length;
            ant++;
        }
        if ( ant == 0 )
            return 0;
        else 
        return (int)(sumPost*1.0/ant + 0.5);
}
*/