package mrandroid.app.activity.student;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import mrandroid.app.R;
import mrandroid.app.activity.start.TalentActivity;
import mrandroid.app.databinding.ActivityWorkBinding;
import mrandroid.app.model.QuestionModel;
import mrandroid.app.model.ResultModel;
import mrandroid.app.util.Constants;
import mrandroid.app.util.LoadingDialog;

public class WorkActivity extends AppCompatActivity {

    private ActivityWorkBinding binding;
    private LoadingDialog loadingDialog;
    private int total = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWorkBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadingDialog = new LoadingDialog(this);

        total = getIntent().getIntExtra("total", 0);
        score = getIntent().getIntExtra("score", 0);

        binding.btnSubmit.setOnClickListener(v -> {
            boolean isValid = checkValidation();
            if (isValid) submitResult();
        });
    }

    private boolean checkValidation() {
        String drive = binding.etDrive.getText().toString().trim();

        if (drive.isEmpty()) {
            Toast.makeText(this, "Data is required!", Toast.LENGTH_SHORT).show();
            return false;
        }

        // All is fine
        return true;
    }

    private void submitResult() {
        String driveLink = binding.etDrive.getText().toString().trim();
        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        String resultRoot = "Results/" + userId;
        ResultModel resultModel = new ResultModel(email,total,score,driveLink);

        DatabaseReference questionRef = FirebaseDatabase.getInstance().getReference().child(resultRoot);
        questionRef.setValue(resultModel)
                .addOnSuccessListener(aVoid -> {
                    loadingDialog.dismiss();
                    Toast.makeText(getBaseContext(), "Result submitted successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getBaseContext(), TalentActivity.class));
                    finish();
                })
                .addOnFailureListener(e -> {
                    loadingDialog.dismiss();
                    Toast.makeText(getBaseContext(), "Error submit result: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });

    }
}