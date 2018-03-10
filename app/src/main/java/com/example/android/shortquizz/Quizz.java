package com.example.android.shortquizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class Quizz extends AppCompatActivity {

    //Store the number of correct answers
    int correctAnswers;
    //Store the number of wrong answers
    int wrongAnswers;

    //Store the RadioButton's, CheckBoxes and EditText with the correct answers
    private RadioButton q1D, q2B, q5A;
    private CheckBox q3A, q3B, q3C, q3D;
    private EditText q4A;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        q1D = findViewById(R.id.checkQuestion1Answer3Hamlet);
        q2B = findViewById(R.id.radioQuestion2Answer2Botticelli);
        q3A = findViewById(R.id.checkQuestion3Answer1Romania);
        q3B = findViewById(R.id.checkQuestion3Answer2India);
        q3C = findViewById(R.id.checkQuestion3Answer3Spain);
        q3D = findViewById(R.id.checkQuestion3Answer4China);
        q4A = findViewById(R.id.editQuestion4Answer1Android);
        q5A = findViewById(R.id.radioQuestion5Answer1Bucharest);
    }

    /**
     * This method is used when Submit button is clicked
     */
    public void calculateScore(View view) {

        //Reinitialise correctAnswers for the case in which the back button is pressed in the ResultsActivity to pick different answers
        correctAnswers = 0;
        wrongAnswers = 0;

        //** Calculate quizz 1
        if (q1D.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers++;
        }

        //** Calculate quizz 2
        if (q2B.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers++;
        }

        //**Calculate quizz 3
        if (q3A.isChecked() && q3C.isChecked() && !q3B.isChecked() && !q3D.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers++;
        }

        //** Calculate quizz 4
        String answer = q4A.getText().toString();
        String corectAnswer = getString(R.string.question4_answer);
        if (answer.equals(corectAnswer)) {
            correctAnswers++;
        } else {
            wrongAnswers++;
        }

        //** Calculate quizz 5
        if (q5A.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers++;
        }

        //** Start ResultsActivity
        Intent Quizz = getIntent();
        String playerName = Quizz.getStringExtra("player_name");
        Intent Results = new Intent(this, com.example.android.shortquizz.Results.class);
        Results.putExtra("correct_answers", correctAnswers);
        Results.putExtra("player_name", playerName);
        Results.putExtra("wrong_answers", wrongAnswers);
        startActivity(Results);
    }
}
