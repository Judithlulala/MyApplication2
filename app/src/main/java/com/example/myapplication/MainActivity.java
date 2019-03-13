package com.example.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private static final String EXTRA_ANSWER_IS_TRUE = "com.brada.android.geoquiz.answer_is_true";

    private static final String TAG = "QuizActivity";
    private Button mFalseButton;
    private Button mTrueButton;
    private Button mNextButton;
    private Button mPrevButton;
    private TextView mQuestionTextView;
    private Button mCheatButton;
    private static final int REQUEST_CODE_CHEAT=0;

    private Question[] mQuestionbank = new Question[]{

            new Question(R.string.question_Yoko, true),
            new Question(R.string.question_Subaru, false),
            new Question(R.string.question_Shingo, true),
            new Question(R.string.question_Maru, false),
            new Question(R.string.question_Ryo, false)};
    private int mCurrentINdex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);


        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();

            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentINdex = (mCurrentINdex + 1) % mQuestionbank.length;
                updateQuestion();

            }
        });
        mPrevButton=(Button)findViewById(R.id.prev_button) ;
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentINdex = (mCurrentINdex -1) % mQuestionbank.length;
                updateQuestion();

            }
        });

        mCheatButton=(Button)findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean answerIsTrue= mQuestionbank[mCurrentINdex].ismAnswerTrue();
                Intent intent=CheatActivity.newIntent(MainActivity.this, answerIsTrue);
                intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
                startActivityForResult(intent, REQUEST_CODE_CHEAT);
            }
        });




    }

    private void updateQuestion() {
        int question = mQuestionbank[mCurrentINdex].getmTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue=mQuestionbank[mCurrentINdex].ismAnswerTrue();

        int messageResId=0;
        if(userPressedTrue == answerIsTrue){
            messageResId=R.string.correct_toast;
        }else{
            messageResId=R.string.incorrect_toast;
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();

    }

}


