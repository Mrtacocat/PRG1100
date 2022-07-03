import static java.lang.System.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import static java.lang.Integer.*;

public class GokartAdmin extends Application {
    
    private RadioButton visAktive, visAlle;
    private Button settAktiv, settService;
    private TextArea tekstområde;
    private TextField kjøretøyId;
            

    public void start(Stage vindu) {
        FlowPane panel = new FlowPane();
        panel.setHgap(10);
        panel.setVgap(10);
        panel.setAlignment(Pos.CENTER);

        ToggleGroup gruppe = new ToggleGroup();

        visAktive = new RadioButton("vis aktive");
        visAktive.setToggleGroup(gruppe);
        panel.getChildren().add(visAktive);

        visAlle = new RadioButton("vis alle");
        visAlle.setToggleGroup(gruppe);
        panel.getChildren().add(visAlle);

        settAktiv = new Button("Sett kjøretøy aktivt");
        //settAktiv.setOnAction(e -> behandleKlikk(e));
        panel.getChildren().add(settAktiv);

        settService = new Button("Sett kjøretøy på service");
        //settService.setOnAction(e -> behandleKlikk(e));
        panel.getChildren().add(settService);
        

        tekstområde = new TextArea();
        panel.getChildren().add(tekstområde);

        panel.getChildren().add(new Label("Kjøretøy-id:"));

        kjøretøyId = new TextField();
        panel.getChildren().add(kjøretøyId);

        Scene scene = new Scene(panel, 600, 300);
        vindu.setTitle("");
        vindu.setScene(scene);
        vindu.show();
    
    }

    public void behandleKlikk(ActionEvent e) {

        try {
            int id = integer.parseInt(kjøretøyId.getText());
            for (kjoretoy kart : lesInnRegister) {
                if(kart.getId() == id ) {

                
                if ( e.getSource() == settAktiv ) {
                
                    }     
                else if ( e.getSource() == settService ) {
                            
                } 
            }         
         }             

        } catch (NumberFormatException ex) {
            out.println("Brukeren skrev feil nummer");
        } catch (Exception exx) {
            out.println("Generell feil: " + exx.toString());
        }
        
        
        }
    

    
    
    /*private Kjoretoy[] lesInnRegister() {
        return null;
    }

    private void lagreRegister(Kjoretoy[] kjoretoy) {
        
    }*/
    public static void main(String[] args) {
        launch(args);
    }
}
