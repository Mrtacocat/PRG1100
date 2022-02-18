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

public class ForLoops {

  public static void main(String[] args) {
    for(int i = 0; i<5; i++) 
      out.println("Helloworld!");

    for(int j = 1; j<=5; j++) 
      out.println("Helloworld!" + j);

    for(int d = 5; d>0; d--) 
      out.println("Helloworld!" + d);
  }

}