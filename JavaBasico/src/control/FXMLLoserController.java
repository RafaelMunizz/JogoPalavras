/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package control;

import connection.Table_palavras;
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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rafae
 */
public class FXMLLoserController implements Initializable {

    @FXML private Label lbl_0;
    @FXML private Label lbl_1;
    @FXML private Label lbl_2;
    @FXML private Label lbl_3;
    @FXML private Label lbl_4;
    @FXML private Button btn_MudarPraJogo;
    @FXML private Button btn_MudarPraMenu;
    
    String btn_MudarPraMenu_Style;
    String btn_MudarPraJogo_Style;

    @FXML
    void handleButtonAction_VoltarParaMenu(ActionEvent event) throws IOException {
              
        Stage stage;
        Scene scene;
        Parent root;
        
        root = FXMLLoader.load(getClass().getResource("/view/FXMLInitial.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Qual a palavra?/Menu principal");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void handleButtonAction_mudarParaJogo(ActionEvent event) throws IOException {
    
        Stage stageJogo;
        Scene sceneJogo;
        Parent rootJogo;
    
        rootJogo = FXMLLoader.load(getClass().getResource("/view/FXMLGame.fxml"));
        stageJogo = (Stage)((Node)event.getSource()).getScene().getWindow();
        sceneJogo = new Scene(rootJogo);
        stageJogo.setScene(sceneJogo);
        stageJogo.setTitle("Qual a palavra?/Partida");
        stageJogo.setResizable(false);
        stageJogo.show();
    }
    
        // M??todo para fazer transi????o de opacidade dos bot??es para dar efeito de press??o
    void transicaoOpacidade (Button btn, String Style, Boolean mudar){
        
        // Se mudar for verdadeiro, a opacidade ser?? aplicada
        // se n??o for, o bot??o retornar?? ao estilo original
        if (mudar){
            btn.setStyle(Style + "-fx-opacity: 75%;");
        } else {
            btn.setStyle(Style);
        }
    }
    
    // btn_MudarPraMenu
    @FXML 
    void OnMouseEntered_btn_MudarPraMenu(MouseEvent event) {
        transicaoOpacidade(btn_MudarPraMenu, this.btn_MudarPraMenu_Style, true);
    }
    @FXML 
    void OnMouseExited_btn_MudarPraMenu(MouseEvent event) {
        transicaoOpacidade(btn_MudarPraMenu, this.btn_MudarPraMenu_Style, false);
    }
    
    // btn_MudarPraJogo
    @FXML 
    void OnMouseEntered_btn_MudarPraJogo(MouseEvent event) {
        transicaoOpacidade(btn_MudarPraJogo, this.btn_MudarPraJogo_Style, true);
    }
    
    @FXML 
    void OnMouseExited_btn_MudarPraJogo(MouseEvent event) {
        transicaoOpacidade(btn_MudarPraJogo, this.btn_MudarPraJogo_Style, false);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.btn_MudarPraJogo_Style = btn_MudarPraJogo.getStyle();
        this.btn_MudarPraMenu_Style = btn_MudarPraMenu.getStyle();
        
        String[] letrasSeparadas = Table_palavras.getPalavraEscolhida().toUpperCase().split("");
        
        this.lbl_0.setText(letrasSeparadas[0]);
        this.lbl_1.setText(letrasSeparadas[1]);
        this.lbl_2.setText(letrasSeparadas[2]);
        this.lbl_3.setText(letrasSeparadas[3]);
        this.lbl_4.setText(letrasSeparadas[4]);
    }    
    
}
