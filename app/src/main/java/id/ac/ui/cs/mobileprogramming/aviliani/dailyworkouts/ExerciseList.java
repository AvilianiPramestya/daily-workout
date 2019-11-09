//package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentTransaction;
//import androidx.lifecycle.ViewModelProviders;
//
//public class ExerciseList extends Fragment {
//    private ExerciseViewModel viewModel;
//    private ListView lv;
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        viewModel = ViewModelProviders.of(this.getActivity()).get(ExerciseViewModel.class);
//
//        lv.setAdapter(new ArrayAdapter<String>(this.getActivity(),
//                android.R.layout.simple_list_item_1, viewModel.getDietList()));
//
//        lv.setOnItemClickListener((adapter, itemView, pos, id) -> {
//            TextView tv = (TextView)itemView;
//            Toast.makeText(this.getContext(), tv.getText().toString(), Toast.LENGTH_SHORT).show();
//            viewModel.selectDietList(tv.getText().toString());
//
//            FragmentManager fm = getFragmentManager();
//            FragmentTransaction ft = fm.beginTransaction();
//            DetailsFragment fragment = new DetailsFragment();
//            ft.replace(R.id.list_container, fragment);
//            ft.addToBackStack(null);
//            ft.commit();
//
//            Log.d("INFOOOOOOOOOOOO: ", tv.getText().toString());
//        });
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        View view = inflater.inflate(R.layout.list_daily_routines,
//                container, false);
//
//        lv = (ListView) view.findViewById(R.id.list_day);
//
//        return view;
//    }
//
//}
