package mrandroid.app.activity.doctor;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import mrandroid.app.databinding.ActivityDoctorBinding;

public class DoctorActivity extends AppCompatActivity {

    private ActivityDoctorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoctorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fabAdd.setOnClickListener(view -> {
            startActivity(new Intent(getBaseContext(), AddQuestionActivity.class));
        });
    }

}