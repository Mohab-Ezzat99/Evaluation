package mrandroid.app.activity.student;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import mrandroid.app.databinding.ActivityStudentBinding;
import mrandroid.app.model.QuestionModel;
import mrandroid.app.util.LoadingDialog;

public class StudentActivity extends AppCompatActivity {

    private ActivityStudentBinding binding;
    private LoadingDialog loadingDialog;
    private List<QuestionModel> questionList = new ArrayList<>();
    private int questionPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadingDialog = new LoadingDialog(this);
        getAllQuestions();
    }

    private void getAllQuestions() {
        loadingDialog.display();
        FirebaseDatabase.getInstance().getReference().child("questions").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                loadingDialog.dismiss();
                for (DataSnapshot questionSnapshot : snapshot.getChildren()) {
                    questionList.add(questionSnapshot.getValue(QuestionModel.class));
                }
                if (!questionList.isEmpty()) {
                    binding.studentRoot.setVisibility(View.VISIBLE);
                    questionPosition = 0;
                    setCurrentQuestion(questionPosition);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                loadingDialog.dismiss();
                Toast.makeText(getBaseContext(), "Error fetching questions: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setCurrentQuestion(int questionPosition) {
        QuestionModel questionModel = questionList.get(questionPosition);

        binding.etQuestion.setText(questionModel.getQuestion());
        binding.etOption1.setText(questionModel.getAnswers().get(0).getAnswer());
        binding.etOption2.setText(questionModel.getAnswers().get(1).getAnswer());
        binding.etOption3.setText(questionModel.getAnswers().get(2).getAnswer());
        binding.etOption4.setText(questionModel.getAnswers().get(3).getAnswer());

        if (questionModel.isCode()) binding.tvOpenCode.setVisibility(View.VISIBLE);
        else binding.tvOpenCode.setVisibility(View.GONE);

        if (questionModel.isIs4Option()) {
            binding.etOption3.setVisibility(View.VISIBLE);
            binding.etOption4.setVisibility(View.VISIBLE);
        }
        else {
            binding.etOption3.setVisibility(View.GONE);
            binding.etOption4.setVisibility(View.GONE);
        }

    }

}