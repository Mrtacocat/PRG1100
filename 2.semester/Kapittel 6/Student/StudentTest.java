/* Programforklaring
   
   AB 2022
*/
import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import java.util.*;
import java.io.*;

public class StudentTest {

  public static void main(String[] args) {
    
    // Opprette studentobjekt.

    Student s1 = new Student();
    // Initiere objektet
    s1.studNr = 238229;
    s1.fornavn = "Christoffer";
    s1.etternavn = "Riis";
    s1.fødtÅr = 2001;
    s1.kjønn = 'K'; 

    out.println("s1: " + s1.studNr + ", " + s1.fornavn + " " + s1.etternavn
    + ", " + s1.fødtÅr + ", " + s1.kjønn);

    // Oppretter enda ett studentobjekt, innlest.
    /*Student s2 = new Student();
    
    // Initiere objektet
    String tallTekst = showInputDialog("Gi studentnummer:");
    s2.studNr = parseInt(tallTekst);

    s2.fornavn = showInputDialog("Gi fornavn:");
    s2.etternavn = showInputDialog("Gi etternavn:");
    tallTekst = showInputDialog("Gi fødselsår:");
    s2.fødselsÅr = parseInt(tallTekst);
    s2.kjønn = showInputDialog("Gi kjønn:").charAt(0);

    out.println("s2: " + s2.studNr + ", " + s2.fornavn + " " + s2.etternavn
    + ", " + s2.fødselsÅr + ", " + s2.kjønn);*/
    Student s2 = new Student(238229);
    out.println("s2: " + s2.studNr + ", " + s2.fornavn + " " + s2.etternavn
    + ", " + s2.fødtÅr + ", " + s2.kjønn);
    

    Student s4 = new Student(238229);
    out.println(s4.toString());

    Student s5 = new Student(238229, 'M', "christoffer", "riis");
    out.println(s5.toString());
    /*out.println(s5.navn());
    out.println(s5.pent("joHAn"));*/

    if(s5.erKvinne() )
      out.println("Kvinne");
    else
      out.println("Mann");

    if(s1.erKvinne() )
      out.println("Kvinne");
    else
      out.println("Mann");

  }

}