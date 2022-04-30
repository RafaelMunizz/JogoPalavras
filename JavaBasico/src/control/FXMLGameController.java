
package control;

import java.io.IOException;
import java.net.URL;
import java.text.Normalizer;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Alertas;
import model.EscolherPalavra;

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
    @FXML private Label lbl_Tentativas;
    
    // Variáveis
    Alertas alerta = new Alertas();
    int tentativasRestantes = 6;
    int totalAcertos = 0;
    String palavraEscolhida;
    
    @FXML
    public void handleButtonAction_voltarParaMenuInicial(ActionEvent event) throws IOException {
        
        //SceneController
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
    public void handleButtonAction_EnviarPalavra(ActionEvent event) {
        
        System.out.println(this.palavraEscolhida);


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
    public boolean analisePalavra(String p){
        
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
    // Método para colocar as letras nos labels correspondentes e chegar se o jogador venceu ou perdeu
    public void colocarPalavras(Label lbl_0, Label lbl_1, Label lbl_2, Label lbl_3, Label lbl_4) {
        
        this.totalAcertos = 0;

        // O tratamento abaixo pega o texto recebido do front-end, põe suas letras em maiúsculo e separa todas as letras.
        String[] palavraRecebidaSeparada = txtField_DigitarPalavra.getText().toUpperCase().split("");
        String[] palavraDefinitivaSeparada = this.palavraEscolhida.toUpperCase().split("");

        testeCaracteres(palavraRecebidaSeparada[0], palavraDefinitivaSeparada[0], lbl_0);
        testeCaracteres(palavraRecebidaSeparada[1], palavraDefinitivaSeparada[1], lbl_1);
        testeCaracteres(palavraRecebidaSeparada[2], palavraDefinitivaSeparada[2], lbl_2);
        testeCaracteres(palavraRecebidaSeparada[3], palavraDefinitivaSeparada[3], lbl_3);
        testeCaracteres(palavraRecebidaSeparada[4], palavraDefinitivaSeparada[4], lbl_4);

        txtField_DigitarPalavra.setText("");

        // Condição de vitória
        // Também usado para que palavras com acento sejam colocadas como corretas, mesmo que a entrada seja sem acentos.
        if(this.totalAcertos == 5){

           lbl_0.setText(palavraDefinitivaSeparada[0]);
           lbl_1.setText(palavraDefinitivaSeparada[1]);
           lbl_2.setText(palavraDefinitivaSeparada[2]);
           lbl_3.setText(palavraDefinitivaSeparada[3]);
           lbl_4.setText(palavraDefinitivaSeparada[4]);

           alerta.jogo_Ganhou();
           //showStage(); //Desenvolvendo
        } else {

            this.tentativasRestantes--;
            lbl_Tentativas.setText(String.valueOf(this.tentativasRestantes));

            if(this.tentativasRestantes == 0){
                alerta.jogo_TentativasEsgotadas();
            }
        }
    }
    
    // Método pada modificar os labels para a cor correspondente de ERRO, ACERTO ou SEMI-ACERTO (Possui a letra, mas não naquela posição)
    public void testeCaracteres(String letraRecebida, String letraDefinitiva, Label lbl){
        
        // ACERTO
        if (removerAcentosStrings(letraRecebida).equals(removerAcentosStrings(letraDefinitiva))){
            lbl.setText(letraRecebida);
            lbl.setStyle("-fx-background-color: #3AA394; -fx-background-insets: 0; -fx-background-radius: 10%; -fx-font-size: 46; -fx-font-weight: bold; -fx-text-fill: #FAFAFF;");
            lbl.setPrefHeight(75.0);
            this.totalAcertos++;
        
        // SEMI-ACERTO
        } else if (!removerAcentosStrings(letraRecebida).equals(removerAcentosStrings(letraDefinitiva)) && letraNaPalavra_PosicaoErrada(letraRecebida)) {
            lbl.setText(letraRecebida);
            lbl.setStyle("-fx-background-color: #D3AD69; -fx-background-insets: 0; -fx-background-radius: 10%; -fx-font-size: 46; -fx-font-weight: bold; -fx-text-fill: #FAFAFF;");
            lbl.setPrefHeight(75.0);
        
        //ERRO
        } else if (!removerAcentosStrings(letraRecebida).equals(removerAcentosStrings(letraDefinitiva)) && !letraNaPalavra_PosicaoErrada(letraRecebida)){
            lbl.setText(letraRecebida);
            lbl.setStyle("-fx-background-color: #312A2C; -fx-background-insets: 0; -fx-background-radius: 10%; -fx-font-size: 46; -fx-font-weight: bold; -fx-text-fill: #FAFAFF;");
            lbl.setPrefHeight(75.0);
        }
    }
    
    // Método para analisar se a letra pertence a palavra e ela não está no local correto
    public boolean letraNaPalavra_PosicaoErrada(String letra){
        
        boolean verificacao = false; // Se verificacao mudar, a palavra possui a letra, mas ela não está na posição correta
        String[] palavraDefinitivaSeparada = removerAcentosStrings(this.palavraEscolhida.toUpperCase()).split("");
        
        for (String c : palavraDefinitivaSeparada){
            if (removerAcentosStrings(letra).equals(c)){
                verificacao = true;
            } 
        }
        return verificacao;
    }
    
    // Método para remover acentuações e sinais gráficos de uma String
    public String removerAcentosStrings(String value) {
        String normalizer = Normalizer.normalize(value, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalizer).replaceAll("");
    }
    
    // Método para chamar uma tela de que o jogador ganhou o jogo (desenvolvendo)
    public void showStage(){
        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("/view/FXMLWinner.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            //((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "NÃO FUNCIONOU");
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lbl_Tentativas.setText(String.valueOf(this.tentativasRestantes));
        
        EscolherPalavra p = new EscolherPalavra();
        this.palavraEscolhida = p.palavraDefinitiva();
    }

}
