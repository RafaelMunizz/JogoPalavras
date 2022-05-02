/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rafae
 */
public class FXMLInstructionsController implements Initializable {
    
    @FXML
    private Button btn_MudarPraMenu;
    
    // Outros
    String btn_MudarPraMenu_Style;
    
    @FXML
    void handleButtonAction_VoltarParaMenu(ActionEvent event) throws IOException {
              
        Stage stage;
        Scene scene;
        Parent root;
        
        root = FXMLLoader.load(getClass().getResource("/view/FXMLInitial.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    // btn_MudarPraMenu
    @FXML 
    void OnMouseEntered_btn_MudarPraMenu(MouseEvent event) {
        btn_MudarPraMenu.setStyle(this.btn_MudarPraMenu_Style + "-fx-opacity: 75%;");
    }
    @FXML 
    void OnMouseExited_btn_MudarPraMenu(MouseEvent event) {
        btn_MudarPraMenu.setStyle(this.btn_MudarPraMenu_Style);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.btn_MudarPraMenu_Style = btn_MudarPraMenu.getStyle();
    }    
    
}
