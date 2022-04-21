package com.sharzelahmad.netscampproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MediaPlayer_activity extends AppCompatActivity {
    CardView musicplayerCardbtn, videoplayerCarbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        musicplayerCardbtn = findViewById(R.id.musicplayerCardbtn);
        videoplayerCarbtn = findViewById(R.id.videoplayerCardbtn);

        getSupportActionBar().hide();

        musicplayerCardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicplayerCardbtn.setBackgroundResource(R.drawable.btn_bg_function);
                videoplayerCarbtn.setBackgroundResource(R.drawable.btn_bg_function1);

                Intent intent = new Intent(MediaPlayer_activity.this, audio_player_activity.class);
                startActivity(intent);
            }
        });
        videoplayerCarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoplayerCarbtn.setBackgroundResource(R.drawable.btn_bg_function);
                musicplayerCardbtn.setBackgroundResource(R.drawable.btn_bg_function1);

                Intent intent = new Intent(MediaPlayer_activity.this, VideoPlayer_activity.class);
                startActivity(intent);
            }
        });
    }
}