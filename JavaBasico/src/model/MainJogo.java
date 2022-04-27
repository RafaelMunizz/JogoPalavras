
package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainJogo extends Application {
    
    @Override
    public void start(Stage stage)  throws Exception {
        Parent Game = FXMLLoader.load(getClass().getResource("/view/FXMLGame.fxml"));

        Scene sceneGame = new Scene(Game);

        stage.setScene(sceneGame);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}