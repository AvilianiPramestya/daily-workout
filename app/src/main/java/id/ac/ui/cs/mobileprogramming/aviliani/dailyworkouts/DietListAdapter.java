package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.entity.DietList;


public class DietListAdapter extends RecyclerView.Adapter<DietListAdapter.DietListHolder> {

    private List<DietList> dietLists = new ArrayList<>();
    private OnItemClickListener listener;

    String day;

    @NonNull
    @Override
    public DietListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item , parent, false);
        return new DietListHolder (itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DietListHolder holder, int position) {
        DietList currentDay = dietLists.get(position);
        String day = holder.itemView.getContext().getString(R.string.day);
        holder.textViewTitle.setText(day + " " +currentDay.getId());
    }

    @Override
    public int getItemCount() {
        return dietLists.size();
    }

    public void setDietLists(List<DietList> dietLists) {
        this.dietLists = dietLists;
        notifyDataSetChanged();
    }

    class DietListHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;

        public DietListHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.list_day);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(dietLists.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(DietList course);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}
