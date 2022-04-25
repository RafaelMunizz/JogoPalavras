package model;

import javafx.scene.control.Alert;

public class Alertas {
    
    Alert alertWARNING = new Alert(Alert.AlertType.WARNING);
    Alert alertINFORMATION = new Alert(Alert.AlertType.INFORMATION);
    Alert alertCONFIRMATION = new Alert(Alert.AlertType.CONFIRMATION);
    Alert alertERROR = new Alert(Alert.AlertType.ERROR);
    
    public void entrada_ComNumerosOuSimbolos(){
        this.alertERROR.setTitle("Erro de entrada"); //Título
        this.alertERROR.setHeaderText("Entrada inválida"); //Cabeçalho
        this.alertERROR.setContentText("A entrada só pode conter letras!"); //Conteúdo
        this.alertERROR.show();
    }
    public void entrada_MaiorOuMenorQueCincoCaracteres(){
        this.alertERROR.setTitle("Erro de entrada"); //Título
        this.alertERROR.setHeaderText("Entrada inválida"); //Cabeçalho
        this.alertERROR.setContentText("A entrada deve conter CINCO caractéres!"); //Conteúdo
        this.alertERROR.show();
    }
}
