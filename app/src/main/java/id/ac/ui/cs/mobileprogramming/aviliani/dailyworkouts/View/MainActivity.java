package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;

import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.R;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.Receiver;


public class MainActivity extends AppCompatActivity {


    public static final String NOTIFICATION_CHANNEL_ID = "10001" ;
    private final static String default_notification_channel_id = "default" ;

    public String[] motivatedWord = new String[]{"A healthy outside starts from the inside",
    "Love yourself enough to live a healthy lifestyle",
    "The reason I exercise is for the quality of life I enjoy",
    "Health is the greatest gift",
    "The groundwork for all happiness is good health",
    "Physical fitness is the first requisite of happiness.",
    "You can’t control what goes on outside, but you can control what goes on inside",
    "It is health that is the real wealth, and not pieces of gold and silver",
    "A good laugh and a long sleep are the best cures in the doctor’s book",
    "I have chosen to be happy because it is good for my health"};

    public native int jniword();

    static {
        System.loadLibrary("jni_words");
    }

    TextView tv_workout;
    CardView hiit_card;
    Button btn_sendMsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        hiit_card = findViewById(R.id.hiit_card);
        btn_sendMsg = findViewById(R.id.notif_btn);
        tv_workout = findViewById(R.id.tv_workout);

        tv_workout.setText(motivatedWord[jniword()]);


        Log.i("NUMBER FROM JNI: ", Integer.toString(jniword()));
        hiit_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WorkoutDetailsActivity.class);
                startActivity(intent);
            }
        });

        btn_sendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, getString(R.string.notify), Toast.LENGTH_SHORT).show();
                scheduleNotification(getNotification( "It's time to start your daily workout" ) , 600000 ) ;
            }
        });

    }


    /**
     * NOTIFICATION
     * @param notification
     * @param delay
     */
    private void scheduleNotification (Notification notification , int delay) {
        Intent notificationIntent = new Intent( this, Receiver. class ) ;
        notificationIntent.putExtra(Receiver. NOTIFICATION_ID , 1 ) ;
        notificationIntent.putExtra(Receiver. NOTIFICATION , notification) ;
        PendingIntent pendingIntent = PendingIntent. getBroadcast ( this, 0 , notificationIntent , PendingIntent. FLAG_UPDATE_CURRENT ) ;
        long futureInMillis = SystemClock. elapsedRealtime () + delay ;
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context. ALARM_SERVICE ) ;
        assert alarmManager != null;
        alarmManager.set(AlarmManager. ELAPSED_REALTIME_WAKEUP , futureInMillis , pendingIntent) ;
    }
    private Notification getNotification (String content) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder( this, default_notification_channel_id ) ;
        builder.setContentTitle( "Start Workout" ) ;
        builder.setContentText(content) ;
        builder.setSmallIcon(R.drawable.snack ) ;
        builder.setAutoCancel( true ) ;
        builder.setChannelId( NOTIFICATION_CHANNEL_ID ) ;
        return builder.build() ;
    }


    public void onSaveClick(View view) {
        Intent intent = new Intent(this, ListIItemActivity.class);
        startActivity(intent);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingProfileActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
