// Oppgave 1 - Eksamen 2018

public class Oppg1 {
    
    // Objektvariabel - innkapsling
    private String startSted, sluttSted, billettEier;
    private int startDato, sluttDato, antPersoner;
    private double pris, rabattPros;

    // konstruktør
    public Billett(String startSted, String sluttSted, String billettEier, int startDato, 
                   int sluttDato, int antPersoner, double pris, double rabattPros) {
        this.startSted = startSted;
        this.sluttSted = sluttSted;
        this.billettEier = billettEier;
        this.startDato = startDato;
        this.sluttDato = sluttDato;
        this.antPersoner = antPersoner;
        this.pris = pris;
        this.rabattPros = rabattPros;          
    }

    // Objektmetoder 

    // get-metode
    public String getbillettEier() { return billettEier; }

    // set-metode
    public void setBillettEier(String billettEier) {
        this.billettEier = newBillettEier;
    }
}
