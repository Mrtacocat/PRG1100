
    /* Kapittel 5, oppgave
   Tekst om programmet
   C.W.R Jan 2022
*/
import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
import java.util.*;

public class Medlem {
	//Objektvariabler-attrubutter-instans
	//Bruker innkapsling - begrenset tilgang til objektvariablene

	private int Nr;
	private int tlf;
	private String fornavn;
	private String etternavn;


	//Konstruktør
	public Medlem(int inNr, int inTlf, String inFornavn, String inEnavn) {
		Nr = inNr;
        tlf = inTlf;
		fornavn = pent(inFornavn);
		etternavn = pent(inEnavn);
	}

	//Objektmetoder
	//get metoder for innkapsling
	public int getNr(){return Nr;}
	public String getFornavn() {return pent(fornavn);}
	public String getEtternavn() {return pent(etternavn);}
	public int getTlf() {return tlf;}
	//Set metoder
	public void setNr(int nyttNr){Nr = nyttNr;}
	public void setEtternavn(String nyttEtternavn){etternavn = nyttEtternavn;}
	public void setFornavn(String nyttFornavn){fornavn = nyttFornavn;}
	public void setTlf(int nyttTlf){tlf = nyttTlf;}

	public String toString(){
		return Nr + " ; " + fornavn + " ; " + etternavn + " ; " + tlf;
	}
	public String skrivEtternavn(){
		return etternavn + " ; " + fornavn + " ; " + tlf + " ; " + Nr;
	}
	public boolean equals(Medlem annen){
		if(annen == null)
			return false;
		return Nr == annen.Nr;
	}
	public String navn(){
		return pent(etternavn) + ", " + pent(fornavn);
	}
	private String pent(String navn){
		char i = navn.toUpperCase().charAt(0);
		String n = navn.toLowerCase();
		return i+n.substring(1);
	}


}

