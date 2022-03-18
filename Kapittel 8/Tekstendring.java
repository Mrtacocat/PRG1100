/* Kap. 8: teksthåndtering - fjerner spesialtegn*/ 
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.*; 
import javafx.event.ActionEvent;

public class Tekstendring extends Application {

  private Button knapp;  
  private TextField tekstfelt;  

  public void start(Stage vindu) { 
    FlowPane panel = new FlowPane();
    panel.setHgap(10);
    knapp = new Button("Fjern tegn");
    knapp.setOnAction(e -> behandleKlikk(e));
    tekstfelt = new TextField(); 
    tekstfelt.setPrefColumnCount(25);
    panel.getChildren().addAll(knapp, tekstfelt); 
    Scene scene = new Scene(panel);
    vindu.setTitle("Tekstendring");
    vindu.setScene(scene);
    vindu.show();
  }
  
  public void behandleKlikk(ActionEvent event) {
      String tekst = tekstfelt.getText();
      //tekst = tekst.replace('!', ' ');
      tekst = tekst.replaceAll("(!|,|\\.|\\?)+", "");
      tekstfelt.setText(tekst);
  }

  public static void main(String[] args) {
    launch(args);
  }

}