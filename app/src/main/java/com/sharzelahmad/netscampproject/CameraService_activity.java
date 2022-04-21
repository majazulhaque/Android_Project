package com.sharzelahmad.netscampproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CameraService_activity extends AppCompatActivity {

    CardView cameraImgbtn, cameraVidbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_service);
        cameraImgbtn = findViewById(R.id.cameraImgbtn);
        cameraVidbtn = findViewById(R.id.cameraVidbtn);

        getSupportActionBar().hide();

        cameraImgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraImgbtn.setBackgroundResource(R.drawable.btn_bg_function);
                cameraVidbtn.setBackgroundResource(R.drawable.btn_bg_function1);


                Intent intent = new Intent(CameraService_activity.this, camera_activity.class);
                startActivity(intent);
            }
        });
        cameraVidbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraVidbtn.setBackgroundResource(R.drawable.btn_bg_function);
                cameraImgbtn.setBackgroundResource(R.drawable.btn_bg_function1);

                Intent intent = new Intent(CameraService_activity.this, RecordVideo_activity.class);
                startActivity(intent);
            }
        });
    }
}