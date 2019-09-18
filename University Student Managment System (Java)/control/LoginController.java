/**
 * @author Amit Biswas
 */

package ucam.control;

import com.jfoenix.controls.*;
import java.io.IOException;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import ucam.code.Main;
import ucam.util.*;


public class LoginController {

    @FXML
    private JFXTextField nameField;
    @FXML
    private JFXPasswordField passField;
    @FXML
    private Label errorMsg;

    
    public void handleLoginButton() throws IOException{

        String namePass = passField.getText() +"-"+ nameField.getText();
        /**
         * If id and password matches , enter Homepage.
         * Else stay at login page.
         */
        if(FileIO.check(namePass)){
            
            /**
             * Loads the main fxml layout with the top menu.
             */
            FXMLLoader homeFXMLLoader = new FXMLLoader();
            homeFXMLLoader.setLocation(getClass().getResource("/ucam/view/fxml/homepagetemplate.fxml"));
            
            /**
             * Borderpane is the main layout .HomepageController
             * controls the transition of panes at center.
             */
            BorderPane mainPane = (BorderPane) homeFXMLLoader.load();
            HomepageController homepageController = homeFXMLLoader.getController();
            
            /**
             * HomepageController is set default controller .Dummy pane
             * is loaded as center pane.
             */
            PaneNavigator.setMainController(homepageController);
            PaneNavigator.loadPane("/ucam/view/fxml/homepagepane.fxml");

            Scene mainScene = new Scene(mainPane , 900 , 600);

            passField.clear();
            nameField.clear();
            errorMsg.setText("");
            
            /**
             * If password matches then mainScene is set as permanent scene.
             */
            Main.primaryStage.setTitle("UIU EMS Homepage");
            Main.primaryStage.setScene(mainScene);

        } else {

            passField.clear();
            nameField.clear();
            errorMsg.setText("Sorry Try Again!");
        }
    }
}
