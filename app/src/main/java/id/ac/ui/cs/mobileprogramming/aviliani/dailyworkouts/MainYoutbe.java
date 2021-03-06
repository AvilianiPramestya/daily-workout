package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View.ListIItemActivity;

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
                youTubePlayer.loadVideo("ml6cT4AZdqI");
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
