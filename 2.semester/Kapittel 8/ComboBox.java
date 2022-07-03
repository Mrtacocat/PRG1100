import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ComboBox {
    ComboBox<String> liste;
    String[] valg = {"default", "Alternativ 1", "Alternativ 2", "Alternativ 3"};

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage vindu) {
        liste = new ComboBox<String>();
        liste.getItems().addAll(valg);
        liste.setOnAction( e -> behandleKlikk(e) );
    }

    public void behandleKlikk(ActionEvent e) {
        
    }
}
