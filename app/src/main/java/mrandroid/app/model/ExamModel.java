package mrandroid.app.model;

public class ExamModel {

    private int id;
    private String question;
    private String option1;
    private String option2;
    private boolean isOption1Correct;

    public ExamModel(String question, String option1, String option2, boolean isOption1Correct) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.isOption1Correct = isOption1Correct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public boolean isOption1Correct() {
        return isOption1Correct;
    }

    public void setOption1Correct(boolean option1Correct) {
        isOption1Correct = option1Correct;
    }
}
