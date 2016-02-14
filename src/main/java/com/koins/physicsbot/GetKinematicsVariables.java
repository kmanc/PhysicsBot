package com.koins.physicsbot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GetKinematicsVariables extends AppCompatActivity implements View.OnClickListener {

    float passOne = 0;
    float passTwo = 0;
    float passThree = 0;
    float passFour = 0;
    int omitFourth = 0;
    int variablesNeeded = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getkinematicsvariables);
        Bundle receive = this.getIntent().getExtras();
        int[] array = receive.getIntArray("key");
        assert array != null;
        variablesNeeded = array[0];
        final Button solveButton = (Button) findViewById(R.id.solve);
        final Button backButton = (Button) findViewById(R.id.back);
        final Button homeButton = (Button) findViewById(R.id.Home);
        solveButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);
        EditText firstVar = (EditText)findViewById(R.id.firstvariable);
        EditText secondVar = (EditText)findViewById(R.id.secondvariable);
        EditText thirdVar = (EditText)findViewById(R.id.thirdvariable);
        EditText fourthVar = (EditText)findViewById(R.id.fourthvariable);
        switch (variablesNeeded)
        {
            case 0:
                //vmiasolvevo
                firstVar.setHint(R.string.deltat);
                secondVar.setHint(R.string.initialposition);
                thirdVar.setHint(R.string.position);
                fourthVar.setHint(R.string.acceleration);
                break;
            case 1:
                //vmiasolvet
                firstVar.setHint(R.string.initialvelocity);
                secondVar.setHint(R.string.initialposition);
                thirdVar.setHint(R.string.position);
                fourthVar.setHint(R.string.acceleration);
                break;
            case 2:
                //vmiasolvexo
                firstVar.setHint(R.string.initialvelocity);
                secondVar.setHint(R.string.deltat);
                thirdVar.setHint(R.string.position);
                fourthVar.setHint(R.string.acceleration);
                break;
            case 3:
                //vmiasolvex
                firstVar.setHint(R.string.initialvelocity);
                secondVar.setHint(R.string.deltat);
                thirdVar.setHint(R.string.initialposition);
                fourthVar.setHint(R.string.acceleration);
                break;
            case 4:
                //vmiasolvea
                firstVar.setHint(R.string.initialvelocity);
                secondVar.setHint(R.string.deltat);
                thirdVar.setHint(R.string.initialposition);
                fourthVar.setHint(R.string.position);
                break;
            case 5:
                //vomiasolvev
                firstVar.setHint(R.string.deltat);
                secondVar.setHint(R.string.initialposition);
                thirdVar.setHint(R.string.position);
                fourthVar.setHint(R.string.acceleration);
                break;
            case 6:
                //vomiasolvet
                firstVar.setHint(R.string.velocity);
                secondVar.setHint(R.string.initialposition);
                thirdVar.setHint(R.string.position);
                fourthVar.setHint(R.string.acceleration);
                break;
            case 7:
                //vomiasolvexo
                firstVar.setHint(R.string.velocity);
                secondVar.setHint(R.string.deltat);
                thirdVar.setHint(R.string.position);
                fourthVar.setHint(R.string.acceleration);
                break;
            case 8:
                //vomiasolvex
                firstVar.setHint(R.string.velocity);
                secondVar.setHint(R.string.deltat);
                thirdVar.setHint(R.string.initialposition);
                fourthVar.setHint(R.string.position);
                break;
            case 9:
                //vomiasolvea
                firstVar.setHint(R.string.velocity);
                secondVar.setHint(R.string.deltat);
                thirdVar.setHint(R.string.initialposition);
                fourthVar.setHint(R.string.position);
                break;
            case 10:
                //tmiasolvev
                firstVar.setHint(R.string.initialvelocity);
                secondVar.setHint(R.string.initialposition);
                thirdVar.setHint(R.string.position);
                fourthVar.setHint(R.string.acceleration);
                break;
            case 11:
                //tmiasolvevo
                firstVar.setHint(R.string.velocity);
                secondVar.setHint(R.string.initialposition);
                thirdVar.setHint(R.string.position);
                fourthVar.setHint(R.string.acceleration);
                break;
            case 12:
                //tmiasolvexo
                firstVar.setHint(R.string.velocity);
                secondVar.setHint(R.string.initialvelocity);
                thirdVar.setHint(R.string.position);
                fourthVar.setHint(R.string.acceleration);
                break;
            case 13:
                //tmiasolvex
                firstVar.setHint(R.string.velocity);
                secondVar.setHint(R.string.initialvelocity);
                thirdVar.setHint(R.string.initialposition);
                fourthVar.setHint(R.string.acceleration);
                break;
            case 14:
                //tmiasolvea
                firstVar.setHint(R.string.velocity);
                secondVar.setHint(R.string.initialvelocity);
                thirdVar.setHint(R.string.initialposition);
                fourthVar.setHint(R.string.position);
                break;
            case 15:
                //xmiasolvev
                firstVar.setHint(R.string.initialvelocity);
                secondVar.setHint(R.string.deltat);
                thirdVar.setHint(R.string.acceleration);
                hidefourth(fourthVar);
                break;
            case 16:
                //xmiasolvevo
                firstVar.setHint(R.string.velocity);
                secondVar.setHint(R.string.deltat);
                thirdVar.setHint(R.string.acceleration);
                hidefourth(fourthVar);
                break;
            case 17:
                //xmiasolvet
                firstVar.setHint(R.string.velocity);
                secondVar.setHint(R.string.initialvelocity);
                thirdVar.setHint(R.string.acceleration);
                hidefourth(fourthVar);
                break;
            case 18:
                //xmiasolvea
                firstVar.setHint(R.string.velocity);
                secondVar.setHint(R.string.initialvelocity);
                thirdVar.setHint(R.string.deltat);
                hidefourth (fourthVar);
                break;
            case 19:
                //amiasolvev
                firstVar.setHint(R.string.initialvelocity);
                secondVar.setHint(R.string.deltat);
                thirdVar.setHint(R.string.initialposition);
                fourthVar.setHint(R.string.position);
                break;
            case 20:
                //amiasolvevo
                firstVar.setHint(R.string.velocity);
                secondVar.setHint(R.string.deltat);
                thirdVar.setHint(R.string.initialposition);
                fourthVar.setHint(R.string.position);
                break;
            case 21:
                //amiasolvet
                firstVar.setHint(R.string.velocity);
                secondVar.setHint(R.string.initialvelocity);
                thirdVar.setHint(R.string.initialposition);
                fourthVar.setHint(R.string.position);
                break;
            case 22:
                //amiasolvexo
                firstVar.setHint(R.string.velocity);
                secondVar.setHint(R.string.initialvelocity);
                thirdVar.setHint(R.string.deltat);
                fourthVar.setHint(R.string.position);
                break;
            case 23:
                //amiasolvex
                firstVar.setHint(R.string.velocity);
                secondVar.setHint(R.string.initialvelocity);
                thirdVar.setHint(R.string.deltat);
                fourthVar.setHint(R.string.initialposition);
                break;
        }
    }

    public void onClick(View v) {
        EditText firstVar = (EditText) findViewById(R.id.firstvariable);
        EditText secondVar = (EditText) findViewById(R.id.secondvariable);
        EditText thirdVar = (EditText) findViewById(R.id.thirdvariable);
        EditText fourthVar = (EditText) findViewById(R.id.fourthvariable);
        switch (v.getId())
        {
            case R.id.solve:
                if (omitFourth == 0 && (firstVar.getText().toString().equals("") || secondVar.getText().toString().equals("") ||
                        thirdVar.getText().toString().equals("") || fourthVar.getText().toString().equals(""))) {
                        Toast.makeText(this, "You have not entered values for all variables!", Toast.LENGTH_SHORT).show();
                }
                else if (omitFourth != 0 && (firstVar.getText().toString().equals("") || secondVar.getText().toString().equals("") ||
                        thirdVar.getText().toString().equals(""))) {
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

    private void solve() {
        EditText firstVar = (EditText) findViewById(R.id.firstvariable);
        EditText secondVar = (EditText) findViewById(R.id.secondvariable);
        EditText thirdVar = (EditText) findViewById(R.id.thirdvariable);
        EditText fourthVar = (EditText) findViewById(R.id.fourthvariable);
        passOne = Float.parseFloat(firstVar.getText().toString());
        passTwo = Float.parseFloat(secondVar.getText().toString());
        passThree = Float.parseFloat(thirdVar.getText().toString());
        Bundle pass = new Bundle();
        if (omitFourth == 0) {
            passFour = Float.parseFloat(fourthVar.getText().toString());
            pass.putFloatArray("keyv",new float[]{variablesNeeded, passOne, passTwo, passThree, passFour});
            Intent solve = new Intent(getApplicationContext(), KinematicsSolve.class);
            solve.putExtras(pass);
            startActivity(solve);
        }
        else {
            pass.putFloatArray("keyv", new float[]{variablesNeeded, passOne, passTwo, passThree});
            Intent solve = new Intent(getApplicationContext(), KinematicsSolve.class);
            solve.putExtras(pass);
            startActivity(solve);
        }
    }

    private void back() {
        Intent back = new Intent(getApplicationContext(), Kinematics.class);
        startActivity(back);
    }

    private void home() {
        Intent home = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(home);
    }

    private void hidefourth(final EditText fourthVar) {

        fourthVar.setVisibility(View.GONE);
        omitFourth = 1;
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


