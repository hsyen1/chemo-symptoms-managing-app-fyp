package hsyen1.symptomsmanagingapp.data;

import android.provider.BaseColumns;

public class QuestionnaireContract {

    public static class Questions implements BaseColumns{

        public static final String TABLE_QUEST = "quest";

        public static final String KEY_ID = "id";
        public static final String KEY_QUES = "question";
        public static final String KEY_OPTION1 = "option1";
        public static final String KEY_OPTION2 = "option2";
        public static final String KEY_OPTION3 = "option3";
        public static final String KEY_OPTION4 = "option4";
    }
}
