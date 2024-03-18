package mrandroid.app.util;

import android.content.Context;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import mrandroid.app.model.AnswerModel;

public class FirebaseQuestions {

    private DatabaseReference databaseReference;
    private Context context;

    public FirebaseQuestions(Context context) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        this.databaseReference = database.getReference();
        this.context = context;
    }

    public void addAnswerToQuestion(String question, AnswerModel answer) {
        DatabaseReference questionRef = databaseReference.child("questions").child(question);
        String answerKey = questionRef.push().getKey();
        questionRef.child(answerKey).setValue(answer)
                .addOnSuccessListener(aVoid -> Toast.makeText(context, "Answer added successfully", Toast.LENGTH_SHORT).show())
                .addOnFailureListener(e -> Toast.makeText(context, "Error adding answer: " + e.getMessage(), Toast.LENGTH_SHORT).show());
    }

    public void deleteQuestion(String question) {
        DatabaseReference questionRef = databaseReference.child("questions").child(question);
        questionRef.removeValue()
                .addOnSuccessListener(aVoid -> Toast.makeText(context, "Question deleted successfully", Toast.LENGTH_SHORT).show())
                .addOnFailureListener(e -> Toast.makeText(context, "Error adding answer: " + e.getMessage(), Toast.LENGTH_SHORT).show());
    }

}
