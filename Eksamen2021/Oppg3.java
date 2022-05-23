import javafx.application.Application;
import javafx.stage.Stage;  
import javafx.scene.Scene;  
import javafx.scene.layout.FlowPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;  
import javafx.geometry.Pos;  
import java.util.*;

import javax.swing.Action;

import java.io.*;

public class Oppg3 extends Application{
    
    String[]  turposter;
    Button    knappDeltager, knappTopp, knappSortering, knappBlankut;
    TextField txtId, txtNavn, txtPost, txtAntall;
    TextArea  tarInfo;

    public void start(Stage vindu) {
        FlowPane panel = new FlowPane();
            panel.setAlignment(Pos.CENTER);
            panel.setHgap(5);
            panel.setVgap(5);

        Label lblId = new Label("Gi deltagernr. (id):");
        txtId = new TextField();
        txtId.setPrefColumnCount(2);

        knappDeltager = new Button("Vis info");
        knappDeltager.setOnAction(e -> behandleKlikk(e));
        panel.getChildren().addAll(lblId, txtId, knappDeltager);
       
        Label lblNavn = new Label("Kallenavn:");
        txtNavn = new TextField();
        txtNavn.setPrefColumnCount(12);
        panel.getChildren().addAll(lblNavn, txtNavn);
       
        Label lblPost = new Label("Antall ulike turposter besøkt:");
        txtPost = new TextField();
        txtPost.setPrefColumnCount(3);
        panel.getChildren().addAll(lblPost, txtPost);

        Label lblAntall = new Label("Totalt antall turer registrert:");
        txtAntall = new TextField();
        txtAntall.setPrefColumnCount(3);
        panel.getChildren().addAll(lblAntall, txtAntall);

        tarInfo = new TextArea();
        tarInfo.setPrefColumnCount(16);
        tarInfo.setPrefRowCount(10);
        tarInfo.setEditable(false);
        panel.getChildren().add(tarInfo);

        knappTopp = new Button("Topp 5");
        knappTopp.setOnAction(e -> behandleKlikk(e));
        
        knappSortering = new Button("A -> Å");
        knappTopp.setOnAction(e -> behandleKlikk(e));

        knappBlankut = new Button("Blank ut");
        knappTopp.setOnAction(e -> behandleKlikk(e));
        
        panel.getChildren().addAll(knappTopp, knappSortering, knappBlankut);


        Scene scene = new Scene(panel, 240, 350);
        vindu.setScene(scene);
        vindu.setTitle("Tulltrim2021");
        vindu.setResizable(false);
        vindu.show();
    }
    
    public void behandleKlikk(ActionEvent e) {  
        /*if ( e.getSource() == knappDeltager )
          hentDeltager();
   else if ( e.getSource() == knappTopp )             
          hentTopp();          
   else */if ( e.getSource() == knappSortering )   
          hentSortering();    
   else if ( e.getSource() == knappBlankut )   
          blankUtDeltager();  
        }
        
    public void blankUtDeltager() {
        txtId.setText("");
        txtNavn.setText("");
        txtPost.setText("");
        txtAntall.setText("");
        tarInfo.setText("");
        turposter = null;
    }

    public void hentSortering() {
        // sorter turpostene alfabetisk
        String[] kopiposter = Arrays.copyOf(turposter, turposter.length);
        Arrays.sort(kopiposter);
        String ut = "";
        for(String s:kopiposter)
            ut += s + "\n";
            tarInfo.setText(ut);
            
    }

    public static void main(String[] args) {
        launch(args);
    }
}
