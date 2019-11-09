package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.DailyRoutinesViewModel;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.DietListAdapter;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.MainActivity;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.R;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.entity.DietList;

public class ListIItemActivity extends MainActivity {

    private DailyRoutinesViewModel dailyRoutinesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_diet_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment_ListItem frag = new Fragment_ListItem();
        ft.replace(R.id.list_meals, frag);
        ft.commit();



//        // List of DietList
//        RecyclerView recyclerView = findViewById(R.id.dietList_recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.hasFixedSize();
//
//        final DietListAdapter adapter = new DietListAdapter();
//        recyclerView.setAdapter(adapter);
//
//        dailyRoutinesViewModel = ViewModelProviders.of(this).get(DailyRoutinesViewModel.class);
//        dailyRoutinesViewModel.getAllDietList().observe(this, new Observer<List<DietList>>() {
//            @Override
//            public void onChanged(@Nullable List<DietList> dietLists) {
//                adapter.setDietLists(dietLists);
//            }
//        });
//
//        // Update
//        adapter.setOnItemClickListener(new DietListAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(DietList dietList) {
//                Bundle bundle = new Bundle();
//                bundle.putString("breakfast", dietList.getBreakfast());
//                bundle.putString("snack",  dietList.getSnack());
//                bundle.putString("lunch",  dietList.getLunch());
//                bundle.putString("dinner",  dietList.getDinner());
//                bundle.putInt("id", dietList.getId());
//                DailyDietListActivity act = new DailyDietListActivity();
//                act.setArguments(bundle);
//
//                FragmentManager fm = getSupportFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.placeholder, act);
//
//                ft.addToBackStack(null);
//                ft.commit();
//
//
////                Intent intent = new Intent(ListIItemActivity.this, DailyDietListActivity.class);
////                intent.putExtra(DailyDietListActivity.ID_DAY, dietList.getId());
////                intent.putExtra(DailyDietListActivity.BREAKFAST, dietList.getBreakfast());
////                intent.putExtra(DailyDietListActivity.SNACK, dietList.getSnack());
////                intent.putExtra(DailyDietListActivity.LUNCH, dietList.getLunch());
////                intent.putExtra(DailyDietListActivity.DINNER, dietList.getDinner());
////                startActivity(intent);
//            }
//        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
