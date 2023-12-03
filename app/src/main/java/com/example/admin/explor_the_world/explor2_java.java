package com.example.admin.explor_the_world;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class explor2_java extends AppCompatActivity {


Button learn,game,admin,exit,instruction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explor_2);

        learn =(Button)findViewById(R.id.addBtn);
        game =(Button)findViewById(R.id.addBtn2);
        admin =(Button)findViewById(R.id.addBtn3);
        instruction =(Button)findViewById(R.id.addBtn5);
        exit =(Button)findViewById(R.id.addBtn4);


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(explor2_java.this);
                builder.setTitle("Login Alert")
                        .setMessage("Are you sure, you want to close ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.exit(0);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {


                                Toast.makeText(explor2_java.this,"Selected Option: No",Toast.LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog dialog  = builder.create();
                dialog.show();
            }
        });




        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(explor2_java.this, Learn_2.class);

                startActivity(intent);

            }
        });



        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(explor2_java.this, Admin.class);

                startActivity(intent);

            }
        });


        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(explor2_java.this,Game.class);

                startActivity(intent);

            }
        });

        instruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(explor2_java.this, Instruction.class);

                startActivity(intent);

            }
        });














    }
}