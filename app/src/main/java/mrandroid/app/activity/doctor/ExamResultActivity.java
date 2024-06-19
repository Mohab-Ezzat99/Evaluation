package mrandroid.app.activity.doctor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;
import mrandroid.app.adapter.ResultAdapter;
import mrandroid.app.databinding.ActivityExamResultBinding;
import mrandroid.app.model.ResultModel;
import mrandroid.app.util.LoadingDialog;

public class ExamResultActivity extends AppCompatActivity implements ResultAdapter.OnItemClickListener {

    private ActivityExamResultBinding binding;
    private ResultAdapter adapter;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExamResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadingDialog = new LoadingDialog(this);
        adapter = new ResultAdapter();
        adapter.setListener(this);
        binding.rvResults.setAdapter(adapter);

        getAllResults();
    }

    private void getAllResults() {
        loadingDialog.display();
        FirebaseDatabase.getInstance().getReference().child("Results").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                loadingDialog.dismiss();
                List<ResultModel> results = new ArrayList<>();
                for (DataSnapshot resultSnapshot : snapshot.getChildren()) {
                    results.add(resultSnapshot.getValue(ResultModel.class));
                }
                adapter.setList(results);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                loadingDialog.dismiss();
                Toast.makeText(getBaseContext(), "Error fetching results: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDriveClick(ResultModel item) {
        String url = item.getDriveLink();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}