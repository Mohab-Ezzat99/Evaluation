package mrandroid.app.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import mrandroid.app.ViewModel;
import mrandroid.app.activity.teacher.AddCourseActivity;
import mrandroid.app.adapter.CoursesAdapter;
import mrandroid.app.adapter.QuestionsAdapter;
import mrandroid.app.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ViewModel viewModel;
    private ActivityHomeBinding binding;
    private CoursesAdapter coursesAdapter = new CoursesAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        binding.rvCourses.setAdapter(coursesAdapter);

        binding.fabAdd.setOnClickListener(view -> {
            Intent intent =new Intent(getBaseContext(), AddCourseActivity.class);
            startActivity(intent);
        });

        fetchAllCourses();
    }

    private void fetchAllCourses() {
        viewModel.getAllCourses().observe(this, courseModels -> {
            coursesAdapter.setList(courseModels);
            coursesAdapter.notifyDataSetChanged();
        });
    }
}