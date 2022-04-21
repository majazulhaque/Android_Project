package com.sharzelahmad.netscampproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MobileServices_activity extends AppCompatActivity {

    CardView callCardbtn, smsCardbtn, emailCardbtn, wifiCardbtn, bluetoothCardbtn, flashlightCardbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_services);
        callCardbtn = findViewById(R.id.callCardbtn);
        smsCardbtn = findViewById(R.id.smsCardbtn);
        emailCardbtn = findViewById(R.id.emailCardbtn);
        wifiCardbtn = findViewById(R.id.wifiCardbtn);
        bluetoothCardbtn = findViewById(R.id.bluetoothCardbtn);
        flashlightCardbtn = findViewById(R.id.flashlightCardbtn);

        getSupportActionBar().hide();

        callCardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callCardbtn.setBackgroundResource(R.drawable.btn_bg_functions);

                smsCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                emailCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                wifiCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                bluetoothCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                flashlightCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);

                Intent intent = new Intent(MobileServices_activity.this, call_activity.class);
                startActivity(intent);
            }
        });
        smsCardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smsCardbtn.setBackgroundResource(R.drawable.btn_bg_functions);

                callCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                emailCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                wifiCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                bluetoothCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                flashlightCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);

                Intent intent = new Intent(MobileServices_activity.this, sms_activity.class);
                startActivity(intent);
            }
        });
        emailCardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emailCardbtn.setBackgroundResource(R.drawable.btn_bg_functions);

                smsCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                callCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                wifiCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                bluetoothCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                flashlightCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);

                Intent intent = new Intent(MobileServices_activity.this, email_activity.class);
                startActivity(intent);
            }
        });
        wifiCardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wifiCardbtn.setBackgroundResource(R.drawable.btn_bg_functions);

                smsCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                emailCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                callCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                bluetoothCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                flashlightCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);

                Intent intent = new Intent(MobileServices_activity.this, wifi_activity.class);
                startActivity(intent);
            }
        });
        bluetoothCardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluetoothCardbtn.setBackgroundResource(R.drawable.btn_bg_functions);

                smsCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                emailCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                wifiCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                callCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                flashlightCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);

                Intent intent = new Intent(MobileServices_activity.this, bluetooth_activity.class);
                startActivity(intent);
            }
        });
        flashlightCardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashlightCardbtn.setBackgroundResource(R.drawable.btn_bg_functions);

                smsCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                emailCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                wifiCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                bluetoothCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                callCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);

                Intent intent = new Intent(MobileServices_activity.this, flash_activity.class);
                startActivity(intent);
            }
        });
    }
}