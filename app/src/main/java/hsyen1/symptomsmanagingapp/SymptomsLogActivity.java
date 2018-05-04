package hsyen1.symptomsmanagingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SymptomsLogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms_log);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        getSupportActionBar().setTitle(dtf.format(now));

        ListView symptomsLogListView = findViewById(R.id.symptomsLogListView);
        Intent getIntent = getIntent();
        ArrayList<SymptomsInfo> symptoms = getIntent.getParcelableArrayListExtra("SYMPTOMS_INFO_ARRAY");

        SymptomsLogAdapter logAdapter = new SymptomsLogAdapter(SymptomsLogActivity.this, android.R.layout.simple_list_item_2, symptoms);
        symptomsLogListView.setAdapter(logAdapter);

    }
}
