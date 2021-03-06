package model;

import javafx.scene.control.Alert;

public class Alertas {

    Alert alertERROR = new Alert(Alert.AlertType.ERROR);
    
    public void entrada_MaiorOuMenorQueCincoCaracteres(){
        this.alertERROR.setTitle("Erro de entrada"); //Título
        this.alertERROR.setHeaderText("Entrada inválida"); //Cabeçalho
        this.alertERROR.setContentText("A entrada deve conter CINCO caractéres!"); //Conteúdo
        this.alertERROR.show();
    }
    
    public void entrada_NaoContemNoBanco(){
        this.alertERROR.setTitle("Erro de entrada"); //Título
        this.alertERROR.setHeaderText("Entrada inválida"); //Cabeçalho
        this.alertERROR.setContentText("Palavra não conhecida. Digite outra palavra!"); //Conteúdo
        this.alertERROR.show();
    }
    
}

