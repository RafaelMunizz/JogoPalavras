
package jogopalavras;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class FXMLGameController implements Initializable {
    
    //Primeira palavra
    @FXML private Label lbl_00;
    @FXML private Label lbl_01;
    @FXML private Label lbl_02;
    @FXML private Label lbl_03;
    @FXML private Label lbl_04;

    //Segunda palavra
    @FXML private Label lbl_10;
    @FXML private Label lbl_11;
    @FXML private Label lbl_12;
    @FXML private Label lbl_13;
    @FXML private Label lbl_14;
        
    //Terceira palavra
    @FXML private Label lbl_20;
    @FXML private Label lbl_21;
    @FXML private Label lbl_22;
    @FXML private Label lbl_23;
    @FXML private Label lbl_24;
    
    //Quarta palavra
    @FXML private Label lbl_30;
    @FXML private Label lbl_31;
    @FXML private Label lbl_32;
    @FXML private Label lbl_33;
    @FXML private Label lbl_34;
            
    //Quinta palavra
    @FXML private Label lbl_40;
    @FXML private Label lbl_41;
    @FXML private Label lbl_42;
    @FXML private Label lbl_43;
    @FXML private Label lbl_44;
    
    //Sexta palavra
    @FXML private Label lbl_50;
    @FXML private Label lbl_51;
    @FXML private Label lbl_52;
    @FXML private Label lbl_53;
    @FXML private Label lbl_54;
    
    //Demais coisas
    @FXML private TextField txtField_DigitarPalavra;
    @FXML private Button btn_EnviarPalavra;
    @FXML private Label lbl_Tentativas;
    
    @FXML
    void handleButtonAction_EnviarPalavra(ActionEvent event) {
        
        String palavra = txtField_DigitarPalavra.getText();
        
        if (analisePalavra(palavra)){
            
            String[] palavraSeparada = palavra.toUpperCase().split("");

            lbl_00.setText(palavraSeparada[0]);
            lbl_01.setText(palavraSeparada[1]);
            lbl_02.setText(palavraSeparada[2]);
            lbl_03.setText(palavraSeparada[3]);
            lbl_04.setText(palavraSeparada[4]);
            
        } else {
            JOptionPane.showMessageDialog(null, "Entrada Inválida. Coloque uma palavra com 5 letras!");
        }
    }
    
    // Método para analisar se a palavra tem 5 letras e não contém números
    boolean analisePalavra(String p){
        
        if (p.length() != 5) return false;
        
        char[] chars = p.toCharArray();
        
        for (char c : chars){
            if (Character.isDigit(c)){return false;} 
        }
        return true;
    }
     
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lbl_Tentativas.setText("6");
    }
}
