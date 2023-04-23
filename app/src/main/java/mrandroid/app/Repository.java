package mrandroid.app;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import mrandroid.app.database.AppDB;
import mrandroid.app.database.AppDao;
import mrandroid.app.model.CourseModel;
import mrandroid.app.model.ExamModel;

public class Repository {
    private final AppDao appDao;

    public Repository(Application application) {
        this.appDao = AppDB.getInstance(application).appDao();
    }

    public void insertCourses(List<CourseModel> courses) {
        appDao.insertCourses(courses)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public LiveData<List<CourseModel>> getAllCourses() {
        return appDao.getAllCourses();
    }

    public void deleteAllCourses() {
        appDao.deleteAllCourses()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public void insertExams(List<ExamModel> exams) {
        appDao.insertExams(exams)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public LiveData<List<ExamModel>> getAllExams() {
        return appDao.getAllExams();
    }

    public void deleteAllExams() {
        appDao.deleteAllExams()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

}
