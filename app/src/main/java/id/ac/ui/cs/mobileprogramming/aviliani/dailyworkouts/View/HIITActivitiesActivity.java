package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.R;

public class HIITActivitiesActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String ACTIVITY_NAME = "id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View.ACTIVITY_NAME";
    public static final String ACTIVITY_NUMBER = "id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View.ACTIVITY_NUMBER";
    public static final String ACTIVITIY_IMAGE = "id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View.ACTIVITIY_IMAGE";

    public static final String TAG = "Timer Service";

    TextView tv_title, textView;
    ImageView tv_image;
    Button start, reset;

    String name;
    int number;
    int image;

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
        reset = findViewById(R.id.pause);
        textView = findViewById(R.id.stopWatch);

        Intent activityIntent = getIntent();

        name = activityIntent.getStringExtra(ACTIVITY_NAME);
        image = activityIntent.getIntExtra(ACTIVITIY_IMAGE, 0);
        number = activityIntent.getIntExtra(ACTIVITY_NUMBER, 0);

        tv_title.setText(name);
        tv_image.setImageResource(image);
        textView.setText(Integer.toString(number));
        Log.d("HIIT ACTIVITY : ", name);


        ListElementsArrayList = new ArrayList<String>(Arrays.asList(ListElements));

        adapter = new ArrayAdapter<String>(HIITActivitiesActivity.this,
                android.R.layout.simple_list_item_1,
                ListElementsArrayList
        );


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService( new Intent(getApplicationContext(), TimerService.class));
                Log.i(TAG, "Started service");


            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), TimerService.class);
                stopService(intent);
                textView.setText(Integer.toString(number));

            }
        });


    }

    private BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateGUI(intent);
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        registerReceiver(br, new IntentFilter(TimerService.COUNTDOWN_BR));
        Log.i(TAG, "Registered broacast receiver");
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterReceiver(br);
        Log.i(TAG, "Unregistered broacast receiver");
    }

    @Override
    public void onStop() {
        try {
            unregisterReceiver(br);
            Log.i(TAG, "onStop method broacast receiver");
        } catch (Exception e) {
            // Receiver was probably already stopped in onPause()
        }
        super.onStop();
    }
    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy activity but service still running");
        super.onDestroy();
    }

    private void updateGUI(Intent intent) {
        if (intent.getExtras() != null) {
            long millisUntilFinished = intent.getLongExtra("countdown", 0);
            Log.i(TAG, "Countdown seconds remaining: " +  millisUntilFinished / 1000);
            textView.setText(Long.toString(millisUntilFinished/1000));
        }
    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



}
