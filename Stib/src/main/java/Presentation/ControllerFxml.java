
package Presentation;

import Model.Facade;
import Model.Stations;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author <@Gabriel.espinosa>
 */
public class ControllerFxml implements Initializable{
    private Facade mdl;
    
    public ControllerFxml(Facade mdl){
        this.mdl=mdl;
    }
    
    @FXML
    private Pane logo;
    
    @FXML
    private ScrollPane mapStib;
    
    @FXML 
    private Button search;
    
    @FXML 
    private Pane planWin;
    
    @FXML
    private ChoiceBox origin;
    
    @FXML
    private ChoiceBox destination;
    
    @FXML
    private Label nbrStation;
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initImage();
        initStation();
        planWin.setStyle("-fx-background-color:#e6ffff");
        
    }
    private void initImage(){
        
        ImageView imgLogo=new ImageView(new Image("/image/logo.png"));
        imgLogo.setFitHeight(124);
        imgLogo.setFitWidth(90);
        imgLogo.maxHeight(124);
        imgLogo.maxWidth(263);
        imgLogo.setX(100);
        logo.getChildren().add(imgLogo);
        
        ImageView imgMap=new ImageView(new Image("/image/metro.gif"));
        //3037x550
        double height=(300);
        double width=(1600);
        imgMap.setFitHeight(height);
        imgMap.setFitWidth(width);
        mapStib.setContent(imgMap);
    }
    
    private void initStation(){
        nbrStation.setText("Nombre de Station : "+mdl.getNbrStation());
        
        for (Stations station : mdl.getListStations()) {
            origin.getItems().add(station.getName());
            destination.getItems().add(station.getName());
        }
    }
}
























































































