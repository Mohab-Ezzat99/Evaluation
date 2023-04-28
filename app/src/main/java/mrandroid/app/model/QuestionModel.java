package mrandroid.app.model;

public class QuestionModel {

    private String question;
    private String option1;
    private String option2;
    private int isOption1Correct;

    public QuestionModel(String question, String option1, String option2, int isOption1Correct) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.isOption1Correct = isOption1Correct;
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

    public int isOption1Correct() {
        return isOption1Correct;
    }

    public void setOption1Correct(int option1Correct) {
        isOption1Correct = option1Correct;
    }

    public boolean isFieldsEmpty() {
        return question.isEmpty() || option1.isEmpty() || option2.isEmpty();
    }

    public boolean isAnswerRequired() {
        return (isOption1Correct == -1);
    }
}
