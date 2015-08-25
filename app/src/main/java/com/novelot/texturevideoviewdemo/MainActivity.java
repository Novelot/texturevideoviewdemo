package com.novelot.texturevideoviewdemo;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;

import com.sprylab.android.widget.TextureVideoView;

public class MainActivity extends AppCompatActivity {

    private TextureVideoView tvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvv = (TextureVideoView) findViewById(R.id.tvv);
        tvv.setVideoPath(getVideoPath());
        tvv.setMediaController(new MediaController(this));
        tvv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                tvv.start();
                //tvv.animate().rotationBy(360.0f).setDuration(tvv.getDuration()).start();
            }
        });
    }

    private String getVideoPath() {
        return "android.resource://" + getPackageName() + "/" + R.raw.video;
    }
}
