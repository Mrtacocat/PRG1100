import static java.lang.System.*;
import java.io.IOException;
import javax.swing.Action;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Klikking extends Application {
    
    public void start(Stage s) { 
        panel.getChildren().addAll(/*Komponenter*/);
        Scene scene = new Scene(panel, 300, 200);
        vindu.setScene(scene);
        vindu.setTitle("Knappeklikk");
        vindu.setResizable(false);
        vindu.setAlwaysOnTop(True);
        vindu.setX(30); vindu.setY(50);
        vindu.show();
    }
 public static void main(String[] args) {
        launch(args);
    }

    // Flow layout (linjeorganisering) er enkel å bruke og fungerer fint hvis vi f.eks. låser vindustørrelsen.
    // Komponentene vises i den rekkefølge de legges ut på panelet.
}