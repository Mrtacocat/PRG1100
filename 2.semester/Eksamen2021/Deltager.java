// OPPGAVE A
import java.util.Arrays;

// OPPGAVE 1
public class Deltager {

    // Objektvariabler
    private String navn;
    private int idnr; 
    private int[] liste;

    // Konstruktør - hvis overlasting skriv = (-er)
    public Deltager(String navn, int idnr, int[] liste) {
        this.navn = navn;
        this.idnr = idnr;
        this.liste = liste;
    }

    //get-metode
    public int getIdnr() {
        return idnr;
    }
    public String getNavn() {
        return navn;
    }
    public int[] getListe() {
        return liste;
    }
    // NB! ikke set-metoder her 
    
    //set-metode
    /*public void set() {
        
    }*/

    public String toString() {
        return idnr+";"+navn+";"+Arrays.toString(liste);
    }
   
}
/*
// OPPGAVE B
 // kun nødvendige intruksjoner er tatt med
String ut = "Mest besøkt:" + "\n";
for(Deltager deltager:deltagerliste) 
    if( deltager.getListe().length >= 5 ) 
        ut += deltager.getNavn() + " - " + deltager.getListe().length;
showMessageDialog(null, ut);*/

