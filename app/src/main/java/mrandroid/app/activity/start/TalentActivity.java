package mrandroid.app.activity.start;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import mrandroid.app.databinding.ActivityTalentBinding;
import mrandroid.app.util.CurrentTalent;
import mrandroid.app.util.tracks.AnimationTrack;
import mrandroid.app.util.tracks.EditTrack;
import mrandroid.app.util.tracks.GraphicTrack;
import mrandroid.app.util.tracks.ProgramingTrack;

public class TalentActivity extends AppCompatActivity {

    private ActivityTalentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTalentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvProgramming.setOnClickListener(view -> {
            CurrentTalent.talentLabel = ProgramingTrack.LABEL.getValue();
            startActivity(new Intent(getBaseContext(), TrackActivity.class));
            finish();
        });

        binding.tvGraphic.setOnClickListener(view -> {
            CurrentTalent.talentLabel = GraphicTrack.LABEL.getValue();
            startActivity(new Intent(getBaseContext(), TrackActivity.class));
            finish();
        });

        binding.tvAnimation.setOnClickListener(view -> {
            CurrentTalent.talentLabel = AnimationTrack.LABEL.getValue();
            startActivity(new Intent(getBaseContext(), TrackActivity.class));
            finish();
        });

        binding.tvEdit.setOnClickListener(view -> {
            CurrentTalent.talentLabel = EditTrack.LABEL.getValue();
            startActivity(new Intent(getBaseContext(), TrackActivity.class));
            finish();
        });

    }
}