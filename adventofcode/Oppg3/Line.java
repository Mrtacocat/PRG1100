import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
import java.util.*; 
import java.io.*;

public class Line {
    public int x1;
    public int y1;
    public int x2;
    public int y2;

    public Line(int x1, int y1, int x2, int y2){
       this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int cross(Line l) {
        int cx = 0;
        int cy = 0;

        if(x1 == x2) {
            if(l.y1 == l.y2) {
                cx = x1;
                cy = l.y1;
            } else {
                return -1;
            }
        } else {
            if(l.y1 == l.y2) {
                cx = l.x1;
                cy = y1;
            } else {
                return -1;
            }
        }

        boolean testx1 = cx >= Math.min(x1, x2) && cx >= Math.min(x1, x2);
        boolean testy1 = cy >= Math.min(y1, y2) && cy >= Math.min(y1, y2);
        boolean testx2 = cx >= Math.min(l.x1, l.x2) && cx >= Math.min(l.x1, l.x2);
        boolean testy2 = cy >= Math.min(l.y1, l.y2) && cy >= Math.min(l.y1, l.y2);

        if(testx1 && testy1 && testx2 && testy2) {
            if(x1 == x2) {
                return Math.abs(x1) + Math.abs(l.y1);
            } else {
                return Math.abs(y1)+ Math.abs(l.x1);
            }
        } else {
            return -1;
        }
    }

    
}
