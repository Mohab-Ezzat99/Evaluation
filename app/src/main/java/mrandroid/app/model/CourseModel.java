package mrandroid.app.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CourseModel {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String courseName;
    private String teacherName;
    private String teacherPhone;
    private String videoUrl;
    private String description;
    private float price;
    private float rate;
    private ExamModel examModel;

    public CourseModel(String courseName, String teacherName, String teacherPhone, String videoUrl, String description, float price, float rate, ExamModel examModel) {
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.teacherPhone = teacherPhone;
        this.videoUrl = videoUrl;
        this.description = description;
        this.price = price;
        this.rate = rate;
        this.examModel = examModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public ExamModel getExamModel() {
        return examModel;
    }

    public void setExamModel(ExamModel examModel) {
        this.examModel = examModel;
    }
}
