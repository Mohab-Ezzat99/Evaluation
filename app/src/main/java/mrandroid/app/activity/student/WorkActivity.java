package mrandroid.app.activity.student;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import mrandroid.app.databinding.ActivityWorkBinding;

public class WorkActivity extends AppCompatActivity {

    private ActivityWorkBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWorkBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSubmit.setOnClickListener(v -> {

        });
    }
}