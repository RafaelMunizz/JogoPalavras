
package control;

import java.io.IOException;
import java.net.URL;
import java.text.Normalizer;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Alertas;
import model.BancoPalavras;

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
    @FXML private Button btn_EnviarPalavra;
    @FXML private Button btn_Desistir;

    
    // Variáveis
    Alertas alerta = new Alertas();
    BancoPalavras BP = new BancoPalavras(true);
    
    static int tentativasRestantes = 6;
    int totalAcertos = 0;
    static String palavraEscolhida;
    String btn_EnviarPalavra_Style;
    String btn_Desistir_Style;

    @FXML
    public void handleButtonAction_Desistir(ActionEvent event) throws IOException {
        
        // event = javafx.event.ActionEvent[source=Button[id=btn_Desistir, styleClass=button]'Sair']
        //SceneController
        Stage stage;
        Scene scene;
        Parent root;
        
        root = FXMLLoader.load(getClass().getResource("/view/FXMLLoser.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Qual a palavra?/Derrota");
        stage.setResizable(false);
        stage.show();
    }
    
    // Método para chamar uma tela de que o jogador ganhou o jogo 
    @FXML
    public void telaVitoria() throws IOException{
        
        //SceneController
        Stage stage;
        Scene scene;
        Parent root;
        
        stage = (Stage) btn_Desistir.getScene().getWindow();
        stage.close();
        
        root = FXMLLoader.load(getClass().getResource("/view/FXMLWinner.fxml"));
        
        stage = new Stage();
        stage.setTitle("Qual a palavra?/Vitória");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    // Método para chamar uma tela de que o jogador ganhou o jogo 
    @FXML
    public void telaDerrota() throws IOException{
        
        //SceneController
        Stage stage;
        Scene scene;
        Parent root;
        
        stage = (Stage) btn_Desistir.getScene().getWindow();
        stage.close();
        
        root = FXMLLoader.load(getClass().getResource("/view/FXMLLoser.fxml"));
        
        stage = new Stage();
        stage.setTitle("Qual a palavra?/Derrota");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    @FXML
    public void handleButtonAction_EnviarPalavra(ActionEvent event) {
        
        System.out.println(FXMLGameController.palavraEscolhida);
        
        // Verificação se a palavra é válida 
        if (analisePalavra(txtField_DigitarPalavra.getText())){

            switch(FXMLGameController.tentativasRestantes){
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
        
        // Palavra maior ou menor que 5 caracteres
        if (p.length() != 5) {
            alerta.entrada_MaiorOuMenorQueCincoCaracteres();
            txtField_DigitarPalavra.setText("");
            return false;
        }
        
        // Avaliando se a palavra pertence ao banco. Se não pertencer, o jogador deve digitar outra palavra válida
        if (!BP.palavraValida(removerAcentosStrings(txtField_DigitarPalavra.getText()))){
            alerta.entrada_NaoContemNoBanco();
            txtField_DigitarPalavra.setText("");
            return false;
        }
        
        return true;
    }
    // Método para colocar as letras nos labels correspondentes e chegar se o jogador venceu ou perdeu
    public void colocarPalavras(Label lbl_0, Label lbl_1, Label lbl_2, Label lbl_3, Label lbl_4){
        
        this.totalAcertos = 0;
        
        // Se a palavra for sem acentos, será encontrada uma equivalente com acentos corretos
        String palavra = BP.palavraFormaFinal(txtField_DigitarPalavra.getText());
        //String palavra = txtField_DigitarPalavra.getText();

        // O tratamento abaixo pega o texto recebido do front-end, põe suas letras em maiúsculo e separa todas as letras.
        String[] palavraRecebidaSeparada = palavra.toUpperCase().split("");
        String[] palavraDefinitivaSeparada = FXMLGameController.palavraEscolhida.toUpperCase().split("");

        testeCaracteres(palavraRecebidaSeparada[0], palavraDefinitivaSeparada[0], lbl_0);
        testeCaracteres(palavraRecebidaSeparada[1], palavraDefinitivaSeparada[1], lbl_1);
        testeCaracteres(palavraRecebidaSeparada[2], palavraDefinitivaSeparada[2], lbl_2);
        testeCaracteres(palavraRecebidaSeparada[3], palavraDefinitivaSeparada[3], lbl_3);
        testeCaracteres(palavraRecebidaSeparada[4], palavraDefinitivaSeparada[4], lbl_4);

        txtField_DigitarPalavra.setText("");

        // Condição de vitória
        // Também usado para que palavras com acento sejam colocadas como corretas, mesmo que a entrada seja sem acentos.
        if(this.totalAcertos == 5){

            try {
                //alerta.jogo_Ganhou(this.palavraEscolhida.toUpperCase());
                telaVitoria(); //Desenvolvendo
            } catch (IOException ex) {
                Logger.getLogger(FXMLGameController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {

            FXMLGameController.tentativasRestantes--;
            lbl_Tentativas.setText(String.valueOf(FXMLGameController.tentativasRestantes));

            if(FXMLGameController.tentativasRestantes == 0){
                try {
                    telaDerrota();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLGameController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    // Método para modificar os labels para a cor correspondente de ERRO, ACERTO ou SEMI-ACERTO (Possui a letra, mas não naquela posição)
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
        String[] palavraDefinitivaSeparada = removerAcentosStrings(FXMLGameController.palavraEscolhida.toUpperCase()).split("");
        
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
    void OnMouseEntered_btn_EnviarPalavra(MouseEvent event) {
        transicaoOpacidade(btn_EnviarPalavra, this.btn_EnviarPalavra_Style, true);
    }
    
    @FXML 
    void OnMouseExited_btn_EnviarPalavra(MouseEvent event) {
        transicaoOpacidade(btn_EnviarPalavra, this.btn_EnviarPalavra_Style, false);
    }
    
    // btn_Fechar
    @FXML 
    void OnMouseEntered_btn_Desistir(MouseEvent event) {
        transicaoOpacidade(btn_Desistir, this.btn_Desistir_Style, true);
    }
    @FXML 
    void OnMouseExited_btn_Desistir(MouseEvent event) {
        transicaoOpacidade(btn_Desistir, this.btn_Desistir_Style, false);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FXMLGameController.tentativasRestantes = 6;
        lbl_Tentativas.setText(String.valueOf(FXMLGameController.tentativasRestantes));
        
        FXMLGameController.palavraEscolhida = BP.getPalavraEscolhida();
        
        this.btn_EnviarPalavra_Style = btn_EnviarPalavra.getStyle();
        this.btn_Desistir_Style = btn_Desistir.getStyle();
    }
}
