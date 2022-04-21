package com.sharzelahmad.netscampproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.sharzelahmad.netscampproject.databinding.ActivityFunctionDesign1Binding;

public class functionDesign1_activity extends AppCompatActivity {

    CardView quizcardbtn, cameraCardbtn, mobileCardbtn, mediaCardbtn, speciaCardbtn, calculatorCardbtn;
    ActivityFunctionDesign1Binding binding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFunctionDesign1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        quizcardbtn = findViewById(R.id.quizzcardbtn);
        cameraCardbtn = findViewById(R.id.cameraCardbtn);
        mobileCardbtn = findViewById(R.id.mobileCardbtn);
        mediaCardbtn = findViewById(R.id.mediaCardbtn);
        speciaCardbtn = findViewById(R.id.specialCardbtn);
        calculatorCardbtn = findViewById(R.id.calculatorCardbtn);

        getSupportActionBar().show();


        quizcardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizcardbtn.setBackgroundResource(R.drawable.btn_bg_functions);

                cameraCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                mobileCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                mediaCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                speciaCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                calculatorCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);

                Intent intent = new Intent(functionDesign1_activity.this, quiz_activity.class);
                startActivity(intent);
            }
        });
        cameraCardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraCardbtn.setBackgroundResource(R.drawable.btn_bg_functions);

                quizcardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                mobileCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                mediaCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                speciaCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                calculatorCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);

                Intent intent = new Intent(functionDesign1_activity.this, CameraService_activity.class);
                startActivity(intent);
            }
        });
        mobileCardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobileCardbtn.setBackgroundResource(R.drawable.btn_bg_functions);

                cameraCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                quizcardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                mediaCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                speciaCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                calculatorCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);

                Intent intent = new Intent(functionDesign1_activity.this, MobileServices_activity.class);
                startActivity(intent);
            }
        });
        mediaCardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaCardbtn.setBackgroundResource(R.drawable.btn_bg_functions);

                cameraCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                mobileCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                quizcardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                speciaCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                calculatorCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);

                Intent intent = new Intent(functionDesign1_activity.this, MediaPlayer_activity.class);
                startActivity(intent);
            }
        });
        speciaCardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speciaCardbtn.setBackgroundResource(R.drawable.btn_bg_functions);

                cameraCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                mobileCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                mediaCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                quizcardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                calculatorCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);

                Intent intent = new Intent(functionDesign1_activity.this, SpecialFeature_activity.class);
                startActivity(intent);
            }
        });
        calculatorCardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorCardbtn.setBackgroundResource(R.drawable.btn_bg_functions);

                cameraCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                mobileCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                mediaCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                speciaCardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);
                quizcardbtn.setBackgroundResource(R.drawable.btn_bg_functions1);

                Intent intent = new Intent(functionDesign1_activity.this, calculator_activity.class);
                startActivity(intent);
            }
        });

        auth = FirebaseAuth.getInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                Toast.makeText(this, "Setting is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                auth.signOut();
                Intent intent = new Intent(functionDesign1_activity.this,signIn_activity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}