/**
 * @author Amit Biswas
 */

package ucam.code;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.Stage;


public class Main extends Application {
    
    /**
     * Kept static to access main stage/window from login page
     * and to logout from any window and return to login page.
     */
    public static Stage primaryStage;
    public static Scene loginScene;
    
    /**
     * Start of application.
     * @param stage is the main stage on which we set up all the scenes
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        primaryStage = stage;
        primaryStage.setTitle("UIU EMS Login");

        FXMLLoader loginFXMLLoader = new FXMLLoader();
        loginFXMLLoader.setLocation(getClass().getResource("/ucam/view/fxml/login.fxml"));
        Parent root = loginFXMLLoader.load();

        loginScene = new Scene(root , 900 , 600);

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}