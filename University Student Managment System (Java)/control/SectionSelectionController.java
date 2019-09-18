/**
 * @author Amit Biswas
 */

package ucam.control;

import com.jfoenix.controls.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.*;
import ucam.code.*;

public class SectionSelectionController implements Initializable {

    /**
     * Kept static to access from section selection popup page.
     * Adding section from pop up page to this instance will
     * add the section to section selection page table .
     * Have to call refresh method to set the selected section visible .
     */
    public static SubjectInfo sectionSubjectInfo;
    public static ObservableList<SubjectInfo> sectionTableInfos;
    public static Stage sectionWindow;

    @FXML
    private JFXButton logoutButton;
    @FXML
    private JFXButton homeButton;
    @FXML
    private JFXButton sectionSelect;
    @FXML
    private JFXButton removeCourse;
    @FXML
    private JFXButton registration;
    @FXML
    private JFXButton refreshButton;

    /**
     * For table in this page.
     */
    @FXML
    private TableView<SubjectInfo> tableView;
    @FXML
    private TableColumn<SubjectInfo , String> serialCol;
    @FXML
    private TableColumn<SubjectInfo , String> codeCol;
    @FXML
    private TableColumn<SubjectInfo , String> titleCol;
    @FXML
    private TableColumn<SubjectInfo , String> creditCol;
    @FXML
    private TableColumn<SubjectInfo , String> trimesterCol;
    @FXML
    private TableColumn<SubjectInfo , String> sectionCol;


    /**
     * This method handles section selection tasks.
     * Pop up feature , modality feature and adding section
     * feature is done here .Edit with caution !
     * 
     * @throws IOException
     */
    @FXML
    void handleSectionSelect() throws IOException {

        sectionWindow = new Stage();
        sectionWindow.setTitle("Select Sections from here");
        /**
         * For sticking the new window on top of current window.
         */
        sectionWindow.initModality(Modality.APPLICATION_MODAL);
        
        /**
         * Get selected items from the table.
         */
        sectionSubjectInfo = new SubjectInfo();
        sectionSubjectInfo = tableView.getSelectionModel().getSelectedItem();
        
        FXMLLoader sectionFXMLLoader = new FXMLLoader();
        
        /**
         * Checks if theory or lab course is selected comparing the
         * serial no and shows new window accordingly.
         */
        String temp = sectionSubjectInfo.getSerialNo();
        if(temp.equals("4") || temp.equals("5")){
            sectionFXMLLoader.setLocation(getClass().getResource("/ucam/view/fxml/sectionpopuplab.fxml"));
        } else {
            sectionFXMLLoader.setLocation(getClass().getResource("/ucam/view/fxml/sectionpopuptheory.fxml"));

        }
        
        Parent root = sectionFXMLLoader.load();
        Scene sectionScene = new Scene(root , 640, 480);

        sectionWindow.setScene(sectionScene);
        sectionWindow.showAndWait();
    }
    
    @FXML
    void handleRegistration() {
    }

    @FXML
    void handleRemoveCourse() {
        SubjectInfo subjectInfo = new SubjectInfo();
        /**
         * Gets the selected items and deletes them from table.
         */
        subjectInfo = tableView.getSelectionModel().getSelectedItem();
        tableView.getItems().remove(subjectInfo);
    }

    /**
     * This button refreshes the table.
     * Important because table doesn't refresh automatically and
     * will not show the section if not refreshed.
     */
    @FXML
    void handleRefreshButton(){
        tableView.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /**
         * For table in this page.
         */
        serialCol.setCellValueFactory(new PropertyValueFactory<>("SerialNo"));
        codeCol.setCellValueFactory(new PropertyValueFactory<>("CourseCode"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("CourseTitle"));
        creditCol.setCellValueFactory(new PropertyValueFactory<>("CourseCredit"));
        trimesterCol.setCellValueFactory(new PropertyValueFactory<>("CourseSem"));
        sectionCol.setCellValueFactory(new PropertyValueFactory<>("Section"));

        /**
         * To populate the table.
         */
        tableView.setItems(sectionTableInfos);
    }
}