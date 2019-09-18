package ucam.util;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import ucam.control.HomepageController;

public class PaneNavigator {
    /**
     * Homepage layout Controller.
     */
    public static HomepageController homepageController;

    /**
     * Stores the main controller for later tasks.
     * @param homepageController is the main application layout controller
     */
    public static void setMainController(HomepageController homepageController) {
        PaneNavigator.homepageController = homepageController;
    }
    
    /**
     * Loads the pane specified by the fxml file into the
     * paneHolder section of the Homepage.
     * @param fxml the fxml file to be loaded.
     */
    public static void loadPane(String fxml) throws IOException {
        homepageController.setPane(FXMLLoader.load(PaneNavigator.class.getResource(fxml)));
    }
}
