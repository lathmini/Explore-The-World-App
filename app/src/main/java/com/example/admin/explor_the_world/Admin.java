package com.example.admin.explor_the_world;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Admin  extends AppCompatActivity {
    EditText uname, pwd;
    Button loginBtn;
    SharedPreferences pref;
    Intent intent;
    private TextView loginLockedTV;
    private TextView attemptsLeftTv;
    private TextView numberofR;
    int numberOfRemainingLogAttempts = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);

            uname = (EditText) findViewById(R.id.txtName);
            pwd = (EditText) findViewById(R.id.txtPwd);
            loginBtn = (Button) findViewById(R.id.btnLogin);
            loginLockedTV = (TextView) findViewById(R.id.textView4);
            attemptsLeftTv = (TextView) findViewById(R.id.textView5);
            numberofR = (TextView) findViewById(R.id.textView6);
            numberofR.setText(Integer.toString(numberOfRemainingLogAttempts));

        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        intent = new Intent(Admin.this,log.class);
        if(pref.contains("username") && pref.contains("password")){
            startActivity(intent);
        }
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = uname.getText().toString();
                String password = pwd.getText().toString();
                if (username.equals("l") && password.equals("2")) {
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Credentials are not valid", Toast.LENGTH_SHORT).show();
                    numberOfRemainingLogAttempts--;
                    attemptsLeftTv.setVisibility(View.VISIBLE);
                    numberofR.setVisibility(View.VISIBLE);
                    numberofR.setText(Integer.toString(numberOfRemainingLogAttempts));

                    if (numberOfRemainingLogAttempts == 0) {
                        loginBtn.setEnabled(false);
                        loginLockedTV.setBackgroundColor(Color.RED);
                        loginLockedTV.setText("LOGIN LOCKED");
                    }
                }
            }
        });
    }
}













