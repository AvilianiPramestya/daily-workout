package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts;

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
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View.ListIItemActivity;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View.SettingProfileActivity;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View.WorkoutDetailsActivity;


public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_daily_routines);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//    }

    public static final String NOTIFICATION_CHANNEL_ID = "10001" ;
    private final static String default_notification_channel_id = "default" ;

    CardView hiit_card;
    Button btn_sendMsg, btn_image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        hiit_card = findViewById(R.id.hiit_card);
        btn_sendMsg = findViewById(R.id.notif_btn);

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
//                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//                NotificationCompat.Builder notification;
//                notification = new NotificationCompat.Builder(MainActivity.this);
//                notification.setSmallIcon(R.drawable.snack);
//                notification.setContentTitle("Start Workout");
//                notification.setContentText("It's time to start your daily workout");
//
//                CharSequence title = "Title";
//                CharSequence message = "Message";
//
//                Intent intent = new Intent(MainActivity.this, MainActivity.class);
//
//                notification.setAutoCancel(true);
//                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
//
//                notification.setContentIntent(pendingIntent);
//                notificationManager.notify(1, notification.build());
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

//    public void onNextClick(View view) {
//        Intent intent = new Intent(this, SettingProfileActivity.class);
//        startActivity(intent);
//
//    }

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
