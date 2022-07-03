/*  Eksamen mai 2022
    Oppgave 3
    Christoffer Riis
*/
import static java.lang.System.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.*;
import java.util.*;
import java.io.*;

public class Oppg3 extends Application {

    final static int MAX = 100; // Max antall brukere

    static int antallBrukere = 0; // antall brukere

    Label       etikettInfo;
    TextField   txtBrukernavn, txtPassord;
    Button      knappLoggInn, knappGlemt;

    String[] brukerTab  = new String[MAX];
    String[] passTab    = new String[MAX];

    public void start(Stage vindu) {

        FlowPane panel = new FlowPane();
        panel.setHgap(5);
        panel.setVgap(5);
        panel.setAlignment(Pos.CENTER);
        
        etikettInfo = new Label("Skriv inn ditt brukernavn og passord!");
        panel.getChildren().add(etikettInfo);
        
        Label brukernavn = new Label("Brukernavn:");
        txtBrukernavn = new TextField();
        txtBrukernavn.setPrefColumnCount(12);
        panel.getChildren().addAll(brukernavn, txtBrukernavn);

        Label passord = new Label("Passord:");
        txtPassord = new TextField();
        txtPassord.setPrefColumnCount(12);
        panel.getChildren().addAll(passord, txtPassord);

        knappLoggInn = new Button("Logg inn");
        knappLoggInn.setOnAction(e -> behandleKlikk(e));
        panel.getChildren().add(knappLoggInn);

        knappGlemt = new Button("Glemt passord");
        knappGlemt.setOnAction(e -> behandleKlikk(e));
        panel.getChildren().add(knappGlemt);
       
        
        Scene scene = new Scene(panel, 250, 150);
        vindu.setTitle("Innlogging");
        vindu.setScene(scene);
        vindu.show();
    }
    public void behandleKlikk(ActionEvent e) {  
        if ( e.getSource() == knappLoggInn ) {
          utførLoggInn();
        }  
        else if ( e.getSource() == knappGlemt ) {
          etikettInfo.setText("Sendt melding om tilbakestilling av passord");
         // endreRegistrering();  
        }
    }

    private int utførLoggInn() {
        try {
            
            File fil = new File("login.txt");
            Scanner leser = new Scanner(fil);
            
            int nr=0;
            String brukernavn = txtBrukernavn.getText();
            String passord = txtPassord.getText();
            while ( leser.hasNextLine() ) {
                String linje = leser.nextLine();
                String[] dataTab = linje.split(";");

                if (brukernavn.equals(dataTab[0]) && passord.equals(dataTab[1])) {
                    etikettInfo.setText("Innlogging er godkjent og du sendes videre.");
                } else {
                    etikettInfo.setText("du har ikke gitt korrekt innloggingsdata!");
                }
            nr++;
            }
        }
        catch (Exception ex) {
            out.println("Feil: " + ex.toString());
        }
        return 0;
    }
        
 public static void main(String[] args) {
        launch(args);
    }
}
