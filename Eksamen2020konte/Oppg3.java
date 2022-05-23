import static java.lang.System.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Oppg3 extends Application {
    
    public void start(Stage vindu) {
        FlowPane root = new FlowPane();
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        
        
        root.getChildren().add(btn);


        Scene scene = new Scene(root, 225, 300);
        vindu.setTitle("RomAdmin");
        vindu.setScene(scene);
        vindu.show();
    }
    private void behandleKlikk(ActionEvent e) {
        if ( e.getSource() == romtypeListe )  
         visTyperom();
   else if ( e.getSource() == avbryt )  
           blankUtFelt();
   else if ( e.getSource() == rediger )  
         redigerRominfo();
   else if ( e.getSource() == lagre )  
         lagreEndringer();
   else if ( e.getSource() == avslutt ) {
          skrivRomTilFil();
          System.exit(0);
       }     
 }
 public static void main(String[] args) {
        launch(args);
    }
}