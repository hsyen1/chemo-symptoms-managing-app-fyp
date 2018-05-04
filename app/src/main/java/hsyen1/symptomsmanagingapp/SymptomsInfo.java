package hsyen1.symptomsmanagingapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by admin on 2018-03-30.
 */

public final class SymptomsInfo implements Parcelable {

    private String mSymptomsID;
    private String mName;
    private String mSeverity;
    private String mInfo = "";
    private boolean mIntervention = false;
    private boolean grade3Intervention = false;
    private boolean grade4Intervention = false;

    public SymptomsInfo(String symptomsID, String name, String severity) {
        mSymptomsID = symptomsID;
        mName = name;
        mSeverity = severity;
    }

    protected SymptomsInfo(Parcel in) {
        mSymptomsID = in.readString();
        mName = in.readString();
        mSeverity = in.readString();
        mInfo = in.readString();
        mIntervention = in.readByte() != 0;
        grade3Intervention = in.readByte() != 0;
        grade4Intervention = in.readByte() != 0;
    }

    public static final Parcelable.Creator<SymptomsInfo> CREATOR = new Parcelable.Creator<SymptomsInfo>() {
        @Override
        public SymptomsInfo createFromParcel(Parcel in) {
            return new SymptomsInfo(in);
        }

        @Override
        public SymptomsInfo[] newArray(int size) {
            return new SymptomsInfo[size];
        }
    };

    public void setSymptomsID(String ID) {
        mSymptomsID = ID;
    }

    public String getSymptomsID() {
        return mSymptomsID;
    }

    public void setSymptomsName(String name) {
        mName = name;
    }

    public String getSymptomsName() {
        return mName;
    }

    public void setSeverity(String severity) {
        mSeverity = severity;
    }

    public String getSeverity() {
        return mSeverity;
    }

    public void grade3ImmediateIntervention(boolean x) {
       grade3Intervention = x;
    }

    public void grade4ImmediateIntervention(boolean y) {
        grade4Intervention = y;
    }

   public boolean requireForGrade3() {
       return grade3Intervention;
   }

    public boolean requireForGrade4() {
        return grade4Intervention;
    }

    public void setIntervention() {
        mIntervention = true;
    }

    public boolean requireIntervention() {
        return mIntervention;
    }

    public void setInfo(String info) {
        mInfo = info;
    }

    public String getInfo() {
        return mInfo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mSymptomsID);
        parcel.writeString(mName);
        parcel.writeString(mSeverity);
        parcel.writeString(mInfo);
        parcel.writeByte((byte) (mIntervention ? 1 : 0));
        parcel.writeByte((byte) (grade3Intervention ? 1 : 0));
        parcel.writeByte((byte) (grade4Intervention ? 1 : 0));
    }
}
