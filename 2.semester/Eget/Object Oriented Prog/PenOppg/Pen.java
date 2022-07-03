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

public class Pen {

    String type = "gel";
    String color = "blue";
    int point = 10;

    static boolean clicked = false;

    public static void click() {
      clicked = true;
    } 

    public static void unclick() {
      clicked = false;
    }

}