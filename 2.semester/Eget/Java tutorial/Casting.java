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
import java.util.Arrays.*;

public class Casting {

  public static void main(String[] args) {
    // Implicit casting / automatic convertion
    // byte > short > int > long > float > double
    double x = 1.1;
    int c = (int)x + 2;
    out.println(c);

    // String to int VIKTIG Å VITE
    String y = "1";
    int z = Integer.parseInt(y) + 2;
    out.println(z);
  }

}