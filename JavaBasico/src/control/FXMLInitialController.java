
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
public class FXMLInitialController implements Initializable {
    
    
    @FXML
    private Button btn_MudarPraJogo;

    @FXML
    private Button btn_Fechar;

    @FXML
    private Button btn_MudarPraInstrucoes;

    @FXML
    private Button btn_MudarPraCreditos;
    
    // Outros
    String btn_MudarPraJogo_Style;
    String btn_Fechar_Style;
    String btn_MudarPraInstrucoes_Style;
    String btn_MudarPraCreditos_Style;

    
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
    
    @FXML
    public void handleButtonAction_mudarParaInstrucoes(ActionEvent event) throws IOException {
       
        Stage stageCreditos;
        Scene sceneCreditos;
        Parent rootCreditos;
        
        rootCreditos = FXMLLoader.load(getClass().getResource("/view/FXMLInstructions.fxml"));
        stageCreditos = (Stage)((Node)event.getSource()).getScene().getWindow();
        sceneCreditos = new Scene(rootCreditos);
        stageCreditos.setScene(sceneCreditos);
        stageCreditos.setResizable(false);
        stageCreditos.show();
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
    
    // btn_MudarPraJogo
    @FXML 
    void OnMouseEntered_btn_MudarPraJogo(MouseEvent event) {
        transicaoOpacidade(btn_MudarPraJogo, this.btn_MudarPraJogo_Style, true);
    }
    
    @FXML 
    void OnMouseExited_btn_MudarPraJogo(MouseEvent event) {
        transicaoOpacidade(btn_MudarPraJogo, this.btn_MudarPraJogo_Style, false);
    }
    
    // btn_Fechar
    @FXML 
    void OnMouseEntered_btn_Fechar(MouseEvent event) {
        transicaoOpacidade(btn_Fechar, this.btn_Fechar_Style, true);
    }
    @FXML 
    void OnMouseExited_btn_Fechar(MouseEvent event) {
        transicaoOpacidade(btn_Fechar, this.btn_Fechar_Style, false);
    }
    
    // btn_MudarPraInstrucoes
    @FXML 
    void OnMouseEntered_btn_MudarPraInstrucoes(MouseEvent event) {
        transicaoOpacidade(btn_MudarPraInstrucoes, this.btn_MudarPraInstrucoes_Style, true);
    }
    @FXML 
    void OnMouseExited_btn_MudarPraInstrucoes(MouseEvent event) {
        transicaoOpacidade(btn_MudarPraInstrucoes, this.btn_MudarPraInstrucoes_Style, false);
    }
    
    // btn_MudarPraCreditos
    @FXML 
    void OnMouseEntered_btn_MudarPraCreditos(MouseEvent event) {
        transicaoOpacidade(btn_MudarPraCreditos, this.btn_MudarPraCreditos_Style, true);
    }
    @FXML 
    void OnMouseExited_btn_MudarPraCreditos(MouseEvent event) {
        transicaoOpacidade(btn_MudarPraCreditos, this.btn_MudarPraCreditos_Style, false);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.btn_MudarPraJogo_Style = btn_MudarPraJogo.getStyle();
        this.btn_Fechar_Style = btn_Fechar.getStyle();
        this.btn_MudarPraInstrucoes_Style = btn_MudarPraInstrucoes.getStyle();
        this.btn_MudarPraCreditos_Style = btn_MudarPraCreditos.getStyle();
    }    
}
