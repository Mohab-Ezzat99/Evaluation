package mrandroid.app.activity.teacher;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

import mrandroid.app.ViewModel;
import mrandroid.app.adapter.QuestionsAdapter;
import mrandroid.app.databinding.ActivityAddExamBinding;
import mrandroid.app.model.CourseModel;
import mrandroid.app.model.QuestionModel;
import mrandroid.app.util.Constants;

public class AddExamActivity extends AppCompatActivity {

    private ViewModel viewModel;
    private ActivityAddExamBinding binding;
    private QuestionsAdapter questionsAdapter = new QuestionsAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddExamBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(ViewModel.class);

        CourseModel courseModel = (CourseModel) getIntent().getSerializableExtra(Constants.COURSE_MODEL);
        int questionsNumber = (int) getIntent().getSerializableExtra(Constants.QUESTIONS_NUMBER);

        questionsAdapter.setList(initQuestionsList(questionsNumber));
        questionsAdapter.setCanEdit(true);
        binding.rvQuestions.setAdapter(questionsAdapter);

        binding.btnSubmit.setOnClickListener(view -> validateAndSubmit(courseModel));

    }

    private ArrayList<QuestionModel> initQuestionsList(int questionsNumber) {
        ArrayList<QuestionModel> questionModels = new ArrayList<>();
        for (int i = 0; i < questionsNumber; i++) {
            questionModels.add(new QuestionModel("", "", "", -1, -1));
        }
        return questionModels;
    }

    private void validateAndSubmit(CourseModel courseModel) {
        questionsAdapter.notifyDataSetChanged();

        if (questionsAdapter.isFieldsRequired()) {
            Toast.makeText(this, "Fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        if (questionsAdapter.isAnswerRequired()) {
            Toast.makeText(this, "Answers are required", Toast.LENGTH_SHORT).show();
            return;
        }

        courseModel.setQuestionModels(questionsAdapter.getList());
        viewModel.insertCourse(courseModel);
        finish();
    }
}