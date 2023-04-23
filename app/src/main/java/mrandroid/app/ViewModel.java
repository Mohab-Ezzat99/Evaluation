package mrandroid.app;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;
import mrandroid.app.model.CourseModel;
import mrandroid.app.model.ExamModel;

public class ViewModel extends AndroidViewModel {

    private final Repository repository;

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public void insertCourses(List<CourseModel> courses) {
        repository.insertCourses(courses);
    }

    public LiveData<List<CourseModel>> getAllCourses() {
        return repository.getAllCourses();
    }

    public void deleteAllCourses() {
        repository.deleteAllCourses();
    }

    public void insertExams(List<ExamModel> exams) {
        repository.insertExams(exams);
    }

    public LiveData<List<ExamModel>> getAllExams() {
        return repository.getAllExams();
    }

    public void deleteAllExams() {
        repository.deleteAllExams();
    }

}
