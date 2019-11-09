package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.MainActivity;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.R;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.adapter.HIITActivitiesAdapter;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.entity.HIITActivities;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.viewmodel.HIITActivitiesViewModel;

public class HIITListItemActivity extends MainActivity {

    private HIITActivitiesViewModel hiitActivitiesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activities_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // List of Activity
        RecyclerView recyclerView = findViewById(R.id.activity_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        final HIITActivitiesAdapter adapter = new HIITActivitiesAdapter();
        recyclerView.setAdapter(adapter);

        hiitActivitiesViewModel = ViewModelProviders.of(this).get(HIITActivitiesViewModel.class);
        hiitActivitiesViewModel.getAllActivities().observe(this, new Observer<List<HIITActivities>>() {
            @Override
            public void onChanged(@Nullable List<HIITActivities> activities) {
                adapter.setHiitActivities(activities);
            }
        });

        // Update
        adapter.setOnItemClickListener(new HIITActivitiesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(HIITActivities activities) {
//                Bundle bundle = new Bundle();
//                bundle.putString("name", activities.getActivity_name());
//                bundle.putString("image",  activities.getImage());
//                bundle.putInt("time", activities.getNumber());
//                HIITActivitiesActivity act = new HIITActivitiesActivity();
//                act.setArguments(bundle);

                Intent intent = new Intent(HIITListItemActivity.this, HIITActivitiesActivity.class);
                intent.putExtra(HIITActivitiesActivity.ACTIVITY_NAME, activities.getActivity_name());
                Log.d("PRINT NAME: ", activities.getActivity_name());
                intent.putExtra(HIITActivitiesActivity.ACTIVITIY_IMAGE, activities.getImage());
                intent.putExtra(HIITActivitiesActivity.ACTIVITY_NUMBER, activities.getNumber());
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
