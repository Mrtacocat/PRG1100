import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
import java.util.*;
import javafx.scene.transform.Scale;

public class DiplomUtskrift {
    public void finnBesteRundetider(Deltager[] deltagerliste) {
        
        final String FILNAVN = "heat.txt";
        File fil;
        Scanner reader = null;

        
        try {
            fil = new File("heat.txt");
            reader = new Scanner(fil);

            int linjer = 0;
            int antallDeltagere = 0;
            
            while(reader.hasNextLine()) {
                int id = Integer.parseInt(reader.nextLine().split(";")[0]);

                if(id > antallDeltagere) {
                    antallDeltagere = id;
                }

                linjer++;
            }

            reader.close();
            reader = new Scanner(fil);


            for(int i = 0; i < linjer; i++) {
                String[] linjedeler = reader.nextLine().split(";");

                int id = Integer.parseInt(linjedeler[0]);
                double rundetid = Double.parseDouble(linjedeler[2]);

                for(Deltager d : deltagerliste) {
                    if(d.getKjoreToyId() == id){
                        d.registererBesteRundeTid(rundetid);
                        break;
                    }
                }
            }

        }catch (IOException eo) {
            out.println("Feil ved å åpne filen: '" + FILNAVN + "', feilmelding: " + eo.toString());
        }catch (FileNotFoundException ex) {
            out.println("Finner ikke filen: '" + FILNAVN + "', feilmelding: " + ex.toString());
        }catch (Exception e) {
            out.println("Generell feil: '" + FILNAVN + "', feilmelding: " + e.toString());
        }finally{
            if(reader != null){
                try{
                    reader.close();
                }catch(Exception e){
                    out.println("Kunne ikke lukke filen: '" + FILNAVN + "', feilmelding: " + e.toString());
                }
            }
        }
    }

    public String[] skrivDiplomer(Deltager[] deltagerliste) { 
        
            String filnavn = "";
            File fil;
            FileWriter writer = null;
            String[] returVariabel = String[deltagerliste.length];
    
            
            try {
                int i = 0;
                for(deltager d : deltagerliste) {
                    filnavn = "diplom-" + d.getNavn() + ".txt";
                    returVariabel[i++] = filnavn;
                    
                    String[] tilSkriving = new String[11];
                    tilSkriving[0] = "---";
                    tilSkriving[1] = "Gratulerer " + d.getNavn() + ",";
                    tilSkriving[2] = "";
                    tilSkriving[3] = "Du har gjennomført gokartkjøring hos fart og Spenning AS";
                    tilSkriving[4] = "";
                    tilSkriving[5] = "Din beste rundetid ble:";
                    tilSkriving[6] = "";
                    tilSkriving[7] = d.getRundetid() + " sekunder";
                    tilSkriving[8] = "";
                    tilSkriving[9] = "Velkommen tilbake!";
                    tilSkriving[10] = "---";

                    fil = new File(filnavn);
                    writer = new FileWriter(fil);
                    for ( String s : tilSkriving ) {
                        writer.println(s);
                    }
                    writer.close();
                }
    
            }catch (IOException eo) {
                out.println("Feil ved å skrive filen: '" + filnavn + "', feilmelding: " + eo.toString());
            }catch (Exception e) {
                out.println("Generell feil: '" + filnavn + "', feilmelding: " + e.toString());
            }finally{
                if(writer != null){
                    try{
                        writer.close();
                    }catch(Exception e){
                        out.println("Kunne ikke lukke filen: '" + filnavn + "', feilmelding: " + e.toString());
                    }
                }
            }

            return returVariabel;
        
    }
}
