package hsyen1.symptomsmanagingapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapterSymptomsLogList extends RecyclerView.Adapter<RecyclerAdapterSymptomsLogList.ViewHolder> {

    private ArrayList<ArrayList<SymptomsInfo>> mPatientsSymptomsHistory;


    public RecyclerAdapterSymptomsLogList(ArrayList<ArrayList<SymptomsInfo>> patientsSymptomsHistory) {
        mPatientsSymptomsHistory = patientsSymptomsHistory;
    }

    @Override
    public RecyclerAdapterSymptomsLogList.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_symptoms_log_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapterSymptomsLogList.ViewHolder holder, final int position) {

        SymptomsInfo symptom1;
        SymptomsInfo symptom2;
        SymptomsInfo symptom3;

        String displaySymptomText1;
        String displaySymptomText2;
        String displaySymptomText3;

        symptom1 = mPatientsSymptomsHistory.get(position).get(0);
        symptom2 = mPatientsSymptomsHistory.get(position).get(1);
        symptom3 = mPatientsSymptomsHistory.get(position).get(2);

        displaySymptomText1 = symptom1.getSymptomsName();
        displaySymptomText2 = symptom2.getSymptomsName();
        displaySymptomText3 = symptom3.getSymptomsName();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        holder.dateLogTextView.setText(dtf.format(now));
        holder.symptomsLogTextView.setText(displaySymptomText1 + ", " + displaySymptomText2 + ", " + displaySymptomText3 + "...");
        holder.additionalNoteTextView.setText("");
        final ArrayList<SymptomsInfo> symptoms = mPatientsSymptomsHistory.get(position);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent symptomsLogIntent = new Intent(holder.context, SymptomsLogActivity.class);
                symptomsLogIntent.putParcelableArrayListExtra("SYMPTOMS_INFO_ARRAY", symptoms);
                holder.context.startActivity(symptomsLogIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPatientsSymptomsHistory.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View itemView;
        public TextView dateLogTextView;
        public TextView symptomsLogTextView;
        public TextView additionalNoteTextView;
        public RelativeLayout relativeLayout;
        public Context context;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            dateLogTextView = itemView.findViewById(R.id.dateLogTextView);
            symptomsLogTextView = itemView.findViewById(R.id.symptomsLogTextView);
            additionalNoteTextView = itemView.findViewById(R.id.additionalNoteLogTextView);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
            context = itemView.getContext();
        }
    }
}
