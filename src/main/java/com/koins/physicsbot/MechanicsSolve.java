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

public class MechanicsSolve extends AppCompatActivity implements View.OnClickListener {
    float firstCollected = 0;
    float secondCollected = 0;
    float thirdCollected = 0;
    float fourthCollected = 0;
    float fifthCollected = 0;
    int variableCode = 0;
    int unitCode;
    int buttonPressed = 0;
    String unit;
    double solution = 0;
    double tempSolution = 0;
    double gravitationalConstant = 6.67408 * .00000000001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mechanicssolve);
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
        if (array.length >= 4) {
            secondCollected = array[3];
        }
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
                //fma
                if (buttonPressed == 0) {
                    solution = firstCollected * secondCollected;
                    shownWork.setText(R.string.finfma);
                    unitCode = 0;
                }
                else if (buttonPressed == 1) {
                    solution = firstCollected / secondCollected;
                    shownWork.setText(R.string.minfma);
                    unitCode = 1;
                }
                else if (buttonPressed == 2) {
                    solution = firstCollected / secondCollected;
                    shownWork.setText(R.string.ainfma);
                    unitCode = 2;
                }
                break;
            case 1:
                //fun
                if (buttonPressed == 0) {
                    solution = firstCollected * secondCollected;
                    shownWork.setText(R.string.finfun);
                    unitCode = 0;
                }
                else if (buttonPressed == 1) {
                    solution = firstCollected / secondCollected;
                    shownWork.setText(R.string.uinfun);
                    unitCode = 3;
                }
                else if (buttonPressed == 2) {
                    solution = firstCollected / secondCollected;
                    shownWork.setText(R.string.ninfun);
                    unitCode = 0;
                }
                break;
            case 2:
                //trf
                if (buttonPressed == 0) {
                    solution = firstCollected * secondCollected * Math.sin(Math.toRadians(thirdCollected));
                    shownWork.setText(R.string.tintrf);
                    unitCode = 13;
                }
                else if (buttonPressed == 1) {
                    solution = firstCollected / (secondCollected * Math.sin(Math.toRadians(thirdCollected)));
                    shownWork.setText(R.string.rintrf);
                    unitCode = 9;
                }
                else if (buttonPressed == 2) {
                    solution = firstCollected / (secondCollected * Math.sin(Math.toRadians(thirdCollected)));
                    shownWork.setText(R.string.rintrf);
                    unitCode = 0;
                }
                else if (buttonPressed == 3) {
                    tempSolution = Math.asin(firstCollected / (secondCollected * thirdCollected));
                    solution = (180 * tempSolution) / 3.1415926545;
                    shownWork.setText(R.string.thetaintrf);
                    unitCode = 14;
                }
                break;
            case 3:
                //pmv
                if (buttonPressed == 0) {
                    solution = firstCollected * secondCollected;
                    shownWork.setText(R.string.pinpmv);
                    unitCode = 4;
                }
                else if (buttonPressed == 1) {
                    solution = firstCollected / secondCollected;
                    shownWork.setText(R.string.minpmv);
                    unitCode = 1;
                }
                else if (buttonPressed == 2) {
                    solution = firstCollected / secondCollected;
                    shownWork.setText(R.string.vinpmv);
                    unitCode = 5;
                }
                break;
            case 4:
                //jft
                if (buttonPressed == 0) {
                    solution = firstCollected * secondCollected;
                    shownWork.setText(R.string.jinjft);
                    unitCode = 6;
                }
                else if (buttonPressed == 1) {
                    solution = firstCollected / secondCollected;
                    shownWork.setText(R.string.finjft);
                    unitCode = 0;
                }
                else if (buttonPressed == 2) {
                    solution = firstCollected / secondCollected;
                    shownWork.setText(R.string.tinjft);
                    unitCode = 7;
                }
                break;
            case 5:
                //kmv
                if (buttonPressed == 0) {
                    solution = .5 * firstCollected * secondCollected * secondCollected;
                    shownWork.setText(R.string.kinkmv);
                    unitCode = 8;
                }
                else if (buttonPressed == 1) {
                    solution = (2 * firstCollected) / (secondCollected * secondCollected);
                    shownWork.setText(R.string.minkmv);
                    unitCode = 1;
                }
                else if (buttonPressed == 2) {
                    solution = Math.sqrt((2 * firstCollected) / secondCollected);
                    shownWork.setText(R.string.vinkmv);
                    unitCode = 5;
                }
                break;
            case 6:
                //umgh
                if (buttonPressed == 0) {
                    solution = firstCollected * secondCollected * thirdCollected;
                    shownWork.setText(R.string.uinugmh);
                    unitCode = 8;
                }
                else if (buttonPressed == 1) {
                    solution = firstCollected / (secondCollected * thirdCollected);
                    shownWork.setText(R.string.minugmh);
                    unitCode = 1;
                }
                else if (buttonPressed == 2) {
                    solution = firstCollected / (secondCollected * thirdCollected);
                    shownWork.setText(R.string.ginugmh);
                    unitCode = 2;
                }
                else if (buttonPressed == 3) {
                    solution = firstCollected / (secondCollected * thirdCollected);
                    shownWork.setText(R.string.hinugmh);
                    unitCode = 9;
                }
                break;
            case 7:
                //wfr
                if (buttonPressed == 0) {
                    solution = firstCollected * secondCollected * Math.cos(Math.toRadians(thirdCollected));
                    shownWork.setText(R.string.winwfr);
                    unitCode = 8;
                }
                else if (buttonPressed == 1) {
                    solution = firstCollected / (secondCollected * Math.cos(Math.toRadians(thirdCollected)));
                    shownWork.setText(R.string.finwfr);
                    unitCode = 0;
                }
                else if (buttonPressed == 2) {
                    solution = firstCollected / (secondCollected * Math.cos(Math.toRadians(thirdCollected)));
                    shownWork.setText(R.string.rinwfr);
                    unitCode = 9;
                }
                else if (buttonPressed == 3) {
                    tempSolution = Math.acos(firstCollected / (secondCollected * thirdCollected));
                    solution = (180 * tempSolution) / 3.1415926545;
                    shownWork.setText(R.string.thetainwfr);
                    unitCode = 14;
                }
                break;
            case 8:
                //pwt
                if (buttonPressed == 0) {
                    solution = firstCollected / secondCollected;
                    shownWork.setText(R.string.pinpwt);
                    unitCode = 10;
                }
                else if (buttonPressed == 1) {
                    solution = firstCollected * secondCollected;
                    shownWork.setText(R.string.winpwt);
                    unitCode = 8;
                }
                else if (buttonPressed == 2) {
                    solution = secondCollected / firstCollected;
                    shownWork.setText(R.string.tinpwt);
                    unitCode = 7;
                }
                break;
            case 9:
                //pfv
                if (buttonPressed == 0) {
                    solution = firstCollected * secondCollected * Math.cos(Math.toRadians(thirdCollected));
                    shownWork.setText(R.string.pinpfv);
                    unitCode = 10;
                }
                else if (buttonPressed == 1) {
                    solution = firstCollected / (secondCollected * Math.cos(Math.toRadians(thirdCollected)));
                    shownWork.setText(R.string.finpfv);
                    unitCode = 0;
                }
                else if (buttonPressed == 2) {
                    solution = firstCollected / (secondCollected * Math.cos(Math.toRadians(thirdCollected)));
                    shownWork.setText(R.string.vinpfv);
                    unitCode = 5;
                }
                else if (buttonPressed == 3) {
                    tempSolution = Math.acos(firstCollected / (secondCollected * thirdCollected));
                    solution = (180 * tempSolution) / 3.1415926545;
                    shownWork.setText(R.string.thetainpfv);
                    unitCode = 14;
                }
                break;
            case 10:
                //ukx
                if (buttonPressed == 0) {
                    solution = .5 * firstCollected * secondCollected * secondCollected;
                    shownWork.setText(R.string.uinukx);
                    unitCode = 8;
                }
                else if (buttonPressed == 1) {
                    solution = (2 * firstCollected) / (secondCollected * secondCollected);
                    shownWork.setText(R.string.kinukx);
                    unitCode = 11;
                }
                else if (buttonPressed == 2) {
                    solution = Math.sqrt((2 * firstCollected) / secondCollected);
                    shownWork.setText(R.string.xinukx);
                    unitCode = 9;
                }
                break;
            case 11:
                //tmk
                if (buttonPressed == 0) {
                    solution = 2 * 3.1415926545 * Math.sqrt(firstCollected / secondCollected);
                    shownWork.setText(R.string.tintmk);
                    unitCode = 7;
                }
                else if (buttonPressed == 1) {
                    solution = (firstCollected / (2 * 3.1415926545) * firstCollected / (2 * 3.1415926545)) * secondCollected;
                    shownWork.setText(R.string.mintmk);
                    unitCode = 1;
                }
                else if (buttonPressed == 2) {
                    solution = secondCollected / (firstCollected / (2 * 3.1415926545) * firstCollected / (2 * 3.1415926545));
                    shownWork.setText(R.string.kintmk);
                    unitCode = 11;
                }
                break;
            case 12:
                //tlg
                if (buttonPressed == 0) {
                    solution = 2 * 3.1415926545 * Math.sqrt(firstCollected / secondCollected);
                    shownWork.setText(R.string.tintlg);
                    unitCode = 7;
                }
                else if (buttonPressed == 1) {
                    solution = (firstCollected / (2 * 3.1415926545) * firstCollected / (2 * 3.1415926545)) * secondCollected;
                    shownWork.setText(R.string.lintlg);
                    unitCode = 9;
                }
                else if (buttonPressed == 2) {
                    solution = secondCollected / (firstCollected / (2 * 3.1415926545) * firstCollected / (2 * 3.1415926545));
                    shownWork.setText(R.string.gintlg);
                    unitCode = 2;
                }
                break;
            case 13:
                //tf
                if (buttonPressed == 0) {
                    solution = 1 / firstCollected;
                    shownWork.setText(R.string.tintf);
                    unitCode = 7;
                }
                else if (buttonPressed == 1) {
                    solution = 1 / firstCollected;
                    shownWork.setText(R.string.fintf);
                    unitCode = 12;
                }
                break;
            case 14:
                //fgmr
                if (buttonPressed == 0) {
                    solution = (gravitationalConstant * firstCollected * secondCollected) / (thirdCollected * thirdCollected);
                    shownWork.setText(R.string.finfgmr);
                    unitCode = 0;
                }
                else if (buttonPressed == 1) {
                    solution = (firstCollected * thirdCollected * thirdCollected) / (gravitationalConstant * secondCollected);
                    shownWork.setText(R.string.moneinfgmr);
                    unitCode = 1;
                }
                else if (buttonPressed == 2) {
                    solution = (firstCollected * thirdCollected * thirdCollected) / (gravitationalConstant * secondCollected);
                    shownWork.setText(R.string.mtwoinfgmr);
                    unitCode = 1;
                }
                else if (buttonPressed == 3) {
                    solution = Math.sqrt((gravitationalConstant * secondCollected * thirdCollected) / (firstCollected));
                    shownWork.setText(R.string.rinfgmr);
                    unitCode = 9;
                }
                break;
            case 15:
                //ugmr
                if (buttonPressed == 0) {
                    solution = (gravitationalConstant * firstCollected * secondCollected) / thirdCollected;
                    shownWork.setText(R.string.uinugmr);
                    unitCode = 8;
                }
                else if (buttonPressed == 1) {
                    solution = (firstCollected * thirdCollected) / (gravitationalConstant * secondCollected);
                    shownWork.setText(R.string.moneinugmr);
                    unitCode = 1;
                }
                else if (buttonPressed == 2) {
                    solution = (firstCollected * thirdCollected) / (gravitationalConstant * secondCollected);
                    shownWork.setText(R.string.mtwoinugmr);
                    unitCode = 1;
                }
                else if (buttonPressed == 3) {
                    solution = (gravitationalConstant * secondCollected * thirdCollected) / (firstCollected);
                    shownWork.setText(R.string.rinugmr);
                    unitCode = 9;
                }
                break;
        }

        switch (unitCode)
        {
            case 0:
                unit = " N";
                break;
            case 1:
                unit = " kg";
                break;
            case 2:
                unit = " m / s²";
                break;
            case 3:
                unit = " ";
                break;
            case 4:
                unit = " (kg * m) / s";
                break;
            case 5:
                unit = " m / s";
                break;
            case 6:
                unit = " N * s";
                break;
            case 7:
                unit = " s";
                break;
            case 8:
                unit = " J";
                break;
            case 9:
                unit = " m";
                break;
            case 10:
                unit = " W";
                break;
            case 11:
                unit = " N / m";
                break;
            case 12:
                unit = " Hz";
                break;
            case 13:
                unit = " N * m";
                break;
            case 14:
                unit = " °";
                break;
        }

        TextView answer = (TextView)findViewById(R.id.mechanswer);
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
        Intent home = new Intent(getApplicationContext(), Mechanics.class);
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

