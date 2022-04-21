package com.sharzelahmad.netscampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class quiz_activity extends AppCompatActivity {
    private String selectedTopicName = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        final LinearLayout java = findViewById(R.id.javalayout);
        final LinearLayout php = findViewById(R.id.phplayout);
        final LinearLayout html = findViewById(R.id.htmllayout);
        final LinearLayout android = findViewById(R.id.androidlayout);

        getSupportActionBar().hide();

        final Button startButton = findViewById(R.id.startquizbtn);

        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedTopicName = "java";

                java.setBackgroundResource(R.drawable.round_back_white_stroke10);

                php.setBackgroundResource(R.drawable.round_back_white10);
                html.setBackgroundResource(R.drawable.round_back_white10);
                android.setBackgroundResource(R.drawable.round_back_white10);

            }
        });
        php.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedTopicName = "php";

                php.setBackgroundResource(R.drawable.round_back_white_stroke10);

                java.setBackgroundResource(R.drawable.round_back_white10);
                html.setBackgroundResource(R.drawable.round_back_white10);
                android.setBackgroundResource(R.drawable.round_back_white10);

            }
        });
        html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedTopicName = "html";

                html.setBackgroundResource(R.drawable.round_back_white_stroke10);

                php.setBackgroundResource(R.drawable.round_back_white10);
                java.setBackgroundResource(R.drawable.round_back_white10);
                android.setBackgroundResource(R.drawable.round_back_white10);

            }
        });
        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedTopicName = "android";

                android.setBackgroundResource(R.drawable.round_back_white_stroke10);

                php.setBackgroundResource(R.drawable.round_back_white10);
                html.setBackgroundResource(R.drawable.round_back_white10);
                java.setBackgroundResource(R.drawable.round_back_white10);

            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(quiz_activity.this,quizPlay_activity.class);
                intent.putExtra("selectedTopic",selectedTopicName);
                startActivity(intent);
            }
        });


    }
}