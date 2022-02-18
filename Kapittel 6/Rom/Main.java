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
    Rom r1 = new Rom();

    out.println(r1.romkode);
    out.println(r1.antPlasser);
    out.println(r1.harPC);
    r1.jegharpc();
    out.println(r1.harPC);
  }

}