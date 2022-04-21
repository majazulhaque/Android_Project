package com.sharzelahmad.netscampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class email_activity extends AppCompatActivity {
    EditText etTo,etSubject,etMessaage;
    Button btSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        etTo = findViewById(R.id.et_to);
        etSubject = findViewById(R.id.et_subject);
        etMessaage = findViewById(R.id.messagespace);
        btSend = findViewById(R.id.sendEmailBtn);

        getSupportActionBar().hide();

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    private void sendMail() {

        String recipientList = etTo.getText().toString();
        String[] recipients = recipientList.split(",");

        String subject = etSubject.getText().toString();
        String message = etMessaage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"choose an email client"));
    }
}