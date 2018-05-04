package hsyen1.symptomsmanagingapp;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by admin on 2018-04-02.
 */

public class SymptomsMainAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final ArrayList<String> values;

    public SymptomsMainAdapter(Context context, int resource, ArrayList<String> values) {
        super(context, resource, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.listview_with_subitems, null);
        }

        TextView mainTextView = convertView.findViewById(R.id.parentMainView);
        mainTextView.setText(values.get(position));
        TextView subTextView = convertView.findViewById(R.id.subItemText);

        if(position == 0) {
            subTextView.setText("Alopecia, Aneroxia, Arthralgia...");
            subTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent startAddSymptomsIntent = new Intent(context, SymptomsListActivity.class);
                    context.startActivity(startAddSymptomsIntent);
                }
            });
        } else if (position == 1) {
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date today = Calendar.getInstance().getTime();
            String date = df.format(today);
            subTextView.setText(date);
        } else {
            subTextView.setText("Add your notes here");
        }

        mainTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(position) {
                    case 0:
                        Intent startAddSymptomsIntent = new Intent(context, SymptomsListActivity.class);
                        context.startActivity(startAddSymptomsIntent);
                }
            }

        });
        return convertView;
    }
}
