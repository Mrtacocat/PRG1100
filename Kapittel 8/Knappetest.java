import static java.lang.System.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class Knappetest extends Application {
    
    Button knapp;
    TextField tekstfelt;

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage vindu) {
        FlowPane panel = new FlowPane();
        knapp = new Button("Klikk her!");
        tekstfelt = new TextField();
        tekstfelt.setPrefColumnCount(15);
        panel.getChildren().addAll(knapp, tekstfelt);
        vindu.setTitle("Knappetrykking");
        Scene scene = new Scene(panel);
        vindu.setScene(scene);
        vindu.show();
    }
    public void behandleKlikk() {
        // Aktivitet/Hendelseshåndtering

    }


}
