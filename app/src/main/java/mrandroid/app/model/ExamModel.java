package mrandroid.app.model;

import java.util.List;

public class ExamModel {

    private String score;
    private List<QuestionModel> questionModels;

    public ExamModel(String score, List<QuestionModel> questionModels) {
        this.score = score;
        this.questionModels = questionModels;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public List<QuestionModel> getQuestionModels() {
        return questionModels;
    }

    public void setQuestionModels(List<QuestionModel> questionModels) {
        this.questionModels = questionModels;
    }
}
