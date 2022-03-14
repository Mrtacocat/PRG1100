/* Kapittel 7, Obligatorisk oppgave i PRG1100
   Database og Java
   Christoffer W. Riis - Dato
*/

import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
import java.util.*;

public class Mal {
    public static void main(String[] args) {
        // Innlesing
        String tallTekst = showInputDialog("Gi tall:");
        int heltall = parseInt(tallTekst);
        double desTall = parseDouble(tallTekst);
        // Beregning
        // Utskrift
        String ut = " ";
        showMessageDialog(null, ut);
        out.println(ut);
    }
}