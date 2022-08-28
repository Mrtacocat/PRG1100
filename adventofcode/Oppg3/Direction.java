import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
import java.util.*; 
import java.io.*;

public class Direction {
    public int direction;
    public int length;

    public Direction(int dir, int len) {
        direction = dir;
        length    = len;
    }

    public Direction(String s) {
        char first = s.charAt(0);
        
        switch(first) {
            case 'U':
                direction = 0;
                break;                
            case 'R':
                direction = 1;
                break;
            case 'D':
                direction = 2;
                break;
            case 'L':
                direction = 3;
                break;
            
        }

        length = Integer.parseInt(s.substring(1));
    }
}
