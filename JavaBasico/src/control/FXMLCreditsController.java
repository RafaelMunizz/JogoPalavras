/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package control;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rafae
 */
public class FXMLCreditsController implements Initializable {

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

    @FXML
    void handleHyperlinkAction_Email(ActionEvent event) throws IOException, URISyntaxException {
        
        Desktop.getDesktop().browse(new URI ("mailto:rafaelvictormuniz@gmail.com"));
    }

    @FXML
    void handleHyperlinkAction_GitHub(ActionEvent event) throws IOException, URISyntaxException {
        
        Desktop.getDesktop().browse(new URI ("https://github.com/RafaelMunizz"));
    }

    @FXML
    void handleHyperlinkAction_LinkedIn(ActionEvent event) throws IOException, URISyntaxException {
        
        Desktop.getDesktop().browse(new URI ("https://www.linkedin.com/in/rafael-muniz-385a621ab/"));
    }

    @FXML
    void handleHyperlinkAction_Termooo(ActionEvent event) throws IOException, URISyntaxException {
        
        Desktop.getDesktop().browse(new URI ("https://term.ooo/"));
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
