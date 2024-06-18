package mrandroid.app.activity.main;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import mrandroid.app.databinding.ActivityStudentWorkBinding;

public class StudentWorkActivity extends AppCompatActivity {

    private ActivityStudentWorkBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentWorkBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSubmit.setOnClickListener(v -> {

        });
    }
}