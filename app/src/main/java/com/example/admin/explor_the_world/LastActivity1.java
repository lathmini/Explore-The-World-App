package com.example.admin.explor_the_world;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LastActivity1 extends AppCompatActivity {

    private TextView Marks;
    private Button Retry, Home, Levels, Retry1;
    private ImageView CupCake1, CupCake2, CupCake3, EmptyCupCake1, EmptyCupCake2,EmptyCupCake3;



    private Animation ZoomInOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_activity);


        Retry = (Button)findViewById(R.id.btn_retry);
        Retry1 = (Button)findViewById(R.id.btn_retry_1);
        Home = (Button)findViewById(R.id.btn_home);
        Levels = (Button)findViewById(R.id.btn_LevelSelect);
       // Marks = (TextView)findViewById(R.id.Marks);


        CupCake1 = (ImageView)findViewById(R.id.CupCake1);
        CupCake2 = (ImageView)findViewById(R.id.CupCake2);
        CupCake3 = (ImageView)findViewById(R.id.CupCake3);

        EmptyCupCake1 = (ImageView)findViewById(R.id.EmptyCupCake1);
        EmptyCupCake2 = (ImageView)findViewById(R.id.EmptyCupCake2);
        EmptyCupCake3 = (ImageView)findViewById(R.id.EmptyCupCake3);


        ////////////////////////////////////////////////////////////////////////////////////////////

      //  ZoomInOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in_and_out);

        // btn_retry ani
     //   Retry.startAnimation(ZoomInOut);

        // btn_home ani
      //  Home.startAnimation(ZoomInOut);

        // btn_levels ani
     //   Levels.startAnimation(ZoomInOut);



        Retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LastActivity1.this, Play.class));
                finish();
            }
        });


        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LastActivity1.this, MainActivity.class));
                finish();
            }
        });


        Levels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  startActivity(new Intent(LastActivity1.this, QuestionSelect.class));
                finish();
            }
        });




    }
}




