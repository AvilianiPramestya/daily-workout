package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.MainYoutbe;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.R;

public class WorkoutDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_title, tv_desc;
    ImageView tv_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_details_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv_title = findViewById(R.id.activity_name);
        tv_image = findViewById(R.id.activity_image);
        tv_desc = findViewById(R.id.activity_desc);

        tv_title.setText("HIIT");
        tv_desc.setText(getString(R.string.deschiit));
        tv_image.setImageResource(R.drawable.hiitbackground);

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);


    }

    public void onNextClick(View view) {

        Intent intent = new Intent(this, HIITListItemActivity.class);
        startActivity(intent);

    }

    public void onYoutubeClick(View view) {

        if (isConnected()) {
            Intent intent = new Intent(this, MainYoutbe.class);
            startActivity(intent);
        } else {
            openDialog();
        }


    }

    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }

    public void openDialog() {
        NetworkDialog networkDialog = new NetworkDialog();
        networkDialog.show(getSupportFragmentManager(), "example");
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
