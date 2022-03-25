import javafx.scene.layout.BorderPane;
import static javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BorderLayout {
    
    Button knapp = new Button();
    Label etikett = new Label();
    TextField status = new TextField();
    
    public void start(Stage vindu) {
    // Norsk = soneorganisering
    BorderPane panel = new BorderPane();
    /*  Top - komp1
        left - komp2
        Center - komp3
        Right - komp4
        Bottom - komp5
        Ett slags kompass 
        Sonen ekspanderer, dvs. proøver å fortrenge andre soner som ikke har (stort nok) innhold.
    */
    panel.setTop(etikett);
    panel.setCenter(knapp);
    panel.setButtom(status);
    // De 5 sonene har hver sin posisjonsmetode

    // hvis du ikke har gjort det over, må du gjøre dette (Defualt justeringen er til venstre).
    panel.setAlignment(etikett, Pos.CENTER);
    panel.setAlignment(status, Pos.CENTER);

    // mer enn 5 komponenter?'
    // den som lå opprinnelig der forsvinner fordi den nye komponenten blir brukt.
    // Løsning: panel
    }
}
