package com.koins.physicsbot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Kinematics extends AppCompatActivity implements View.OnClickListener {

    int variableCollector = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematics);

        final Button vMiaSolveVo = (Button) findViewById(R.id.vmiasolvevo);
        final Button vMiaSolveT = (Button) findViewById(R.id.vmiasolvet);
        final Button vMiaSolveXo = (Button) findViewById(R.id.vmiasolvexo);
        final Button vMiaSolveX = (Button) findViewById(R.id.vmiasolvex);
        final Button vMiaSolveA = (Button) findViewById(R.id.vmiasolvea);
        final Button voMiaSolveV = (Button) findViewById(R.id.vomiasolvev);
        final Button voMiaSolveT = (Button) findViewById(R.id.vomiasolvet);
        final Button voMiaSolveXo = (Button) findViewById(R.id.vomiasolvexo);
        final Button voMiaSolveX = (Button) findViewById(R.id.vomiasolvex);
        final Button voMiaSolveA = (Button) findViewById(R.id.vomiasolvea);
        final Button tMiaSolveV = (Button) findViewById(R.id.tmiasolvev);
        final Button tMiaSolveVo = (Button) findViewById(R.id.tmiasolvevo);
        final Button tMiaSolveXo = (Button) findViewById(R.id.tmiasolvexo);
        final Button tMiaSolveX = (Button) findViewById(R.id.tmiasolvex);
        final Button tMiaSolveA = (Button) findViewById(R.id.tmiasolvea);
        final Button xMiaSolveV = (Button) findViewById(R.id.xmiasolvev);
        final Button xMiaSolveVo = (Button) findViewById(R.id.xmiasolvevo);
        final Button xMiaSolveT = (Button) findViewById(R.id.xmiasolvet);
        final Button xMiaSolveA = (Button) findViewById(R.id.xmiasolvea);
        final Button aMiaSolveV = (Button) findViewById(R.id.amiasolvev);
        final Button aMiaSolveVo = (Button) findViewById(R.id.amiasolvevo);
        final Button aMiaSolveT = (Button) findViewById(R.id.amiasolvet);
        final Button aMiaSolveXo = (Button) findViewById(R.id.amiasolvexo);
        final Button aMiaSolveX = (Button) findViewById(R.id.amiasolvex);
        final Button homeButton = (Button) findViewById(R.id.Home);
        vMiaSolveVo.setOnClickListener(this);
        vMiaSolveT.setOnClickListener(this);
        vMiaSolveXo.setOnClickListener(this);
        vMiaSolveX.setOnClickListener(this);
        vMiaSolveA.setOnClickListener(this);
        voMiaSolveV.setOnClickListener(this);
        voMiaSolveT.setOnClickListener(this);
        voMiaSolveXo.setOnClickListener(this);
        voMiaSolveX.setOnClickListener(this);
        voMiaSolveA.setOnClickListener(this);
        tMiaSolveV.setOnClickListener(this);
        tMiaSolveVo.setOnClickListener(this);
        tMiaSolveXo.setOnClickListener(this);
        tMiaSolveX.setOnClickListener(this);
        tMiaSolveA.setOnClickListener(this);
        xMiaSolveV.setOnClickListener(this);
        xMiaSolveVo.setOnClickListener(this);
        xMiaSolveT.setOnClickListener(this);
        xMiaSolveA.setOnClickListener(this);
        aMiaSolveV.setOnClickListener(this);
        aMiaSolveVo.setOnClickListener(this);
        aMiaSolveT.setOnClickListener(this);
        aMiaSolveXo.setOnClickListener(this);
        aMiaSolveX.setOnClickListener(this);
        homeButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.vmiasolvevo:
                variableCollector = 0;
                varCollection();
                break;
            case R.id.vmiasolvet:
                variableCollector = 1;
                varCollection();
                break;
            case R.id.vmiasolvexo:
                variableCollector = 2;
                varCollection();
                break;
            case R.id.vmiasolvex:
                variableCollector = 3;
                varCollection();
                break;
            case R.id.vmiasolvea:
                variableCollector = 4;
                varCollection();
                break;
            case R.id.vomiasolvev:
                variableCollector = 5;
                varCollection();
                break;
            case R.id.vomiasolvet:
                variableCollector = 6;
                varCollection();
                break;
            case R.id.vomiasolvexo:
                variableCollector = 7;
                varCollection();
                break;
            case R.id.vomiasolvex:
                variableCollector = 8;
                varCollection();
                break;
            case R.id.vomiasolvea:
                variableCollector = 9;
                varCollection();
                break;
            case R.id.tmiasolvev:
                variableCollector = 10;
                varCollection();
                break;
            case R.id.tmiasolvevo:
                variableCollector = 11;
                varCollection();
                break;
            case R.id.tmiasolvexo:
                variableCollector = 12;
                varCollection();
                break;
            case R.id.tmiasolvex:
                variableCollector = 13;
                varCollection();
                break;
            case R.id.tmiasolvea:
                variableCollector = 14;
                varCollection();
                break;
            case R.id.xmiasolvev:
                variableCollector = 15;
                varCollection();
                break;
            case R.id.xmiasolvevo:
                variableCollector = 16;
                varCollection();
                break;
            case R.id.xmiasolvet:
                variableCollector = 17;
                varCollection();
                break;
            case R.id.xmiasolvea:
                variableCollector = 18;
                varCollection();
                break;
            case R.id.amiasolvev:
                variableCollector = 19;
                varCollection();
                break;
            case R.id.amiasolvevo:
                variableCollector = 20;
                varCollection();
                break;
            case R.id.amiasolvet:
                variableCollector = 21;
                varCollection();
                break;
            case R.id.amiasolvexo:
                variableCollector = 22;
                varCollection();
                break;
            case R.id.amiasolvex:
                variableCollector = 23;
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
        Intent nextPage = new Intent(getApplicationContext(), GetKinematicsVariables.class);
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
