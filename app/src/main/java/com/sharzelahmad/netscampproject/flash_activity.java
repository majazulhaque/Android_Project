package com.sharzelahmad.netscampproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class flash_activity extends AppCompatActivity {
    ImageButton iflash;
    CameraManager cm;
    private boolean flash = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);

        getSupportActionBar().hide();


        iflash = (ImageButton) findViewById(R.id.iflash);
        cm = (CameraManager) getSystemService(CAMERA_SERVICE);
        iflash.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (flash == false){
                    flashon();
                }
                else {
                    flashoff();
                }
            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void flashon(){
        try {
            String s1 = cm.getCameraIdList()[0];
            cm.setTorchMode(s1,true);
            flash = true;
            Toast.makeText(flash_activity.this, "Please Click off BUTTON to Turn Off Flash Light", Toast.LENGTH_SHORT).show();
            iflash.setImageResource(R.drawable.offtogglebtnn);
        }
        catch (CameraAccessException e){

        }
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void flashoff(){
        try {
            String s1 = cm.getCameraIdList()[0];
            cm.setTorchMode(s1,false);
            flash = false;
            Toast.makeText(flash_activity.this, "Please Click on BUTTON to Turn On Flash Light", Toast.LENGTH_SHORT).show();
            iflash.setImageResource(R.drawable.togglebtnon);
        }
        catch (CameraAccessException e){

        }
    }

    @Override
    public void onBackPressed() {
        flashoff();
        super.onBackPressed();
    }
}