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
import java.util.Scanner;

public class ReadingInput {

  public static void main(String[] args) {
    String message = "Hello World" + "!!";
    out.println(message.endsWith("!!"));

    String message1 = "Hello World" + "!!";
    out.println(message1.startsWith("!!"));

    
    out.println(message.length());
    out.println(message1.length());
    out.println(message.indexOf("e"));
    out.println(message.replace("!", "*"));

  }

}