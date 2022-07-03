/* Kapittel 5, Utfordring 
   Program som bruker utvidet for-løkke
   C.W.R - Jan 2022
*/

import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
import java.util.*;

public class Talltabell {
    public static void main(String[] args) {
        // Oppretter tabellen
        final int LENGDE = 7;
        int[] tallrekke = new int[LENGDE];

        // Fyller tabellen med tilfeldige tall 1-25
        for(int i=0; i<LENGDE; i++) {
            tallrekke[i] = Min.trekkTall(1, 25);
        }

        // Utskrift av tabellen ( alle verdiene )
        
    }
}