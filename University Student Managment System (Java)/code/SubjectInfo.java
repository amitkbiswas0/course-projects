/**
 * @author Amit Biswas
 */

package ucam.code;

import javafx.beans.property.SimpleStringProperty;


public class SubjectInfo {
    
    /**
     * SimpleStringProperty instead of String to create instance
     * of various property's mentioned in this class
     */
    private SimpleStringProperty serialNo;
    private SimpleStringProperty courseCode;
    private SimpleStringProperty courseTitle;
    private SimpleStringProperty courseCredit;
    private SimpleStringProperty courseSem;
    private SimpleStringProperty section;

    public SubjectInfo() {
    }

    public SubjectInfo(String serialNo, String courseCode, String courseTitle, String courseCredit, String courseSem , String section) {
        
        this.serialNo = new SimpleStringProperty(serialNo);
        this.courseCode = new SimpleStringProperty(courseCode);
        this.courseTitle = new SimpleStringProperty(courseTitle);
        this.courseCredit = new SimpleStringProperty(courseCredit);
        this.courseSem = new SimpleStringProperty(courseSem);
        this.section = new SimpleStringProperty(section);
        
    }

    public String getSerialNo() {
        return serialNo.get();
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = new SimpleStringProperty(serialNo);
    }

    public String getCourseCode() {
        return courseCode.get();
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = new SimpleStringProperty(courseCode);
    }

    public String getCourseTitle() {
        return courseTitle.get();
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = new SimpleStringProperty(courseTitle);
    }

    public String getCourseCredit() {
        return courseCredit.get();
    }

    public void setCourseCredit(String courseCredit) {
        this.courseCredit = new SimpleStringProperty(courseCredit);
    }

    public String getCourseSem() {
        return courseSem.get();
    }

    public void setCourseSem(String courseSem) {
        this.courseSem = new SimpleStringProperty(courseSem);
    }
    public String getSection() {
        return section.get();
    }

    public void setSection(String section) {
        this.section = new SimpleStringProperty(section);
    }

}
