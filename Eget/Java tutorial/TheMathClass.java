/* Kapittel 5, oppgave
   Tekst om programmet
   C.W.R Jan 2022
*/
import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
import java.util.*;

public class TheMathClass {

  public static void main(String[] args) {
    // runder opp
    int result = Math.round(1.1F);
    out.println(result);

    // går opp til neste tall altså taket (veldig bra forklart)
    int result1 = (int)Math.ceil(1.1F);
    out.println(result1);

    // mindre eller lik
    int result2 = (int)Math.floor(1.1F);
    out.println(result2);

    int result3 = Math.max(1, 2);
    out.println(result3);

    int result4 = Math.min(1, 2);
    out.println(result4);

    double result5 = Math.random() * 100;
    out.println(result5);

    int result6 = (int)Math.round(Math.random() * 100);
    out.println(result6);

    int result7 = (int)(Math.random() * 100);
    out.println(result7);



  }

}