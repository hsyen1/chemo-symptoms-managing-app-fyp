package hsyen1.symptomsmanagingapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;

public class SymptomsListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        displayExpandableSymptoms();
    }


    private void displayExpandableSymptoms() {
        final ExpandableListView expandableSymptomsView = (ExpandableListView) findViewById(R.id.expandableSymptomsList);

        ExpandableListViewAdapter expandableListViewAdapter = new ExpandableListViewAdapter(SymptomsListActivity.this);

        expandableSymptomsView.setAdapter(expandableListViewAdapter);
    }

}
