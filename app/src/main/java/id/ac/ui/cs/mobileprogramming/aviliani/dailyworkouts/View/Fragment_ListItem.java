package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.viewmodel.DailyRoutinesViewModel;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.adapter.DietListAdapter;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.R;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.entity.DietList;

public class Fragment_ListItem extends Fragment {
    private DailyRoutinesViewModel dailyRoutinesViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_item_activity,
                container, false);
        // List of DietList
        RecyclerView recyclerView = view.findViewById(R.id.dietList_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.hasFixedSize();

        final DietListAdapter adapter = new DietListAdapter();
        recyclerView.setAdapter(adapter);

        dailyRoutinesViewModel = ViewModelProviders.of(this).get(DailyRoutinesViewModel.class);
        dailyRoutinesViewModel.getAllDietList().observe(this, new Observer<List<DietList>>() {
            @Override
            public void onChanged(@Nullable List<DietList> dietLists) {
                adapter.setDietLists(dietLists);
            }
        });

        // Update
        adapter.setOnItemClickListener(new DietListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DietList dietList) {
                Bundle bundle = new Bundle();
                bundle.putString("breakfast", dietList.getBreakfast());
                bundle.putString("snack",  dietList.getSnack());
                bundle.putString("lunch",  dietList.getLunch());
                bundle.putString("dinner",  dietList.getDinner());
                bundle.putInt("id", dietList.getId());
                DailyDietListActivity act = new DailyDietListActivity();
                act.setArguments(bundle);

                FragmentManager fm = ((AppCompatActivity) container.getContext()).getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.list_meals, act);
                ft.addToBackStack(null);
                ft.commit();

//                Intent intent = new Intent(ListIItemActivity.this, DailyDietListActivity.class);
//                intent.putExtra(DailyDietListActivity.ID_DAY, dietList.getId());
//                intent.putExtra(DailyDietListActivity.BREAKFAST, dietList.getBreakfast());
//                intent.putExtra(DailyDietListActivity.SNACK, dietList.getSnack());
//                intent.putExtra(DailyDietListActivity.LUNCH, dietList.getLunch());
//                intent.putExtra(DailyDietListActivity.DINNER, dietList.getDinner());
//                startActivity(intent);
            }
        });



        return view;
    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//    }

}
