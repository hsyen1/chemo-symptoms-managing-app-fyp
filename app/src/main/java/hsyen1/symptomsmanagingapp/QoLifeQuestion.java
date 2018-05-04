package hsyen1.symptomsmanagingapp;

public class QoLifeQuestion {

    private int mID = 0;
    private String mQuestion;
    private static final String OPTION_1 = "Not at all";
    private static final String OPTION_2 = "A little";
    private static final String OPTION_3 = "Quite a bit";
    private static final String OPTION_4 = "Very much";

    public QoLifeQuestion(String question) {
        mQuestion = question;
    }

    public void setID(int ID) {
        mID = ID;
    }

    public int getID() {
        return mID;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public String getOption1() {
        return OPTION_1;
    }

    public String getOption2() {
        return OPTION_2;
    }

    public String getOption3() {
        return OPTION_3;
    }

    public String getOption4() {
        return OPTION_4;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

}
