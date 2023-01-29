package mrandroid.attendance.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import mrandroid.attendance.R;
import mrandroid.attendance.databinding.ActivityHomeBinding;
import mrandroid.attendance.databinding.ActivitySplashBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}