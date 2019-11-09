package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.R;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View.DailyDietListActivity;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View.ListIItemActivity;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.YoutubeConfig;

public class MainYoutbe extends YouTubeBaseActivity {


    YouTubePlayerView mYoutubePlayerView;
    Button btnPlay;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube_activity);

        mYoutubePlayerView = findViewById(R.id.youtube_view);
        btnPlay = findViewById(R.id.ytButton);

        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d("MainYoutb : ", "on Click: Done init");
                youTubePlayer.loadVideo("W4hTJybfU7s");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d("MainYoutb : ", "on Click: Failed init");

            }
        };
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainYoutb : ", "on Click: Init Youtube player");
                mYoutubePlayerView.initialize(YoutubeConfig.getApiKey(), mOnInitializedListener);
            }
        });

    }

    /**
     * Called when the "Save" button is clicked.
     */
    public void onSaveClick(View view) {
        Intent intent = new Intent(this, ListIItemActivity.class);
        startActivity(intent);

    }


}
