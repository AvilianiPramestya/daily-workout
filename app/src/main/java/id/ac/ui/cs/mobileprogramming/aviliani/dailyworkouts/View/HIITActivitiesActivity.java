package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.R;

public class HIITActivitiesActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String ACTIVITY_NAME = "id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View.ACTIVITY_NAME";
    public static final String ACTIVITY_NUMBER = "id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View.ACTIVITY_NUMBER";
    public static final String ACTIVITIY_IMAGE = "id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View.ACTIVITIY_IMAGE";

    TextView tv_title, tv_timer, textView;
    ImageView tv_image;
    Button start, pause;

    String name;
    int number;
    int image;


    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L ;

    Handler handler;

    int Seconds, Minutes, MilliSeconds ;

    String[] ListElements = new String[] {  };

    List<String> ListElementsArrayList ;

    ArrayAdapter<String> adapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_activities_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv_title = findViewById(R.id.activity_name);
        tv_image = findViewById(R.id.activity_image);

        start = findViewById(R.id.start);
        pause = findViewById(R.id.pause);
        textView = findViewById(R.id.stopWatch);


        Intent activityIntent = getIntent();

        name = activityIntent.getStringExtra(ACTIVITY_NAME);
        image = activityIntent.getIntExtra(ACTIVITIY_IMAGE, 0);
        number = activityIntent.getIntExtra(ACTIVITY_NUMBER, 0);

        tv_title.setText(name);
        tv_image.setImageResource(image);
        Log.d("HIIT ACTIVITY : ", name);


        handler = new Handler() ;

        ListElementsArrayList = new ArrayList<String>(Arrays.asList(ListElements));

        adapter = new ArrayAdapter<String>(HIITActivitiesActivity.this,
                android.R.layout.simple_list_item_1,
                ListElementsArrayList
        );


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);


            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimeBuff += MillisecondTime;

                handler.removeCallbacks(runnable);


            }
        });



    }

    @Override
    public void onClick(View v) {

    }

    public Runnable runnable = new Runnable() {

        public void run() {

            MillisecondTime = SystemClock.uptimeMillis() - StartTime;

            UpdateTime = TimeBuff + MillisecondTime;

            Seconds = (int) (UpdateTime / 1000);

            Minutes = Seconds / 60;

            Seconds = Seconds % 60;

            MilliSeconds = (int) (UpdateTime % 1000);

            textView.setText("" + Minutes + ":"
                    + String.format("%02d", Seconds) + ":"
                    + String.format("%03d", MilliSeconds));

            handler.postDelayed(this, 0);
        }

    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



}
