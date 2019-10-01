package com.example.assignment6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PuzzleIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_intro);
    }

    public void createProblem(View view) {
        Intent intent = new Intent( this, PuzzleScreen.class);
        startActivity(intent);
    }
}
