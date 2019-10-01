package com.example.assignment6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;

import domains.puzzle.PuzzleProblem;
import domains.puzzle.PuzzleState;
import framework.problem.State;
import framework.solution.AStarSolver;
import framework.solution.SolvingAssistant;

public class PuzzleScreen extends AppCompatActivity {

    private GridLayout currentState;
    private PuzzleProblem puzzle;
    private SolvingAssistant helper;
    private TextView feedback;
    private TextView statsView;
    private AStarSolver starSolver;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button solveButton;
    private Button nextButton;
    private Button resetButton;
    private ArrayList<Button> bList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_screen);
        currentState = findViewById(R.id.grid);
        puzzle = new PuzzleProblem();
        helper = new SolvingAssistant(puzzle);
        puzzle.setCurrentState(new PuzzleState(new int[][] {new int[]{5, 2, 7},
                                                            new int[]{8, 0, 4},
                                                            new int[]{3, 6, 1}}));
        feedback = findViewById(R.id.feedbackView);
        statsView = findViewById(R.id.Statistics);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b1.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(3), GridLayout.spec(3)));
        b2.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(1), GridLayout.spec(2)));
        b3.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(3), GridLayout.spec(1)));
        b4.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(2), GridLayout.spec(3)));
        b5.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(1), GridLayout.spec(1)));
        b6.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(3), GridLayout.spec(2)));
        b7.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(1), GridLayout.spec(3)));
        b8.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(2), GridLayout.spec(1)));
        solveButton = findViewById(R.id.solveButton);
        nextButton = findViewById(R.id.nextButton);
        nextButton.setEnabled(false);
        resetButton = findViewById(R.id.resetButton);
        bList = new ArrayList<>();
        bList.add(b1);
        bList.add(b2);
        bList.add(b3);
        bList.add(b4);
        bList.add(b5);
        bList.add(b6);
        bList.add(b7);
        bList.add(b8);


    }

    public void solve(View view) {

        starSolver = new AStarSolver(puzzle);
        starSolver.solve();
        starSolver.getSolution().next();
        statsView.setText(starSolver.getStatistics().toString());
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        solveButton.setEnabled(false);
        nextButton.setEnabled(true);

    }

    public void next(View view) {
        if(starSolver.getSolution().hasNext()) {
            puzzle.setCurrentState((PuzzleState) starSolver.getSolution().next().getData());

            PuzzleState cState = (PuzzleState) puzzle.getCurrentState();
            PuzzleState.Location loc = cState.getLocation(1);
            b1.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc.getRow() + 1), GridLayout.spec(loc.getColumn() + 1)));

            cState = (PuzzleState) puzzle.getCurrentState();
            loc = cState.getLocation(2);
            b2.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc.getRow() + 1), GridLayout.spec(loc.getColumn() + 1)));

            cState = (PuzzleState) puzzle.getCurrentState();
            loc = cState.getLocation(3);
            b3.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc.getRow() + 1), GridLayout.spec(loc.getColumn() + 1)));

            cState = (PuzzleState) puzzle.getCurrentState();
            loc = cState.getLocation(4);
            b4.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc.getRow() + 1), GridLayout.spec(loc.getColumn() + 1)));

            cState = (PuzzleState) puzzle.getCurrentState();
            loc = cState.getLocation(5);
            b5.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc.getRow() + 1), GridLayout.spec(loc.getColumn() + 1)));

            cState = (PuzzleState) puzzle.getCurrentState();
            loc = cState.getLocation(6);
            b6.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc.getRow() + 1), GridLayout.spec(loc.getColumn() + 1)));

            cState = (PuzzleState) puzzle.getCurrentState();
            loc = cState.getLocation(7);
            b7.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc.getRow() + 1), GridLayout.spec(loc.getColumn() + 1)));

            cState = (PuzzleState) puzzle.getCurrentState();
            loc = cState.getLocation(8);
            b8.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc.getRow() + 1), GridLayout.spec(loc.getColumn() + 1)));
        }


        if(puzzle.getCurrentState().equals(puzzle.getFinalState())) {
            nextButton.setEnabled(false);
            feedback.setText("End of A* Search.");
        }

    }

    public void reset(View view) {
        helper.reset();
        feedback.setText("");
        statsView.setText("");
        nextButton.setEnabled(true);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        nextButton.setEnabled(false);
        solveButton.setEnabled(true);
        b1.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(3), GridLayout.spec(3)));
        b2.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(1), GridLayout.spec(2)));
        b3.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(3), GridLayout.spec(1)));
        b4.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(2), GridLayout.spec(3)));
        b5.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(1), GridLayout.spec(1)));
        b6.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(3), GridLayout.spec(2)));
        b7.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(1), GridLayout.spec(3)));
        b8.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(2), GridLayout.spec(1)));
        puzzle.setCurrentState(new PuzzleState(new int[][] {new int[]{5, 2, 7},
                new int[]{8, 0, 4},
                new int[]{3, 6, 1}}));


    }

    public void move1(View view) {
        mover(1);
    }

    public void move2(View view) {
        mover(2);
    }

    public void move3(View view) {
        mover(3);
    }

    public void move4(View view) {
        mover(4);
    }

    public void move5(View view) {
        mover(5);
    }

    public void move6(View view) {
        mover(6);
    }

    public void move7(View view) {
        mover(7);
    }

    public void move8(View view) {
        mover(8);
    }

    private void mover(int tile) {
     String s = "Slide tile " + Integer.toString(tile);
     Button button = null;
     helper.tryMove(s);

     switch(tile) {
         case 1: button = b1;
             break;

         case 2: button = b2;
             break;

         case 3: button = b3;
             break;

         case 4: button = b4;
             break;

         case 5: button = b5;
             break;

         case 6: button = b6;
             break;

         case 7: button = b7;
             break;

         case 8: button = b8;
             break;
     }
        if(helper.isMoveLegal()) {
            feedback.setText("");
            PuzzleState cState = (PuzzleState) puzzle.getCurrentState();
            PuzzleState.Location loc = cState.getLocation(tile);
            button.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc.getRow() + 1), GridLayout.spec(loc.getColumn() + 1)));
        }
        else {
            feedback.setText("Illegal Move! Try again.");

        }

        if(helper.isProblemSolved()) {
            feedback.setText("Congratulations, you solved the puzzle!");
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
        }
    }


}
