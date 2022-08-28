import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
import java.util.*;

// ops = operations

public class intComp {
    int[] ops;
    int pointer = 0;

    public intComp(String s){
        // Split string into array
        String[] delimited = s.split(",");
        ops = new int[delimited.length];
        for(int i = 0; i < delimited.length; i++){
            ops[i] = Integer.parseInt(delimited[i]);
        }
    }

    public int RunProgram(){
        // Iterate
        while(ops[pointer] != 99){
            
            switch(ops[pointer + 0]) {
                case 1: // plusse
                    ops[ops[pointer + 3]] = ops[ops[pointer + 1]] + ops[ops[pointer + 2]];
                    pointer += 4;
                    break;
                case 2: // gange
                    ops[ops[pointer + 3]] = ops[ops[pointer + 1]] * ops[ops[pointer + 2]];
                    pointer += 4;
                    break;
                default:
                    out.println("Error");
            }

        }

        return ops[0];
    }



}
