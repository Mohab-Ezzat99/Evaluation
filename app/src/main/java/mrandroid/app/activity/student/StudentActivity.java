package mrandroid.app.activity.student;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import mrandroid.app.databinding.ActivityStudentBinding;

public class StudentActivity extends AppCompatActivity {

    private ActivityStudentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

}