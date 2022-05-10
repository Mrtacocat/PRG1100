import static java.lang.System.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import static java.lang.Integer.*;

public class Knappetest extends Application {

  private int antall = 0;
  private Button blankUt, beregning;  
  private TextField tekstLengde, tekstHøyde, tekstDypde, tekstVolum;  

  public void start(Stage vindu) { 
    FlowPane panel = new FlowPane();
    panel.setHgap(10);
    panel.setVgap(10);
    panel.setAlignment(Pos.CENTER);


    Label topp = new Label("Oppgi målene på oljetankene i feltene under!");
    panel.getChildren().addAll(topp); 
    
    Label lengde = new Label("Tanklengde L i cm:");
    tekstLengde = new TextField(); 
    tekstLengde.setPrefColumnCount(10);
    panel.getChildren().addAll(lengde, tekstLengde); 

    Label høyde = new Label("Tankhøyde H i cm:");
    tekstHøyde = new TextField(); 
    tekstHøyde.setPrefColumnCount(10);
    panel.getChildren().addAll(høyde, tekstHøyde); 
 
    Label dypde = new Label("Oljedypde D i cm:");
    tekstDypde = new TextField(); 
    tekstDypde.setPrefColumnCount(10);
    panel.getChildren().addAll(dypde, tekstDypde); 
  
    Label volum = new Label("Oljerestvolum i liter:");
    tekstVolum = new TextField(); 
    tekstVolum.setPrefColumnCount(9);
    panel.getChildren().addAll(volum, tekstVolum); 


    beregning = new Button("Beregn resvolum");
    beregning.setOnAction(e -> behandleKlikk(e));
    blankUt = new Button("Blank ut");
    blankUt.setOnAction(e -> behandleKlikk(e));
    panel.getChildren().addAll(beregning, blankUt); 

    
    Scene scene = new Scene(panel, 300, 200);
    vindu.setTitle("Oljekalkulator'n");
    vindu.setScene(scene);
    vindu.setResizable(false);
    vindu.show();
  }
  
  public void behandleKlikk(ActionEvent e) {
      if ( e.getSource() == blankUt )
      blankUtGUI();
      else if ( e.getSource() == beregning )
      gjennomførBeregning();

  }

  public static void main(String[] args) {
    launch(args);
  }

  private void blankUtGUI() {
    tekstLengde.setText("");
    tekstHøyde.setText("");
    tekstDypde.setText("");
    tekstVolum.setText("");
  }

  private void gjennomførBeregning() {
    try {
    // henter inndata
    int L = parseInt( tekstLengde.getText() );
    int H = parseInt( tekstHøyde.getText() );
    int D = parseInt( tekstDypde.getText() );
    double R=H/2.0;
    double V = L*(R*R*Math.acos((R -D)/ R) - (R-D)*Math.sqrt(D*(2*R-D)) );
    V = V/1000; // 1000 cm^3 -> 1 liter

    tekstVolum.setText("" + (int)Math.round(V));
    }
    catch (Exception e) {
      out.println("Feilet: " + e.toString());
    }
  }

}