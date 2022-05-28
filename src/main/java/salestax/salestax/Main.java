package salestax.salestax;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application { // extend application class to get the functionality of JavaFX


    public static void main(String[] args) {
        launch();                           //is a method to set up JavaFX App and it calls start method to set up
                                            //app's scene
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("user-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Sales Tax App");
        stage.setScene(scene);
        stage.show();
    }

}