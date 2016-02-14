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

public class MagnetismSolve extends AppCompatActivity implements View.OnClickListener {
    float firstCollected = 0;
    float secondCollected = 0;
    float thirdCollected = 0;
    float fourthCollected = 0;
    float fifthCollected = 0;
    int variableCode = 0;
    int unitCode;
    int answerVis = 1;
    int buttonPressed = 0;
    String unit;
    double solution = 0;
    double tempSolution = 0;
    double magnetismConstant = .0000002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.magnetismsolve);
        TextView work = (TextView) findViewById(R.id.workshown);
        TextView shownWork = (TextView)findViewById(R.id.workshown);
        work.setVisibility(View.GONE);
        final Button homeButton = (Button) findViewById(R.id.Home);
        homeButton.setOnClickListener(this);
        final Button moreButton = (Button) findViewById(R.id.Another);
        moreButton.setOnClickListener(this);
        Bundle receive = this.getIntent().getExtras();
        float[] array = receive.getFloatArray("keyv");
        assert array != null;
        variableCode = (int) array[0];
        buttonPressed = (int) array[1];
        firstCollected = array[2];
        secondCollected = array[3];
        if (array.length >= 5) {
            thirdCollected = array[4];
        }
        if (array.length >= 6) {
            fourthCollected = array[5];
        }
        if (array.length == 7) {
            fifthCollected = array[6];
        }

        switch (variableCode) {
            case 0:
                //fqvb
                if (buttonPressed == 0) {
                    solution = firstCollected * secondCollected * thirdCollected * Math.sin(Math.toRadians(fourthCollected));
                    shownWork.setText(R.string.finfqvb);
                    unitCode = 0;
                }
                else if (buttonPressed == 1) {
                    solution = firstCollected / (secondCollected * thirdCollected * Math.sin(Math.toRadians(fourthCollected)));
                    shownWork.setText(R.string.qinfqvb);
                    unitCode = 1;
                }
                else if (buttonPressed == 2) {
                    solution = firstCollected / (secondCollected * thirdCollected * Math.sin(Math.toRadians(fourthCollected)));
                    shownWork.setText(R.string.vinfqvb);
                    unitCode = 2;
                }
                else if (buttonPressed == 3) {
                    solution = firstCollected / (secondCollected * thirdCollected * Math.sin(Math.toRadians(fourthCollected)));
                    shownWork.setText(R.string.binfqvb);
                    unitCode = 3;
                }
                else if (buttonPressed == 4) {
                    tempSolution = Math.asin(firstCollected / (secondCollected * thirdCollected * fourthCollected));
                    solution = (180 * tempSolution) / 3.1415926545;
                    shownWork.setText(R.string.thetainfqvb);
                    unitCode = 4;
                }
                answerVis = 1;
                break;
            case 1:
                //fbil
                if (buttonPressed == 0) {
                    solution = firstCollected * secondCollected * thirdCollected * Math.sin(Math.toRadians(fourthCollected));
                    shownWork.setText(R.string.finfbil);
                    unitCode = 0;
                }
                else if (buttonPressed == 1) {
                    solution = firstCollected / (secondCollected * thirdCollected * Math.sin(Math.toRadians(fourthCollected)));
                    shownWork.setText(R.string.binfbil);
                    unitCode = 3;
                }
                else if (buttonPressed == 2) {
                    solution = firstCollected / (secondCollected * thirdCollected * Math.sin(Math.toRadians(fourthCollected)));
                    shownWork.setText(R.string.iinfbil);
                    unitCode = 5;
                }
                else if (buttonPressed == 3) {
                    solution = firstCollected / (secondCollected * thirdCollected * Math.sin(Math.toRadians(fourthCollected)));
                    shownWork.setText(R.string.linfbil);
                    unitCode = 6;
                }
                else if (buttonPressed == 4) {
                    tempSolution = Math.asin(firstCollected / (secondCollected * thirdCollected * fourthCollected));
                    solution = (180 * tempSolution) / 3.1415926545;
                    shownWork.setText(R.string.thetainfbil);
                    unitCode = 4;
                }
                answerVis = 1;
                break;
            case 2:
                //bir
                if (buttonPressed == 0) {
                    solution = (magnetismConstant * firstCollected) / secondCollected;
                    shownWork.setText(R.string.binbir);
                    unitCode = 3;
                }
                else if (buttonPressed == 1) {
                    solution = (firstCollected * secondCollected) / magnetismConstant;
                    shownWork.setText(R.string.iinbir);
                    unitCode = 5;
                }
                else if (buttonPressed == 2) {
                    solution = (magnetismConstant * secondCollected) / firstCollected;
                    shownWork.setText(R.string.rinbir);
                    unitCode = 6;
                }
                answerVis = 1;
                break;
            case 3:
                //oba
                if (buttonPressed == 0) {
                    solution = firstCollected * secondCollected * Math.cos(Math.toRadians(thirdCollected));
                    shownWork.setText(R.string.oinoba);
                    unitCode = 7;
                }
                else if (buttonPressed == 1) {
                    solution = firstCollected / (secondCollected * Math.cos(Math.toRadians(thirdCollected)));
                    shownWork.setText(R.string.binoba);
                    unitCode = 3;
                }
                else if (buttonPressed == 2) {
                    solution = firstCollected / (secondCollected * Math.cos(Math.toRadians(thirdCollected)));
                    shownWork.setText(R.string.ainoba);
                    unitCode = 8;
                }
                else if (buttonPressed == 3) {
                    tempSolution = Math.acos(firstCollected / (secondCollected * thirdCollected));
                    solution = (180 * tempSolution) / 3.1415926545;
                    shownWork.setText(R.string.thetainoba);
                    unitCode = 4;
                }
                break;
            case 4:
                //eot
                if (buttonPressed == 0) {
                    solution = firstCollected / secondCollected;
                    shownWork.setText(R.string.eineot);
                    unitCode = 2;
                }
                else if (buttonPressed == 1) {
                    solution = (firstCollected * secondCollected) / magnetismConstant;
                    shownWork.setText(R.string.oineot);
                    unitCode = 7;
                }
                else if (buttonPressed == 2) {
                    solution = (magnetismConstant * secondCollected) / firstCollected;
                    shownWork.setText(R.string.tineot);
                    unitCode = 9;
                }
                break;
            case 5:
                //eblv
                if (buttonPressed == 0) {
                    solution = firstCollected * secondCollected * thirdCollected;
                    shownWork.setText(R.string.eineblv);
                    unitCode = 7;
                }
                else if (buttonPressed == 1) {
                    solution = firstCollected / (secondCollected * thirdCollected);
                    shownWork.setText(R.string.bineblv);
                    unitCode = 3;
                }
                else if (buttonPressed == 2) {
                    solution = firstCollected / (secondCollected * thirdCollected);
                    shownWork.setText(R.string.lineblv);
                    unitCode = 8;
                }
                else if (buttonPressed == 3) {
                    solution = firstCollected / (secondCollected * thirdCollected);
                    shownWork.setText(R.string.vineblv);
                    unitCode = 4;
                }
                break;
        }
        switch (unitCode)
        {
            case 0:
                unit = " N";
                break;
            case 1:
                unit = " C";
                break;
            case 2:
                unit = " V";
                break;
            case 3:
                unit = " N/(m·A)";
                break;
            case 4:
                unit = " °";
                break;
            case 5:
                unit = " A";
                break;
            case 6:
                unit = " m";
                break;
            case 7:
                unit = " Wb";
                break;
            case 8:
                unit = " m²";
                break;
            case 9:
                unit = " s";
                break;
        }

        TextView answer = (TextView)findViewById(R.id.maganswer);
        String tempAnswer = Double.toString(solution);
        String displayedAnswer = tempAnswer + unit;

        answer.setText(displayedAnswer);

        switchHandling(work);
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
        Intent home = new Intent(getApplicationContext(), Magnetism.class);
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

