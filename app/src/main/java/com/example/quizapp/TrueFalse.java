package com.example.quizapp;

public class TrueFalse {

    private int mQuestionsID;
    private boolean mAnswer;

    // Create a constructor

    public TrueFalse(int questionResourceID,boolean trueOrFalse){
        mQuestionsID=questionResourceID;
        mAnswer=trueOrFalse;
    }

    public int getQuestionsID() {
        return mQuestionsID;
    }

    public void setQuestionsID(int questionsID) {
        mQuestionsID = questionsID;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}
