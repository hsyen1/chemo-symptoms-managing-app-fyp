package hsyen1.symptomsmanagingapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import hsyen1.symptomsmanagingapp.QoLifeQuestion;

import static hsyen1.symptomsmanagingapp.data.QuestionnaireContract.Questions.*;

public class QuestionnaireDbHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "QoLifeQuestions";
    private SQLiteDatabase db;

    public QuestionnaireDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        db = sqLiteDatabase;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_OPTION1 + " TEXT, " + KEY_OPTION2 + " TEXT, "
                + KEY_OPTION3 + " TEXT, " + KEY_OPTION4 + " TEXT)";
        db.execSQL(sql);
        initializeQuestions();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);

        onCreate(db);
    }

    public ArrayList<QoLifeQuestion> getAllQuestions() {

        ArrayList<QoLifeQuestion> questionList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_QUEST;

        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()) {
            do {
                QoLifeQuestion question = new QoLifeQuestion("");
                question.setID(cursor.getInt(0));
                question.setQuestion(cursor.getString(1));
                questionList.add(question);
            } while (cursor.moveToNext());
        }

        return questionList;
    }

    public void addQoLifeQuestion(QoLifeQuestion quest) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_QUES, quest.getQuestion());
        contentValues.put(KEY_OPTION1, quest.getOption1());
        contentValues.put(KEY_OPTION2, quest.getOption2());
        contentValues.put(KEY_OPTION3, quest.getOption3());
        contentValues.put(KEY_OPTION4, quest.getOption4());

        db.insert(TABLE_QUEST, null, contentValues);
    }

    private void initializeQuestions() {
        QoLifeQuestion q1 = new QoLifeQuestion("Do you have trouble doing strenuous activities, like carrying a heavy shopping bag or suitcase?");
        this.addQoLifeQuestion(q1);

        QoLifeQuestion q2 = new QoLifeQuestion("Do you have any trouble taking a long walk?");
        this.addQoLifeQuestion(q2);

        QoLifeQuestion q3 = new QoLifeQuestion("Do you have any trouble taking a short walk outside of the house?");
        this.addQoLifeQuestion(q3);

        QoLifeQuestion q4 = new QoLifeQuestion("Do you need to stay in bed or a chair during the day?");
        this.addQoLifeQuestion(q4);

        QoLifeQuestion q5 = new QoLifeQuestion("Do you need help with eating, dressing, washing yourself for using the toilet?");
        this.addQoLifeQuestion(q5);

        QoLifeQuestion q6 = new QoLifeQuestion("Were you limited in doing either your work or other daily activities?");
        this.addQoLifeQuestion(q6);

        QoLifeQuestion q7 = new QoLifeQuestion("Were you limited in pursuing your hobbies or other leisure time activities?");
        this.addQoLifeQuestion(q7);

        QoLifeQuestion q8 = new QoLifeQuestion("Were you short of breath?");
        this.addQoLifeQuestion(q8);

        QoLifeQuestion q9 = new QoLifeQuestion("Have you had pain?");
        this.addQoLifeQuestion(q9);

        QoLifeQuestion q10 = new QoLifeQuestion("Do you need to rest?");
        this.addQoLifeQuestion(q10);

        QoLifeQuestion q11 = new QoLifeQuestion("Have you had trouble sleeping?");
        this.addQoLifeQuestion(q11);

        QoLifeQuestion q12 = new QoLifeQuestion("Have you felt weak?");
        this.addQoLifeQuestion(q12);

        QoLifeQuestion q13 = new QoLifeQuestion("Have you lacked appetite?");
        this.addQoLifeQuestion(q13);

        QoLifeQuestion q14 = new QoLifeQuestion("Have you felt nauseated?");
        this.addQoLifeQuestion(q14);

        QoLifeQuestion q15 = new QoLifeQuestion("Have you vomited?");
        this.addQoLifeQuestion(q15);

        QoLifeQuestion q16 = new QoLifeQuestion("Have you been constipated?");
        this.addQoLifeQuestion(q16);

        QoLifeQuestion q17 = new QoLifeQuestion("Have you had diarrhoea?");
        this.addQoLifeQuestion(q17);

        QoLifeQuestion q18 = new QoLifeQuestion("Were you tired");
        this.addQoLifeQuestion(q18);

        QoLifeQuestion q19 = new QoLifeQuestion("Did pain interfere with your daily activities?");
        this.addQoLifeQuestion(q19);

        QoLifeQuestion q20 = new QoLifeQuestion("Have you had difficulty in concentrating on things, like reading a newspaper or watching television?");
        this.addQoLifeQuestion(q20);

        QoLifeQuestion q21 = new QoLifeQuestion("Did you feel intense?");
        this.addQoLifeQuestion(q21);

        QoLifeQuestion q22 = new QoLifeQuestion("Did you worry?");
        this.addQoLifeQuestion(q22);

        QoLifeQuestion q23 = new QoLifeQuestion("Did you feel irritable?");
        this.addQoLifeQuestion(q23);

        QoLifeQuestion q24 = new QoLifeQuestion("Did you feel depressed?");
        this.addQoLifeQuestion(q24);

        QoLifeQuestion q25 = new QoLifeQuestion("Have you had difficulty remembering things?");
        this.addQoLifeQuestion(q25);

        QoLifeQuestion q26 = new QoLifeQuestion("Has your physical condition or medical treatment interfered with your family life?");
        this.addQoLifeQuestion(q26);

        QoLifeQuestion q27 = new QoLifeQuestion("Has your physical condition or medical treatment interfered with your social activities?");
        this.addQoLifeQuestion(q27);

        QoLifeQuestion q28 = new QoLifeQuestion("Has your physical condition or medical treatment caused you financial difficulties?");
        this.addQoLifeQuestion(q28);
    }
}
