/* Adventofcode 2019 - Day 1a*/

import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
import java.util.*; 
import java.io.*;
import java.math.*;

public class Oppg1a {
    public static void main(String[] args) {
 
        int mass = 0;
        int massTotal = 0;
        try {
            File fil = new File("Oppg1.input");
            Scanner skriver = new Scanner(fil);
    
            while(skriver.hasNextLine()) {
                mass = skriver.nextInt();
                int result = (mass / 3) - 2;
                massTotal+= result;

            }

            out.println(massTotal);
            skriver.close();
        } catch(Exception e) {
            out.println("Error: " + e.toString());
        }
        

        
       /*  int mass = 12;
        int result = (mass / 3) - 2;*/

        
        
    }
}   
