public class Dimensjon {
    private int bredde, høyde;
    public Dimensjon(int bredde, int høyde) {
      this.bredde = bredde;
      this.høyde = høyde;  
    }  
    public void setBredde() {  
      this.bredde = bredde;  
    }
    public void setHøyde() {  
      this.høyde = høyde;    
    }  
    public int getBredde() {
      return bredde;  
    }
    public int getHøyde() {  
      return høyde;   
    }  
    public int areal() {  
      return bredde*høyde;   
    }
    public boolean equals(Dimensjon a) {
      return bredde == a.bredde &&
             høyde == a.høyde;
    }
    public String toString() {
      return bredde+"x"+høyde;
    }
     
  }