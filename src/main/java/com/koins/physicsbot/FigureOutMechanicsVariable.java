package com.koins.physicsbot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

public class FigureOutMechanicsVariable extends AppCompatActivity implements View.OnClickListener {

    float passOne = 0;
    float passTwo = 0;
    float passThree = 0;
    float passFour = 0;
    int omitSecondEditText = 0;
    int omitThirdEditText = 0;
    int omitFourthEditText = 0;
    int variablesNeeded = 0;
    int firstOptionValue = 0;
    int secondOptionValue = 0;
    int thirdOptionValue = 0;
    int fourthOptionValue = 0;
    int fifthOptionValue = 0;
    RelativeLayout.LayoutParams layoutFixer = new RelativeLayout.LayoutParams
            (RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figureoutmechanicsvariable);
        Bundle receive = this.getIntent().getExtras();
        int[] array = receive.getIntArray("key");
        assert array != null;
        variablesNeeded = array[0];
        ToggleButton firstVar = (ToggleButton) findViewById(R.id.firstchoice);
        ToggleButton secondVar = (ToggleButton) findViewById(R.id.secondchoice);
        ToggleButton thirdVar = (ToggleButton) findViewById(R.id.thirdchoice);
        ToggleButton fourthVar = (ToggleButton) findViewById(R.id.fourthchoice);
        ToggleButton fifthVar = (ToggleButton) findViewById(R.id.fifthchoice);
        EditText hideSecondEditText = (EditText) findViewById(R.id.secondvariable);
        EditText hideThirdEditText = (EditText) findViewById(R.id.thirdvariable);
        EditText hideFourthEditText = (EditText) findViewById(R.id.fourthvariable);
        final Button solveButton = (Button) findViewById(R.id.solve);
        final Button backButton = (Button) findViewById(R.id.back);
        final Button homeButton = (Button) findViewById(R.id.Home);
        switchHandling();
        solveButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);

        switch (variablesNeeded)
        {
            case 0:
                //fma
                hideButton(fourthVar);
                hideButton(fifthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("F");
                secondVar.setText("m");
                thirdVar.setText("a");
                break;
            case 1:
                //fun
                hideButton(fourthVar);
                hideButton(fifthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("F");
                secondVar.setText("μ");
                thirdVar.setText("N");
                break;
            case 2:
                //trf
                hideButton(fifthVar);
                hideEditText(hideFourthEditText);
                firstVar.setText("τ");
                secondVar.setText("r");
                thirdVar.setText("F");
                fourthVar.setText("θ");
                break;
            case 3:
                //pmv
                hideButton(fourthVar);
                hideButton(fifthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("p");
                secondVar.setText("m");
                thirdVar.setText("v");
                break;
            case 4:
                //jft
                hideButton(fourthVar);
                hideButton(fifthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("J");
                secondVar.setText("F");
                thirdVar.setText("Δt");
                break;
            case 5:
                //kmv
                hideButton(fourthVar);
                hideButton(fifthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("K");
                secondVar.setText("m");
                thirdVar.setText("v");
                break;
            case 6:
                //umgh
                hideButton(fifthVar);
                hideEditText(hideFourthEditText);
                firstVar.setText("U");
                secondVar.setText("m");
                thirdVar.setText("g");
                fourthVar.setText("h");
                break;
            case 7:
                //wfr
                hideButton(fifthVar);
                hideEditText(hideFourthEditText);
                firstVar.setText("W");
                secondVar.setText("F");
                thirdVar.setText("Δr");
                fourthVar.setText("θ");
                break;
            case 8:
                //pwt
                hideButton(fourthVar);
                hideButton(fifthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("P");
                secondVar.setText("W");
                thirdVar.setText("Δt");
                break;
            case 9:
                //pfv
                hideButton(fifthVar);
                hideEditText(hideFourthEditText);
                firstVar.setText("P");
                secondVar.setText("F");
                thirdVar.setText("v");
                fourthVar.setText("θ");
                break;
            case 10:
                //ukx
                hideButton(fourthVar);
                hideButton(fifthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("U");
                secondVar.setText("k");
                thirdVar.setText("x");
                break;
            case 11:
                //tmk
                hideButton(fourthVar);
                hideButton(fifthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("Ts");
                secondVar.setText("m");
                thirdVar.setText("k");
                break;
            case 12:
                //tlg
                hideButton(fourthVar);
                hideButton(fifthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("Tp");
                secondVar.setText("l");
                thirdVar.setText("g");
                break;
            case 13:
                //tf
                hideButton(thirdVar);
                hideButton(fourthVar);
                hideButton(fifthVar);
                hideEditText(hideSecondEditText);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("T");
                secondVar.setText("f");
                break;
            case 14:
                //fgmr
                hideButton(fifthVar);
                hideEditText(hideFourthEditText);
                firstVar.setText("F");
                secondVar.setText("m1");
                thirdVar.setText("m2");
                fourthVar.setText("r");
                break;
            case 15:
                //ugmr
                hideButton(fifthVar);
                hideEditText(hideFourthEditText);
                firstVar.setText("U");
                secondVar.setText("m1");
                thirdVar.setText("m2");
                fourthVar.setText("r");
                break;
        }
    }

    public void onClick(View v) {

        EditText firstValue = (EditText) findViewById(R.id.firstvariable);
        EditText secondValue = (EditText) findViewById(R.id.secondvariable);
        EditText thirdValue = (EditText) findViewById(R.id.thirdvariable);
        EditText fourthValue = (EditText) findViewById(R.id.fourthvariable);

        switch (v.getId())
        {
            case R.id.solve:
                if (omitThirdEditText == 0 && omitFourthEditText == 0 && omitSecondEditText == 0 &&  (firstValue.getText().toString().equals("") ||
                        secondValue.getText().toString().equals("") || thirdValue.getText().toString().equals("") ||
                        fourthValue.getText().toString().equals(""))) {
                    Toast.makeText(this, "You have not entered values for all variables!", Toast.LENGTH_SHORT).show();
                }
                else if (omitThirdEditText == 0 && omitFourthEditText != 0 && omitSecondEditText == 0 && (firstValue.getText().toString().equals("") ||
                        secondValue.getText().toString().equals("") || thirdValue.getText().toString().equals(""))) {
                    Toast.makeText(this, "You have not entered values for all variables!", Toast.LENGTH_SHORT).show();
                }
                else if (omitThirdEditText != 0 && omitFourthEditText != 0 && omitSecondEditText == 0 && (firstValue.getText().toString().equals("") ||
                        secondValue.getText().toString().equals("") )) {
                    Toast.makeText(this, "You have not entered values for all variables!", Toast.LENGTH_SHORT).show();
                }
                else if (omitThirdEditText != 0 && omitFourthEditText != 0 && omitSecondEditText != 0 && (firstValue.getText().toString().equals(""))) {
                    Toast.makeText(this, "You have not entered values for all variables!", Toast.LENGTH_SHORT).show();
                }
                else
                    solve();
                break;
            case R.id.back:
                back();
                break;
            case R.id.Home:
                home();
                break;
        }
    }

    private void switchHandling() {

        final ToggleButton firstVar = (ToggleButton) findViewById(R.id.firstchoice);
        final ToggleButton secondVar = (ToggleButton) findViewById(R.id.secondchoice);
        final ToggleButton thirdVar = (ToggleButton) findViewById(R.id.thirdchoice);
        final ToggleButton fourthVar = (ToggleButton) findViewById(R.id.fourthchoice);
        final ToggleButton fifthVar = (ToggleButton) findViewById(R.id.fifthchoice);

        firstVar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (firstVar.isChecked()) {
                    firstOptionValue = 1;
                    secondOptionValue = 0;
                    thirdOptionValue = 0;
                    fourthOptionValue = 0;
                    fifthOptionValue = 0;
                    secondVar.setChecked(false);
                    thirdVar.setChecked(false);
                    fourthVar.setChecked(false);
                    fifthVar.setChecked(false);
                    setEditTexts();
                } else {
                    firstOptionValue = 0;
                }
            }
        });

        secondVar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (secondVar.isChecked()) {
                    secondOptionValue = 1;
                    firstOptionValue = 0;
                    thirdOptionValue = 0;
                    fourthOptionValue = 0;
                    fifthOptionValue = 0;
                    firstVar.setChecked(false);
                    thirdVar.setChecked(false);
                    fourthVar.setChecked(false);
                    fifthVar.setChecked(false);
                    setEditTexts();
                } else {
                    secondOptionValue = 0;
                }
            }
        });

        thirdVar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (thirdVar.isChecked()) {
                    thirdOptionValue = 1;
                    firstOptionValue = 0;
                    secondOptionValue = 0;
                    fourthOptionValue = 0;
                    fifthOptionValue = 0;
                    firstVar.setChecked(false);
                    secondVar.setChecked(false);
                    fourthVar.setChecked(false);
                    fifthVar.setChecked(false);
                    setEditTexts();
                } else {
                    thirdOptionValue = 0;
                }
            }
        });

        fourthVar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (fourthVar.isChecked()) {
                    fourthOptionValue = 1;
                    firstOptionValue = 0;
                    secondOptionValue = 0;
                    thirdOptionValue = 0;
                    fifthOptionValue = 0;
                    firstVar.setChecked(false);
                    secondVar.setChecked(false);
                    thirdVar.setChecked(false);
                    fifthVar.setChecked(false);
                    setEditTexts();
                } else {
                    fourthOptionValue = 0;
                }
            }
        });

        fifthVar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (fifthVar.isChecked()) {
                    fifthOptionValue = 1;
                    firstOptionValue = 0;
                    secondOptionValue = 0;
                    thirdOptionValue = 0;
                    fourthOptionValue = 0;
                    firstVar.setChecked(false);
                    secondVar.setChecked(false);
                    thirdVar.setChecked(false);
                    fourthVar.setChecked(false);
                    setEditTexts();
                } else {
                    fifthOptionValue = 0;
                }
            }
        });
    }

    private  void setEditTexts() {

        EditText firstValue = (EditText) findViewById(R.id.firstvariable);
        EditText secondValue = (EditText) findViewById(R.id.secondvariable);
        EditText thirdValue = (EditText) findViewById(R.id.thirdvariable);
        EditText fourthValue = (EditText) findViewById(R.id.fourthvariable);
        ToggleButton firstVar = (ToggleButton) findViewById(R.id.firstchoice);
        ToggleButton secondVar = (ToggleButton) findViewById(R.id.secondchoice);
        ToggleButton thirdVar = (ToggleButton) findViewById(R.id.thirdchoice);
        ToggleButton fourthVar = (ToggleButton) findViewById(R.id.fourthchoice);

        firstValue.setText(null);
        secondValue.setText(null);
        thirdValue.setText(null);
        fourthValue.setText(null);

        switch (variablesNeeded)
        {
            case 0:
                //fma
                omitFourthEditText = omitThirdEditText = 1;
                firstVar.setText("F");
                firstVar.setTextOn("F");
                firstVar.setTextOff("F");
                secondVar.setText("m");
                secondVar.setTextOn("m");
                secondVar.setTextOff("m");
                thirdVar.setText("a");
                thirdVar.setTextOn("a");
                thirdVar.setTextOff("a");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.lowerm);
                    secondValue.setHint(R.string.acceleration);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint(R.string.acceleration);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint(R.string.lowerm);
                }
                break;
            case 1:
                //fun
                firstVar.setText("F");
                firstVar.setTextOn("F");
                firstVar.setTextOff("F");
                secondVar.setText("μ");
                secondVar.setTextOn("μ");
                secondVar.setTextOff("μ");
                thirdVar.setText("N");
                thirdVar.setTextOn("N");
                thirdVar.setTextOff("N");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.mu);
                    secondValue.setHint(R.string.bign);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint(R.string.bign);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint(R.string.mu);
                }
                break;
            case 2:
                //trf
                omitFourthEditText = 1;
                firstVar.setText("τ");
                firstVar.setTextOn("τ");
                firstVar.setTextOff("τ");
                secondVar.setText("r");
                secondVar.setTextOn("r");
                secondVar.setTextOff("r");
                thirdVar.setText("F");
                thirdVar.setTextOn("F");
                thirdVar.setTextOff("F");
                fourthVar.setText("θ");
                fourthVar.setTextOn("θ");
                fourthVar.setTextOff("θ");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.lowerr);
                    secondValue.setHint(R.string.force);
                    thirdValue.setHint(R.string.theta);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.tau);
                    secondValue.setHint(R.string.force);
                    thirdValue.setHint(R.string.theta);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.tau);
                    secondValue.setHint(R.string.lowerr);
                    thirdValue.setHint(R.string.theta);
                }
                if (fourthOptionValue == 1){
                    firstValue.setHint(R.string.tau);
                    secondValue.setHint(R.string.lowerr);
                    thirdValue.setHint(R.string.force);
                }
                break;
            case 3:
                //pmv
                omitFourthEditText = 1;
                firstVar.setText("ϕ");
                firstVar.setTextOn("ϕ");
                firstVar.setTextOff("ϕ");
                secondVar.setText("B");
                secondVar.setTextOn("B");
                secondVar.setTextOff("B");
                thirdVar.setText("A");
                thirdVar.setTextOn("A");
                thirdVar.setTextOff("A");
                fourthVar.setText("θ");
                fourthVar.setTextOn("θ");
                fourthVar.setTextOff("θ");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.magneticfield);
                    secondValue.setHint(R.string.area);
                    thirdValue.setHint(R.string.theta);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.phi);
                    secondValue.setHint(R.string.area);
                    thirdValue.setHint(R.string.theta);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.phi);
                    secondValue.setHint(R.string.magneticfield);
                    thirdValue.setHint(R.string.theta);
                }
                if (fourthOptionValue == 1){
                    firstValue.setHint(R.string.phi);
                    secondValue.setHint(R.string.magneticfield);
                    thirdValue.setHint(R.string.area);
                }
                break;
            case 4:
                //jft
                omitFourthEditText = omitThirdEditText = 1;
                firstVar.setText("J");
                firstVar.setTextOn("J");
                firstVar.setTextOff("J");
                secondVar.setText("F");
                secondVar.setTextOn("F");
                secondVar.setTextOff("F");
                thirdVar.setText("Δt");
                thirdVar.setTextOn("Δt");
                thirdVar.setTextOff("Δt");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint(R.string.deltat);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.bigj);
                    secondValue.setHint(R.string.deltat);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.bigj);
                    secondValue.setHint(R.string.force);
                }
                break;
            case 5:
                //kmv
                omitFourthEditText = omitThirdEditText = 1;
                firstVar.setText("K");
                firstVar.setTextOn("K");
                firstVar.setTextOff("K");
                secondVar.setText("m");
                secondVar.setTextOn("m");
                secondVar.setTextOff("m");
                thirdVar.setText("V");
                thirdVar.setTextOn("V");
                thirdVar.setTextOff("V");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.lowerm);
                    secondValue.setHint(R.string.velocity);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.bigk);
                    secondValue.setHint(R.string.velocity);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.bigk);
                    secondValue.setHint(R.string.lowerm);
                }
                break;
            case 6:
                //umgh
                omitFourthEditText = 1;
                firstVar.setText("U");
                firstVar.setTextOn("U");
                firstVar.setTextOff("U");
                secondVar.setText("m");
                secondVar.setTextOn("m");
                secondVar.setTextOff("m");
                thirdVar.setText("g");
                thirdVar.setTextOn("g");
                thirdVar.setTextOff("g");
                fourthVar.setText("h");
                fourthVar.setTextOn("h");
                fourthVar.setTextOff("h");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.lowerm);
                    secondValue.setHint(R.string.lowerg);
                    thirdValue.setHint(R.string.lowerh);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.potentialenergy);
                    secondValue.setHint(R.string.lowerg);
                    thirdValue.setHint(R.string.lowerh);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.potentialenergy);
                    secondValue.setHint(R.string.lowerm);
                    thirdValue.setHint(R.string.lowerh);
                }
                if (fourthOptionValue == 1){
                    firstValue.setHint(R.string.potentialenergy);
                    secondValue.setHint(R.string.lowerm);
                    thirdValue.setHint(R.string.lowerg);
                }
                break;
            case 7:
                //wfr
                omitFourthEditText = 1;
                firstVar.setText("W");
                firstVar.setTextOn("W");
                firstVar.setTextOff("W");
                secondVar.setText("F");
                secondVar.setTextOn("F");
                secondVar.setTextOff("F");
                thirdVar.setText("Δr");
                thirdVar.setTextOn("Δr");
                thirdVar.setTextOff("Δr");
                fourthVar.setText("θ");
                fourthVar.setTextOn("θ");
                fourthVar.setTextOff("θ");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint(R.string.deltar);
                    thirdValue.setHint(R.string.theta);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.work);
                    secondValue.setHint(R.string.deltar);
                    thirdValue.setHint(R.string.theta);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.work);
                    secondValue.setHint(R.string.force);
                    thirdValue.setHint(R.string.theta);
                }
                if (fourthOptionValue == 1){
                    firstValue.setHint(R.string.work);
                    secondValue.setHint(R.string.force);
                    thirdValue.setHint(R.string.deltar);
                }
                break;
            case 8:
                //pwt
                omitFourthEditText = omitThirdEditText = 1;
                firstVar.setText("P");
                firstVar.setTextOn("P");
                firstVar.setTextOff("P");
                secondVar.setText("W");
                secondVar.setTextOn("W");
                secondVar.setTextOff("W");
                thirdVar.setText("Δt");
                thirdVar.setTextOn("Δt");
                thirdVar.setTextOff("Δt");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.work);
                    secondValue.setHint(R.string.deltat);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.power);
                    secondValue.setHint(R.string.deltat);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.power);
                    secondValue.setHint(R.string.work);
                }
                break;
            case 9:
                //pfv
                omitFourthEditText = 1;
                firstVar.setText("P");
                firstVar.setTextOn("P");
                firstVar.setTextOff("P");
                secondVar.setText("F");
                secondVar.setTextOn("F");
                secondVar.setTextOff("F");
                thirdVar.setText("V");
                thirdVar.setTextOn("V");
                thirdVar.setTextOff("V");
                fourthVar.setText("θ");
                fourthVar.setTextOn("θ");
                fourthVar.setTextOff("θ");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint(R.string.velocity);
                    thirdValue.setHint(R.string.theta);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.power);
                    secondValue.setHint(R.string.velocity);
                    thirdValue.setHint(R.string.theta);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.power);
                    secondValue.setHint(R.string.force);
                    thirdValue.setHint(R.string.theta);
                }
                if (fourthOptionValue == 1){
                    firstValue.setHint(R.string.power);
                    secondValue.setHint(R.string.force);
                    thirdValue.setHint(R.string.velocity);
                }
                break;
            case 10:
                //ukx
                omitFourthEditText = omitThirdEditText = 1;
                firstVar.setText("U");
                firstVar.setTextOn("U");
                firstVar.setTextOff("U");
                secondVar.setText("K");
                secondVar.setTextOn("K");
                secondVar.setTextOff("K");
                thirdVar.setText("x");
                thirdVar.setTextOn("x");
                thirdVar.setTextOff("x");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.bigk);
                    secondValue.setHint(R.string.position);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.potentialenergy);
                    secondValue.setHint(R.string.position);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.potentialenergy);
                    secondValue.setHint(R.string.bigk);
                }
                break;
            case 11:
                //tmk
                omitFourthEditText = omitThirdEditText = 1;
                firstVar.setText("Ts");
                firstVar.setTextOn("Ts");
                firstVar.setTextOff("Ts");
                secondVar.setText("m");
                secondVar.setTextOn("m");
                secondVar.setTextOff("m");
                thirdVar.setText("K");
                thirdVar.setTextOn("K");
                thirdVar.setTextOff("K");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.lowerm);
                    secondValue.setHint(R.string.bigk);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.ts);
                    secondValue.setHint(R.string.bigk);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.ts);
                    secondValue.setHint(R.string.lowerm);
                }
                break;
            case 12:
                //tlg
                omitFourthEditText = omitThirdEditText = 1;
                firstVar.setText("Tp");
                firstVar.setTextOn("Tp");
                firstVar.setTextOff("Tp");
                secondVar.setText("l");
                secondVar.setTextOn("l");
                secondVar.setTextOff("l");
                thirdVar.setText("g");
                thirdVar.setTextOn("g");
                thirdVar.setTextOff("g");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.lowerl);
                    secondValue.setHint(R.string.lowerg);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.tp);
                    secondValue.setHint(R.string.lowerg);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.tp);
                    secondValue.setHint(R.string.lowerl);
                }
                break;
            case 13:
                //tf
                omitFourthEditText = omitThirdEditText = omitSecondEditText = 1;
                firstVar.setText("T");
                firstVar.setTextOn("T");
                firstVar.setTextOff("T");
                secondVar.setText("f");
                secondVar.setTextOn("f");
                secondVar.setTextOff("f");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.frequency);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.bigt);
                }
                break;
            case 14:
                //fgmr
                omitFourthEditText = 1;
                firstVar.setText("F");
                firstVar.setTextOn("F");
                firstVar.setTextOff("F");
                secondVar.setText("m1");
                secondVar.setTextOn("m1");
                secondVar.setTextOff("m1");
                thirdVar.setText("m2");
                thirdVar.setTextOn("m2");
                thirdVar.setTextOff("m2");
                fourthVar.setText("r");
                fourthVar.setTextOn("r");
                fourthVar.setTextOff("r");
                if (firstOptionValue == 1){
                    firstValue.setHint("m1");
                    secondValue.setHint("m2");
                    thirdValue.setHint(R.string.lowerr);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint("m2");
                    thirdValue.setHint(R.string.lowerr);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint("m1");
                    thirdValue.setHint(R.string.lowerr);
                }
                if (fourthOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint("m1");
                    thirdValue.setHint("m2");
                }
                break;
            case 15:
                //ugmr
                omitFourthEditText = 1;
                firstVar.setText("U");
                firstVar.setTextOn("U");
                firstVar.setTextOff("U");
                secondVar.setText("m1");
                secondVar.setTextOn("m1");
                secondVar.setTextOff("m1");
                thirdVar.setText("m2");
                thirdVar.setTextOn("m2");
                thirdVar.setTextOff("m2");
                fourthVar.setText("r");
                fourthVar.setTextOn("r");
                fourthVar.setTextOff("r");
                if (firstOptionValue == 1){
                    firstValue.setHint("m1");
                    secondValue.setHint("m2");
                    thirdValue.setHint(R.string.lowerr);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.potentialenergy);
                    secondValue.setHint("m2");
                    thirdValue.setHint(R.string.lowerr);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.potentialenergy);
                    secondValue.setHint("m1");
                    thirdValue.setHint(R.string.lowerr);
                }
                if (fourthOptionValue == 1){
                    firstValue.setHint(R.string.potentialenergy);
                    secondValue.setHint("m1");
                    thirdValue.setHint("m2");
                }
                break;
        }
    }

    private void solve() {

        EditText firstVar = (EditText) findViewById(R.id.firstvariable);
        EditText secondVar = (EditText) findViewById(R.id.secondvariable);
        EditText thirdVar = (EditText) findViewById(R.id.thirdvariable);
        EditText fourthVar = (EditText) findViewById(R.id.fourthvariable);
        float buttonPressed = 0;

        passOne = Float.parseFloat(firstVar.getText().toString());
        if (firstOptionValue == 1){
            buttonPressed = 0;
        }
        else if (secondOptionValue == 1){
            buttonPressed = 1;
        }
        else if (thirdOptionValue == 1){
            buttonPressed = 2;
        }
        else if (fourthOptionValue == 1){
            buttonPressed = 3;
        }
        else if (fifthOptionValue == 1){
            buttonPressed = 4;
        }
        Bundle pass = new Bundle();
        if (omitFourthEditText == 0 && omitThirdEditText == 0 && omitSecondEditText == 0) {
            passTwo = Float.parseFloat(secondVar.getText().toString());
            passThree = Float.parseFloat(thirdVar.getText().toString());
            passFour = Float.parseFloat(fourthVar.getText().toString());
            pass.putFloatArray("keyv",new float[]{variablesNeeded, buttonPressed, passOne, passTwo, passThree, passFour});
            Intent solve = new Intent(getApplicationContext(), MechanicsSolve.class);
            solve.putExtras(pass);
            startActivity(solve);
        }
        else if (omitFourthEditText != 0 && omitThirdEditText == 0 && omitSecondEditText == 0) {
            passTwo = Float.parseFloat(secondVar.getText().toString());
            passThree = Float.parseFloat(thirdVar.getText().toString());
            pass.putFloatArray("keyv",new float[]{variablesNeeded, buttonPressed, passOne, passTwo, passThree});
            Intent solve = new Intent(getApplicationContext(), MechanicsSolve.class);
            solve.putExtras(pass);
            startActivity(solve);
        }
        else if (omitFourthEditText != 0 && omitThirdEditText != 0 && omitSecondEditText == 0){
            passTwo = Float.parseFloat(secondVar.getText().toString());
            pass.putFloatArray("keyv", new float[]{variablesNeeded, buttonPressed, passOne, passTwo});
            Intent solve = new Intent(getApplicationContext(), MechanicsSolve.class);
            solve.putExtras(pass);
            startActivity(solve);
        }
        else if (omitFourthEditText != 0 && omitThirdEditText != 0 && omitSecondEditText != 0){
            pass.putFloatArray("keyv", new float[]{variablesNeeded, buttonPressed, passOne, passTwo});
            Intent solve = new Intent(getApplicationContext(), MechanicsSolve.class);
            solve.putExtras(pass);
            startActivity(solve);
        }
        else {
            pass.putFloatArray("keyv", new float[]{variablesNeeded, buttonPressed, passOne});
            Intent solve = new Intent(getApplicationContext(), MechanicsSolve.class);
            solve.putExtras(pass);
            startActivity(solve);
        }
    }

    private void back() {
        Intent back = new Intent(getApplicationContext(), Mechanics.class);
        startActivity(back);
    }

    private void home() {
        Intent home = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(home);
    }

    private void hideEditText(final EditText element) {

        element.setVisibility(View.GONE);
    }

    private void hideButton(final Button element) {

        element.setVisibility(View.GONE);
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