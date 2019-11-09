//package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.fragment.app.Fragment;
//import androidx.lifecycle.ViewModelProviders;
//
//import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.entity.DietList;
//
//public class DetailsFragment extends Fragment {
//
//    private DailyRoutinesViewModel viewModel;
//
//    private TextView day;
//    private TextView breakfast;
//    private TextView lunch;
//    private TextView dinner;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        viewModel = ViewModelProviders.of(this.getActivity()).get(DailyRoutinesViewModel.class);
//
//        viewModel.getSelectedDietList().observe(this, item -> {
//            displayDetails(viewModel.getDietListDetails(item));
//        });
//    }
//
//    public void displayDetails(DietList dietList){
//        String currDay = getString(R.string.day) + dietList.getId();
//        day.setText(currDay);
//        breakfast.setText(""+dietList.getBreakfast());
//        lunch.setText(dietList.getLunch());
//        dinner.setText(""+dietList.getDinner());
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_daily_routines,
//                container, false);
//
//        day = view.findViewById(R.id.day);
//        breakfast = view.findViewById(R.id.breakfast);
//        lunch = view.findViewById(R.id.lunch);
//        dinner = view.findViewById(R.id.dinner);
//
//        return view;
//    }
//}
