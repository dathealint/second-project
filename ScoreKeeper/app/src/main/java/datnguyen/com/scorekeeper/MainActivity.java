package datnguyen.com.scorekeeper;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int score_a = 0;
    private int score_b = 0;

    final static int TEAM_A = 0;
    final static int TEAM_B = 1;

    private TextView tvScoreA;
    private TextView tvScoreB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // grab references of textview scores of team A and B
        tvScoreA = (TextView) findViewById(R.id.tvScoreTeamA);
        tvScoreB = (TextView) findViewById(R.id.tvScoreTeamB);

        // first reset scores to 0
        onClickReset(null);
    }

    void updateScore(int team) {
        if (team == TEAM_A) {
            tvScoreA.setText(String.valueOf(score_a));
        } else if (team == TEAM_B) {
            tvScoreB.setText(String.valueOf(score_b));
        }
    }

    void onClickPointTeamAButton(View view) {
        int point = Integer.parseInt(view.getTag().toString());
        score_a += point;
        if (score_a < 0) {
            score_a = 0;
        }
        updateScore(TEAM_A);
    }

    void onClickPointTeamBButton(View view) {
        int point = Integer.parseInt(view.getTag().toString());
        score_b += point;
        if (score_b < 0) {
            score_b = 0;
        }
        updateScore(TEAM_B);
    }

    void onClickReset(View view) {
        // reset points of 2 teams to 0
        score_a = 0;
        score_b = 0;
        updateScore(TEAM_A);
        updateScore(TEAM_B);
    }
}
