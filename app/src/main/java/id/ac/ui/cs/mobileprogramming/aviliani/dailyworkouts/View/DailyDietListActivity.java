package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.R;

public class DailyDietListActivity extends Fragment {


    TextView tv_day, tv_breakfast, tv_snack, tv_lunch, tv_dinner;
    int id;
    String breakfast;
    String snack;
    String lunch;
    String dinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cardview_dietlist,
                container, false);


        tv_day = view.findViewById(R.id.days);
        tv_breakfast = view.findViewById(R.id.breakfast);
        tv_snack = view.findViewById(R.id.snack);
        tv_lunch = view.findViewById(R.id.lunch);
        tv_dinner = view.findViewById(R.id.dinner);

        Bundle bundle = this.getArguments();

        id = bundle.getInt("id");
        breakfast = bundle.getString("breakfast");
        snack = bundle.getString("snack");
        lunch = bundle.getString("lunch");
        dinner = bundle.getString("dinner");

        tv_day.setText(getString(R.string.day) + " " + id);
        tv_breakfast.setText(breakfast);
        tv_snack.setText(snack);
        tv_lunch.setText(lunch);
        tv_dinner.setText(dinner);


        return view;
    }


}
