package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.R;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.entity.HIITActivities;

public class HIITActivitiesAdapter extends RecyclerView.Adapter<HIITActivitiesAdapter.HIITActivitiesListHolder>{

    private List<HIITActivities> hiitActivities = new ArrayList<>();
    private HIITActivitiesAdapter.OnItemClickListener listener;


    @NonNull
    @Override
    public HIITActivitiesAdapter.HIITActivitiesListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_activities , parent, false);
        return new HIITActivitiesAdapter.HIITActivitiesListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HIITActivitiesAdapter.HIITActivitiesListHolder holder, int position) {
        HIITActivities activities = hiitActivities.get(position);
        holder.textViewTitle.setText(activities.getActivity_name());
        holder.textViewTimer.setText("" + activities.getNumber() + "s");
    }

    @Override
    public int getItemCount() {
        return hiitActivities.size();
    }

    public void setHiitActivities(List<HIITActivities> hiitActivities) {
        this.hiitActivities = hiitActivities;
        notifyDataSetChanged();
    }

    class HIITActivitiesListHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle, textViewTimer;

        public HIITActivitiesListHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.list_activity);
            textViewTimer = itemView.findViewById(R.id.time_activity);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(hiitActivities.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(HIITActivities course);
    }

    public void setOnItemClickListener(HIITActivitiesAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

}
