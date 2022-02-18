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

public class Rom {
    int     romkode;
    int     antPlasser = 100;
    static boolean harPC = false;

    private static void jegharpc() {
      harPC = true;
    }

    private static void harIKKE() {
      harPC = false;
    }
}