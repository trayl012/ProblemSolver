package com.example.assignment6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FarmerIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_intro);
    }

    public void createProblem(View view) {
        Intent intent = new Intent( this, FarmerScreen.class);
        startActivity(intent);
    }
}
