package mrandroid.app.activity.doctor;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import mrandroid.app.activity.start.TalentActivity;
import mrandroid.app.databinding.ActivityExamResultBinding;

public class ExamResultActivity extends AppCompatActivity {

    private ActivityExamResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExamResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}