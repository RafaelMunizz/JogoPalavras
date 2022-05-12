/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package control;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import model.BancoPalavras;

/**
 * FXML Controller class
 *
 * @author rafae
 */
public class FXMLWinnerController implements Initializable {
    
    @FXML private Label lbl_0;
    @FXML private Label lbl_1;
    @FXML private Label lbl_2;
    @FXML private Label lbl_3;
    @FXML private Label lbl_4;
    @FXML private Label lbl_tentativas;
    @FXML private Button btn_MudarPraJogo;
    @FXML private Button btn_MudarPraMenu;
    
    // Outros
    BancoPalavras BP = new BancoPalavras(false);
    
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
    
        // Método para fazer transição de opacidade dos botões para dar efeito de pressão
    void transicaoOpacidade (Button btn, String Style, Boolean mudar){
        
        // Se mudar for verdadeiro, a opacidade será aplicada
        // se não for, o botão retornará ao estilo original
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
        // Variável auxiliar para acessar métodos getters de outra classe
        
        
        
        // A fazer: Ao pegar os valores da palavra e de tentativas da outra classe
        // eles estão vindo com o seu valor de inicialização, e não com os valores 
        // das variáveis no momento em que o jogador ganha ou perde a partida.
        
        System.out.println(BP.getPalavraEscolhida());
        
        String[] letrasSeparadas = BP.getPalavraEscolhida().toUpperCase().split("");
        
        this.lbl_0.setText(letrasSeparadas[0]);
        this.lbl_1.setText(letrasSeparadas[1]);
        this.lbl_2.setText(letrasSeparadas[2]);
        this.lbl_3.setText(letrasSeparadas[3]);
        this.lbl_4.setText(letrasSeparadas[4]);
        this.lbl_tentativas.setText(String.valueOf(7 - FXMLGameController.tentativasRestantes));
    }    
}
