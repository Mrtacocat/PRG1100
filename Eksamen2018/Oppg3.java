import static java.lang.System.*;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class Oppg3 extends Application{
    
    private Button knappTlf, knappNavn, knappNy, knappSlett;
    private TextField content, tlfText, navnText, statusmelding;
    
    public void start(Stage primaryStage) {
        FlowPane panel = new FlowPane();
        panel.setHgap(7);
        panel.setVgap(10);
        panel.setAlignment(Pos.CENTER);
        knappTlf = new Button("Sorter tlf");
       // knappTlf.setOnAction(e -> actionPerformed(e));

        knappNavn = new Button("Sorter Navn");
       // knappNavn.setOnAction(e -> actionPerformed(e));

        content = new TextField();
        content.setPrefWidth(240);
        content.setPrefHeight(180);

        Label tlf = new Label("Tlf:");
        tlfText = new TextField();
        tlfText.setPrefColumnCount(6);

        Label navn = new Label("Navn:");
        navnText = new TextField();
        navnText.setPrefColumnCount(7);
        
        knappNy = new Button("Ny kontakt");
       // knappNy.setOnAction(e -> actionPerformed(e));
        
        knappSlett = new Button("Slett kontakt");
       // knappSlett.setOnAction(e -> actionPerformed(e));

        statusmelding = new TextField();
        statusmelding.setPrefColumnCount(20);
        statusmelding.setEditable(false);

        panel.getChildren().addAll(knappTlf, knappNavn, content, tlf, tlfText, navn, navnText, knappNy, knappSlett, statusmelding);


        Scene scene = new Scene(panel, 250, 330);
        primaryStage.setTitle("Kontakter");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    /*
    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() == knappTlf )
        sorterPåTlf();
        else if ( e.getSource() == knappNavn )
        sorterPåNavn();
        else if ( e.getSource() == knappNy )
        nyKontakt(); // Skal ikke kodes!
        else if ( e.getSource() == knappSlett )
        slettKontakt(); // Skal ikke kodes!
        } */
    public static void main(String[] args) {
        launch(args);
    }
}
