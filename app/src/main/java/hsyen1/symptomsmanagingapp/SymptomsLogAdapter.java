package hsyen1.symptomsmanagingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SymptomsLogAdapter extends ArrayAdapter<SymptomsInfo>{

    private ArrayList<SymptomsInfo> mValues;
    private Context mContext;

    public SymptomsLogAdapter(@NonNull Context context, int resource, ArrayList<SymptomsInfo> values) {
        super(context, resource, values);
        mValues = values;
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = View.inflate(mContext, R.layout.symptomslog_listview_with_subitems, null);
        }

        String symptomName = mValues.get(position).getSymptomsName();
        String severity = mValues.get(position).getSeverity();
        String info = mValues.get(position).getInfo();

        TextView logTexts = convertView.findViewById(R.id.logTexts);
        logTexts.setText(symptomName);
        TextView severityTexts = convertView.findViewById(R.id.severityTexts);
        severityTexts.setText(severity);
        TextView addInfoTexts = convertView.findViewById(R.id.additionalInfoTexts);
        addInfoTexts.setText(info);

        return convertView;
    }
}
