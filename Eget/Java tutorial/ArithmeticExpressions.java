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

public class ArithmeticExpressions {

  public static void main(String[] args) {
    double result = (double)10 / (double)3; 
    out.println(result);

    int x = 1;
    x++;
    out.println(x);

    int x = 1;
    x = x + 2; // det samme som den under bare kortere
    x += 2;
    // vi har også...
    x -= 2;
    x *= 2;
    x /= 2;
    
  }

}