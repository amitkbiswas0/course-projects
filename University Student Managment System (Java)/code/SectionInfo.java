/**
 * @author Amit Biswas
 */

package ucam.code;

import javafx.beans.property.SimpleStringProperty;


public class SectionInfo {
    
    /**
     * SimpleStringProperty instead of String to create instance
     * of various property's mentioned in this class
     */
    private SimpleStringProperty section;
    private SimpleStringProperty day;
    private SimpleStringProperty time;
    private SimpleStringProperty teacher;

    public SectionInfo() {
    }
    
    public SectionInfo(String section, String day, String time, String teacher) {
        
        this.section = new SimpleStringProperty(section);
        this.day = new SimpleStringProperty(day);
        this.time = new SimpleStringProperty(time);
        this.teacher = new SimpleStringProperty(teacher);
    }

    public String getSection() {
        return section.get();
    }

    public void setSection(String section) {
        this.section = new SimpleStringProperty(section);
    }

    public String getDay() {
        return day.get();
    }

    public void setDay(String day) {
        this.day = new SimpleStringProperty(day);
    }

    public String getTime() {
        return time.get();
    }

    public void setTime(String time) {
        this.time = new SimpleStringProperty(time);
    }

    public String getTeacher() {
        return teacher.get();
    }

    public void setTeacher(String teacher) {
        this.teacher = new SimpleStringProperty(teacher);
    }
}
