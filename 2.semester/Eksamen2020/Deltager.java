public class Deltager {

    private String navn;
    public String getNavn() {
        return navn;
    }

    public void setNavn(int navn) {
        this.navn = navn;
    }

    private String epost;
    public String getEpost() {
        return epost;
    }
    public void setEpost(String epost) {
        this.epost = epost;
    }

    private int telefonnummer;
    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(int telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

   
    private java.time.LocalDate signertRisikoSkjema;
    public String getsignertRisikoSkjema() {
        return signertRisikoSkjema;
    }
     
    public void setsignertRisikoSkjema(java.time.LocalDate signertRisikoSkjema) {
        this.signertRisikoSkjema = signertRisikoSkjema;
    }

    private int rundetid;
    public int getRundetid() {
        return rundetid;
    }

    public Deltager(String navn, String epost, int telefonnummer, java.time.LocalDate signertRisikoSkjema) {
        this.navn = navn;
        this.epost = epost;
        this.telefonnummer = telefonnummer;
        this.signertRisikoSkjema = signertRisikoSkjema;

        rundetid = 0;
    }

    public void registererBesteRundeTid(int tid) {
        if(tid < rundetid || rundetid == 0) {
            rundetid = tid;
        }
    }
}

