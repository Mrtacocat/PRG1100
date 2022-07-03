/* Kapittel X, oppgave Y
   Tekst om programmet
   Navn - Dato
*/

import static java.lang.System.*;

public class UtvidetFOR_løkke {
    public static void main(String[] args) {
        /* Utskrift av alle elementer:
        int[] tallrekke = {8, 12, 10, 7, 7, 4, 0};
        String ut = "tall: "; 
        for (int i=0; i<7; i++) {
            ut += tallrekke[i] + " ";  
        }
        out.println(ut);
        */

        int[] tallrekke = {8, 12, 10, 7, 7, 4, 0};
        // Alternativt: 
        String ut = "Tall: ";
        for(int tall:tallrekke){
            ut += tall + " ";
        }
            out.println(ut);


    }
}