package hsyen1.symptomsmanagingapp;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.ListView;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class SymptomsMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms_main);

        displayMainSections();
    }

    private void displayMainSections() {

        final ListView symptomsMainListView = (ListView) findViewById(R.id.symptomsMainList);
        ArrayList<String> symptomsMainPageItems = new ArrayList<>();
        symptomsMainPageItems.add("Add Symptoms");
        symptomsMainPageItems.add("Date & Time");
        symptomsMainPageItems.add("Notes");

        SymptomsMainAdapter symptomsMainAdapter = new SymptomsMainAdapter(SymptomsMainActivity.this, android.R.layout.simple_list_item_2, symptomsMainPageItems);

        symptomsMainListView.setAdapter(symptomsMainAdapter);
    }

    public void onSaveButtonClick(View view) {

        //saveSymptomsObject();

        final AlertDialog alertDialog = new AlertDialog.Builder(SymptomsMainActivity.this).create();
        boolean intervention = false;
        List<SymptomsInfo> patientSymptoms = DataManager.getInstance().getPatientSymptoms();
        for(SymptomsInfo patientSymptom : patientSymptoms) {
            if(patientSymptom.requireIntervention()) {
                intervention = true;
                break;
            }
        }

        if(intervention) {
            alertDialog.setTitle("Symptoms Alert!");
            alertDialog.setMessage("It seems that your symptoms require medical attention. Would you like to alert the assigned contact via WhatsApp or Email?");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Email",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            sendEmailAlert();
                        }
                    });
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "WhatsApp",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            sendTextAlert();
                        }
                    });
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Cancel",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            alertDialog.cancel();
                        }
                    });


        } else {
            alertDialog.setTitle("Congrats");
            alertDialog.setMessage("You still have cancer");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
        }
        alertDialog.show();
    }

    private void sendEmailAlert() {
        String info = "";
        String subject = "Symptoms Alert";

        List<SymptomsInfo> patientSymptomsInfo = DataManager.getInstance().getPatientSymptoms();
        for(SymptomsInfo patientSymptom : patientSymptomsInfo) {
            info += "Symptom: " + patientSymptom.getSymptomsName() + "\n";
            info += "Severity: " + patientSymptom.getSeverity() + "\n";
            info += "Additional Info: " + patientSymptom.getInfo() + "\n\n";
        }

        Intent mailIntent = new Intent(Intent.ACTION_SEND);
        mailIntent.setType("message/rfc2822");
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        mailIntent.putExtra(Intent.EXTRA_TEXT, info);
        startActivity(mailIntent);
    }


    private void sendTextAlert() {
        PackageManager packageManager = getApplicationContext().getPackageManager();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String phone = "0163463337";

        try {
            String url = "https://api.whatsapp.com/send?phone=6" + phone + "&text="
                    + URLEncoder.encode("test123", "UTF-8");
            intent.setPackage("com.whatsapp");
            intent.setData(Uri.parse(url));
            if(intent.resolveActivity(packageManager) != null) {
                getApplicationContext().startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public void saveSymptomsObject() {
        List<SymptomsInfo> patientSymptoms = DataManager.getInstance().getPatientSymptoms();
        List<List<SymptomsInfo>> patientSymptomsLog;

        DataManager.getInstance().addSymptomsLog(patientSymptoms);

        patientSymptomsLog = DataManager.getInstance().getSymptomsLog();

        SharedPreferences symptomsPref = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
        SharedPreferences.Editor symptomsPrefEditor = symptomsPref.edit();
        try {
            Gson gson = new Gson();
            String json = gson.toJson(patientSymptomsLog);
            symptomsPrefEditor.putString("SAVE_SYMPTOMS", json);
            symptomsPrefEditor.apply();
        } catch (Exception e) {

        }

    }*/

}
