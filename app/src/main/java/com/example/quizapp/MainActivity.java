package com.example.quizapp;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {

    // TODO: Declare member variable

    Button mTrueButton;
    Button mFalseButton;
    TextView mQuestionTextView;
    TextView mScoreBar;
    ProgressBar mProgressBar;
    int mIndex;  //This is tracking which question the user is on
    int mQuestion;
    int mScore;

    private TrueFalse[] mQuestionBank= new TrueFalse[]{
            new TrueFalse(R.string.question_1,true),
            new TrueFalse(R.string.question_2,false),
            new TrueFalse(R.string.question_3,true),
            new TrueFalse(R.string.question_4,true),
            new TrueFalse(R.string.question_5,false),
            new TrueFalse(R.string.question_6,true),
            new TrueFalse(R.string.question_7,false),
            new TrueFalse(R.string.question_8,true),
            new TrueFalse(R.string.question_9,true),
            new TrueFalse(R.string.question_10,false)

    };

    final int PROGRESS_BAR_INCREMENT= 100/ 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton  = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mScoreBar    = findViewById(R.id.initial_score);
        mProgressBar = findViewById(R.id.progressBar);
        mQuestionTextView = findViewById(R.id.question_text_view);
        // TODO:  Store QuestionId
        mQuestion = mQuestionBank[mIndex].getQuestionsID();
        mQuestionTextView.setText(mQuestion);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkAnswer(true);
                updateQuestion();
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkAnswer(false);
                updateQuestion();

            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void updateQuestion(){
        mIndex = (mIndex+1)%mQuestionBank.length;



        if(mIndex == 0){
            //AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over ");
            alert.setCancelable(false);
            alert.setMessage("Your Score " + mScore + " Points !");
            alert.setPositiveButton("Close App", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    finish();
                }
            });
            alert.show();
        }


        mQuestion = mQuestionBank[mIndex].getQuestionsID();
        mQuestionTextView.setText(mQuestion);
        mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        mScoreBar.setText(" Score( "+ mScore +"/"+ mQuestionBank.length+"  )");
    }

    private void checkAnswer(boolean userSelection){
        boolean correctAnswer = mQuestionBank[mIndex].isAnswer();
        if (userSelection==correctAnswer){
            Toast mToast=Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT);
            mToast.setGravity(Gravity.CENTER|Gravity.START,0,0);
            mToast.show();
            mScore = mScore + 1;

        }else
        {
            Toast mToast=Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT);
            mToast.setGravity(Gravity.CENTER|Gravity.END,0,0);
            mToast.show();
        }
    }
}
