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

public class FigureOutMagnetismVariable extends AppCompatActivity implements View.OnClickListener {

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
    int fifthOptionValue = 0;
    RelativeLayout.LayoutParams layoutFixer = new RelativeLayout.LayoutParams
            (RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figureoutmagnetismvariable);
        Bundle receive = this.getIntent().getExtras();
        int[] array = receive.getIntArray("key");
        assert array != null;
        variablesNeeded = array[0];
        ToggleButton firstVar = (ToggleButton) findViewById(R.id.firstchoice);
        ToggleButton secondVar = (ToggleButton) findViewById(R.id.secondchoice);
        ToggleButton thirdVar = (ToggleButton) findViewById(R.id.thirdchoice);
        ToggleButton fourthVar = (ToggleButton) findViewById(R.id.fourthchoice);
        ToggleButton fifthVar = (ToggleButton) findViewById(R.id.fifthchoice);
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
                //fqvb
                firstVar.setText("F");
                secondVar.setText("q");
                thirdVar.setText("v");
                fourthVar.setText("B");
                fifthVar.setText("θ");
                break;
            case 1:
                //fbil
                firstVar.setText("F");
                secondVar.setText("B");
                thirdVar.setText("I");
                fourthVar.setText("l");
                fifthVar.setText("θ");
                break;
            case 2:
                //bir
                hideButton(fourthVar);
                hideButton(fifthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("B");
                secondVar.setText("I");
                thirdVar.setText("r");
                break;
            case 3:
                //oba
                hideButton(fifthVar);
                hideEditText(hideFourthEditText);
                firstVar.setText("ϕ");
                secondVar.setText("B");
                thirdVar.setText("A");
                fourthVar.setText("θ");
                break;
            case 4:
                //eot
                hideButton(fourthVar);
                hideButton(fifthVar);
                hideEditText(hideThirdEditText);
                hideEditText(hideFourthEditText);
                firstVar.setText("ϵ");
                secondVar.setText("Δϕ");
                thirdVar.setText("Δt");
                break;
            case 5:
                //eblv
                hideEditText(hideFourthEditText);
                hideButton(fifthVar);
                firstVar.setText("ϵ");
                secondVar.setText("B");
                thirdVar.setText("l");
                fourthVar.setText("v");
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
        ToggleButton fifthVar = (ToggleButton) findViewById(R.id.fifthchoice);
        TextView textFixer = (TextView)findViewById(R.id.title);
        String newTitle = getResources().getString(R.string.fixedtitle);

        firstValue.setText(null);
        secondValue.setText(null);
        thirdValue.setText(null);
        fourthValue.setText(null);

        switch (variablesNeeded)
        {
            case 0:
                //fqvb
                textFixer.setText(newTitle);
                firstVar.setText("F");
                firstVar.setTextOn("F");
                firstVar.setTextOff("F");
                secondVar.setText("q");
                secondVar.setTextOn("q");
                secondVar.setTextOff("q");
                thirdVar.setText("v");
                thirdVar.setTextOn("v");
                thirdVar.setTextOff("v");
                fourthVar.setText("B");
                fourthVar.setTextOn("B");
                fourthVar.setTextOff("B");
                fifthVar.setText("θ");
                fifthVar.setTextOn("θ");
                fifthVar.setTextOff("θ");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.pointcharge);
                    secondValue.setHint(R.string.velocity);
                    thirdValue.setHint(R.string.magneticfield);
                    fourthValue.setHint(R.string.theta);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint(R.string.velocity);
                    thirdValue.setHint(R.string.magneticfield);
                    fourthValue.setHint(R.string.theta);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint(R.string.pointcharge);
                    thirdValue.setHint(R.string.magneticfield);
                    fourthValue.setHint(R.string.theta);
                }
                if (fourthOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint(R.string.pointcharge);
                    thirdValue.setHint(R.string.velocity);
                    fourthValue.setHint(R.string.theta);
                }
                if (fifthOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint(R.string.pointcharge);
                    thirdValue.setHint(R.string.velocity);
                    fourthValue.setHint(R.string.magneticfield);
                }
                break;
            case 1:
                //fbil
                textFixer.setText(newTitle);
                firstVar.setText("F");
                firstVar.setTextOn("F");
                firstVar.setTextOff("F");
                secondVar.setText("B");
                secondVar.setTextOn("B");
                secondVar.setTextOff("B");
                thirdVar.setText("I");
                thirdVar.setTextOn("I");
                thirdVar.setTextOff("I");
                fourthVar.setText("l");
                fourthVar.setTextOn("l");
                fourthVar.setTextOff("l");
                fifthVar.setText("θ");
                fifthVar.setTextOn("θ");
                fifthVar.setTextOff("θ");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.magneticfield);
                    secondValue.setHint(R.string.current);
                    thirdValue.setHint(R.string.lowerl);
                    fourthValue.setHint(R.string.theta);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint(R.string.current);
                    thirdValue.setHint(R.string.lowerl);
                    fourthValue.setHint(R.string.theta);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint(R.string.magneticfield);
                    thirdValue.setHint(R.string.lowerl);
                    fourthValue.setHint(R.string.theta);
                }
                if (fourthOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint(R.string.magneticfield);
                    thirdValue.setHint(R.string.current);
                    fourthValue.setHint(R.string.theta);
                }
                if (fifthOptionValue == 1){
                    firstValue.setHint(R.string.force);
                    secondValue.setHint(R.string.magneticfield);
                    thirdValue.setHint(R.string.current);
                    fourthValue.setHint(R.string.lowerl);
                }
                break;
            case 2:
                //bir
                omitFourthEditText = omitThirdEditText = 1;
                firstVar.setText("B");
                firstVar.setTextOn("B");
                firstVar.setTextOff("B");
                secondVar.setText("I");
                secondVar.setTextOn("I");
                secondVar.setTextOff("I");
                thirdVar.setText("r");
                thirdVar.setTextOn("r");
                thirdVar.setTextOff("r");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.current);
                    secondValue.setHint(R.string.lowerr);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.magneticfield);
                    secondValue.setHint(R.string.lowerr);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.magneticfield);
                    secondValue.setHint(R.string.current);
                }
                break;
            case 3:
                //oba
                omitFourthEditText = omitThirdEditText = 1;
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
                //eot
                omitFourthEditText = omitThirdEditText = 1;
                firstVar.setText("ϵ");
                firstVar.setTextOn("ϵ");
                firstVar.setTextOff("ϵ");
                secondVar.setText("Δϕ");
                secondVar.setTextOn("Δϕ");
                secondVar.setTextOff("Δϕ");
                thirdVar.setText("Δt");
                thirdVar.setTextOn("Δt");
                thirdVar.setTextOff("Δt");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.deltaphi);
                    secondValue.setHint(R.string.deltat);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.epsilon);
                    secondValue.setHint(R.string.deltat);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.epsilon);
                    secondValue.setHint(R.string.deltaphi);
                }
                break;
            case 5:
                //eblv
                omitFourthEditText = 1;
                firstVar.setText("ϵ");
                firstVar.setTextOn("ϵ");
                firstVar.setTextOff("ϵ");
                secondVar.setText("B");
                secondVar.setTextOn("B");
                secondVar.setTextOff("B");
                thirdVar.setText("l");
                thirdVar.setTextOn("l");
                thirdVar.setTextOff("l");
                fourthVar.setText("v");
                fourthVar.setTextOn("v");
                fourthVar.setTextOff("v");
                if (firstOptionValue == 1){
                    firstValue.setHint(R.string.magneticfield);
                    secondValue.setHint(R.string.lowerl);
                    thirdValue.setHint(R.string.velocity);
                }
                if (secondOptionValue == 1){
                    firstValue.setHint(R.string.epsilon);
                    secondValue.setHint(R.string.lowerl);
                    thirdValue.setHint(R.string.velocity);
                }
                if (thirdOptionValue == 1){
                    firstValue.setHint(R.string.epsilon);
                    secondValue.setHint(R.string.magneticfield);
                    thirdValue.setHint(R.string.velocity);
                }
                if (fourthOptionValue == 1){
                    firstValue.setHint(R.string.epsilon);
                    secondValue.setHint(R.string.magneticfield);
                    thirdValue.setHint(R.string.lowerl);
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
        else if (fifthOptionValue == 1){
            buttonPressed = 4;
        }
        Bundle pass = new Bundle();
        if (omitFourthEditText == 0 && omitThirdEditText == 0) {
            passThree = Float.parseFloat(thirdVar.getText().toString());
            passFour = Float.parseFloat(fourthVar.getText().toString());
            pass.putFloatArray("keyv",new float[]{variablesNeeded, buttonPressed, passOne, passTwo, passThree, passFour});
            Intent solve = new Intent(getApplicationContext(), MagnetismSolve.class);
            solve.putExtras(pass);
            startActivity(solve);
        }
        else if (omitFourthEditText != 0 && omitThirdEditText == 0) {
            passThree = Float.parseFloat(thirdVar.getText().toString());
            pass.putFloatArray("keyv",new float[]{variablesNeeded, buttonPressed, passOne, passTwo, passThree});
            Intent solve = new Intent(getApplicationContext(), MagnetismSolve.class);
            solve.putExtras(pass);
            startActivity(solve);
        }
        else {
            pass.putFloatArray("keyv", new float[]{variablesNeeded, buttonPressed, passOne, passTwo});
            Intent solve = new Intent(getApplicationContext(), MagnetismSolve.class);
            solve.putExtras(pass);
            startActivity(solve);
        }
    }

    private void back() {
        Intent back = new Intent(getApplicationContext(), Magnetism.class);
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