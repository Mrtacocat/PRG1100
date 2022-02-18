/* Kapittel 7, Eksempel
   Program som leser studentdata fra tekstfil og oppretter tabell med studentobjekt
   C.W.R - 17.02.2022
*/

import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
import java.util.*;
import java.io.*;
public class Register {
    public static void main(String[] args) {
        final int MAX_ANT = 10;
        final String FIL = "text.txt";
        String ut = "Studentregister creating... ok!";
        Scanner leser = null; 
        int antStud = 0;
        try {
            // Koden vi ønsker utført
            Student[] studentTab = new Student[MAX_ANT];
            int i = 0;
            // Åpner datastrøm
            
            leser = new Scanner( new File("text.txt") );
            while ( leser.hasNextLine() ) {
                String linje = leser.nextLine();
                // Splitter tekstlinja i enkeltelement
                String[] datatab = linje.split(";");
                int nr = parseInt(datatab[0]);
                String fornavn = datatab[1];
                String etternavn = datatab[2];
                int dato = parseInt(datatab[3]);
                char kjønn = datatab[4].charAt(0);
                studentTab[i++] = new Student(nr,dato,kjønn,fornavn,etternavn);
            }
            leser.close();
            antStud = i;

            // Kvitterer studentliste
            String liste = "Registrerte studenter" + "\n";
            for (i=0; i<antStud; i++) 
                liste += studentTab[i].toString() + "\n";
                showMessageDialog(null, liste);

                // Setter inn en ny student
                // Detaljert dialog for å hente data til nytt objekt
            
        }
        catch (NumberFormatException e){
            // Håndterer evt. problem
            ut = "File problem: illegal NumberForamt";
        }
        catch (ArrayIndexOutOfBoundsException e){
            // Håndterer evt. problem
            ut = "Memory problem: Array is full!";
        }
        catch (FileNotFoundException e){
            // Håndterer evt. problem
            ut = "File problem: Can't find file. " + FIL;
        }
        catch (Exception e){
            // Håndterer evt. problem
            ut = "File problem: " + e.getMessage();
        }
        finally {
            // Avslutter kontrollert
            if ( leser != null )
            leser.close();
        }
        
        out.println(ut);
    }
}