package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.R;

public class ListIItemActivity extends MainActivity {


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


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
