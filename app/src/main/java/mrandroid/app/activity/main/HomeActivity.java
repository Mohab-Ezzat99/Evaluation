package mrandroid.app.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import mrandroid.app.activity.teacher.AddCourseActivity;
import mrandroid.app.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fabAdd.setOnClickListener(view -> {
            Intent intent =new Intent(getBaseContext(), AddCourseActivity.class);
            startActivity(intent);
        });
    }
}