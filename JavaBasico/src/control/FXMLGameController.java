
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.Alertas;

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
    
    //Demais itens
    @FXML private TextField txtField_DigitarPalavra;
    @FXML private Button btn_EnviarPalavra;
    @FXML private Label lbl_Tentativas;
    
    // Variáveis
    Alertas alerta = new Alertas();
    int tentativasRestantes = 6;
    
    @FXML
    void handleButtonAction_EnviarPalavra(ActionEvent event) {
        
        if (analisePalavra(txtField_DigitarPalavra.getText())){
            
            switch(this.tentativasRestantes){
                case 6:
                    colocarPalavras(lbl_00,lbl_01,lbl_02,lbl_03,lbl_04);
                    break;
                case 5:
                    colocarPalavras(lbl_10,lbl_11,lbl_12,lbl_13,lbl_14);
                    break;
                case 4:
                    colocarPalavras(lbl_20,lbl_21,lbl_22,lbl_23,lbl_24);
                    break;
                case 3:
                    colocarPalavras(lbl_30,lbl_31,lbl_32,lbl_33,lbl_34);
                    break;
                case 2:
                    colocarPalavras(lbl_40,lbl_41,lbl_42,lbl_43,lbl_44);
                    break;
                case 1:
                    colocarPalavras(lbl_50,lbl_51,lbl_52,lbl_53,lbl_54);
                    break;
                default:
                    break;
            }
        }
    }
    
    // Método para analisar se a palavra tem 5 letras e não contém números
    boolean analisePalavra(String p){
        
        // Palavra maior que 5 caracteres
        if (p.length() != 5) {
            alerta.entrada_MaiorOuMenorQueCincoCaracteres();
            txtField_DigitarPalavra.setText("");
            return false;
        }
        
        // Palavra contendo algo diferente de letras
        boolean verificacao = true; // Se verificacao mudar, a entrada não contém somente letras
        char[] chars = p.toCharArray();
        
        for (char c : chars){
            if (!Character.isLetter(c)){
                verificacao = false;
            } 
        }
        
        if (verificacao == false){
            alerta.entrada_ComNumerosOuSimbolos();
            txtField_DigitarPalavra.setText("");
            return false;
        }
        
        return true;
    }
    
    void colocarPalavras(Label lbl_0, Label lbl_1, Label lbl_2, Label lbl_3, Label lbl_4){
        
            String[] palavraSeparada = txtField_DigitarPalavra.getText().toUpperCase().split("");

            lbl_0.setText(palavraSeparada[0]);
            lbl_1.setText(palavraSeparada[1]);
            lbl_2.setText(palavraSeparada[2]);
            lbl_3.setText(palavraSeparada[3]);
            lbl_4.setText(palavraSeparada[4]);
            
            txtField_DigitarPalavra.setText("");
            this.tentativasRestantes--;
            lbl_Tentativas.setText(String.valueOf(this.tentativasRestantes));
    }
     
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lbl_Tentativas.setText(String.valueOf(this.tentativasRestantes));
    }

}
