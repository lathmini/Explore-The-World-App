package com.example.admin.explor_the_world;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Thread  th;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        th = new Thread() {
            @Override
            public void run() {
                for (i = 5; i >= 0; i--) {
                    {
                        if(i==1){
                            Intent intent = new Intent(MainActivity.this,explor2_java.class);;

                            startActivity(intent);

                        }
                    }


                    try {
                        sleep(800);
                    } catch (InterruptedException ex) {
                    }
                }
            }

        } ;
        th.start();




    }
}
