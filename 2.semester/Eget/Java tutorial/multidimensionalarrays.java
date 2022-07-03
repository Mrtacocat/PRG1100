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
import java.util.Arrays.*;

public class multidimensionalarrays {

  public static void main(String[] args) {
    // multi-dimensional arrays
    int[][] numbers = new int[2][3];
    numbers[0][0] = 1;
    out.println(Arrays.deepToString(numbers));

    // multi-dimensional arrays
    int[][] numberss = { { 1, 2, 3 }, { 4, 5, 6 } };
    out.println(Arrays.deepToString(numberss));


    

    
  }

}