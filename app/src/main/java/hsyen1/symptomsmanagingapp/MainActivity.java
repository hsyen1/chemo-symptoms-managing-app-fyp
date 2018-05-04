package hsyen1.symptomsmanagingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void symptomsClick(View view) {
        Intent symptomsActivityIntent = new Intent(MainActivity.this, SymptomsLogListActivity.class);
        startActivity(symptomsActivityIntent);
    }

    public void QoLifeClick(View view) {
        Intent qoLifeActivityIntent = new Intent(MainActivity.this, QoLifeActivity.class);
        startActivity(qoLifeActivityIntent);
    }

    public void contactAndAlertClick(View view) {

    }
}
