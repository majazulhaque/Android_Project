package com.sharzelahmad.netscampproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class getotp_activity extends AppCompatActivity {
    TextView mchangenumber;
    EditText mgetotp;
    Button mverifyotp;
    String enteredotp;

    FirebaseAuth firebaseAuth;
    ProgressBar mprogressbarofotpauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getotp);
        mchangenumber = findViewById(R.id.changenumber);
        mverifyotp = findViewById(R.id.verifyotpbtn);
        mgetotp = findViewById(R.id.etenterotp);
        mprogressbarofotpauth=findViewById(R.id.progressbarofotpauths);

        getSupportActionBar().hide();

        firebaseAuth=FirebaseAuth.getInstance();

        mchangenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getotp_activity.this,otplogin_activity.class);

                startActivity(intent);
            }
        });

        mverifyotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredotp=mgetotp.getText().toString();
                if (enteredotp.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Enter your OTP First", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    mprogressbarofotpauth.setVisibility(View.VISIBLE);
                    String coderecieved = getIntent().getStringExtra("otp");
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(coderecieved,enteredotp);
                    signInWithPhoneAuthCredential(credential);
                }
            }
        });


    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential)
    {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    mprogressbarofotpauth.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Login successful with Phone", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getotp_activity.this,functionDesign1_activity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    if (task.getException() instanceof FirebaseAuthInvalidCredentialsException)
                    {
                        mprogressbarofotpauth.setVisibility(View.INVISIBLE);
                        Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}