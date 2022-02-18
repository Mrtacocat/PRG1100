import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
import java.util.*;

public class Headphones {

    String chargerPort = "Micro usb";
    String[] controls = {"power", "volume", "skip", "play/pause"};
    String color = "Red/black";

    static boolean power = false;
    static int volume = 0;

    public static void powerOn() {
      power = true;
    }

    public static void powerOff() {
      power = false;  
    }

    public static void volumeUp() {
      volume++;
    } 

    public static void volumeDown() {
      volume--;
    }
}