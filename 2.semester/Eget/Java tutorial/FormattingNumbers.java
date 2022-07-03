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
import java.text.NumberFormat;

public class FormattingNumbers {

  public static void main(String[] args) {
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    String result = currency.format(1234567.891);
    out.println(result);

    NumberFormat percent = NumberFormat.getPercentInstance();
    String result1 = percent.format(0.1);
    out.println(result1);

    String result2 = NumberFormat.getPercentInstance().format(0.1);
    out.println(result2);
  }

}