package com.example.admin.explor_the_world;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Play extends AppCompatActivity {

    private RadioGroup rg;
    private RadioButton Answer1, Answer2, Answer3, Answer4;
    private Button Pass, Back;
    private TextView Question_Tv, MarksTv, PassTv,Ques_number, No_Passes, Pass_Name;
    private ImageView Star;

    private MediaPlayer BackGroundSound;
    private QuestionsScience mQuestions = new QuestionsScience();

    private String mAnswer;
    private int mQuestionNumber = mQuestions.mQuestions.length;

    Random random;

    int k = 1;

    private long PressBack;
    private Toast backToast;

    private Animation Rotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.question_activity);

        BackGroundSound = MediaPlayer.create(this, R.raw.bgm3);
        BackGroundSound.start();

        random = new Random();

        Pass = (Button) findViewById(R.id.pass_btn);
        Back = (Button)findViewById(R.id.btn_Back);

        Question_Tv = (TextView) findViewById(R.id.Ques_tv);
        MarksTv = (TextView) findViewById(R.id.marks_tv);
        PassTv = (TextView) findViewById(R.id.pass_tv);
        Ques_number = (TextView)findViewById(R.id.q_number);
        No_Passes = (TextView)findViewById(R.id.no_pass);
        Pass_Name = (TextView)findViewById(R.id.Pass_name);


        Ques_number.setText(k + "of 10");

        rg = (RadioGroup) findViewById(R.id.radioGroup);
        Answer1 = (RadioButton)findViewById(R.id.R1);
        Answer2 = (RadioButton)findViewById(R.id.R2);
        Answer3 = (RadioButton)findViewById(R.id.R3);
        Answer4 = (RadioButton)findViewById(R.id.R4);

        updateQuestion(random.nextInt(mQuestionNumber));


        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Play.this, Game.class));
                BackGroundSound.pause();
                finish();
            }
        });


        Pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PassTv.getText().equals("0")) {

                    Pass_Name.setVisibility(View.INVISIBLE);
                    PassTv.setVisibility(View.INVISIBLE);
                    Pass.setVisibility(View.INVISIBLE);
                    No_Passes.setVisibility(View.VISIBLE);

                } else {
                    try {

                        int va1 = Integer.parseInt((String) PassTv.getText());
                        int tot = va1 - 1;
                        PassTv.setText(String.valueOf(tot));

                        updateQuestion(random.nextInt(mQuestionNumber));
                        Ques_number.setText(k + "/10");

                    } catch (Exception ex) {

                    }
                }
            }
        });

    }

    //////////////////////////////////////////////////////////////////////
    private void updateQuestion(int i) {

        Question_Tv.setText(mQuestions.getQuestion(i));
        Answer1.setText(mQuestions.getChoice1(i));
        Answer2.setText(mQuestions.getChoice2(i));
        Answer3.setText(mQuestions.getChoice3(i));
        Answer4.setText(mQuestions.getChoice4(i));

        mAnswer = mQuestions.getCorrectAnswer(i);

    }
