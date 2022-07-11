/* Adventofcode 2019 */

import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
import java.util.*; 
import java.io.*;

public class Oppg2 {
    public static void main(String[] args) {
        Scanner reader = null;
        try{
            reader = new Scanner(new File("Oppg2.input"));

            intComp computer = new intComp(reader.nextLine());
            reader.close();

            computer.ops[1] = 12;
            computer.ops[1] = 2;

            out.println("Svar: " + computer.RunProgram());

        } catch(Exception e) {
            out.println("Feilmelding: " + e.toString());
        } finally{
            if(reader != null) {
                try{
                    reader.close();

                } catch(Exception e){
                    out.println("shit");

                }
            }
        }
    }
}