package mrandroid.app.activity.start;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import mrandroid.app.R;
import mrandroid.app.activity.auth.IntroActivity;
import mrandroid.app.activity.auth.SignupActivity;
import mrandroid.app.databinding.ActivitySplashBinding;
import mrandroid.app.databinding.ActivityTalentBinding;
import mrandroid.app.util.talent.CurrentTalent;
import mrandroid.app.util.talent.TalentNames;

public class TalentActivity extends AppCompatActivity {

    private ActivityTalentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTalentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvProgramming.setOnClickListener(view -> {
            CurrentTalent.name = TalentNames.PROGRAMING.getName();
            startActivity(new Intent(getBaseContext(), LevelActivity.class));
            finish();
        });

        binding.tvGraphic.setOnClickListener(view -> {
            CurrentTalent.name = TalentNames.PHOTOSHOP.getName();
            startActivity(new Intent(getBaseContext(), LevelActivity.class));
            finish();
        });

        binding.tvAnimation.setOnClickListener(view -> {
            CurrentTalent.name = TalentNames.ANIMATION.getName();
            startActivity(new Intent(getBaseContext(), LevelActivity.class));
            finish();
        });

        binding.tvEdit.setOnClickListener(view -> {
            CurrentTalent.name = TalentNames.EDIT.getName();
            startActivity(new Intent(getBaseContext(), LevelActivity.class));
            finish();
        });

    }
}