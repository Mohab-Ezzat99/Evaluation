package mrandroid.app.model;

public class ResultModel {

    private String email;
    private int total;
    private int score;
    private String driveLink;

    public ResultModel() {
    }

    public ResultModel(String email, int total, int score, String driveLink) {
        this.email = email;
        this.total = total;
        this.score = score;
        this.driveLink = driveLink;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDriveLink() {
        return driveLink;
    }

    public void setDriveLink(String driveLink) {
        this.driveLink = driveLink;
    }
}
