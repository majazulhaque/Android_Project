package com.sharzelahmad.netscampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class vibration_activity extends AppCompatActivity {
    ImageButton vibbtn;
    private boolean vibration = false;
//    Vibrator v1;
       Vibrator v1;
    ImageView vibfwd, vibbkw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibration);
        vibbtn = findViewById(R.id.vibbtn);
        vibfwd = findViewById(R.id.imagefwd);
        vibbkw = findViewById(R.id.imagebkw);

        getSupportActionBar().hide();

        v1 = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        long[] pattern = {0, 500, 1000};
        vibbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (vibration == false) {

                    if (Build.VERSION.SDK_INT>26){
                        v1.vibrate(pattern,0);
                    }
                    else {
                        v1.vibrate(pattern,0);
                    }
                    vibbkw.setVisibility(View.VISIBLE);
                    vibfwd.setVisibility(View.VISIBLE);

                    vibration = true;
                    Toast.makeText(vibration_activity.this, "Please Click off BUTTON to Turn Off Vibration", Toast.LENGTH_SHORT).show();
                    vibbtn.setImageResource(R.drawable.offtogglebtnn);
                } else {

                    if (Build.VERSION.SDK_INT>26){
                        v1.cancel();
                    }
                    else {
                        v1.cancel();
                    }
                    vibfwd.setVisibility(View.INVISIBLE);
                    vibbkw.setVisibility(View.INVISIBLE);

                    vibration = false;
                    Toast.makeText(vibration_activity.this, "Please Click on BUTTON to Turn On Vibration", Toast.LENGTH_SHORT).show();
                    vibbtn.setImageResource(R.drawable.togglebtnon);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        v1.cancel();
        super.onBackPressed();
    }
}