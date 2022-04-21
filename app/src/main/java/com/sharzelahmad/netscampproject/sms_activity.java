package com.sharzelahmad.netscampproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class sms_activity extends AppCompatActivity {

    EditText txt_pNumber, txt_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        txt_message = findViewById(R.id.txt_message);
        txt_pNumber = findViewById(R.id.txt_phone_number);

        getSupportActionBar().hide();
    }

    public void btn_send(View view) {

        int permissionCheck = ContextCompat.checkSelfPermission(sms_activity.this, Manifest.permission.SEND_SMS);

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

            MyMessage();
        }
        else
        {
            ActivityCompat.requestPermissions(sms_activity.this,new String[]{Manifest.permission.SEND_SMS}, 0);

        }

    }

    private void MyMessage() {

        String phoneNumber = txt_pNumber.getText().toString().trim();
        String Message = txt_message.getText().toString().trim();

        if (!txt_pNumber.getText().toString().equals("") || !txt_message.getText().toString().equals(""))
        {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber,null,Message,null,null);

            Toast.makeText(sms_activity.this, "Message Send", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(sms_activity.this, "Please Enter Number or Message", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {

            case 0:
                if (grantResults.length>= 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    MyMessage();
                }
                else {
                    Toast.makeText(sms_activity.this, "You don't have Required Permission", Toast.LENGTH_SHORT).show();
                }

                break;
        }


    }
}