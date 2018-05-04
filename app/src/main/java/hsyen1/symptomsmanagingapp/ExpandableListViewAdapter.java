package hsyen1.symptomsmanagingapp;

import android.content.Context;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hansern on 2018-03-31.
 */

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    private int icon;
    private Context context;
    private String[][] child2 = {{"Low", "Medium", "High", "Very High"}};
    private List<SymptomsInfo> symptomObjects = DataManager.getInstance().getSymptomsObjects();
    private boolean buttonClicked;


    public ExpandableListViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return symptomObjects.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return symptomObjects.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child2[0][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        convertView = View.inflate(context, R.layout.group_layout, null);

        TextView textView = convertView.findViewById(R.id.parentTextView);
        textView.setText(symptomObjects.get(groupPosition).getSymptomsName());

        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        convertView = View.inflate(context, R.layout.child_layout, null);
        RadioButton childItem1 = convertView.findViewById(R.id.childItem1);
        RadioButton childItem2 = convertView.findViewById(R.id.childItem2);
        RadioButton childItem3 = convertView.findViewById(R.id.childItem3);
        RadioButton childItem4 = convertView.findViewById(R.id.childItem4);
        final Button addSymptomsButton = convertView.findViewById(R.id.addSymptomsButton);
        final EditText extraSymptomsInfo = convertView.findViewById(R.id.extraSymptomsInfo);

        addSymptomsButton.setText("Add Symptoms");

        if(symptomObjects.get(groupPosition).getSeverity() == "Low" &&
                DataManager.getInstance().getPatientSymptoms().contains(symptomObjects.get(groupPosition))) {
            childItem1.setChecked(true);
            addSymptomsButton.setText("Remove Symptom");
            extraSymptomsInfo.setText(symptomObjects.get(groupPosition).getInfo());
        } else if(symptomObjects.get(groupPosition).getSeverity() == "Medium" &&
                DataManager.getInstance().getPatientSymptoms().contains(symptomObjects.get(groupPosition))) {
            childItem2.setChecked(true);
            addSymptomsButton.setText("Remove Symptom");
            extraSymptomsInfo.setText(symptomObjects.get(groupPosition).getInfo());
        } else if(symptomObjects.get(groupPosition).getSeverity() == "High" &&
                DataManager.getInstance().getPatientSymptoms().contains(symptomObjects.get(groupPosition))) {
            childItem3.setChecked(true);
            addSymptomsButton.setText("Remove Symptom");
            extraSymptomsInfo.setText(symptomObjects.get(groupPosition).getInfo());
        } else if(symptomObjects.get(groupPosition).getSeverity() == "Very High" &&
                DataManager.getInstance().getPatientSymptoms().contains(symptomObjects.get(groupPosition))){
            childItem4.setChecked(true);
            addSymptomsButton.setText("Remove Symptom");
            extraSymptomsInfo.setText(symptomObjects.get(groupPosition).getInfo());
        }

        childItem1.setText(child2[0][0]);
        childItem2.setText(child2[0][1]);
        childItem3.setText(child2[0][2]);
        childItem4.setText(child2[0][3]);

        addSymptomsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(DataManager.getInstance().getPatientSymptoms().contains(symptomObjects.get(groupPosition))) {
                    DataManager.getInstance().removePatientSymptom(symptomObjects.get(groupPosition));
                    addSymptomsButton.setText("Add Symptom");
                    Toast.makeText(context, symptomObjects.get(groupPosition).getSymptomsName() + " removed", Toast.LENGTH_SHORT).show();
                } else {
                    DataManager.getInstance().addPatientSymptom(symptomObjects.get(groupPosition));
                    if(!TextUtils.isEmpty(extraSymptomsInfo.getText())) {
                        symptomObjects.get(groupPosition).setInfo(extraSymptomsInfo.getText().toString());
                    }
                    addSymptomsButton.setText("Remove Symptom");
                    Toast.makeText(context, symptomObjects.get(groupPosition).getSymptomsName() + " added", Toast.LENGTH_SHORT).show();
                }
            }
        });


        RadioGroup radioGroup = convertView.findViewById(R.id.RGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.childItem1:
                        symptomObjects.get(groupPosition).setSeverity("Low");
                        break;
                    case R.id.childItem2:
                        symptomObjects.get(groupPosition).setSeverity("Medium");
                        break;
                    case R.id.childItem3:
                        symptomObjects.get(groupPosition).setSeverity("High");
                        if(symptomObjects.get(groupPosition).requireForGrade3()) {
                            symptomObjects.get(groupPosition).setIntervention();
                        }
                        break;
                    case R.id.childItem4:
                        symptomObjects.get(groupPosition).setSeverity("Very High");
                        if(symptomObjects.get(groupPosition).requireForGrade4()) {
                            symptomObjects.get(groupPosition).setIntervention();
                        }
                        break;
                }
            }
        });


        return convertView;
    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
