package com.koins.physicsbot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
import static java.lang.Math.*;

public class KinematicsSolve extends AppCompatActivity implements View.OnClickListener {
    float firstCollected = 0;
    float secondCollected = 0;
    float thirdCollected = 0;
    float fourthCollected = 0;
    int variableCode = 0;
    int unitCode;
    int answerVis = 2;
    String unit;
    double solution = 0;
    double solutionTwo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematicssolve);
        TextView shownWork = (TextView) findViewById(R.id.workshown);
        shownWork.setVisibility(View.GONE);
        final Button homeButton = (Button) findViewById(R.id.Home);
        homeButton.setOnClickListener(this);
        final Button moreButton = (Button) findViewById(R.id.Another);
        moreButton.setOnClickListener(this);
        Bundle receive = this.getIntent().getExtras();
        float[] array = receive.getFloatArray("keyv");
        assert array != null;
        variableCode = (int) array[0];
        firstCollected = array[1];
        secondCollected = array[2];
        thirdCollected = array[3];
        if (array.length == 5) {
            fourthCollected = array[4];
        }
        TextView secondAns = (TextView) findViewById(R.id.secondkinanswer);

        switch (variableCode)
        {
            case 0:
                //vmiasolvevo
                solution = (thirdCollected - secondCollected - (.5 * fourthCollected * firstCollected * firstCollected)) / firstCollected;
                shownWork.setText(R.string.vmiasolvevo);
                unitCode = 0;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 1:
                //vmiasolvet
                solution = (-1 * firstCollected + sqrt((firstCollected * firstCollected) - (4 * fourthCollected * (secondCollected - thirdCollected)))) / fourthCollected;
                solutionTwo = (-1 * firstCollected - sqrt((firstCollected * firstCollected) - (4 * fourthCollected * (secondCollected - thirdCollected)))) / fourthCollected;
                shownWork.setText(R.string.vmiasolvet);
                unitCode = 3;
                break;
            case 2:
                //vmiasolvexo
                solution = thirdCollected - (firstCollected * secondCollected) - (.5 * fourthCollected * secondCollected * secondCollected);
                shownWork.setText(R.string.vmiasolvexo);
                unitCode = 2;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 3:
                //vmiasolvex
                solution = thirdCollected + (firstCollected * secondCollected) + (.5 * fourthCollected * secondCollected * secondCollected);
                shownWork.setText(R.string.vmiasolvex);
                unitCode = 2;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 4:
                //vmiasolvea
                solution = 2 * (fourthCollected - thirdCollected - (firstCollected * secondCollected)) / (secondCollected * secondCollected);
                shownWork.setText(R.string.vmiasolvea);
                unitCode = 1;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 5:
                //vomiasolvev
                solution = (thirdCollected - secondCollected + (.5 * fourthCollected * firstCollected * firstCollected)) / firstCollected;
                shownWork.setText(R.string.vomiasolvev);
                unitCode = 0;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 6:
                //vomiasolvet
                solution = (-1 * firstCollected + sqrt((firstCollected * firstCollected) - (4 * fourthCollected * (thirdCollected - secondCollected)))) / fourthCollected;
                solutionTwo = (-1 * firstCollected - sqrt((firstCollected * firstCollected) - (4 * fourthCollected * (thirdCollected - secondCollected)))) / fourthCollected;
                shownWork.setText(R.string.vomiasolvet);
                unitCode = 3;
                break;
            case 7:
                //vomiasolvexo
                solution = thirdCollected - (firstCollected * secondCollected) + (.5 * fourthCollected * secondCollected * secondCollected);
                shownWork.setText(R.string.vomiasolvexo);
                unitCode = 2;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 8:
                //vomiasolvex
                solution = thirdCollected + (firstCollected * secondCollected) - (.5 * fourthCollected * secondCollected * secondCollected);
                shownWork.setText(R.string.vomiasolvex);
                unitCode = 2;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 9:
                //vomiasolvea
                solution = 2 * (firstCollected * secondCollected + thirdCollected - fourthCollected) / (secondCollected * secondCollected);
                shownWork.setText(R.string.vomiasolvea);
                unitCode = 1;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 10:
                //tmiasolvev
                solution = sqrt(firstCollected * firstCollected + (2 * fourthCollected * (thirdCollected - secondCollected)));
                shownWork.setText(R.string.tmiasolvev);
                unitCode = 0;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 11:
                //tmiasolvevo
                solution = sqrt(firstCollected * firstCollected - (2 * fourthCollected * (thirdCollected - secondCollected)));
                shownWork.setText(R.string.tmiasolvevo);
                unitCode = 0;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 12:
                //tmiasolvexo
                solution = thirdCollected - ((firstCollected * firstCollected - (secondCollected * secondCollected)) / (2 * fourthCollected));
                shownWork.setText(R.string.tmiasolvexo);
                unitCode = 2;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 13:
                //tmiasolvex
                solution = thirdCollected + ((firstCollected * firstCollected - (secondCollected * secondCollected)) / (2 * fourthCollected));
                shownWork.setText(R.string.tmiasolvex);
                unitCode = 2;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 14:
                //tmiasolvea
                solution = (firstCollected * firstCollected - (secondCollected * secondCollected)) / (2 * (fourthCollected - thirdCollected));
                shownWork.setText(R.string.tmiasolvea);
                unitCode = 1;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 15:
                //xmiasolvev
                solution = firstCollected + (secondCollected * thirdCollected);
                shownWork.setText(R.string.xmiasolvev);
                unitCode = 0;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 16:
                //xmiasolvevo
                solution = firstCollected - (secondCollected * thirdCollected);
                shownWork.setText(R.string.xmiasolvevo);
                unitCode = 0;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 17:
                //xmiasolvet
                solution = (firstCollected - secondCollected) / thirdCollected;
                shownWork.setText(R.string.xmiasolvet);
                unitCode = 3;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 18:
                //xmiasolvea
                solution = (firstCollected - secondCollected) / thirdCollected;
                shownWork.setText(R.string.xmiasolvea);
                unitCode = 1;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 19:
                //amiasolvev
                solution = (2 * (fourthCollected - thirdCollected) / secondCollected) - firstCollected;
                shownWork.setText(R.string.amiasolvev);
                unitCode = 0;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 20:
                //amiasolvevo
                solution = (2 * (fourthCollected - thirdCollected) / secondCollected) - firstCollected;
                shownWork.setText(R.string.amiasolvevo);
                unitCode = 0;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 21:
                //amiasolvet
                solution = (2 * (fourthCollected - thirdCollected)) / (firstCollected + secondCollected);
                shownWork.setText(R.string.amiasolvet);
                unitCode = 3;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 22:
                //amiasolvexo
                solution = fourthCollected - (.5 * thirdCollected * (firstCollected + secondCollected));
                shownWork.setText(R.string.amiasolvexo);
                unitCode = 2;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 23:
                //amiasolvex
                solution = fourthCollected + (.5 * thirdCollected * (firstCollected + secondCollected));
                shownWork.setText(R.string.amiasolvex);
                unitCode = 2;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
        }

        switch (unitCode)
        {
            case 0:
                unit = " m / s";
                break;
            case 1:
                unit = " m / s²";
                break;
            case 2:
                unit = " m";
                break;
            case 3:
                unit = " s";
                break;
        }

        TextView answer = (TextView)findViewById(R.id.kinanswer);
        String tempAnswer = Double.toString(solution);
        String displayedAnswer = tempAnswer + unit;

        answer.setText(displayedAnswer);

        if (answerVis == 2) {
            String tempAnswer2 = Double.toString(solutionTwo);
            String displayedAnswerTwo = tempAnswer2 + unit;
            secondAns.setText(displayedAnswerTwo);
        }

        switchHandling(shownWork);
    }

    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.Another:
                more();
                break;
            case R.id.Home:
                home();
                break;
        }
    }

    private void home() {
        Intent home = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(home);
    }

    private void more() {
        Intent home = new Intent(getApplicationContext(), Kinematics.class);
        startActivity(home);
    }

    private void switchHandling(final TextView work){
        final ToggleButton showWork = (ToggleButton) findViewById(R.id.showMore1);

        showWork.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (showWork.isChecked()) {
                    work.setVisibility(View.VISIBLE);
                } else {
                    work.setVisibility(View.GONE);
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

