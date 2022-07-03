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

public class Main {

  public static void main(String[] args) {
    Pen p = new Pen();

    out.println(p.color);
    out.println(p.point);
    out.println(p.type);

    out.println(p.clicked);

    p.click();

    out.println(p.clicked);
  }

} 