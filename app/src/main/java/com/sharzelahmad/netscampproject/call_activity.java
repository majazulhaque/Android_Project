package com.sharzelahmad.netscampproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class call_activity extends AppCompatActivity {

    EditText txt_Number;
    Button btn_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        txt_Number = findViewById(R.id.txt_number);
        btn_call = findViewById(R.id.btn_call);

        getSupportActionBar().hide();

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCall = new  Intent(Intent.ACTION_CALL);
                String number = txt_Number.getText().toString();

                if (number.trim().isEmpty())
                {
                    Toast.makeText(call_activity.this, "Please Enter Your Number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    intentCall.setData(Uri.parse("tel:"+number));
                }
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(call_activity.this, "Please Grant Permission", Toast.LENGTH_SHORT).show();
                    requestPermission();
                }
                else
                {
                    startActivity(intentCall);
                }

            }
        });
    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(call_activity.this,new String[]{Manifest.permission.CALL_PHONE},1);
    }
}