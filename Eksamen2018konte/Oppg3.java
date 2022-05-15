import static java.lang.System.*;

import javax.swing.Action;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import static java.lang.Integer.*;

public class Oppg3 extends Application {

    ComboBox<String> liste;
    String[] valg = {"Mann", "Kvinne"};
    TextField txtAlder, txtHøyde, txtVekt, txtKFP;
    Button btnKFP, blankUt;
   
    public void start(Stage vindu) {
        FlowPane panel = new FlowPane();
        panel.setHgap(20);
        panel.setVgap(5);
        panel.setAlignment(Pos.CENTER); 

        Label lbltopp = new Label("Kroppsfettprosent: Oppgi alder, høyde i m og vekt i kg");
        panel.getChildren().addAll(lbltopp);

        Label alder = new Label("Alder:");
        txtAlder = new TextField();
        txtAlder.setPrefColumnCount(6);
        panel.getChildren().addAll(alder, txtAlder);

        Label høyde = new Label("Høyde (m):");
        txtHøyde = new TextField();
        txtHøyde.setPrefColumnCount(6);
        panel.getChildren().addAll(høyde, txtHøyde);

        Label kjønn = new Label("Kjønn:");
        liste = new ComboBox<String>();
        liste.getItems().addAll(valg);
        panel.getChildren().addAll(kjønn, liste);

        Label vekt = new Label("Vekt (kg):");
        txtVekt = new TextField();
        txtVekt.setPrefColumnCount(6);
        panel.getChildren().addAll(vekt, txtVekt);

        btnKFP = new Button("Beregn KFP");
        btnKFP.setOnAction(e -> behandleKlikk(e));
        
        txtKFP = new TextField();
        txtKFP.setPrefColumnCount(7);
        txtKFP.setEditable(false);

        blankUt = new Button("Blank ut");
        blankUt.setOnAction(e -> behandleKlikk(e));
        panel.getChildren().addAll(btnKFP, txtKFP, blankUt);



        Scene scene = new Scene(panel, 330, 150);
        vindu.setTitle("KFP-Kalkulator");
        vindu.setScene(scene);
        vindu.setResizable(false);
        vindu.show();

    }
    
    public void behandleKlikk(ActionEvent e) {
        if (e.getSource() == blankUt)
        blankUtGUI();
        else if (e.getSource() == btnKFP)
        gjennomførBeregning();
    }

    private void blankUtGUI() {
        txtAlder.setText("");
        txtHøyde.setText("");
        txtVekt.setText("");
    }

    private void gjennomførBeregning() {
        try {
            int A = parseInt( txtAlder.getText() );
            float H = Float.parseFloat( txtHøyde.getText() );
            float V = Float.parseFloat( txtVekt.getText() );
            double BMI=V/H*H;
            double KFP=1.20*BMI+(0.23*A)-5.40;

            txtKFP.setText("KFP = " + KFP);
        }
        catch (NumberFormatException ex) {
            out.println("Feilet: " + ex.toString());
        }
    }

    public static void main(String[] args) {
        launch(args);
      }

    
}
