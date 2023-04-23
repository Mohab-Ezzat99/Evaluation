package mrandroid.app.database;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import mrandroid.app.model.CourseModel;
import mrandroid.app.model.ExamModel;

public class Converters {

    @TypeConverter
    public String convertToCourseString(List<CourseModel> courses){
        return new Gson().toJson(courses);
    }

    @TypeConverter
    public List<CourseModel> convertToCourseList(String stringList){
        Type listType = new TypeToken<List<CourseModel>>(){}.getType();
        return new Gson().fromJson(stringList,listType);
    }

    @TypeConverter
    public String convertToExamString(List<ExamModel> exams){
        return new Gson().toJson(exams);
    }

    @TypeConverter
    public List<ExamModel> convertToExamList(String stringList){
        Type listType = new TypeToken<List<ExamModel>>(){}.getType();
        return new Gson().fromJson(stringList,listType);
    }
}
