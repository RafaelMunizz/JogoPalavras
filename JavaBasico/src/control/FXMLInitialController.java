
package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author rafae
 */
public class FXMLInitialController implements Initializable {
    
    //SceneController
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    public void handleButtonAction_mudarParaJogo(ActionEvent event) throws IOException {
        
        root = FXMLLoader.load(getClass().getResource("/view/FXMLGame.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    @FXML
    public void handleButtonAction_FecharJogo(ActionEvent event) throws IOException {
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    
        @FXML
    void handleButtonAction_mudarParaCreditos(ActionEvent event) {

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
