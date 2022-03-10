/*
  Programforklaring
*/

import static java.lang.System.*;

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

public class button extends Application {
    
    @Override
    public void start(Stage s) { 
        // set title 
        s.setTitle("Creating Buttons");

        // create button
        Button b = new Button("Button");

        // create a stack pane
        TilePane r = new TilePane();    

        // create a label
        Label l = new Label("Button not selected");

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                l.setText("Button Selected");
            }
        };

        // when button is pressed
        b.setOnAction(event);

        // add button
        r.getChildren().add(b);
        r.getChildren().add(l);

        // create a scene
        Scene sc = new Scene(r, 200, 200);

        // set the scene
        s.setScene(sc);
        s.show();



    }
 public static void main(String[] args) {
        launch(args);
    }
}