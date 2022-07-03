import static java.lang.System.*;

import java.util.concurrent.Flow;

import javax.xml.namespace.QName;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*; // FlowPane
import javafx.scene.control.*; // Button, TextField
import javafx.event.*;

public class Flereknappeklikk extends Application {
    // deklarasjon av objektvariabler
    Button knapp1, knapp2, blankUt;
    TextField tekst1, tekst2;
    int antKlikk1, antKlikk2; // Nullstille?

    public static void main(String[] args) { launch(args); }

    public void start(Stage vindu) {
        // Opprette GUI, gjøre komponenter tilgjengelige
        FlowPane panel = new FlowPane();
        Label info = new Label("Klikk på en av knappene");
        knapp1 = new Button("Knapp 1");
        knapp1.setOnAction( e -> behandleKlikk(e) );
        tekst1 = new TextField();
        tekst1.setPrefColumnCount(15);
        knapp2 = new Button("Knapp 2");
        knapp2.setOnAction( e -> behandleKlikk(e) );
        tekst2 = new TextField();
        tekst2.setPrefColumnCount(15);
        
        blankUt = new Button("Nullstill");
        blankUt.setOnAction( e -> behandleKlikk(e));

        panel.getChildren().addAll(info, knapp1, tekst1, knapp2, tekst2, blankUt);
        Scene scene = new Scene(panel);
        vindu.setTitle("Flere Knappeklikk");
        vindu.setScene(scene);
        vindu.show();

    }

    public void behandleKlikk(ActionEvent e) {
        // Håndtere hendelser fra GUI-Komponenter
        if ( e.getSource() == knapp1 ) {
            antKlikk1++;
            tekst1.setText("Antall klikk = " + antKlikk1);
        } 
        else if ( e.getSource() == knapp2 ) {
            tekst2.setText("Antall klikk = " + ++antKlikk2);
        } 
        else if ( e.getSource() == blankUt ){
            tekst1.setText(""); 
            antKlikk1 = 0;
            tekst2.setText(""); 
            antKlikk2 = 0;
        }
    }
}