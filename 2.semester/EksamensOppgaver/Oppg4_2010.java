/* Kap 8: Ekstra oppgave fra Eksamen 04.05.2010 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.geometry.*;
import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;

public class Oppg4_2010 extends Application {
  private final double US_KURS = 8.71;
  private ComboBox<String> liste;
  private Button knapp1, nullstill;
  private TextField tekstUS, tekstNOR;
  private String[] alternativ = {"Dollar", "Fahrenheit", "Miles"};

  public void start(Stage vindu) {
    FlowPane panel = new FlowPane();
    panel.setHgap(10);
    panel.setVgap(10);  
    Label ledetekst = new Label("Omregner verdier fra noen utvalgte USA-enheter til verdier i norske enheter.");
    panel.getChildren().add(ledetekst);
    panel.setAlignment(Pos.CENTER);
    
    Label usEtikett = new Label("Verdi i USA: ");
    // Oppretter det første tekstfeltet
    tekstUS = new TextField();
    tekstUS.setPrefColumnCount(7);

    // Nedtrekksliste 
    liste = new ComboBox<String>();
    liste.getItems().addAll(alternativ);
    liste.getSelectionModel().select(1);

    Label norEtikett = new Label("Verdi i Norge: ");
    // Oppretter det andre tekstfeltet
    tekstNOR = new TextField();
    tekstNOR.setPrefColumnCount(7);
    
    // Oppretter den første knappen
    knapp1 = new Button("Beregn");
    // Oppretter den andre knappen
    nullstill = new Button("Blank ut");

    liste.setOnAction(e -> behandleklikk(e));
    knapp1.setOnAction(e -> behandleklikk(e));
    nullstill.setOnAction(e -> behandleklikk(e));

    panel.getChildren().addAll(usEtikett,tekstUS,liste,norEtikett,tekstNOR,knapp1,nullstill);

    Scene scene = new Scene(panel, 478, 120);
    // vindu.setResizable(false);
    vindu.setTitle("Konverteringshjelp");
    vindu.setScene(scene);
    vindu.show();
  }

  public void behandleklikk(ActionEvent e) {
    if (e.getSource() == knapp1 || e.getSource() == liste ) {
        String talltekst = tekstUS.getText();
        double usBeløp = parseDouble(talltekst);
        double norBeløp = Math.round(usBeløp * US_KURS);
        tekstNOR.setText("" + norBeløp);
    } 
    else if (e.getSource() == nullstill) {
        tekstUS.setText("");
        tekstNOR.setText("");
    }
  }

  public static void main(String[] args) {
    launch(args);
  }

}
