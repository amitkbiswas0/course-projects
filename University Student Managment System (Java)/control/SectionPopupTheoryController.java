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
import ucam.code.*;


public class SectionPopupTheoryController implements Initializable {
    
    @FXML
    private JFXButton sectionChoose;
    
    /**
     * For table in this page.
     */
    @FXML
    private TableView<SectionInfo> sectionTable;
    @FXML
    private TableColumn<SectionInfo , String> sectionCol;
    @FXML
    private TableColumn<SectionInfo , String> dayCol;
    @FXML
    private TableColumn<SectionInfo , String> timeCol;
    @FXML
    private TableColumn<SectionInfo , String> teacherCol;

    
    @FXML
    void handleSectionChoose() {
        
        SectionInfo sectionInfo = new SectionInfo();
        /**
         * To add the selected section to the instance at section selection page.
         */
        sectionInfo = sectionTable.getSelectionModel().getSelectedItem();
        String str = sectionInfo.getSection();
        SectionSelectionController.sectionSubjectInfo.setSection(str);
        
        /**
         * Closes the window after clicking the button.
         */
        SectionSelectionController.sectionWindow.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        /**
         * For table in this page.
         */
        sectionCol.setCellValueFactory(new PropertyValueFactory<>("Section"));
        dayCol.setCellValueFactory(new PropertyValueFactory<>("Day"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("Time"));
        teacherCol.setCellValueFactory(new PropertyValueFactory<>("Teacher"));
        
        sectionTable.setItems(sectionInfosTheory);
    }
    
    /**
     * List of theory sections to be chosen from.
     */
    ObservableList<SectionInfo> sectionInfosTheory = FXCollections.observableArrayList(
            new SectionInfo("A", "Sat/Tues", "8.30AM - 10.10AM", "Mam"),
            new SectionInfo("B", "Sun/Wed", "8.30AM - 10.10AM", "Mam"),
            new SectionInfo("C", "Sat/Tues", "11.40AM - 1.10PM", "Mam")
    ); 
}
