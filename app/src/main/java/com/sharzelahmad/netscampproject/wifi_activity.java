package com.sharzelahmad.netscampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class wifi_activity extends AppCompatActivity {
    ImageButton iw;
    private boolean wifi = false;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        iw = findViewById(R.id.iw);

        getSupportActionBar().hide();

        wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        iw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    Intent panelIntent = new
                            Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);
                    startActivityForResult(panelIntent, 0);
                    if(wifi == false){
                        wifiManager.setWifiEnabled(true);
                        wifi = true;
                        Toast.makeText(wifi_activity.this, "Please Click off BUTTON to Turn Off Wifi", Toast.LENGTH_SHORT).show();
                        iw.setImageResource(R.drawable.offtogglebtnn);

                    }
                    else {
                        wifiManager.setWifiEnabled(false);
                        wifi = false;
                        Toast.makeText(wifi_activity.this, "Please Click on BUTTON to Turn On Wifi", Toast.LENGTH_SHORT).show();
                        iw.setImageResource(R.drawable.togglebtnon);
                    }
                } else {
                    // for previous android version
                    if(wifi == false){
                        wifiManager.setWifiEnabled(true);
                        wifi = true;
                        Toast.makeText(wifi_activity.this, "Please Click off BUTTON to Turn Off Wifi", Toast.LENGTH_SHORT).show();
                        iw.setImageResource(R.drawable.offtogglebtnn);

                    }
                    else {
                        wifiManager.setWifiEnabled(false);
                        wifi = false;
                        Toast.makeText(wifi_activity.this, "Please Click on BUTTON to Turn On Wifi", Toast.LENGTH_SHORT).show();
                        iw.setImageResource(R.drawable.togglebtnon);
                    }

                }

            }
        });
    }
}