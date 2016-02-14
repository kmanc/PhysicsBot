package com.koins.physicsbot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Magnetism extends AppCompatActivity implements View.OnClickListener {

    int variableCollector = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magnetism);

        final Button fieldForce1 = (Button) findViewById(R.id.fieldforceone);
        final Button fieldForce2 = (Button) findViewById(R.id.fieldforcetwo);
        final Button magneticField = (Button) findViewById(R.id.magneticfield);
        final Button flux = (Button) findViewById(R.id.flux);
        final Button emfaverage = (Button) findViewById(R.id.emfaverage);
        final Button emf = (Button) findViewById(R.id.emf);
        final Button homeButton = (Button) findViewById(R.id.Home);
        fieldForce1.setOnClickListener(this);
        fieldForce2.setOnClickListener(this);
        magneticField.setOnClickListener(this);
        flux.setOnClickListener(this);
        emfaverage.setOnClickListener(this);
        emf.setOnClickListener(this);
        homeButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.fieldforceone:
                variableCollector = 0;
                varCollection();
                break;
            case R.id.fieldforcetwo:
                variableCollector = 1;
                varCollection();
                break;
            case R.id.magneticfield:
                variableCollector = 2;
                varCollection();
                break;
            case R.id.flux:
                variableCollector = 3;
                varCollection();
                break;
            case R.id.emfaverage:
                variableCollector = 4;
                varCollection();
                break;
            case R.id.emf:
                variableCollector = 5;
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
        Intent nextPage = new Intent(getApplicationContext(), FigureOutMagnetismVariable.class);
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
