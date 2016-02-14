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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class FigureOutElectricityVariable extends AppCompatActivity implements View.OnClickListener {

    float passOne = 0;
    float passTwo = 0;
    float passThree = 0;
    float passFour = 0;
    int omitThirdEditText = 0;
    int omitFourthEditText = 0;
    int variablesNeeded = 0;
    int firstOptionValue = 0;
    int secondOptionValue = 0;
    int thirdOptionValue = 0;
    int fourthOptionValue = 0;
    RelativeLayout.LayoutParams layoutFixer = new RelativeLayout.LayoutParams
            (RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figureoutelectricityvariable);
        Bundle receive = this.getIntent().getExtras();
        int[] array = receive.getIntArray("key");
        assert array != null;
        variablesNeeded = array[0];
        ToggleButton firstVar = (ToggleButton) findViewById(R.id.firstchoice);
        ToggleButton secondVar = (ToggleButton) findViewById(R.id.secondchoice);
        ToggleButton thirdVar = (ToggleButton) findViewById(R.id.thirdchoice);
        ToggleButton fourthVar = (ToggleButton) findViewById(R.id.fourthchoice);
        EditText hideThirdEditText = (EditText) findViewById(R.id.thirdvariable);
        EditText hideFourthEditText = (EditText) findViewById(R.id.fourthvariable);
        TextView textFixer = (TextView)findViewById(R.id.title);
        String newTitle = getResources().getString(R.string.fixedtitle);
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
                //resistances
                textFixer.setText(newTitle);
                hideButton(thirdVar);
                hideButton(fourthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("S");
                secondVar.setText("P");
                break;
            case 1:
                //capacitances
                textFixer.setText(newTitle);
                hideButton(thirdVar);
                hideButton(fourthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("S");
                secondVar.setText("P");
                break;
            case 2:
                //vir
                hideButton(fourthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("V");
                secondVar.setText("I");
                thirdVar.setText("R");
                break;
            case 3:
                //piv
                hideButton(fourthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("P");
                secondVar.setText("I");
                thirdVar.setText("V");
                break;
            case 4:
                //cqv
                hideButton(fourthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("C");
                secondVar.setText("Q");
                thirdVar.setText("V");
                break;
            case 5:
                //vkqr
                hideButton(fourthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("V");
                secondVar.setText("q");
                thirdVar.setText("r");
                break;
            case 6:
                //iqt
                hideButton(fourthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("I");
                secondVar.setText("ΔQ");
                thirdVar.setText("Δt");
                break;
            case 7:
                //fkqr
                hideEditText(hideFourthEditText);
                firstVar.setText("F");
                secondVar.setText("q1");
                thirdVar.setText("q2");
                fourthVar.setText("R");
                break;
            case 8:
                //efq
                hideButton(fourthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("E");
                secondVar.setText("F");
                thirdVar.setText("q");
                break;
            case 9:
                //uqv
                hideButton(fourthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("U");
                secondVar.setText("q");
                thirdVar.setText("V");
                break;
            case 10:
                //ukqr
                hideEditText(hideFourthEditText);
                firstVar.setText("U");
                secondVar.setText("q1");
                thirdVar.setText("q2");
                fourthVar.setText("R");
                break;
            case 11:
                //cϵad
                hideButton(fourthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("C");
                secondVar.setText("A");
                thirdVar.setText("d");
                break;
            case 12:
                //rρla
                hideEditText(hideFourthEditText);
                firstVar.setText("R");
                secondVar.setText("ρ");
                thirdVar.setText("l");
                fourthVar.setText("A");
                break;
            case 13:
                //ubigqv
                hideButton(fourthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("U");
                secondVar.setText("Q");
                thirdVar.setText("V");
                break;
            case 14:
                //ucv
                hideButton(fourthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("U");
                secondVar.setText("C");
                thirdVar.setText("V");
                break;
            case 15:
                //evd
                hideButton(fourthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("E");
                secondVar.setText("V");
                thirdVar.setText("d");
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
                if (omitThirdEditText == 0 && omitFourthEditText == 0 && (firstValue.getText().toString().equals("") || secondValue.getText().toString().equals("") ||
                        thirdValue.getText().toString().equals("") || fourthValue.getText().toString().equals(""))) {
                    Toast.makeText(this, "You have not entered values for all variables!", Toast.LENGTH_SHORT).show();
                }
                else if (omitThirdEditText == 0 && omitFourthEditText != 0 && (firstValue.getText().toString().equals("") || secondValue.getText().toString().equals("") ||
                        thirdValue.getText().toString().equals(""))) {
                    Toast.makeText(this, "You have not entered values for all variables!", Toast.LENGTH_SHORT).show();
                }
                else if (omitThirdEditText != 0 && omitFourthEditText != 0 && (firstValue.getText().toString().equals("") || secondValue.getText().toString().equals("") )) {
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

        firstVar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (firstVar.isChecked()) {
                    firstOptionValue = 1;
                    secondOptionValue = 0;
                    thirdOptionValue = 0;
                    fourthOptionValue = 0;
                    secondVar.setChecked(false);
                    thirdVar.setChecked(false);
                    fourthVar.setChecked(false);
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
                    firstVar.setChecked(false);
                    thirdVar.setChecked(false);
                    fourthVar.setChecked(false);
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
                    firstVar.setChecked(false);
                    secondVar.setChecked(false);
                    fourthVar.setChecked(false);
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
                    firstVar.setChecked(false);
                    secondVar.setChecked(false);
                    thirdVar.setChecked(false);
                    setEditTexts();
                } else {
                    fourthOptionValue = 0;
                }
            }
        });
    }

    private  void setEditTexts() {

        EditText firstValue = (EditText) findViewById(R.id.firstvariable);
        EditText secondValue = (EditText) findViewById(R.id.secondvariable);
        EditText thirdValue = (EditText) findViewById(R.id.thirdvariable);
        ToggleButton firstVar = (ToggleButton) findViewById(R.id.firstchoice);
        ToggleButton secondVar = (ToggleButton) findViewById(R.id.secondchoice);
        ToggleButton thirdVar = (ToggleButton) findViewById(R.id.thirdchoice);
        ToggleButton fourthVar = (ToggleButton) findViewById(R.id.fourthchoice);
        TextView textFixer = (TextView)findViewById(R.id.title);
        String newTitle = getResources().getString(R.string.fixedtitle);
        
        firstValue.setText(null);
        secondValue.setText(null);

        switch (variablesNeeded)
        {
            case 0:
                //resistances
                omitFourthEditText = omitThirdEditText = 1;
                textFixer.setText(newTitle);
                firstVar.setText("S");
                firstVar.setTextOn("S");
                firstVar.setTextOff("S");
                secondVar.setText("P");
                secondVar.setTextOn("P");
                secondVar.setTextOff("P");
                layoutFixer.addRule(RelativeLayout.BELOW, firstValue.getId());
                firstValue.setHint("R1");
                layoutFixer.addRule(RelativeLayout.BELOW, secondValue.getId());
                secondValue.setHint("R2");
                break;
            case 1:
                //capacitances
                omitFourthEditText = omitThirdEditText = 1;
                textFixer.setText(newTitle);
                firstVar.setText("S");
                firstVar.setTextOn("S");
                firstVar.setTextOff("S");
                secondVar.setText("P");
                secondVar.setTextOn("P");
                secondVar.setTextOff("P");
                layoutFixer.addRule(RelativeLayout.BELOW, firstValue.getId());
                firstValue.setHint("C1");
                layoutFixer.addRule(RelativeLayout.BELOW, secondValue.getId());
                secondValue.setHint("C2");
                break;
            case 2:
                //vir
                omitFourthEditText = omitThirdEditText = 1;
                firstVar.setText("V");
                firstVar.setTextOn("V");
                firstVar.setTextOff("V");
                secondVar.setText("I");
                secondVar.setTextOn("I");
                secondVar.setTextOff("I");
                thirdVar.setText("R");
                thirdVar.setTextOn("R");
                thirdVar.setTextOff("R");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.current);
                    secondValue.setHint(R.string.resistance);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.voltage);
                    secondValue.setHint(R.string.resistance);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.voltage);
                    secondValue.setHint(R.string.current);
                }
                break;
            case 3:
                //piv
                omitFourthEditText = omitThirdEditText = 1;
                firstVar.setText("P");
                firstVar.setTextOn("P");
                firstVar.setTextOff("P");
                secondVar.setText("I");
                secondVar.setTextOn("I");
                secondVar.setTextOff("I");
                thirdVar.setText("V");
                thirdVar.setTextOn("V");
                thirdVar.setTextOff("V");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.current);
                    secondValue.setHint(R.string.voltage);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.power);
                    secondValue.setHint(R.string.voltage);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.power);
                    secondValue.setHint(R.string.current);
                }
                break;
            case 4:
                //cqv
                omitFourthEditText = omitThirdEditText = 1;
                firstVar.setText("C");
                firstVar.setTextOn("C");
                firstVar.setTextOff("C");
                secondVar.setText("Q");
                secondVar.setTextOn("Q");
                secondVar.setTextOff("Q");
                thirdVar.setText("V");
                thirdVar.setTextOn("V");
                thirdVar.setTextOff("V");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.charge);
                    secondValue.setHint(R.string.voltage);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.capacitance);
                    secondValue.setHint(R.string.voltage);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.capacitance);
                    secondValue.setHint(R.string.charge);
                }
                break;
            case 5:
                //vkqr
                omitFourthEditText = omitThirdEditText = 1;
                firstVar.setText("V");
                firstVar.setTextOn("V");
                firstVar.setTextOff("V");
                secondVar.setText("q");
                secondVar.setTextOn("q");
                secondVar.setTextOff("q");
                thirdVar.setText("r");
                thirdVar.setTextOn("r");
                thirdVar.setTextOff("r");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.pointcharge);
                    secondValue.setHint(R.string.lowerr);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.voltage);
                    secondValue.setHint(R.string.lowerr);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.voltage);
                    secondValue.setHint(R.string.pointcharge);
                }
                break;
            case 6:
                //iqt
                omitFourthEditText = omitThirdEditText = 1;
                firstVar.setText("I");
                firstVar.setTextOn("I");
                firstVar.setTextOff("I");
                secondVar.setText("ΔQ");
                secondVar.setTextOn("ΔQ");
                secondVar.setTextOff("ΔQ");
                thirdVar.setText("Δt");
                thirdVar.setTextOn("Δt");
                thirdVar.setTextOff("Δt");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.deltacharge);
                    secondValue.setHint(R.string.deltat);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.current);
                    secondValue.setHint(R.string.deltat);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.current);
                    secondValue.setHint(R.string.deltacharge);
                }
                break;
            case 7:
                //fkqr
                omitFourthEditText = 1;
                firstVar.setText("F");
                firstVar.setTextOn("F");
                firstVar.setTextOff("F");
                secondVar.setText("q1");
                secondVar.setTextOn("q1");
                secondVar.setTextOff("q1");
                thirdVar.setText("q2");
                thirdVar.setTextOn("q2");
                thirdVar.setTextOff("q2");
                fourthVar.setText("R");
                fourthVar.setTextOn("R");
                fourthVar.setTextOff("R");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.pointchargeone);
                    secondValue.setHint(R.string.pointchargetwo);
                    thirdValue.setHint(R.string.resistance);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint(R.string.pointchargetwo);
                    thirdValue.setHint(R.string.resistance);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint(R.string.pointchargeone);
                    thirdValue.setHint(R.string.resistance);
                }
                if (fourthOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint(R.string.pointchargeone);
                    thirdValue.setHint(R.string.pointchargetwo);
                }
                break;
            case 8:
                //efq
                omitFourthEditText = omitThirdEditText = 1;
                firstVar.setText("E");
                firstVar.setTextOn("E");
                firstVar.setTextOff("E");
                secondVar.setText("F");
                secondVar.setTextOn("F");
                secondVar.setTextOff("F");
                thirdVar.setText("q");
                thirdVar.setTextOn("q");
                thirdVar.setTextOff("q");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint(R.string.pointcharge);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.electricfield);
                    secondValue.setHint(R.string.pointcharge);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.electricfield);
                    secondValue.setHint(R.string.force);
                }
                break;
            case 9:
                //uqv
                omitFourthEditText = omitThirdEditText = 1;
                firstVar.setText("Ue");
                firstVar.setTextOn("Ue");
                firstVar.setTextOff("Ue");
                secondVar.setText("q");
                secondVar.setTextOn("q");
                secondVar.setTextOff("q");
                thirdVar.setText("V");
                thirdVar.setTextOn("V");
                thirdVar.setTextOff("V");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.pointcharge);
                    secondValue.setHint(R.string.voltage);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.potentialenergy);
                    secondValue.setHint(R.string.voltage);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.potentialenergy);
                    secondValue.setHint(R.string.pointcharge);
                }
                break;
            case 10:
                //ukqr
                omitFourthEditText = 1;
                firstVar.setText("Ue");
                firstVar.setTextOn("Ue");
                firstVar.setTextOff("Ue");
                secondVar.setText("q1");
                secondVar.setTextOn("q1");
                secondVar.setTextOff("q1");
                thirdVar.setText("q2");
                thirdVar.setTextOn("q2");
                thirdVar.setTextOff("q2");
                fourthVar.setText("R");
                fourthVar.setTextOn("R");
                fourthVar.setTextOff("R");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.pointchargeone);
                    secondValue.setHint(R.string.pointchargetwo);
                    thirdValue.setHint(R.string.resistance);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.potentialenergy);
                    secondValue.setHint(R.string.pointchargetwo);
                    thirdValue.setHint(R.string.resistance);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.potentialenergy);
                    secondValue.setHint(R.string.pointchargeone);
                    thirdValue.setHint(R.string.resistance);
                }
                if (fourthOptionValue == 1){
                    firstValue.setHint(R.string.potentialenergy);
                    secondValue.setHint(R.string.pointchargeone);
                    thirdValue.setHint(R.string.pointchargetwo);
                }
                break;
            case 11:
                //cϵad
                omitFourthEditText = omitThirdEditText = 1;
                firstVar.setText("C");
                firstVar.setTextOn("C");
                firstVar.setTextOff("C");
                secondVar.setText("A");
                secondVar.setTextOn("A");
                secondVar.setTextOff("A");
                thirdVar.setText("d");
                thirdVar.setTextOn("d");
                thirdVar.setTextOff("d");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.area);
                    secondValue.setHint(R.string.distance);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.capacitance);
                    secondValue.setHint(R.string.distance);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.capacitance);
                    secondValue.setHint(R.string.area);
                }
                break;
            case 12:
                //rρla
                omitFourthEditText = 1;
                firstVar.setText("R");
                firstVar.setTextOn("R");
                firstVar.setTextOff("R");
                secondVar.setText("ρ");
                secondVar.setTextOn("ρ");
                secondVar.setTextOff("ρ");
                thirdVar.setText("l");
                thirdVar.setTextOn("l");
                thirdVar.setTextOff("l");
                fourthVar.setText("A");
                fourthVar.setTextOn("A");
                fourthVar.setTextOff("A");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.resistivity);
                    secondValue.setHint(R.string.lowerl);
                    thirdValue.setHint(R.string.area);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.resistance);
                    secondValue.setHint(R.string.lowerl);
                    thirdValue.setHint(R.string.area);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.resistance);
                    secondValue.setHint(R.string.resistivity);
                    thirdValue.setHint(R.string.area);
                }
                if (fourthOptionValue == 1){
                    firstValue.setHint(R.string.resistance);
                    secondValue.setHint(R.string.resistivity);
                    thirdValue.setHint(R.string.lowerl);
                }
                break;
            case 13:
                //ubigqv
                omitFourthEditText = omitThirdEditText = 1;
                firstVar.setText("Uc");
                firstVar.setTextOn("Uc");
                firstVar.setTextOff("Uc");
                secondVar.setText("Q");
                secondVar.setTextOn("Q");
                secondVar.setTextOff("Q");
                thirdVar.setText("V");
                thirdVar.setTextOn("V");
                thirdVar.setTextOff("V");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.charge);
                    secondValue.setHint(R.string.voltage);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.potentialenergy);
                    secondValue.setHint(R.string.voltage);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.potentialenergy);
                    secondValue.setHint(R.string.charge);
                }
                break;
            case 14:
                //ucv
                omitFourthEditText = omitThirdEditText = 1;
                firstVar.setText("Uc");
                firstVar.setTextOn("Uc");
                firstVar.setTextOff("Uc");
                secondVar.setText("C");
                secondVar.setTextOn("C");
                secondVar.setTextOff("C");
                thirdVar.setText("V");
                thirdVar.setTextOn("V");
                thirdVar.setTextOff("V");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.capacitance);
                    secondValue.setHint(R.string.voltage);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.potentialenergy);
                    secondValue.setHint(R.string.voltage);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.potentialenergy);
                    secondValue.setHint(R.string.charge);
                }
                break;
            case 15:
                //evd
                omitFourthEditText = omitThirdEditText = 1;
                firstVar.setText("E");
                firstVar.setTextOn("E");
                firstVar.setTextOff("E");
                secondVar.setText("V");
                secondVar.setTextOn("V");
                secondVar.setTextOff("V");
                thirdVar.setText("d");
                thirdVar.setTextOn("d");
                thirdVar.setTextOff("d");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.voltage);
                    secondValue.setHint(R.string.distance);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.electricfield);
                    secondValue.setHint(R.string.distance);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.electricfield);
                    secondValue.setHint(R.string.voltage);
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
        passTwo = Float.parseFloat(secondVar.getText().toString());
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
        Bundle pass = new Bundle();
        if (omitFourthEditText == 0 && omitThirdEditText == 0) {
            passThree = Float.parseFloat(thirdVar.getText().toString());
            passFour = Float.parseFloat(fourthVar.getText().toString());
            pass.putFloatArray("keyv",new float[]{variablesNeeded, buttonPressed, passOne, passTwo, passThree, passFour});
            Intent solve = new Intent(getApplicationContext(), ElectricitySolve.class);
            solve.putExtras(pass);
            startActivity(solve);
        }
        else if (omitFourthEditText != 0 && omitThirdEditText == 0) {
            passThree = Float.parseFloat(thirdVar.getText().toString());
            pass.putFloatArray("keyv",new float[]{variablesNeeded, buttonPressed, passOne, passTwo, passThree});
            Intent solve = new Intent(getApplicationContext(), ElectricitySolve.class);
            solve.putExtras(pass);
            startActivity(solve);
        }
        else {
            pass.putFloatArray("keyv", new float[]{variablesNeeded, buttonPressed, passOne, passTwo});
            Intent solve = new Intent(getApplicationContext(), ElectricitySolve.class);
            solve.putExtras(pass);
            startActivity(solve);
        }
    }

    private void back() {
        Intent back = new Intent(getApplicationContext(), Electricity.class);
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


