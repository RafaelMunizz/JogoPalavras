
package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainJogo extends Application {
    
    @Override
    public void start(Stage stage)  throws Exception {
        Parent initial = FXMLLoader.load(getClass().getResource("/view/FXMLInitial.fxml"));

        Scene sceneInitial = new Scene(initial);

        stage.setScene(sceneInitial);
        stage.setResizable(false);
        stage.setTitle("Qual a palavra?");
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
