package mrandroid.app.activity.start;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import mrandroid.app.activity.doctor.DoctorActivity;
import mrandroid.app.activity.student.StudentActivity;
import mrandroid.app.databinding.ActivityTrackBinding;
import mrandroid.app.util.Constants;
import mrandroid.app.util.CurrentTalent;
import mrandroid.app.util.tracks.AnimationTrack;
import mrandroid.app.util.tracks.EditTrack;
import mrandroid.app.util.tracks.GraphicTrack;
import mrandroid.app.util.tracks.ProgramingTrack;

public class TrackActivity extends AppCompatActivity {

    private ActivityTrackBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTrackBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupTracks();

        binding.tvTrackOne.setOnClickListener(view -> {
            CurrentTalent.track = binding.tvTrackOne.getText().toString();

            if (Constants.IS_DOCTOR)
                startActivity(new Intent(getBaseContext(), DoctorActivity.class));
            else startActivity(new Intent(getBaseContext(), StudentActivity.class));
            finishAffinity();
        });

        binding.tvTrackTwo.setOnClickListener(view -> {
            CurrentTalent.track = binding.tvTrackTwo.getText().toString();

            if (Constants.IS_DOCTOR)
                startActivity(new Intent(getBaseContext(), DoctorActivity.class));
            else startActivity(new Intent(getBaseContext(), StudentActivity.class));
            finishAffinity();
        });

        binding.tvTrackThree.setOnClickListener(view -> {
            CurrentTalent.track = binding.tvTrackThree.getText().toString();

            if (Constants.IS_DOCTOR)
                startActivity(new Intent(getBaseContext(), DoctorActivity.class));
            else startActivity(new Intent(getBaseContext(), StudentActivity.class));
            finishAffinity();
        });

    }

    private void setupTracks() {
        if (CurrentTalent.talentLabel.equals(ProgramingTrack.LABEL.getValue())) {
            binding.tvTrackOne.setText(ProgramingTrack.HTML.getValue());
            binding.tvTrackTwo.setText(ProgramingTrack.PYTHON.getValue());
            binding.tvTrackThree.setText(ProgramingTrack.JAVA.getValue());
        }

        if (CurrentTalent.talentLabel.equals(GraphicTrack.LABEL.getValue())) {
            binding.tvTrackOne.setText(GraphicTrack.PHOTOSHOP.getValue());
            binding.tvTrackTwo.setText(GraphicTrack.INDESIGN.getValue());
            binding.tvTrackThree.setText(GraphicTrack.ILLUSTRATOR.getValue());
        }

        if (CurrentTalent.talentLabel.equals(EditTrack.LABEL.getValue())) {
            binding.tvTrackOne.setText(EditTrack.ADOBE_PREMIERE_PRO.getValue());
            binding.tvTrackTwo.setText(EditTrack.FINAL_CUT_PRO.getValue());
            binding.tvTrackThree.setText(EditTrack.DAVINCI_RESOLVE.getValue());
        }

        if (CurrentTalent.talentLabel.equals(AnimationTrack.LABEL.getValue())) {
            binding.tvTrackOne.setText(AnimationTrack.ADOBE_ANIMATE.getValue());
            binding.tvTrackTwo.setText(AnimationTrack.BLENDER.getValue());
            binding.tvTrackThree.setText(AnimationTrack.TOON_BOOM_HARMONY.getValue());
        }
    }
}