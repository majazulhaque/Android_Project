package com.sharzelahmad.netscampproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class RecordVideo_activity extends AppCompatActivity {
    VideoView captureVideo;
    Button recordbtn;
    MediaController mediaController;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_video);
        captureVideo = findViewById(R.id.captureVideo);

        getSupportActionBar().hide();

        recordbtn = findViewById(R.id.recordVideo);
        captureVideo.setZOrderOnTop(true);
        mediaController = new MediaController(this);
        recordbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(intent,0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uri = data.getData();
        captureVideo.setVideoURI(uri);
        captureVideo.setMediaController(mediaController);
        mediaController.setAnchorView(captureVideo);
        captureVideo.start();
    }
}