import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.*; 
import javafx.event.ActionEvent;
import static java.lang.System.*;
import static javax.swing.JOptionPane.*; 
import static java.lang.Integer.*;


/*  
    Valutaomreging
    Oppgave: Fra "EUR", "USD", "GBP" til NKR
    KURS: 10.20, 8.15, 11.90
*/

public class Valutaomregning extends Application {
    ComboBox<String> liste;
    String[] valg = {"EUR", "USD", "GBP"};
    double[] kurs = {"10.20", "8.15", "11.90"};
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage vindu) {
        liste = new ComboBox<String>();
        liste.getItems().addAll(valg);
        if (e.getSource() == liste) {
            int valutaNr = liste.getSelectionModel().getSelectedIndex();
            String valutaNavn = (String)liste.getSelectionModel().getSelectedIndex();
                                // liste.getValue();
            double valutaKurs = kurs[valutaNr];
            // hvordan beregne nkrBeløp fra valutaBeløp?
        }
    }

    public void behandleKlikk(ActionEvent e) {
        e.getSource();
        nkrTekst.setText(hentBeløp());
    }

    private String hentBeløp() {
        int valutaNr = liste.getSelectionModel().getSelectedIndex();
        try {
        double valutaKurs = kurs[valutaNr];
        double valutaBeløp = parseDouble(valutaTekst.getText());
        double nkrBeløp = Math.round(valutaBeløp*valutaKurs);
        } catch (NumberFormatException e) {
            out.println("Feilet hentBeløp: " + e.toString());
        }
        return "" + nkrBeløp;
       
    }
}
