/*  Eksamen mai 2022
    Oppgave 1
    Christoffer Riis
*/
// OPPGAVE A 
public class Bilde {

    // Objektvariablene
    String tittel, kunstner, type;
    int årstall, dimensjon;
    boolean innrammet;
    int[] bildeTab;

    // Konstruktør
    public Bilde(String tittel, String kunstner, String type, 
                 int årstall, int dimensjon, boolean innrammet) {
        this.tittel = tittel;
        this.kunstner = kunstner;
        this.type = type;
        this.årstall = årstall;
        this.dimensjon = dimensjon;
        this.innrammet = innrammet;
    }
    
    public int[] getListe() {
        return bildeTab;
    }

    
    // toString metode for å vise tilstanden til et bilde-objekt
    /*if (innrammet) {
        out.println("bilde er innrammet!");
    } 
    else {
        out.println("Bilde er uten ramme.");
    }*/
    public String toString() {
        return tittel+";"+kunstner+";"+innrammet;
    }
    
    public boolean equals(Bilde annen) {
        return (tittel.equals(annen.tittel) 
            && kunstner.equals(annen.kunstner) 
            && type.equals(annen.type) 
            && dimensjon == annen.dimensjon
            && årstall == annen.årstall 
            && innrammet == annen.innrammet);
    }

// Oppgave B
// metoder er tatt fra dimensjons klassen
/*
    String ut = "Resultat: " + "\n";
    for(Bilde bilde:bildeTab) 
        if (bilde.getListe().length <= 25 )
            ut += bilde.getBredde() + " - " + bilde.getHøyde() + " - " + bilde.getListe().length;
    showMessageDialog(null, ut);
*/
}
