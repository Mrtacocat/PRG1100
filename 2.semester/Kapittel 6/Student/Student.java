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

public class Student {
 
// Data
  int studNr;
  int fødtÅr;
  String fornavn;
  String etternavn;
  char kjønn;

//konstruktør
public Student(int inNr, int inÅr, char inKjønn, String inFn, String inEn) {
  studNr = inNr;
  fødtÅr = inÅr;
  kjønn = inKjønn;
  fornavn = pent(inFn);
  etternavn = pent(inEn);
}

public Student(int studNr) {
  this.studNr = studNr; 
  // Dummy-verdier på resten
  fødtÅr = 2001;
  kjønn = 'M';
  fornavn = "Christoffer";
  etternavn = "Riis";
}
public Student() {

}
public Student(int studNr, char kjønn, String fornavn, String etternavn) {
  this(studNr, 2001, kjønn, fornavn, etternavn);
}

// Objektmetoder
public boolean erKvinne() {
  return (kjønn == 'K') || (kjønn == 'k');
} 


public String toString() {
  return studNr + ";" + fødtÅr + ";" + kjønn + ";" + fornavn + ";" + etternavn;
  }


public String navn() {
  return pent(etternavn) + ", " + pent(fornavn);
}


private String pent(String navn) {
    char i = navn.toUpperCase().charAt(0);
    String n = navn.toLowerCase();
    return i + n.substring(1);
}


}
