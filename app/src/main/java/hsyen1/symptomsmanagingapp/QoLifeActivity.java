package hsyen1.symptomsmanagingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import hsyen1.symptomsmanagingapp.data.QuestionnaireDbHelper;

public class QoLifeActivity extends AppCompatActivity {

    private ArrayList<QoLifeQuestion> questionList;
    private int mTopID = 0;
    private int mBtmID = 1;

    private QoLifeQuestion currentTopQuestion;
    private QoLifeQuestion currentBtmQuestion;

    private TextView topQuestionTextView;
    private TextView btmQuestionTextView;

    private RadioGroup topRadioGroup;
    private RadioGroup btmRadioGroup;

    private RadioButton topOption1;
    private RadioButton topOption2;
    private RadioButton topOption3;
    private RadioButton topOption4;

    private RadioButton btmOption1;
    private RadioButton btmOption2;
    private RadioButton btmOption3;
    private RadioButton btmOption4;

    private Button backButton;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qo_life);

        QuestionnaireDbHelper dbHelper = new QuestionnaireDbHelper(this);
        questionList = dbHelper.getAllQuestions();

        currentTopQuestion = questionList.get(mTopID);
        currentBtmQuestion = questionList.get(mBtmID);

        topQuestionTextView = findViewById(R.id.topQuestionTextView);
        btmQuestionTextView = findViewById(R.id.bottomQuestionTextView);

        topRadioGroup = findViewById(R.id.topRadioParent);
        btmRadioGroup = findViewById(R.id.bottomRadioParent);

        topOption1 = findViewById(R.id.topOption1);
        topOption2 = findViewById(R.id.topOption2);
        topOption3 = findViewById(R.id.topOption3);
        topOption4 = findViewById(R.id.topOption4);

        btmOption1 = findViewById(R.id.bottomOption1);
        btmOption2 = findViewById(R.id.bottomOption2);
        btmOption3 = findViewById(R.id.bottomOption3);
        btmOption4 = findViewById(R.id.bottomOption4);

        backButton = findViewById(R.id.backButton);
        nextButton = findViewById(R.id.nextButton);

        if(mTopID == 0 && mBtmID == 1) {
            backButton.setVisibility(View.INVISIBLE);
            backButton.setClickable(false);
        } else {
            backButton.setVisibility(View.VISIBLE);
            backButton.setClickable(true);
        }

        setTopQuestionView();
        setBtmQuestionView();
        //nextButton.setOnClickListener();

    }

    private void setTopQuestionView() {
        topQuestionTextView.setText(currentTopQuestion.getQuestion());
        topOption1.setText(currentTopQuestion.getOption1());
        topOption2.setText(currentTopQuestion.getOption2());
        topOption3.setText(currentTopQuestion.getOption3());
        topOption4.setText(currentTopQuestion.getOption4());
        mTopID += 2;
    }

    private void setBtmQuestionView() {
        btmQuestionTextView.setText(currentBtmQuestion.getQuestion());
        btmOption1.setText(currentBtmQuestion.getOption1());
        btmOption2.setText(currentBtmQuestion.getOption2());
        btmOption3.setText(currentBtmQuestion.getOption3());
        btmOption4.setText(currentBtmQuestion.getOption4());
        mBtmID += 2;
    }
}
