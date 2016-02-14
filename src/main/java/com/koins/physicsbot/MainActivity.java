package com.koins.physicsbot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //test
        final Button mechButton = (Button) findViewById(R.id.Mechanics);
        final Button kinButton = (Button) findViewById(R.id.Kinematics);
        final Button elecButton = (Button) findViewById(R.id.Electricity);
        final Button magButton = (Button) findViewById(R.id.Magnetism);
        final Button directionButton = (Button) findViewById(R.id.Directions);
        final Button exitButton = (Button) findViewById(R.id.Exit);
        mechButton.setOnClickListener(this);
        kinButton.setOnClickListener(this);
        elecButton.setOnClickListener(this);
        magButton.setOnClickListener(this);
        directionButton.setOnClickListener(this);
        exitButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.Mechanics:
                mechSetup();
                break;
            case R.id.Kinematics:
                kinSetup();
                break;
            case R.id.Electricity:
                elecSetup();
                break;
            case R.id.Magnetism:
                magSetup();
                break;
            case R.id.Directions:
                directMe();
                break;
            case R.id.Exit:
                exit();
                break;
        }
    }

    private void mechSetup() {
        Intent mechanics = new Intent(getApplicationContext(), Mechanics.class);
        startActivity(mechanics);
    }

    private void kinSetup() {
        Intent kinematics = new Intent(getApplicationContext(), Kinematics.class);
        startActivity(kinematics);
    }

    private void elecSetup() {
        Intent electricity = new Intent(getApplicationContext(), Electricity.class);
        startActivity(electricity);
    }

    private void magSetup() {
        Intent magnetism = new Intent(getApplicationContext(), Magnetism.class);
        startActivity(magnetism);
    }

    private void directMe() {
        Intent direct = new Intent(getApplicationContext(), Directions.class);
        startActivity(direct);
    }

    private void exit() {
        this.finishAffinity();
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
