package mrandroid.app.activity.start;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import mrandroid.app.activity.main.HomeActivity;
import mrandroid.app.databinding.ActivityLevelBinding;
import mrandroid.app.util.talent.CurrentTalent;
import mrandroid.app.util.talent.TalentLevel;

public class LevelActivity extends AppCompatActivity {

    private ActivityLevelBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLevelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvLow.setOnClickListener(view -> {
            CurrentTalent.level = TalentLevel.LOW.getName();
            startActivity(new Intent(getBaseContext(), HomeActivity.class));
        });

        binding.tvNormal.setOnClickListener(view -> {
            CurrentTalent.level = TalentLevel.NORMAL.getName();
            startActivity(new Intent(getBaseContext(), HomeActivity.class));
        });

        binding.tvHigh.setOnClickListener(view -> {
            CurrentTalent.level = TalentLevel.HIGH.getName();
            startActivity(new Intent(getBaseContext(), HomeActivity.class));
        });

    }
}