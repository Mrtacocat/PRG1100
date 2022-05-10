// Oppgave 1 - Eksamen okt 2019

public class Seddel {

    // Objektvariabel - innkapsling (begrenset tilgang - private)
    private String land, valuta;
    private int    verdi, år, kvalitet;
    private double pris;

    // konstruktør
    public Seddel(String land, String valuta, int verdi, int år, int kvalitet, double pris) {
        this.land = land;
        this.valuta = valuta;
        this.verdi = verdi;
        this.år = år;
        this.kvalitet = kvalitet;
        this.pris = pris;
    }
    // Overlaster konstruktøren
    public Seddel(String land, String valuta, int verdi, int år) {
        this(land, valuta, verdi, år, -1, 0); // -1 = uvurdert kvalitet

    }

    // Objektmetoder

    // get-metode
    public int getKvalitet() { return kvalitet; }
    // set-metode
    public void setKvalitet(int kvalitet) { 
        if ( 0 <= kvalitet && kvalitet <= 3)
        this.kvalitet = kvalitet; 
    }

    public String toString() {
        return land +";"+ valuta +";"+ verdi +";"+ år +";"+ kvalitet +";"+ pris;
    }

    public boolean equals(Seddel annen) {
        return (land.equals(annen.land) && verdi == annen.verdi && valuta.equals(annen.valuta)
                && år == annen.år && kvalitet == annen.kvalitet && pris == annen.pris);
    }

    
}

/* b) Plubber ut norske sedler på minst 100 kr fra før 1960

    String ut = "Aktuelle Norske sedler (minst 100 kr, før 1960):" + "\n";
    int n=0;
    for( Seddel s: seddelTab )
        if ( s != null && s.getLan().equals("Norge") && s.getÅr() < 1960 && s.getVerdi() >= 100 ) {
            ut += s.toString() + "\n"
            n++;
        }
        if( n == 0 )
            ut += " - Fant ingen slike sedler!";
    showMessageDialog(null, ut);


*/