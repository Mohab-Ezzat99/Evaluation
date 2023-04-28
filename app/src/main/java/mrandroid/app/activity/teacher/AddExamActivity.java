package mrandroid.app.activity.teacher;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import mrandroid.app.databinding.ActivityQuestionsNumberBinding;
import mrandroid.app.model.CourseModel;
import mrandroid.app.model.QuestionModel;
import mrandroid.app.util.Constants;

public class AddExamActivity extends AppCompatActivity {

    private ActivityQuestionsNumberBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionsNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CourseModel courseModel = (CourseModel) getIntent().getSerializableExtra(Constants.COURSE_MODEL);
        int questionsNumber = (int) getIntent().getSerializableExtra(Constants.QUESTIONS_NUMBER);
        initQuestionsList(questionsNumber);

        binding.btnSubmit.setOnClickListener(view -> validateAndSubmit(courseModel));

    }

    private ArrayList<QuestionModel> initQuestionsList(int questionsNumber) {
        ArrayList<QuestionModel> questionModels = new ArrayList<>();
        for (int i = 0; i < questionsNumber; i++) {
            questionModels.add(new QuestionModel("","","",-1));
        }
        return questionModels;
    }

    private void validateAndSubmit(CourseModel courseModel) {

    }
}