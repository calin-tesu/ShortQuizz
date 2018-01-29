package com.example.android.shortquizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //** This method start the Quizz activity and pass the player name to other activitis
    public void startGame(View view) {
        EditText name = findViewById(R.id.playerName);
        String playerName = name.getText().toString();
        Intent Quizz = new Intent(this, Quizz.class);
        Quizz.putExtra("player_name", playerName);
        startActivity(Quizz);
    }
}
