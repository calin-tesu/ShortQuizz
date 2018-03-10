package com.example.android.shortquizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class Results extends AppCompatActivity {

    int correctAnswers;
    String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //Star rating of score and display a Toast with the number of correct answers
        Intent Results = getIntent();
        correctAnswers = Results.getIntExtra("correct_answers", 0);
        playerName = Results.getStringExtra("player_name");
        RatingBar stars = findViewById(R.id.stars);
        stars.setRating(correctAnswers);
        Toast.makeText(this, playerName + getString(R.string.scoreMessage) + String.valueOf(correctAnswers), Toast.LENGTH_SHORT).show();
    }

    //Share the results with other apps
    public void shareResults(View view) {
        String scoreMessage = playerName + getString(R.string.scoreMessage) + String.valueOf(correctAnswers);
        Intent shareScore = new Intent(Intent.ACTION_SEND);
        shareScore.setType("text/plain");
        shareScore.putExtra(Intent.EXTRA_TEXT, scoreMessage);
        // Create intent to show the chooser dialog for sharing to other apps
        Intent chooser = Intent.createChooser(shareScore, scoreMessage);
        startActivity(chooser);
    }
    }
