package hsyen1.symptomsmanagingapp;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class SymptomsLog {

    @SerializedName("mSymptoms")
    private List<SymptomsInfo> mSymptoms;


    private String mDate;
    private String mNotes;

    public SymptomsLog(List<SymptomsInfo> symptoms, String date, String notes) {
        mSymptoms = symptoms;
        mDate = date;
        mNotes = notes;
    }

    public String getDate() {
        return mDate;
    }

    public void addSymptoms(SymptomsInfo symptom) {
        mSymptoms.add(symptom);
    }

    public List<SymptomsInfo> getSymptoms() {
        return mSymptoms;
    }

    public String getNotes() {
        return mNotes;
    }
}
