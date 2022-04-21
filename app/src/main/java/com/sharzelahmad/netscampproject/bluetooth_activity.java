package com.sharzelahmad.netscampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class bluetooth_activity extends AppCompatActivity {
    ImageButton ib;
    BluetoothAdapter ba;
    private  boolean bluetooth = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        ib = (ImageButton) findViewById(R.id.ib);

        getSupportActionBar().hide();

        ba = BluetoothAdapter.getDefaultAdapter();
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bluetooth == false) {
                    ba.enable();
                    bluetooth = true;
                    Toast.makeText(bluetooth_activity.this, "Please Click off BUTTON to Turn Off Bluetooth", Toast.LENGTH_SHORT).show();
                    ib.setImageResource(R.drawable.offtogglebtnn);
                } else {
                    ba.disable();
                    bluetooth = false;
                    Toast.makeText(bluetooth_activity.this, "Please Click on BUTTON to Turn On Bluetooth", Toast.LENGTH_SHORT).show();
                    ib.setImageResource(R.drawable.togglebtnon);
                }
            }
        });
    }
}