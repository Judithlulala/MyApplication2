package com.example.myapplication;

public class Question {
    private int mTextResId;
    private boolean mAnswerTrue;



    public Question(int TextResId, boolean answerTrue){
        mTextResId=TextResId;
        mAnswerTrue=answerTrue;

    }
    public int getmTextResId() {
        return mTextResId;
    }

    public boolean ismAnswerTrue() {
        return mAnswerTrue;
    }

    public void setmTextResId(int mTextResId) {
        this.mTextResId = mTextResId;
    }

    public void setmAnswerTrue(boolean mAnswerTrue) {
        this.mAnswerTrue = mAnswerTrue;
    }
}
