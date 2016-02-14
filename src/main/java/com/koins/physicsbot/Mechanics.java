package com.koins.physicsbot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Mechanics extends AppCompatActivity implements View.OnClickListener {

    int variableCollector = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mechanics);

        final Button sumForce = (Button) findViewById(R.id.sumforces);
        final Button frictionalForce = (Button) findViewById(R.id.frictionalforce);
        final Button torque = (Button) findViewById(R.id.torque);
        final Button momentum = (Button) findViewById(R.id.momentum);
        final Button impulse = (Button) findViewById(R.id.impulse);
        final Button kineticEnergy = (Button) findViewById(R.id.kineticenergy);
        final Button potentialEnergyEq = (Button) findViewById(R.id.potentialenergyeq);
        final Button workEq = (Button) findViewById(R.id.workeq);
        final Button powerEq = (Button) findViewById(R.id.powereq);
        final Button powerEqTwo = (Button) findViewById(R.id.powereqtwo);
        final Button springPotential = (Button) findViewById(R.id.springpotential);
        final Button springPeriod = (Button) findViewById(R.id.springperiod);
        final Button pendulumPeriod = (Button) findViewById(R.id.pendulumperiod);
        final Button period = (Button) findViewById(R.id.period);
        final Button gravityForce = (Button) findViewById(R.id.gravityforce);
        final Button gravityPotential = (Button) findViewById(R.id.gravitypotential);
        final Button homeButton = (Button) findViewById(R.id.Home);
        sumForce.setOnClickListener(this);
        frictionalForce.setOnClickListener(this);
        torque.setOnClickListener(this);
        momentum.setOnClickListener(this);
        impulse.setOnClickListener(this);
        kineticEnergy.setOnClickListener(this);
        potentialEnergyEq.setOnClickListener(this);
        workEq.setOnClickListener(this);
        powerEq.setOnClickListener(this);
        powerEqTwo.setOnClickListener(this);
        springPotential.setOnClickListener(this);
        springPeriod.setOnClickListener(this);
        pendulumPeriod.setOnClickListener(this);
        period.setOnClickListener(this);
        gravityForce.setOnClickListener(this);
        gravityPotential.setOnClickListener(this);
        homeButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.sumforces:
                variableCollector = 0;
                varCollection();
                break;
            case R.id.frictionalforce:
                variableCollector = 1;
                varCollection();
                break;
            case R.id.torque:
                variableCollector = 2;
                varCollection();
                break;
            case R.id.momentum:
                variableCollector = 3;
                varCollection();
                break;
            case R.id.impulse:
                variableCollector = 4;
                varCollection();
                break;
            case R.id.kineticenergy:
                variableCollector = 5;
                varCollection();
                break;
            case R.id.potentialenergyeq:
                variableCollector = 6;
                varCollection();
                break;
            case R.id.workeq:
                variableCollector = 7;
                varCollection();
                break;
            case R.id.powereq:
                variableCollector = 8;
                varCollection();
                break;
            case R.id.powereqtwo:
                variableCollector = 9;
                varCollection();
                break;
            case R.id.springpotential:
                variableCollector = 10;
                varCollection();
                break;
            case R.id.springperiod:
                variableCollector = 11;
                varCollection();
                break;
            case R.id.pendulumperiod:
                variableCollector = 12;
                varCollection();
                break;
            case R.id.period:
                variableCollector = 13;
                varCollection();
                break;
            case R.id.gravityforce:
                variableCollector = 14;
                varCollection();
                break;
            case R.id.gravitypotential:
                variableCollector = 15;
                varCollection();
                break;
            case R.id.Home:
                goHome();
                break;
        }
    }

    private void varCollection() {
        Bundle pass = new Bundle();
        pass.putIntArray("key", new int[]{variableCollector});
        Intent nextPage = new Intent(getApplicationContext(), FigureOutMechanicsVariable.class);
        nextPage.putExtras(pass);
        startActivity(nextPage);
    }

    private void goHome() {
        Intent home = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(home);
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
