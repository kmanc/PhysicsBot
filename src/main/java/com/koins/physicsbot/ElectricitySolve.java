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

public class ElectricitySolve extends AppCompatActivity implements View.OnClickListener {
    float firstCollected = 0;
    float secondCollected = 0;
    float thirdCollected = 0;
    float fourthCollected = 0;
    int variableCode = 0;
    int unitCode;
    int answerVis = 2;
    int buttonPressed = 0;
    String unit;
    double solution = 0;
    double solutionTwo = 0;
    double electricityConstant = 8987551787.0;
    double epsilonConstant = 8.854187817 * .000000000001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.electricitysolve);
        TextView work = (TextView) findViewById(R.id.workshown);
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
        TextView shownWork = (TextView)findViewById(R.id.workshown);
        if (array.length >= 5) {
            thirdCollected = array[4];
        }
        if (array.length == 6) {
            fourthCollected = array[5];
        }
        TextView secondAns = (TextView) findViewById(R.id.secondelecanswer);

        switch (variableCode)
        {
            case 0:
                //resistances
                if (buttonPressed == 0) {
                    solution = firstCollected + secondCollected;
                    shownWork.setText(R.string.seriesres);
                }
                else if (buttonPressed == 1) {
                    solution = 1 / ((1 / firstCollected) + (1 / secondCollected));
                    shownWork.setText(R.string.parallelres);
                }
                unitCode = 2;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 1:
                //capacitances
                if (buttonPressed == 0) {
                    solution = 1 / ((1 / firstCollected) + (1 / secondCollected));
                    shownWork.setText(R.string.seriescap);
                }
                else if (buttonPressed == 1) {
                    solution = firstCollected + secondCollected;
                    shownWork.setText(R.string.parallelcap);
                }
                unitCode = 12;
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 2:
                //vir
                if (buttonPressed == 0) {
                    solution = firstCollected * secondCollected;
                    shownWork.setText(R.string.vinvir);
                    unitCode = 0;
                }
                else if (buttonPressed == 1) {
                    solution = firstCollected / secondCollected;
                    shownWork.setText(R.string.iinvir);
                    unitCode = 1;
                }
                else if (buttonPressed == 2){
                    solution = firstCollected / secondCollected;
                    shownWork.setText(R.string.rinvir);
                    unitCode = 2;
                }
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 3:
                //piv
                if (buttonPressed == 0) {
                    solution = firstCollected * secondCollected;
                    shownWork.setText(R.string.pinpiv);
                    unitCode = 3;
                }
                else if (buttonPressed == 1) {
                    solution = firstCollected / secondCollected;
                    shownWork.setText(R.string.iinpiv);
                    unitCode = 1;
                }
                else if (buttonPressed == 2){
                    solution = firstCollected / secondCollected;
                    shownWork.setText(R.string.vinpiv);
                    unitCode = 0;
                }
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 4:
                //cqv
                if (buttonPressed == 0) {
                    solution = firstCollected / secondCollected;
                    shownWork.setText(R.string.cincqv);
                    unitCode = 12;
                }
                else if (buttonPressed == 1) {
                    solution = firstCollected * secondCollected;
                    shownWork.setText(R.string.qincqv);
                    unitCode = 4;
                }
                else if (buttonPressed == 2){
                    solution = secondCollected / firstCollected;
                    shownWork.setText(R.string.vincqv);
                    unitCode = 0;
                }
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 5:
                //vkqr
                if (buttonPressed == 0) {
                    solution = electricityConstant * (firstCollected / secondCollected);
                    shownWork.setText(R.string.vinvkqr);
                    unitCode = 0;
                }
                else if (buttonPressed == 1) {
                    solution =  (firstCollected / electricityConstant) * secondCollected;
                    shownWork.setText(R.string.qinvkqr);
                    unitCode = 4;
                }
                else if (buttonPressed == 2){
                    solution = (secondCollected / electricityConstant) / firstCollected;
                    shownWork.setText(R.string.rinvkqr);
                    unitCode = 9;
                }
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;

            case 6:
                //iqt
                if (buttonPressed == 0) {
                    solution = firstCollected / secondCollected;
                    shownWork.setText(R.string.iiniqt);
                    unitCode = 1;
                }
                else if (buttonPressed == 1) {
                    solution = firstCollected * secondCollected;
                    shownWork.setText(R.string.qiniqt);
                    unitCode = 4;
                }
                else if (buttonPressed == 2){
                    solution = secondCollected / firstCollected;
                    shownWork.setText(R.string.tiniqt);
                    unitCode = 5;
                }
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 7:
                //fkqr
                answerVis = 1;
                if (buttonPressed == 0) {
                    solution = (electricityConstant * firstCollected * secondCollected) / (thirdCollected * thirdCollected);
                    shownWork.setText(R.string.finfkqr);
                    unitCode = 7;
                }
                else if (buttonPressed == 1) {
                    solution = (firstCollected * thirdCollected * thirdCollected) / (electricityConstant * secondCollected);
                    shownWork.setText(R.string.q1infkqr);
                    unitCode = 4;
                }
                else if (buttonPressed == 2){
                    solution = (firstCollected * thirdCollected * thirdCollected) / (electricityConstant * secondCollected);
                    shownWork.setText(R.string.q2infkqr);
                    unitCode = 4;
                }
                else if (buttonPressed == 3){
                    solution = sqrt((electricityConstant * secondCollected * thirdCollected) / firstCollected);
                    shownWork.setText(R.string.rinfkqr);
                    unitCode = 9;
                    answerVis = 1;
                }
                secondAns.setVisibility(View.GONE);
                break;
            case 8:
                //efq
                if (buttonPressed == 0) {
                    solution = firstCollected / secondCollected;
                    shownWork.setText(R.string.einefq);
                    unitCode = 6;
                }
                else if (buttonPressed == 1) {
                    solution = firstCollected * secondCollected;
                    shownWork.setText(R.string.finefq);
                    unitCode = 7;
                }
                else if (buttonPressed == 2){
                    solution = secondCollected / firstCollected;
                    shownWork.setText(R.string.qinefq);
                    unitCode = 4;
                }
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 9:
                //uqv
                if (buttonPressed == 0) {
                    solution = firstCollected * secondCollected;
                    shownWork.setText(R.string.uinuqv);
                    unitCode = 8;
                }
                else if (buttonPressed == 1) {
                    solution = firstCollected / secondCollected;
                    shownWork.setText(R.string.qinuqv);
                    unitCode = 4;
                }
                else if (buttonPressed == 2){
                    solution = firstCollected / secondCollected;
                    shownWork.setText(R.string.vinuqv);
                    unitCode = 0;
                }
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 10:
                //ukqr
                if (buttonPressed == 0) {
                    solution = (electricityConstant * firstCollected * secondCollected) / (thirdCollected);
                    shownWork.setText(R.string.uinukqr);
                    unitCode = 8;
                }
                else if (buttonPressed == 1) {
                    solution = (firstCollected * thirdCollected) / (electricityConstant * secondCollected);
                    shownWork.setText(R.string.q1inukqr);
                    unitCode = 4;
                }
                else if (buttonPressed == 2){
                    solution = (firstCollected * thirdCollected) / (electricityConstant * secondCollected);
                    shownWork.setText(R.string.q2inukqr);
                    unitCode = 4;
                }
                else if (buttonPressed == 3){
                    solution = (electricityConstant * secondCollected * thirdCollected) / firstCollected;
                    shownWork.setText(R.string.rinukqr);
                    unitCode = 9;
                }
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 11:
                //cϵad
                if (buttonPressed == 0) {
                    solution = (epsilonConstant * firstCollected) / secondCollected;
                    shownWork.setText(R.string.cincϵad);
                    unitCode = 12;
                }
                else if (buttonPressed == 1) {
                    solution = (epsilonConstant * secondCollected) / firstCollected;
                    shownWork.setText(R.string.aincϵad);
                    unitCode = 10;
                }
                else if (buttonPressed == 2){
                    solution = (firstCollected * secondCollected) / epsilonConstant;
                    shownWork.setText(R.string.dincϵad);
                    unitCode = 9;
                }
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 12:
                //rρla
                if (buttonPressed == 0) {
                    solution = (firstCollected * secondCollected) / thirdCollected;
                    shownWork.setText(R.string.rinrρla);
                    unitCode = 2;
                }
                else if (buttonPressed == 1) {
                    solution = (secondCollected * thirdCollected) / firstCollected;
                    shownWork.setText(R.string.ρinrρla);
                    unitCode = 11;
                }
                else if (buttonPressed == 2) {
                    solution = (firstCollected * thirdCollected) / secondCollected;
                    shownWork.setText(R.string.linrρla);
                    unitCode = 9;
                }
                else if (buttonPressed == 3){
                    solution = (firstCollected * thirdCollected) / secondCollected;
                    shownWork.setText(R.string.ainrρla);
                    unitCode = 10;
                }
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 13:
                //ubigqv
                if (buttonPressed == 0) {
                    solution = .5 * firstCollected * secondCollected;
                    shownWork.setText(R.string.uinubigqv);
                    unitCode = 8;
                }
                else if (buttonPressed == 1) {
                    solution = (2 * firstCollected) / secondCollected;
                    shownWork.setText(R.string.bigqinubigqv);
                    unitCode = 4;
                }
                else if (buttonPressed == 2){
                    solution = (2 * firstCollected) / secondCollected;
                    shownWork.setText(R.string.vinubigqv);
                    unitCode = 0;
                }
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 14:
                //ucv
                if (buttonPressed == 0) {
                    solution = .5 * firstCollected * secondCollected * secondCollected;
                    shownWork.setText(R.string.uinucv);
                    unitCode = 8;
                }
                else if (buttonPressed == 1) {
                    solution = (2 * firstCollected) / (secondCollected * secondCollected);
                    shownWork.setText(R.string.cinucv);
                    unitCode = 12;
                }
                else if (buttonPressed == 2){
                    solution = sqrt((2 * firstCollected) / secondCollected);
                    shownWork.setText(R.string.vinucv);
                    unitCode = 0;
                }
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
            case 15:
                //evd
                if (buttonPressed == 0) {
                    solution = (-1 * firstCollected) / secondCollected;
                    shownWork.setText(R.string.einevd);
                    unitCode = 8;
                }
                else if (buttonPressed == 1) {
                    solution = -1 * firstCollected * secondCollected;
                    shownWork.setText(R.string.vinevd);
                    unitCode = 12;
                }
                else if (buttonPressed == 2){
                    solution = (-1 * firstCollected) / secondCollected;
                    shownWork.setText(R.string.dinevd);
                    unitCode = 0;
                }
                secondAns.setVisibility(View.GONE);
                answerVis = 1;
                break;
        }

        switch (unitCode)
        {
            case 0:
                unit = " V";
                break;
            case 1:
                unit = " A";
                break;
            case 2:
                unit = " Ω";
                break;
            case 3:
                unit = " W";
                break;
            case 4:
                unit = " C";
                break;
            case 5:
                unit = " s";
                break;
            case 6:
                unit = " N/C";
                break;
            case 7:
                unit = " N";
                break;
            case 8:
                unit = " J";
                break;
            case 9:
                unit = " m";
                break;
            case 10:
                unit = " m²";
                break;
            case 11:
                unit = " Ω*m";
                break;
            case 12:
                unit = " F";
                break;
        }

        TextView answer = (TextView)findViewById(R.id.elecanswer);
        String tempAnswer = Double.toString(solution);
        String displayedAnswer = tempAnswer + unit;

        answer.setText(displayedAnswer);

        if (answerVis == 2) {
            String tempAnswer2 = Double.toString(solutionTwo);
            String displayedAnswerTwo = tempAnswer2 + unit;
            secondAns.setText(displayedAnswerTwo);
        }

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
        Intent home = new Intent(getApplicationContext(), Electricity.class);
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

