package com.example.android.shortquizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class Quizz extends AppCompatActivity {

    int score;
    private RadioButton q1D, q2B, q5A;
    private CheckBox q3A, q3B, q3C, q3D;
    private EditText q4A;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        q1D = findViewById(R.id.q1D);
        q2B = findViewById(R.id.q2B);
        q3A = findViewById(R.id.q3A);
        q3B = findViewById(R.id.q3B);
        q3C = findViewById(R.id.q3C);
        q3D = findViewById(R.id.q3D);
        q4A = findViewById(R.id.q4A);
        q5A = findViewById(R.id.q5A);
    }

    /**
     * This method is used when Submit button is clicked
     */
    public void calculateScore(View view) {

        score = 0;

        //** Calculate quizz 1
        if (q1D.isChecked()) {
            score += 1;
        }

        //** Calculate quizz 2
        if (q2B.isChecked()) {
            score += 1;
        }

        //**Calculate quizz 3
        if (q3A.isChecked() && q3C.isChecked() && !q3B.isChecked() && !q3D.isChecked()) {
            score += 1;
        }

        //** Calculate quizz 4
        String answer = q4A.getText().toString();
        String corectAnswer = getString(R.string.q4Answer);
        if (answer.equals(corectAnswer)) {
            score += 1;
        }

        //** Calculate quizz 5
        if (q5A.isChecked()) {
            score += 1;
        }

        //** Start ResultsActivity
        Intent Quizz = getIntent();
        String playerName = Quizz.getStringExtra("player_name");
        Intent Results = new Intent(this, com.example.android.shortquizz.Results.class);
        Results.putExtra("correct_answers", score);
        Results.putExtra("player_name", playerName);
        startActivity(Results);
    }
}
