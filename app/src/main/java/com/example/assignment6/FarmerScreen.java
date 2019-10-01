package com.example.assignment6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import domains.farmer.FarmerProblem;
import framework.solution.AStarSolver;
import framework.solution.SolvingAssistant;

public class FarmerScreen extends AppCompatActivity {


    private TextView currentState;
    private FarmerProblem farmer;
    private SolvingAssistant helper;
    private TextView feedback;
    private TextView statsView;
    private AStarSolver starSolver;
    private Button nextButton;
    private Button f;
    private Button w;
    private Button g;
    private Button c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_screen);
        farmer = new FarmerProblem();
        helper = new SolvingAssistant(farmer);
        currentState = findViewById(R.id.StateView);
        currentState.setText(farmer.getCurrentState().toString());
        feedback = findViewById(R.id.feedbackView);
        statsView = findViewById(R.id.Statistics);
        nextButton = findViewById(R.id.solveButton);
        f = findViewById(R.id.himselfButton);
        w = findViewById(R.id.wolfButton);
        g = findViewById(R.id.goatButton);
        c = findViewById(R.id.cabbageButton);
    }

    public void alone(View view) {
        feedback.setText("");
        helper.tryMove("Farmer goes alone");

        if(!helper.isMoveLegal()) {
            feedback.setText("Illegal move! Try again.");
        }

        currentState.setText(farmer.getCurrentState().toString());

        if(helper.isProblemSolved()) {
            feedback.setText("Congratulations, you solved the puzzle!");

        }
    }

    public void wolf(View view) {
        feedback.setText("");
        helper.tryMove("Farmer takes wolf");

        if(!helper.isMoveLegal()) {
            feedback.setText("Illegal move! Try again.");
        }

        currentState.setText(farmer.getCurrentState().toString());

        if(helper.isProblemSolved()) {
            feedback.setText("Congratulations, you solved the puzzle!");
        }

    }

    public void goat(View view) {

        feedback.setText("");
        helper.tryMove("Farmer takes goat");

        if(!helper.isMoveLegal()) {
            feedback.setText("Illegal move! Try again.");
        }

        currentState.setText(farmer.getCurrentState().toString());

        if(helper.isProblemSolved()) {
            feedback.setText("Congratulations, you solved the puzzle!");
        }


    }

    public void cabbage(View view) {
        feedback.setText("");
        helper.tryMove("Farmer takes cabbage");

        if(!helper.isMoveLegal()) {
            feedback.setText("Illegal move! Try again.");
        }

        currentState.setText(farmer.getCurrentState().toString());

        if(helper.isProblemSolved()) {
            feedback.setText("Congratulations, you solved the puzzle!");
        }

    }

    public void solve(View view) {
        starSolver = new AStarSolver(farmer);
        starSolver.solve();
        starSolver.getSolution().next();
        statsView.setText(starSolver.getStatistics().toString());
        f.setEnabled(false);
        w.setEnabled(false);
        g.setEnabled(false);
        c.setEnabled(false);

    }

    public void next(View view) {
        currentState.setText(starSolver.getSolution().next().toString());
        if(currentState.getText().equals(farmer.getFinalState().toString())) {
            nextButton.setEnabled(false);
            feedback.setText("End of A* Search.");
        }

    }

    public void reset(View view) {
        helper.reset();
        currentState.setText(farmer.getCurrentState().toString());
        feedback.setText("");
        statsView.setText("");
        nextButton.setEnabled(true);
        f.setEnabled(true);
        w.setEnabled(true);
        g.setEnabled(true);
        c.setEnabled(true);

    }





}