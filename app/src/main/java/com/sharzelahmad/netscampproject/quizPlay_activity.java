package com.sharzelahmad.netscampproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class quizPlay_activity extends AppCompatActivity {

    private  TextView questions;
    private TextView question;
    private AppCompatButton option1, option2, option3, option4;

    private AppCompatButton nextbtnnn;
    private Timer quizTimer;
    private  int totalTimeInMin = 1;
    private int seconds = 0;

    private  List<QuestionList> questionsLists;

    private int currentQuestionPosition = 0;
    private String selectedoptionByUser = "";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_play);


        final ImageView backbtnnn = findViewById(R.id.backbtnnn);
        final TextView timer = findViewById(R.id.timer);
        final TextView selectedTopicName = findViewById(R.id.topicName);

        getSupportActionBar().hide();

        question = findViewById(R.id.question);
        questions = findViewById(R.id.questionNo);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        nextbtnnn = findViewById(R.id.nextbtnnn);

        final String getSelectedTopicName = getIntent().getStringExtra("selectedTopic");

        selectedTopicName.setText(getSelectedTopicName);

        questionsLists = QuestionBank.getQuestions(getSelectedTopicName);

        startTimer(timer);
        questions.setText((currentQuestionPosition+1) + "/"+questionsLists.size());
        question.setText(questionsLists.get(0).getQuestion());
        option1.setText(questionsLists.get(0).getOption1());
        option2.setText(questionsLists.get(0).getOption2());
        option3.setText(questionsLists.get(0).getOption3());
        option4.setText(questionsLists.get(0).getOption4());

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedoptionByUser.isEmpty()){
                    selectedoptionByUser = option1.getText().toString();

                    option1.setBackgroundResource(R.drawable.round_back_red10);
                    option1.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedoptionByUser);
                }

            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedoptionByUser.isEmpty()){
                    selectedoptionByUser = option2.getText().toString();

                    option2.setBackgroundResource(R.drawable.round_back_red10);
                    option2.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedoptionByUser);
                }

            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedoptionByUser.isEmpty()){
                    selectedoptionByUser = option3.getText().toString();

                    option3.setBackgroundResource(R.drawable.round_back_red10);
                    option3.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedoptionByUser);
                }

            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedoptionByUser.isEmpty()){
                    selectedoptionByUser = option4.getText().toString();

                    option4.setBackgroundResource(R.drawable.round_back_red10);
                    option4.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedoptionByUser);
                }

            }
        });
        nextbtnnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedoptionByUser.isEmpty()) {
                    Toast.makeText(quizPlay_activity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
                else {
                    changeNextQuestion();

                }

            }
        });

        backbtnnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quizTimer.purge();
                quizTimer.cancel();

                startActivity(new Intent(quizPlay_activity.this,quiz_activity.class));
                finish();
            }
        });

    }
    @SuppressLint("SetTextI18n")
    private void changeNextQuestion(){
        currentQuestionPosition++;

        if ((currentQuestionPosition+1) == questionsLists.size()){
            nextbtnnn.setText("Submit Quiz");
        }
        if (currentQuestionPosition < questionsLists.size()){
            selectedoptionByUser = "";

            option1.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option1.setTextColor(Color.parseColor("#1F6BBB"));

            option2.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option2.setTextColor(Color.parseColor("#1F6BBB"));

            option3.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option3.setTextColor(Color.parseColor("#1F6BBB"));

            option4.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option4.setTextColor(Color.parseColor("#1F6BBB"));

            questions.setText((currentQuestionPosition+1) + "/"+questionsLists.size());
            question.setText(questionsLists.get(currentQuestionPosition).getQuestion());
            option1.setText(questionsLists.get(currentQuestionPosition).getOption1());
            option2.setText(questionsLists.get(currentQuestionPosition).getOption2());
            option3.setText(questionsLists.get(currentQuestionPosition).getOption3());
            option4.setText(questionsLists.get(currentQuestionPosition).getOption4());
        }
        else {
            Intent intent = new Intent(quizPlay_activity.this,QuizResult_activity.class);
            intent.putExtra("correct",getCorrectAnswers());
            intent.putExtra("incorrect",getInCorrectAnswers());
            startActivity(intent);

            finish();
        }
    }
    private void startTimer(TextView timerTextview){
        quizTimer = new Timer();

        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if (seconds == 0){
                    totalTimeInMin--;
                    seconds = 59;
                }
                else if (seconds == 0 && totalTimeInMin == 0){
                    quizTimer.purge();
                    quizTimer.cancel();

                    Toast.makeText(quizPlay_activity.this, "Time Over", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(quizPlay_activity.this, QuizResult_activity.class);
                    intent.putExtra("correct",getCorrectAnswers());
                    intent.putExtra("Incorrect",getInCorrectAnswers());
                    startActivity(intent);

                    finish();
                }
                else {
                    seconds--;
                }
                runOnUiThread(new Runnable() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void run() {

                        String finalMinutes = String.valueOf(totalTimeInMin);
                        String finalSeconds = String.valueOf(seconds);

                        if (finalMinutes.length() == 1){
                            finalMinutes = "0" + finalMinutes;
                        }
                        if (finalSeconds.length() == 1){
                            finalSeconds = "0"+finalSeconds;
                        }
                        timerTextview.setText(finalMinutes + ":"+finalSeconds);
                    }
                });

            }
        },1000,1000);
    }
    private int getCorrectAnswers() {

        int correctAnswers = 0;
        for (int j=0;j<questionsLists.size();j++){

            final String getUserSelectedAnswer = questionsLists.get(j).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(j).getAnswer();

            if (getUserSelectedAnswer.equals(getAnswer)) {
                correctAnswers++;
            }

        }
        return correctAnswers;
    }

    private int getInCorrectAnswers() {

        int correctAnswers = 0;
        for (int j=0;j<questionsLists.size();j++){

            final String getUserSelectedAnswer = questionsLists.get(j).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(j).getAnswer();

            if (!getUserSelectedAnswer.equals(getAnswer)) {
                correctAnswers++;
            }

        }
        return correctAnswers;
    }

    @Override
    public void onBackPressed() {
        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(quizPlay_activity.this,quiz_activity.class));
        finish();
    }
    private void revealAnswer() {
        final String getAnswer = questionsLists.get(currentQuestionPosition).getAnswer();

        if (option1.getText().toString().equals(getAnswer)) {
            option1.setBackgroundResource(R.drawable.round_back_green10);
            option1.setTextColor(Color.WHITE);
        }
        else if (option2.getText().toString().equals(getAnswer)) {
            option2.setBackgroundResource(R.drawable.round_back_green10);
            option2.setTextColor(Color.WHITE);
        }
        else if (option3.getText().toString().equals(getAnswer)) {
            option3.setBackgroundResource(R.drawable.round_back_green10);
            option3.setTextColor(Color.WHITE);
        }else if (option4.getText().toString().equals(getAnswer)) {
            option4.setBackgroundResource(R.drawable.round_back_green10);
            option4.setTextColor(Color.WHITE);
        }


    }
}