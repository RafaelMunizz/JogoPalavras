
package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rafae
 */
public class FXMLInitialController implements Initializable {
            
    @FXML
    public void handleButtonAction_mudarParaJogo(ActionEvent event) throws IOException {
    
        Stage stageJogo;
        Scene sceneJogo;
        Parent rootJogo;
    
        rootJogo = FXMLLoader.load(getClass().getResource("/view/FXMLGame.fxml"));
        stageJogo = (Stage)((Node)event.getSource()).getScene().getWindow();
        sceneJogo = new Scene(rootJogo);
        stageJogo.setScene(sceneJogo);
        stageJogo.setResizable(false);
        stageJogo.show();
    
    }
    @FXML
    public void handleButtonAction_FecharJogo(ActionEvent event) throws IOException {
        
        Stage stageFechar;
        stageFechar = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageFechar.close();
    }
    
    @FXML
    public void handleButtonAction_mudarParaCreditos(ActionEvent event) throws IOException {
       
        Stage stageCreditos;
        Scene sceneCreditos;
        Parent rootCreditos;
        
        rootCreditos = FXMLLoader.load(getClass().getResource("/view/FXMLCredits.fxml"));
        stageCreditos = (Stage)((Node)event.getSource()).getScene().getWindow();
        sceneCreditos = new Scene(rootCreditos);
        stageCreditos.setScene(sceneCreditos);
        stageCreditos.setResizable(false);
        stageCreditos.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
