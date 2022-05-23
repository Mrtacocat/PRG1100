// Oppg1
public class Oppg1 {
    private Person  kjøper;
    private int     antall;
    private double  rabatt, pris;
    private String  startSted, sluttSted;
    private Tid     startTid, sluttTid; // egen datatype for data og tid

    // konstruktør
    public Billett (String kjøper, int antall, double rabatt, double pris,
                    String startSted, String sluttSted,
                    String startTid, String sluttTid) {
        this.kjøper = kjøper;
        this.antall = antall;
        this.rabatt = rabatt;
        this.pris   = pris;
        this.startSted = startSted;
        this.sluttSted = sluttSted;
        this.startTid  = startTid;
        this.sluttTid  = sluttTid;  
    }

    // set- og get-metodene for alle objektvariabler, men velger: 
    // set-metode
    public void setRabatt(double nyRabatt) {
        rabatt = nyRabatt;
    }
    // get-metode
    public double getRabatt() {
        return rabatt;
    }



}
