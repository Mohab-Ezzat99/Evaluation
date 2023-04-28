package mrandroid.app.database;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import mrandroid.app.model.CourseModel;
import mrandroid.app.model.ExamModel;
import mrandroid.app.model.QuestionModel;

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
    public String convertToQuestionString(QuestionModel question){
        return new Gson().toJson(question);
    }

    @TypeConverter
    public QuestionModel convertToQuestionModel(String string){
        Type type = new TypeToken<QuestionModel>(){}.getType();
        return new Gson().fromJson(string,type);
    }

    @TypeConverter
    public String convertToExamString(ExamModel exam){
        return new Gson().toJson(exam);
    }

    @TypeConverter
    public ExamModel convertToExamModel(String string){
        Type type = new TypeToken<ExamModel>(){}.getType();
        return new Gson().fromJson(string,type);
    }

}
