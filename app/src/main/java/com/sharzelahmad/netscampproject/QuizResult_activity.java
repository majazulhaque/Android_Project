package com.sharzelahmad.netscampproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuizResult_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        final AppCompatButton startNewBtn = findViewById(R.id.startNewQuizbtn);
        final TextView correctAnswer = findViewById(R.id.correctAnswers);
        final TextView incorrectAnswer = findViewById(R.id.incorrectAnswers);

        final int getCorrectAnswer = getIntent().getIntExtra("correct",0);
        final int getIncorrectAnswer = getIntent().getIntExtra("incorrect",0);

        correctAnswer.setText(String.valueOf(getCorrectAnswer));
        incorrectAnswer.setText(String.valueOf(getIncorrectAnswer));

        getSupportActionBar().hide();

        startNewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizResult_activity.this,quiz_activity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(QuizResult_activity.this,quiz_activity.class));
        finish();
    }
}