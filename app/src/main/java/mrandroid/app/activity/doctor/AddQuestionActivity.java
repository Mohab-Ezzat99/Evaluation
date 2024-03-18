package mrandroid.app.activity.doctor;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import mrandroid.app.R;
import mrandroid.app.databinding.ActivityAddQuestionBinding;
import mrandroid.app.model.AnswerModel;
import mrandroid.app.util.LoadingDialog;

public class AddQuestionActivity extends AppCompatActivity {

    private ActivityAddQuestionBinding binding;
    private boolean is4Options = true;
    private LoadingDialog loadingDialog;
    private AnswerModel option1;
    private AnswerModel option2;
    private AnswerModel option3;
    private AnswerModel option4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddQuestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadingDialog = new LoadingDialog(this);
        option1 = new AnswerModel("", false);
        option2 = new AnswerModel("", false);
        option3 = new AnswerModel("", false);
        option4 = new AnswerModel("", false);

        binding.rgOptionsNum.setOnCheckedChangeListener((radioGroup, id) -> {
            if (id == R.id.rbOptionNum2) setup2Options();
            else setup4Options();
        });

        binding.rgOptionsAnswer.setOnCheckedChangeListener((radioGroup, id) -> {
            // reset
            option1.setCorrect(false);
            option2.setCorrect(false);
            option3.setCorrect(false);
            option4.setCorrect(false);

            switch (id) {
                case R.id.rbOption1:
                    option1.setCorrect(true);
                    break;

                case R.id.rbOption2:
                    option2.setCorrect(true);
                    break;

                case R.id.rbOption3:
                    option3.setCorrect(true);
                    break;

                case R.id.rbOption4:
                    option4.setCorrect(true);
                    break;
            }
        });

        binding.fabSubmit.setOnClickListener(view -> {
            boolean isValid = validateQuestion();
            if (isValid) createAnswer1();
        });

    }

    private void setup4Options() {
        is4Options = true;
        binding.itlOption3.setVisibility(View.VISIBLE);
        binding.itlOption4.setVisibility(View.VISIBLE);
        binding.rbOption3.setVisibility(View.VISIBLE);
        binding.rbOption4.setVisibility(View.VISIBLE);
    }

    private void setup2Options() {
        is4Options = false;
        binding.itlOption3.setVisibility(View.GONE);
        binding.itlOption4.setVisibility(View.GONE);
        binding.rbOption3.setVisibility(View.GONE);
        binding.rbOption4.setVisibility(View.GONE);
    }

    private boolean validateQuestion() {
        String question = binding.etQuestion.getText().toString().trim();
        String option1Text = binding.etOption1.getText().toString().trim();
        String option2Text = binding.etOption2.getText().toString().trim();
        String option3Text = binding.etOption3.getText().toString().trim();
        String option4Text = binding.etOption4.getText().toString().trim();

        boolean isEmpty;
        if (is4Options)
            isEmpty = question.isEmpty() || option1Text.isEmpty() || option2Text.isEmpty() || option3Text.isEmpty() || option4Text.isEmpty();
        else isEmpty = question.isEmpty() || option1Text.isEmpty() || option2Text.isEmpty();

        if (isEmpty) {
            Toast.makeText(this, "Data is required!", Toast.LENGTH_SHORT).show();
            return false;
        }

        boolean hasCorrectAnswer;
        if (is4Options)
            hasCorrectAnswer = option1.isCorrect() || option2.isCorrect() || option3.isCorrect() || option4.isCorrect();
        else hasCorrectAnswer = option1.isCorrect() || option2.isCorrect();

        if (!hasCorrectAnswer) {
            Toast.makeText(this, "Correct answer is required!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void createAnswer1() {
        loadingDialog.display();

        String question = binding.etQuestion.getText().toString().trim();
        String option1Text = binding.etOption1.getText().toString().trim();
        option1.setAnswer(option1Text);

        DatabaseReference questionRef = FirebaseDatabase.getInstance().getReference().child("questions").child(question);
        questionRef.push().setValue(option1)
                .addOnSuccessListener(aVoid -> createAnswer2())
                .addOnFailureListener(e -> {
                    loadingDialog.dismiss();
                    Toast.makeText(getBaseContext(), "Error adding answer: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    private void createAnswer2() {
        String question = binding.etQuestion.getText().toString().trim();
        String option2Text = binding.etOption2.getText().toString().trim();
        option2.setAnswer(option2Text);

        DatabaseReference questionRef = FirebaseDatabase.getInstance().getReference().child("questions").child(question);
        questionRef.push().setValue(option2)
                .addOnSuccessListener(aVoid -> {
                    if (is4Options) createAnswer3();
                    else {
                        loadingDialog.dismiss();
                        Toast.makeText(getBaseContext(), "Question created successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                })
                .addOnFailureListener(e -> {
                    loadingDialog.dismiss();
                    Toast.makeText(getBaseContext(), "Error adding answer: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    private void createAnswer3() {
        String question = binding.etQuestion.getText().toString().trim();
        String option3Text = binding.etOption3.getText().toString().trim();
        option3.setAnswer(option3Text);

        DatabaseReference questionRef = FirebaseDatabase.getInstance().getReference().child("questions").child(question);
        questionRef.push().setValue(option3)
                .addOnSuccessListener(aVoid -> createAnswer4())
                .addOnFailureListener(e -> {
                    loadingDialog.dismiss();
                    Toast.makeText(getBaseContext(), "Error adding answer: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    private void createAnswer4() {
        String question = binding.etQuestion.getText().toString().trim();
        String option4Text = binding.etOption4.getText().toString().trim();
        option4.setAnswer(option4Text);

        DatabaseReference questionRef = FirebaseDatabase.getInstance().getReference().child("questions").child(question);
        questionRef.push().setValue(option4)
                .addOnSuccessListener(aVoid -> {
                    loadingDialog.dismiss();
                    Toast.makeText(getBaseContext(), "Question created successfully", Toast.LENGTH_SHORT).show();
                    finish();
                })
                .addOnFailureListener(e -> {
                    loadingDialog.dismiss();
                    Toast.makeText(getBaseContext(), "Error adding answer: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

}