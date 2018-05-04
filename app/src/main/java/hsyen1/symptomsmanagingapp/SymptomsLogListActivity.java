package hsyen1.symptomsmanagingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SymptomsLogListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private ArrayList<ArrayList<SymptomsInfo>> dummySymptoms;
    private ArrayList<ArrayList<SymptomsInfo>> patientSymptomsHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms_log_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent symptomsActivityIntent = new Intent(SymptomsLogListActivity.this, SymptomsMainActivity.class);
                startActivity(symptomsActivityIntent);
            }
        });

        recyclerView = findViewById(R.id.recycler_view);

        ArrayList<SymptomsInfo> patientSymptoms = DataManager.getInstance().getPatientSymptoms();

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        dummySymptoms = DataManager.getInstance().getSymptomsLog();

        if(!DataManager.getInstance().getPatientSymptoms().isEmpty()) {
            DataManager.getInstance().addSymptomsLog(patientSymptoms);
            adapter = new RecyclerAdapterSymptomsLogList(DataManager.getInstance().getSymptomsLog());
        } else {
            adapter = new RecyclerAdapterSymptomsLogList(dummySymptoms);
        }

        recyclerView.setAdapter(adapter);
        //restoreSavedObjects();
    }

    /*private void restoreSavedObjects() {
        recyclerView = findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        dummySymptoms = DataManager.getInstance().getSymptomsLog();

        SharedPreferences symptomsPref = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
        Gson gson = new Gson();
        String json = symptomsPref.getString("SAVE_SYMPTOMS", "");
        if(json.isEmpty()) {
            adapter = new RecyclerAdapterSymptomsLogList(dummySymptoms);
        } else {
            Type type = new TypeToken<List<List<SymptomsInfo>>>() {
            }.getType();
            patientSymptomsHistory = gson.fromJson(json, type);
            adapter = new RecyclerAdapterSymptomsLogList(patientSymptomsHistory);
        }
        recyclerView.setAdapter(adapter);
    }*/

}
