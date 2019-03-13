package com.example.myapplication;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.content.Context;


public class CheatActivity extends AppCompatActivity {
    private static final String EXTRA_ANSWER_IS_TRUE = "com.brada.android.geoquiz.answer_is_true";
    private boolean mAnswerIsTrue;


    public static Intent newIntent(Context packageContext, boolean answerIsTrue){
        Intent intent=new Intent(packageContext, CheatActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

       mAnswerIsTrue= getIntent().hasExtra(EXTRA_ANSWER_IS_TRUE);
        final TextView answer= (TextView)findViewById(R.id.answer_text_view);


        Button ShowAnwer =(Button)findViewById(R.id.show_answer_button);
        ShowAnwer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String answers=String.valueOf(mAnswerIsTrue);
                answer.setText(answers);

            }
        });

    }
}
