
package model;

import connection.ConnectionSQLite;
import connection.Table_palavras;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainJogo extends Application {
    
    // Objetos
    ConnectionSQLite conexaoSQLite = new ConnectionSQLite();
    Table_palavras TabelaSQLite = new Table_palavras(conexaoSQLite);
    
    @Override
    public void start(Stage stage)  throws Exception {
        Parent initial = FXMLLoader.load(getClass().getResource("/view/FXMLInitial.fxml"));

        Scene sceneInitial = new Scene(initial);

        stage.setScene(sceneInitial);
        stage.setResizable(false);
        stage.setTitle("Qual a palavra?");
        stage.show();
        
        database();
    }

    public void database(){
        
        // Descomentar caso tabela deixar de existir
        //TabelaSQLite.createTable();
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
