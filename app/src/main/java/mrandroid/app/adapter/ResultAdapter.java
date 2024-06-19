package mrandroid.app.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import mrandroid.app.R;
import mrandroid.app.model.ResultModel;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.MedicineViewHolder> {
    private List<ResultModel> list = new ArrayList<>();
    private OnItemClickListener listener;

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public MedicineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MedicineViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exam_result, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MedicineViewHolder holder, int position) {
        ResultModel item = list.get(holder.getAdapterPosition());

        holder.tvEmail.setText(item.getEmail());
        holder.tvScore.setText("Score: " + item.getScore() + "/" + item.getTotal());
        holder.tvDriveLink.setText(item.getDriveLink());

        holder.tvDriveLink.setOnClickListener(view -> {
            listener.onDriveClick(item);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setList(List<ResultModel> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    static class MedicineViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvEmail;
        private final TextView tvScore;
        private final TextView tvDriveLink;

        public MedicineViewHolder(@NonNull View itemView) {
            super(itemView);

            tvEmail = itemView.findViewById(R.id.tv_email);
            tvScore = itemView.findViewById(R.id.tv_score);
            tvDriveLink = itemView.findViewById(R.id.tv_drive_link);

        }
    }

    public interface OnItemClickListener {
        void onDriveClick(ResultModel item);
    }
}