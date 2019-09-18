/**
 * @author Amit Biswas
 */

package ucam.control;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import ucam.code.Main;
import ucam.util.PaneNavigator;


public class HomepageController implements Initializable{
    
    /**
     * According to user choice given from top menu , this stackpane
     * holds different panes for different uses .It's at the center of Homepage.
     */
    @FXML
    private StackPane paneHolder;

    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu homeMenu;
    @FXML
    private MenuItem sectionSelectionMenu;
    @FXML
    private MenuItem preadvisingMenu;
    @FXML
    private MenuItem preadvisingReMenu;
    @FXML
    private MenuItem changePassMenu;
    @FXML
    private MenuItem classRoutineMenu;
    @FXML
    private MenuItem resultHistoryMenu;
    @FXML
    private Menu paymentMenu;
    @FXML
    private MenuItem courseEvalMenu;
    @FXML
    private MenuItem contactMenu;
    @FXML
    private JFXButton logoutButton;
    @FXML
    private Label mainPageCenter;

    
    @FXML
    void handleLogoutButton() {
        Main.primaryStage.setTitle("UIU EMS Login");
        Main.primaryStage.setScene(Main.loginScene);
    }
    
    @FXML
    void handleHomeMenu() throws IOException {
        PaneNavigator.loadPane("/ucam/view/fxml/homepagepane.fxml");
    }
    
    @FXML
    void handleSectionSelectionMenu() throws IOException {
        PaneNavigator.loadPane("/ucam/view/fxml/sectionselectionpane.fxml");
    }
    
    @FXML
    void handlePreadvisingMenu() throws IOException {
        PaneNavigator.loadPane("/ucam/view/fxml/preadvisingpane.fxml");
    }
    
    @FXML
    void handlePreadvisingReMenu() throws IOException {
        PaneNavigator.loadPane("/ucam/view/fxml/preadvisingrepane.fxml");
    }
    
    @FXML
    void handleChangePassMenu() throws IOException {
        PaneNavigator.loadPane("/ucam/view/fxml/changepasspane.fxml");
    }

    @FXML
    void handleClassRoutineMenu() {
    }
    
    @FXML
    void handleResultHistoryMenu() {
    }

    @FXML
    void handlePaymentMenu() throws IOException {
        PaneNavigator.loadPane("/ucam/view/fxml/homepagepane.fxml");
    }
    
    @FXML
    void handleCourseEvalMenu() {
    }
    
    @FXML
    void handleContactMenu() {
    }
    
    /**
     * Replaces the pane displayed in the paneholder with a new pane.
     * @param node the pane node to be swapped in.
     */
    public void setPane(Node node){
        paneHolder.getChildren().setAll(node);
    }
    
    /**
     * As it is not possible to add click action in menu(NOT menuitem) ,
     * this is a workaround to add action to home and payment menu.
     * These lines of code have to be in this method to execute while the homepage initialize/start.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Label homeLabel = new Label("Home");
        Label paymentLabel = new Label("Payment");
        
        homeLabel.setOnMouseClicked(e-> {
            try {
                handleHomeMenu();
            } catch (IOException ex) {
                Logger.getLogger(HomepageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        paymentLabel.setOnMouseClicked(e->{
            try {
                handlePaymentMenu();
            } catch (IOException ex) {
                Logger.getLogger(HomepageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        homeMenu.setGraphic(homeLabel);
        paymentMenu.setGraphic(paymentLabel);
    }

}
