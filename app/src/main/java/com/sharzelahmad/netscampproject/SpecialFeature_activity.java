package com.sharzelahmad.netscampproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SpecialFeature_activity extends AppCompatActivity {
    CardView browserCardbtn, ttsCardbtn, vibrateCardbtn, calculatorCardbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_feature);
        browserCardbtn = findViewById(R.id.browserCardbtn);
        ttsCardbtn = findViewById(R.id.ttsCardbtn);
        vibrateCardbtn = findViewById(R.id.vibrateCardbtn);
        calculatorCardbtn = findViewById(R.id.calculatorCardbtn);

        getSupportActionBar().hide();

        browserCardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                browserCardbtn.setBackgroundResource(R.drawable.btn_bg_function);
                ttsCardbtn.setBackgroundResource(R.drawable.btn_bg_function1);
                vibrateCardbtn.setBackgroundResource(R.drawable.btn_bg_function1);

                Intent intent = new Intent(SpecialFeature_activity.this, web_activity.class);
                startActivity(intent);
            }
        });
        ttsCardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ttsCardbtn.setBackgroundResource(R.drawable.btn_bg_function);
                browserCardbtn.setBackgroundResource(R.drawable.btn_bg_function1);
                vibrateCardbtn.setBackgroundResource(R.drawable.btn_bg_function1);

                Intent intent = new Intent(SpecialFeature_activity.this, tts_activity.class);
                startActivity(intent);
            }
        });
        vibrateCardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrateCardbtn.setBackgroundResource(R.drawable.btn_bg_function);
                ttsCardbtn.setBackgroundResource(R.drawable.btn_bg_function1);
                browserCardbtn.setBackgroundResource(R.drawable.btn_bg_function1);

                Intent intent = new Intent(SpecialFeature_activity.this, vibration_activity.class);
                startActivity(intent);
            }
        });
    }
}