package hsyen1.symptomsmanagingapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2018-03-31.
 */

public class DataManager {

    private static DataManager ourInstance = null;
    private ArrayList<SymptomsInfo> mSymptoms = new ArrayList<>();
    private ArrayList<SymptomsInfo> mPatientSymptoms = new ArrayList<>();
    private ArrayList<ArrayList<SymptomsInfo>> mDummySymptomLogs = new ArrayList<>();

    private DataManager() {
    }

    public static DataManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new DataManager();
            ourInstance.initializeSymptoms();
            ourInstance.initializeSymptomsLog();
        }
        return ourInstance;
    }

    public void addPatientSymptom(SymptomsInfo symptom) {
        if(!mPatientSymptoms.contains(symptom)) {
            mPatientSymptoms.add(symptom);
        }
    }

    public void addSymptomsLog(ArrayList<SymptomsInfo> symptomsInfoList) {
        mDummySymptomLogs.add(symptomsInfoList);
    }

    public void removePatientSymptom(SymptomsInfo symptom) {
        mPatientSymptoms.remove(symptom);
    }

    public ArrayList<SymptomsInfo> getPatientSymptoms() {
        return mPatientSymptoms;
    }


    public ArrayList<SymptomsInfo> getSymptomsObjects() {
        return mSymptoms;
    }

    public ArrayList<ArrayList<SymptomsInfo>> getSymptomsLog() {
        return mDummySymptomLogs;
    }

    private void initializeSymptomsLog() {
        ArrayList<SymptomsInfo> symptomsList1 = new ArrayList<>();
        ArrayList<SymptomsInfo> symptomsList2 = new ArrayList<>();
        ArrayList<SymptomsInfo> symptomsList3 = new ArrayList<>();

        SymptomsInfo Aneroxia = new SymptomsInfo("2", "Aneroxia", "Medium");
        SymptomsInfo BackPain = new SymptomsInfo("4", "Back Pain", "High");
        SymptomsInfo Fatigue = new SymptomsInfo("15", "Fatigue", "Very High");
        symptomsList1.add(Aneroxia);
        symptomsList1.add(BackPain);
        symptomsList1.add(Fatigue);

        mDummySymptomLogs.add(symptomsList1);

        SymptomsInfo Cough = new SymptomsInfo("9", "Cough", "Medium");
        SymptomsInfo Diarrhea = new SymptomsInfo("10", "Diarrhea", "Low");
        SymptomsInfo Dizziness = new SymptomsInfo("11", "Dizziness", "Low");
        SymptomsInfo DryMouth = new SymptomsInfo("12", "Dry Mouth", "Medium");
        symptomsList2.add(Cough);
        symptomsList2.add(Diarrhea);
        symptomsList2.add(Dizziness);
        symptomsList2.add(DryMouth);


        mDummySymptomLogs.add(symptomsList2);

        SymptomsInfo MucositisOral = new SymptomsInfo("24", "Mucositis Oral", "High");
        SymptomsInfo MuscleCramp = new SymptomsInfo("25", "Muscle Cramp", "Medium");
        SymptomsInfo OralPain = new SymptomsInfo("26", "Oral Pain", "High");
        symptomsList3.add(MucositisOral);
        symptomsList3.add(MuscleCramp);
        symptomsList3.add(OralPain);

        mDummySymptomLogs.add(symptomsList3);
    }

    private void initializeSymptoms() {

        SymptomsInfo Alopecia = new SymptomsInfo("1", "Alopecia", null);
        mSymptoms.add(Alopecia);

        SymptomsInfo Aneroxia = new SymptomsInfo("2", "Aneroxia", null);
        Aneroxia.grade3ImmediateIntervention(true);
        Aneroxia.grade4ImmediateIntervention(true);
        mSymptoms.add(Aneroxia);

        SymptomsInfo Arthralgia = new SymptomsInfo("3", "Arthralgia", null);
        mSymptoms.add(Arthralgia);

        SymptomsInfo BackPain = new SymptomsInfo("4", "Back Pain", null);
        mSymptoms.add(BackPain);

        SymptomsInfo BonePain = new SymptomsInfo("5", "Bone Pain", null);
        mSymptoms.add(BonePain);

        SymptomsInfo ChestWallPain = new SymptomsInfo("6", "Chest Wall Pain", null);
        mSymptoms.add(ChestWallPain);

        SymptomsInfo ConcentrationImpairment = new SymptomsInfo("7", "Concentration Impairment", null);
        mSymptoms.add(ConcentrationImpairment);

        SymptomsInfo Constipation = new SymptomsInfo("8", "Constipation", null);
        Constipation.grade4ImmediateIntervention(true);
        mSymptoms.add(Constipation);

        SymptomsInfo Cough = new SymptomsInfo("9", "Cough", null);
        mSymptoms.add(Cough);

        SymptomsInfo Diarrhea = new SymptomsInfo("10", "Diarrhea", null);
        Diarrhea.grade3ImmediateIntervention(true);
        Diarrhea.grade4ImmediateIntervention(true);
        mSymptoms.add(Diarrhea);

        SymptomsInfo Dizziness = new SymptomsInfo("11", "Dizziness", null);
        mSymptoms.add(Dizziness);

        SymptomsInfo DryMouth = new SymptomsInfo("12", "Dry Mouth", null);
        mSymptoms.add(DryMouth);

        SymptomsInfo Dysphagia = new SymptomsInfo("13", "Dysphagia", null);
        Dysphagia.grade3ImmediateIntervention(true);
        Dysphagia.grade4ImmediateIntervention(true);
        mSymptoms.add(Dysphagia);

        SymptomsInfo Dyspnea = new SymptomsInfo("14", "Dyspnea", null);
        Dyspnea.grade3ImmediateIntervention(true);
        Dyspnea.grade4ImmediateIntervention(true);
        mSymptoms.add(Dyspnea);

        SymptomsInfo Fatigue = new SymptomsInfo("15", "Fatigue", null);
        mSymptoms.add(Fatigue);

        SymptomsInfo Fever = new SymptomsInfo("16", "Fever", null);
        Fever.grade3ImmediateIntervention(true);
        Fever.grade4ImmediateIntervention(true);
        mSymptoms.add(Fever);

        SymptomsInfo Gastritis = new SymptomsInfo("17", "Gastritis", null);
        Fever.grade3ImmediateIntervention(true);
        Fever.grade4ImmediateIntervention(true);
        mSymptoms.add(Gastritis);

        SymptomsInfo GastrointestinalPain = new SymptomsInfo("18", "Gastrointestinal Pain", null);
        mSymptoms.add(GastrointestinalPain);

        SymptomsInfo GeneralizedMuscleWeakness = new SymptomsInfo("19", "Generalized Muscle Weakness", null);
        mSymptoms.add(GeneralizedMuscleWeakness);

        SymptomsInfo GingivalPain = new SymptomsInfo("20", "Gingival Pain", null);
        mSymptoms.add(GingivalPain);

        SymptomsInfo Headache = new SymptomsInfo("21", "Headache", null);
        mSymptoms.add(Headache);

        SymptomsInfo Hiccups = new SymptomsInfo("22", "Hiccups", null);
        //grade 2 medical intervention
        mSymptoms.add(Hiccups);

        SymptomsInfo Malaise = new SymptomsInfo("23", "Malaise", null);
        mSymptoms.add(Malaise);

        SymptomsInfo MucositisOral = new SymptomsInfo("24", "Mucositis Oral", null);
        MucositisOral.grade3ImmediateIntervention(true);
        MucositisOral.grade4ImmediateIntervention(true);
        mSymptoms.add(MucositisOral);

        SymptomsInfo MuscleCramp = new SymptomsInfo("25", "Muscle Cramp", null);
        mSymptoms.add(MuscleCramp);

        SymptomsInfo OralPain = new SymptomsInfo("26", "Oral Pain", null);
        mSymptoms.add(OralPain);

        SymptomsInfo Pain = new SymptomsInfo("27", "Pain", null);
        mSymptoms.add(Pain);

        SymptomsInfo PalmarPlanterErythrodysesthesiaSyndrome = new SymptomsInfo("28", "Palmar-Plantar Erythrodysesthesia Syndrome", null);
        mSymptoms.add(PalmarPlanterErythrodysesthesiaSyndrome);

        SymptomsInfo PeripheralSensoryNeuropathy = new SymptomsInfo("29", "Peripheral Sensory Neuropathy", null);
        PeripheralSensoryNeuropathy.grade4ImmediateIntervention(true);
        mSymptoms.add(PeripheralSensoryNeuropathy);

        SymptomsInfo Pruritus = new SymptomsInfo("30", "Pruritus", null);
        mSymptoms.add(Pruritus);
    }

}