//////////////////////////////////////////////////////////////////////

    //answer btns
    public void checkBtn(View v) {
        int radioId = rg.getCheckedRadioButtonId();
        Answer1 = (RadioButton) findViewById(radioId);


        if (Answer1.getText() == mAnswer) {
            try {

                int va1 = Integer.parseInt((String) MarksTv.getText());
                int tot = va1 + 10;
                MarksTv.setText(String.valueOf(tot));

            } catch (Exception ex) {
            }

            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();

            //////////////////////////ques no.
            k++;
            Ques_number.setText(k + "/10");
            if (k==10){
                startActivity(new Intent(Play.this,LastActivity1.class));
                BackGroundSound.pause();
                finish();
            }

            updateQuestion(random.nextInt(mQuestionNumber));

        } else {
            if (MarksTv.getText().equals("0")) {
                updateQuestion(random.nextInt(mQuestionNumber));

                Answer1.setChecked(false);
                Answer2.setChecked(false);
                Answer3.setChecked(false);
                Answer4.setChecked(false);

                k++;
                Ques_number.setText(k + "/10");
                if (k==10){
                    startActivity(new Intent(Play.this,LastActivity1.class));
                    BackGroundSound.pause();
                    finish();
                }

            } else {
                try {

                    int va1 = Integer.parseInt((String) MarksTv.getText());
                    int tot = va1 - 10;
                    MarksTv.setText(String.valueOf(tot));

                } catch (Exception ex) {
                }
                updateQuestion(random.nextInt(mQuestionNumber));

                Answer1.setChecked(false);
                Answer2.setChecked(false);
                Answer3.setChecked(false);
                Answer4.setChecked(false);

                k++;
                Ques_number.setText(k + "/10");
                if (k==10){
                    startActivity(new Intent(Play.this,LastActivity1.class));
                    BackGroundSound.pause();
                    finish();
                }

            }

            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();


        }


    }


    public void checkBtn2(View v) {
        int radioId = rg.getCheckedRadioButtonId();
        Answer2 = (RadioButton) findViewById(radioId);

        if (Answer2.getText() == mAnswer) {
            try {

                int va1 = Integer.parseInt((String) MarksTv.getText());
                int tot = va1 + 10;
                MarksTv.setText(String.valueOf(tot));

            } catch (Exception ex) {
            }

            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();


            updateQuestion(random.nextInt(mQuestionNumber));

            //////////////////////////ques no.
            k++;
            Ques_number.setText(k + "/10");
            if (k==10){
                startActivity(new Intent(Play.this,LastActivity1.class));
                BackGroundSound.pause();
                finish();
            }
            else {
            }

            updateQuestion(random.nextInt(mQuestionNumber));

        } else {
            if (MarksTv.getText().equals("0")) {

                updateQuestion(random.nextInt(mQuestionNumber));

                Answer1.setChecked(false);
                Answer2.setChecked(false);
                Answer3.setChecked(false);
                Answer4.setChecked(false);

                k++;
                Ques_number.setText(k + "/10");
                if (k==10){
                    startActivity(new Intent(Play.this,LastActivity1.class));
                    BackGroundSound.pause();
                    finish();
                }

            } else {
                try {

                    int va1 = Integer.parseInt((String) MarksTv.getText());
                    int tot = va1 - 10;
                    MarksTv.setText(String.valueOf(tot));

                } catch (Exception ex) {
                }

                updateQuestion(random.nextInt(mQuestionNumber));

                Answer1.setChecked(false);
                Answer2.setChecked(false);
                Answer3.setChecked(false);
                Answer4.setChecked(false);

                k++;
                Ques_number.setText(k + "/10");
                if (k==10){
                    startActivity(new Intent(Play.this,LastActivity1.class));
                    BackGroundSound.pause();
                    finish();
                }

            }
            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
        }
    }


    public void checkBtn3(View v) {
        int radioId = rg.getCheckedRadioButtonId();
        Answer3 = (RadioButton) findViewById(radioId);

        if (Answer3.getText() == mAnswer) {
            try {

                int va1 = Integer.parseInt((String) MarksTv.getText());
                int tot = va1 + 10;
                MarksTv.setText(String.valueOf(tot));

            } catch (Exception ex) {
            }

            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();

            updateQuestion(random.nextInt(mQuestionNumber));

            //////////////////////////ques no.

            Answer1.setChecked(false);
            Answer2.setChecked(false);
            Answer3.setChecked(false);
            Answer4.setChecked(false);

            k++;
            Ques_number.setText(k + "/10");
            if (k==10){
                startActivity(new Intent(Play.this,LastActivity1.class));
                BackGroundSound.pause();
                finish();
            }
            else {
            }

            updateQuestion(random.nextInt(mQuestionNumber));

        } else {
            if (MarksTv.getText().equals("0")) {

                updateQuestion(random.nextInt(mQuestionNumber));

                Answer1.setChecked(false);
                Answer2.setChecked(false);
                Answer3.setChecked(false);
                Answer4.setChecked(false);

                k++;
                Ques_number.setText(k + "/10");
                if (k==10){
                    startActivity(new Intent(Play.this,LastActivity1.class));
                    BackGroundSound.pause();
                    finish();
                }


            } else {
                try {

                    int va1 = Integer.parseInt((String) MarksTv.getText());
                    int tot = va1 - 10;
                    MarksTv.setText(String.valueOf(tot));

                } catch (Exception ex) {
                }

                updateQuestion(random.nextInt(mQuestionNumber));

                Answer1.setChecked(false);
                Answer2.setChecked(false);
                Answer3.setChecked(false);
                Answer4.setChecked(false);

                k++;
                Ques_number.setText(k + "/10");
                if (k==10){
                    startActivity(new Intent(Play.this,LastActivity1.class));
                    BackGroundSound.pause();
                    finish();
                }
            }

            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();


        }
    }

    public void checkBtn4(View v) {
        int radioId = rg.getCheckedRadioButtonId();
        Answer4 = (RadioButton) findViewById(radioId);

        if (Answer4.getText() == mAnswer) {
            try {

                int va1 = Integer.parseInt((String) MarksTv.getText());
                int tot = va1 + 10;
                MarksTv.setText(String.valueOf(tot));

            } catch (Exception ex) {
            }

            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();

            updateQuestion(random.nextInt(mQuestionNumber));

            Answer1.setChecked(false);
            Answer2.setChecked(false);
            Answer3.setChecked(false);
            Answer4.setChecked(false);

            //////////////////////////ques no.
            k++;
            Ques_number.setText(k + "/10");
            if (k==10){
                startActivity(new Intent(Play.this,LastActivity1.class));
                BackGroundSound.pause();
                finish();
            }
            else {
            }

            updateQuestion(random.nextInt(mQuestionNumber));


        } else {
            if (MarksTv.getText().equals("0")) {

                updateQuestion(random.nextInt(mQuestionNumber));

                Answer1.setChecked(false);
                Answer2.setChecked(false);
                Answer3.setChecked(false);
                Answer4.setChecked(false);

                k++;
                Ques_number.setText(k + "/10");
                if (k==10){
                    startActivity(new Intent(Play.this,LastActivity1.class));
                    BackGroundSound.pause();
                    finish();
                }

            } else {
                try {

                    int va1 = Integer.parseInt((String) MarksTv.getText());
                    int tot = va1 - 10;
                    MarksTv.setText(String.valueOf(tot));

                } catch (Exception ex) {
                }

                updateQuestion(random.nextInt(mQuestionNumber));
                Answer1.setChecked(false);
                Answer2.setChecked(false);
                Answer3.setChecked(false);
                Answer4.setChecked(false);
                k++;
                Ques_number.setText(k + "/10");

                if (k==10){
                    startActivity(new Intent(Play.this,LastActivity1.class));
                    BackGroundSound.pause();
                    finish();
                }

            }

            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();


        }
    }


    @Override
    public void onBackPressed(){

      //  startActivity(new Intent(Play.this,QuestionSelect.class));
        BackGroundSound.pause();
        finish();

    }

}



