import static java.lang.System.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*; // FlowPane
import javafx.scene.control.*; // Button, TextField
import javafx.event.*;

public class Knappetest extends Application {
    
    int antall = 0;
    Button knapp;
    TextField tekstfelt;

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage vindu) {
        FlowPane panel = new FlowPane();
        knapp = new Button("Klikk her!");
        knapp.setOnAction(e -> behandleKlikk(e));
        tekstfelt = new TextField();
        tekstfelt.setPrefColumnCount(15);
        panel.getChildren().addAll(knapp, tekstfelt);
        vindu.setTitle("Knappetrykking");
        Scene scene = new Scene(panel);
        vindu.setScene(scene);
        vindu.show();
    }
    public void behandleKlikk(ActionEvent e) {
        // Aktivitet/Hendelseshåndtering
        antall++;
        tekstfelt.setText("Antall klikk = " + antall);

    }


}
