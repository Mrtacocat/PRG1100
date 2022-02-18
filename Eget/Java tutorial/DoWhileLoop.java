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

public class DoWhileLoop {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = "";
    while (!input.equals("quit")) {
      out.println("Input: ");
      
      input = scanner.next().toLowerCase();
      out.println(input);
    }

    do {
      out.println("Input: ");
      input = scanner.next().toLowerCase();
      out.println(input);
    } while (!input.equals("quit"));

  }
}