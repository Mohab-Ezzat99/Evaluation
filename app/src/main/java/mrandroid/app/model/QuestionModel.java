package mrandroid.app.model;

public class QuestionModel {

    private String question;
    private boolean isCode;

    public QuestionModel(String question, boolean isCode) {
        this.question = question;
        this.isCode = isCode;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isCode() {
        return isCode;
    }

    public void setCode(boolean code) {
        isCode = code;
    }
}
