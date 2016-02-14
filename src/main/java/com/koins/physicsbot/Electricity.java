package com.koins.physicsbot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Electricity extends AppCompatActivity implements View.OnClickListener {

    int variableCollector = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.electricity);

        final Button resistances = (Button) findViewById(R.id.resistances);
        final Button capacitances = (Button) findViewById(R.id.capacitances);
        final Button vir = (Button) findViewById(R.id.vir);
        final Button piv = (Button) findViewById(R.id.piv);
        final Button cqv = (Button) findViewById(R.id.cqv);
        final Button vkqr = (Button) findViewById(R.id.vkqr);
        final Button iqt = (Button) findViewById(R.id.iqt);
        final Button fkqr = (Button) findViewById(R.id.fkqr);
        final Button efq = (Button) findViewById(R.id.efq);
        final Button uqv = (Button) findViewById(R.id.uqv);
        final Button ukqr = (Button) findViewById(R.id.ukqr);
        final Button cϵad = (Button) findViewById(R.id.cϵad);
        final Button rρla = (Button) findViewById(R.id.rρla);
        final Button ubigqv = (Button) findViewById(R.id.ubigqv);
        final Button ucv = (Button) findViewById(R.id.ucv);
        final Button evd = (Button) findViewById(R.id.evd);
        final Button homeButton = (Button) findViewById(R.id.Home);
        homeButton.setOnClickListener(this);
        resistances.setOnClickListener(this);
        capacitances.setOnClickListener(this);
        vir.setOnClickListener(this);
        piv.setOnClickListener(this);
        cqv.setOnClickListener(this);
        vkqr.setOnClickListener(this);
        iqt.setOnClickListener(this);
        fkqr.setOnClickListener(this);
        efq.setOnClickListener(this);
        uqv.setOnClickListener(this);
        ukqr.setOnClickListener(this);
        cϵad.setOnClickListener(this);
        rρla.setOnClickListener(this);
        ubigqv.setOnClickListener(this);
        ucv.setOnClickListener(this);
        evd.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.resistances:
                variableCollector = 0;
                varCollection();
                break;
            case R.id.capacitances:
                variableCollector = 1;
                varCollection();
                break;
            case R.id.vir:
                variableCollector = 2;
                varCollection();
                break;
            case R.id.piv:
                variableCollector = 3;
                varCollection();
                break;
            case R.id.cqv:
                variableCollector = 4;
                varCollection();
                break;
            case R.id.vkqr:
                variableCollector = 5;
                varCollection();
                break;
            case R.id.iqt:
                variableCollector = 6;
                varCollection();
                break;
            case R.id.fkqr:
                variableCollector = 7;
                varCollection();
                break;
            case R.id.efq:
                variableCollector = 8;
                varCollection();
                break;
            case R.id.uqv:
                variableCollector = 9;
                varCollection();
                break;
            case R.id.ukqr:
                variableCollector = 10;
                varCollection();
                break;
            case R.id.cϵad:
                variableCollector = 11;
                varCollection();
                break;
            case R.id.rρla:
                variableCollector = 12;
                varCollection();
                break;
            case R.id.ubigqv:
                variableCollector = 13;
                varCollection();
                break;
            case R.id.ucv:
                variableCollector = 14;
                varCollection();
                break;
            case R.id.evd:
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
        Intent nextPage = new Intent(getApplicationContext(), FigureOutElectricityVariable.class);
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
