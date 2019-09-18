/**
 * @author Amit Biswas
 */

package ucam.control;

import com.jfoenix.controls.*;
import java.io.IOException;
import javafx.fxml.*;
import javafx.scene.control.*;
import ucam.util.FileIO;


public class ChangePasswordController{
    
    /**
     * Strings to store values from password fields
     */
    private String oldPassword;
    private String newPassOne;
    private String newPassTwo;

    @FXML
    private JFXPasswordField oldpass;
    @FXML
    private JFXPasswordField newpassOne;
    @FXML
    private JFXPasswordField newpassTwo;
    @FXML
    private JFXButton changePass;
    @FXML
    private Label errorMsg;
    
    /**
     * checks if the passwords entered are in correct order
     * and matches the procedure of password changing
     * @throws IOException 
     */
    @FXML
    void handleChangePass() throws IOException {
        
        oldPassword = oldpass.getText();
        newPassOne = newpassOne.getText();
        newPassTwo = newpassTwo.getText();
            
        if(FileIO.checkOldPass(oldPassword)){
            
            if(newPassOne.equals(newPassTwo)){
                
                if(FileIO.writeNewpass(newPassOne)){
                    
                    errorMsg.setText("Password Changed Successfully");
                    
                } else {
                    oldpass.clear();
                    newpassOne.clear();
                    newpassTwo.clear();
                    errorMsg.setText("Problem writing File!");
                } 
            } else {
                oldpass.clear();
                newpassOne.clear();
                newpassTwo.clear();
                errorMsg.setText("Enter Same New Password twice!");
            }
        } else {
            oldpass.clear();
            newpassOne.clear();
            newpassTwo.clear();
            errorMsg.setText("Old Password doesn't match!");
        }
    }
}
