/*  Kap.8: eksempel på javaFX
    En trekkemaskin som trekker tilfeldige heltall
*/
import static java.lang.Integer.*;
import static javax.swing.JOptionPane.*;
import static java.lang.System.*;
import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField; 
import javafx.event.ActionEvent;


public class Trekkemaskin extends Application {

  private Button knapp;  
  private TextField tekstfelt, min, max;  


  public void start(Stage vindu) { 
    FlowPane panel = new FlowPane();
    panel.setHgap(10);
    panel.setVgap(10);
    knapp = new Button("Trekk");
    knapp.setOnAction(e -> behandleKlikk(e));
    tekstfelt = new TextField(); 
    Label minTekst = new Label("Min: ");
    min = new TextField();
    min.setPrefColumnCount(4);
    Label maxTekst = new Label("  Max: ");
    max = new TextField();
    max.setPrefColumnCount(4);

    panel.getChildren().addAll(knapp, tekstfelt, minTekst, min, maxTekst, max); 
    Scene scene = new Scene(panel, 220, 80);
    vindu.setTitle("Trekkemaskin");
    vindu.setScene(scene);
    vindu.show();
  }
  
  public void behandleKlikk(ActionEvent event) {
    try {
      
    int start = parseInt(min.getText());
    int slutt = parseInt(max.getText());
    int tall = Min.trekkTall(start, slutt); 
     
    } catch (NumberFormatException ex){
      tekstfelt.setText("Mangler min/max");
    }
    
  }

  public static void main(String[] args) {
    launch(args);
  }

}