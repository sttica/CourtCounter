package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    int gameTotal = 15;
    int pointCap = 17;

    String teamAwin;
    String teamBwin;

    TextView winView;
    TextView scoreViewA;
    TextView scoreViewB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamAwin = getString(R.string.teamAwin);
        teamBwin = getString(R.string.teamBwin);

        winView = (TextView) findViewById(R.id.win);
        scoreViewA = (TextView) findViewById(R.id.team_a_score);
        scoreViewB = (TextView) findViewById(R.id.team_b_score);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        scoreViewA.setText(String.valueOf(score));
    }

    public void plusTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
        checkWin();
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        scoreViewB.setText(String.valueOf(score));
    }

    public void plusTeamB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
        checkWin();
    }

    /**
     * Checks win condition
     */
    public void checkWin() {
        if (scoreTeamA >= gameTotal & (scoreTeamA - scoreTeamB) >= 2 || scoreTeamA == pointCap) {
            winView.setText(teamAwin);
        }
        if (scoreTeamB >= gameTotal & (scoreTeamB - scoreTeamA) >= 2 || scoreTeamB == pointCap) {
            winView.setText(teamBwin);
        }
    }

    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        TextView winView = (TextView) findViewById(R.id.win);
        winView.setText("");
    }

}
