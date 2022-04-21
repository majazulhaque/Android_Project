package com.sharzelahmad.netscampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.VideoView;

import com.gauravk.audiovisualizer.visualizer.BarVisualizer;

import java.util.Locale;

public class tts_activity extends AppCompatActivity {
    EditText ttsinput;
    Button ttsbtn;
    TextToSpeech ts;
    VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tts);
        ttsinput = (EditText) findViewById(R.id.ttsinput);

        getSupportActionBar().hide();

        ttsbtn = (Button) findViewById(R.id.ttsbtn);
        videoView = (VideoView) findViewById(R.id.vv);
        String videoPath = "android.resource://"  + getPackageName() + "/" + R.raw.videounscreenn;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.setZOrderOnTop(true);
//        MediaController mediaController = new MediaController(this );
//        videoView.setMediaController(mediaController);
//        mediaController.setAnchorView(videoView);
        ts = new TextToSpeech(this, new  TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                ts.setLanguage(Locale.ENGLISH);
                ts.setSpeechRate(0.5f);

            }
        });
        ttsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = ttsinput.getText().toString();
                videoView.start();
                ts.speak(s1,TextToSpeech.QUEUE_FLUSH,null);

            }

        });
    }
}