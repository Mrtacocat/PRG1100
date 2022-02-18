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

public class Student {
	//Objektvariabler-attrubutter-instans
	//Bruker innkapsling - begrenset tilgang til objektvariablene

	private int studNr;
	private int fødselsÅr;
	private char kjønn;
	private String fornavn;
	private String etternavn;


	//Konstruktør
	public Student(int inNr, int inÅr, char inKjønn, String inFornavn, String inEnavn) {
		studNr = inNr;
		fødselsÅr = inÅr;
		kjønn = inKjønn;
		fornavn = pent(inFornavn);
		etternavn = pent(inEnavn);
	}
	//Overlaster konstruktøren
	public Student(int studNr){
		this.studNr = studNr;
		//Dummy verdier
		fødselsÅr = 1970;
		kjønn = 'K';
		fornavn = "Kari";
		etternavn = "Normann";
	}
	public Student(int studNr, char kjønn, String fornavn, String etternavn){
		this(studNr, 1900, kjønn, fornavn, etternavn);
	}
	public Student(){
		
	}
	//Objektmetoder
	//get metoder for innkapsling
	public int getStudNr(){return studNr;}
	public char getKjønn() {return kjønn;}
	public String getFornavn() {return pent(fornavn);}
	public String getEtternavn() {return pent(etternavn);}
	public int getFødselsÅr() {return fødselsÅr;}
	//Set metoder
	public void setStudnr(int nyttStudNr){studNr = nyttStudNr;}
	public void setEtternavn(String nyttEtternavn){etternavn = nyttEtternavn;}
	public void setFornavn(String nyttFornavn){fornavn = nyttFornavn;}
	public void setKjønn(char nyttKjønn){kjønn = nyttKjønn;}
	public void setFødselsÅr(int nyttFødselsÅr){fødselsÅr = nyttFødselsÅr;}

	public boolean erKvinne(){
		return (kjønn == 'K') || (kjønn == 'k');
	}
	public String toString(){
		return studNr + " ; " + fødselsÅr + " ; " + kjønn + " ; " + fornavn + " ; " + etternavn;
	}
	public String skrivEtternavn(){
		return etternavn + " ; " + fornavn + " ; " + kjønn + " ; " + fødselsÅr + " ; " + studNr;
	}
	public boolean equals(Student annen){
		if(annen == null)
			return false;
		return studNr == annen.studNr;
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