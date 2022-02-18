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

public class Conditionals {

  public static void main(String[] args) {
    /*   
    5 > 2;
    5 < 2;
    5 >= 2;
    5 <= 2;
    5 == 2;
    5 != 2;
    */

    boolean isRainy = false;
    boolean hasUmbrella = false;
    if (isRainy == true && hasUmbrella == true) {
      out.println("Take your umbrella!");
    } else if (isRainy == true || hasUmbrella == true) {
      out.println("It is either raining, or you have an umbrella, or both");
    } else {
      out.println("It is not raining");
    }

    int x = 5;
    int y = 2;

    if (x < y) {
      out.println("true");
    } else if(5 > 3) {
      out.println("The else if condition was true");
    } 
    else {
      out.println("false");
    }
  }

}