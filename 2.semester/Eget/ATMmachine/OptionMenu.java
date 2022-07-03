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

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'kr'###,##0.00");
    
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    /* Validerer login informasjon, kunde nummer og pin nummer */
  
  public void getLogin() throws IOException {
    int x = 1;

    do {
      try {

        data.put(9876543, 9876);
        data.put(8989898, 1890);

        out.println("Velkommen til minibanken!");

        out.print("Legg inn ditt kunde nummer: ");
        setCustomerNumber(menuInput.nextInt()); 

        out.print("Legg inn din PIN: ");
        setPinNumber(menuInput.nextInt());
      } catch (Exception e) {
        out.println("\n" + "Ugyldig tegn. Bare bruk tall." + "\n");
        x = 2;
      }
      for (Entry<Integer, Integer> entry : data.entrySet()) {
        if (entry.getkey() == getCustomerNumber() && entry.getValue() == getPinNumber())
        getAccountType();
      }
    }
    out.println("\n" + "Feil kunde nummer og/eller Pin nummer." + "\n");
  } while (x == 1);

}