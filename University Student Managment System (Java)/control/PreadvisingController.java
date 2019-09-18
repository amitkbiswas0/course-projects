/**
 * @author Amit Biswas
 */

package ucam.control;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ucam.code.SubjectInfo;


public class PreadvisingController implements Initializable {

    @FXML
    private JFXButton addCourse;

    /**
     * For table from which to select the courses.
     */
    @FXML
    private TableView<SubjectInfo> tableViewFrom;
    @FXML
    private TableColumn<SubjectInfo , String> serialCol1;
    @FXML
    private TableColumn<SubjectInfo , String> codeCol1;
    @FXML
    private TableColumn<SubjectInfo , String> titleCol1;
    @FXML
    private TableColumn<SubjectInfo , String> creditCol1;
    @FXML
    private TableColumn<SubjectInfo , String> trimesterCol1;
    
    /**
     * For table to which to show selected courses.
     */
    @FXML
    private TableView<SubjectInfo> tableViewTo;
    @FXML
    private TableColumn<SubjectInfo , String> serialCol2;
    @FXML
    private TableColumn<SubjectInfo , String> codeCol2;
    @FXML
    private TableColumn<SubjectInfo , String> titleCol2;
    @FXML
    private TableColumn<SubjectInfo , String> creditCol2;
    @FXML
    private TableColumn<SubjectInfo , String> trimesterCol2;
    

    @FXML
    void handleAddCourse() {
        
        SubjectInfo subjectInfo = tableViewFrom.getSelectionModel().getSelectedItem();;
        /**
         * To remove from first table and adds to second table.
         */
        tableViewFrom.getItems().remove(subjectInfo);
        tableViewTo.getItems().add(subjectInfo);
        /**
         * To add selected courses at section selection page's table.
         */
        SectionSelectionController.sectionTableInfos.add(subjectInfo);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        /**
         * For table from which to select the courses.
         */
        serialCol1.setCellValueFactory(new PropertyValueFactory<>("SerialNo"));
        codeCol1.setCellValueFactory(new PropertyValueFactory<>("CourseCode"));
        titleCol1.setCellValueFactory(new PropertyValueFactory<>("CourseTitle"));
        creditCol1.setCellValueFactory(new PropertyValueFactory<>("CourseCredit"));
        trimesterCol1.setCellValueFactory(new PropertyValueFactory<>("CourseSem"));
        
        /**
         * For table to which to show selected courses.
         */
        serialCol2.setCellValueFactory(new PropertyValueFactory<>("SerialNo"));
        codeCol2.setCellValueFactory(new PropertyValueFactory<>("CourseCode"));
        titleCol2.setCellValueFactory(new PropertyValueFactory<>("CourseTitle"));
        creditCol2.setCellValueFactory(new PropertyValueFactory<>("CourseCredit"));
        trimesterCol2.setCellValueFactory(new PropertyValueFactory<>("CourseSem"));
        
        /**
         * For table in the section selection page.
         */
        SectionSelectionController.sectionTableInfos = FXCollections.observableArrayList();
        
        /**
         * To populate the table from which to select the courses.
         */
        tableViewFrom.setItems(subjectInfos);
    }
    
    /**
     * List of subject info class instances to add in the tableViewFrom table.
     */
    ObservableList<SubjectInfo> subjectInfos = FXCollections.observableArrayList(
            new SubjectInfo("1", "MATH 187", "Fourier & Laplace Transformations & Complex Variable", "3.00", "5th" , "N/A"),
            new SubjectInfo("2", "CSI 233", "Theory of Computing", "3.00", "6th" , "N/A"),
            new SubjectInfo("3", "CSI 221", "Database Management Systems", "3.00", "7th" , "N/A"),
            new SubjectInfo("4", "CSI 222", "Database Management Systems Laboratory", "1.00", "7th" , "N/A"),
            new SubjectInfo("5", "CSE 236", "Assembly Programming Laboratory", "1.00", "6th" , "N/A")        
        );
}
