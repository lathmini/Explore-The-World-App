package com.example.admin.explor_the_world;

//country details click open



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Countrydetails extends AppCompatActivity {

    EditText editText;
    EditText name, loc, desig,id, popu11, pasiden,clan,dial;
    Button saveBtn;
    ImageView  dro;
    Intent intent;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countrydetails);

        editText = (EditText)findViewById(R.id.editText2);
       // dro = (ImageView) findViewById(R.id.draw);
      //  ImageView img =new ImageView(this);

        // Receiving value into activity using intent.
        String TempHolder = getIntent().getStringExtra("ListViewClickedValue");


       // Setting up received value into EditText.
        editText.setText(TempHolder);
      //  int cxc = Integer.parseInt(TempHolder);
    //  dro.setImageResource(R.drawable.democratic);


        name = (EditText)findViewById(R.id.txtName);
        loc = (EditText)findViewById(R.id.txtLocation);
        desig = (EditText)findViewById(R.id.txtDesignation);
        popu11 = (EditText)findViewById(R.id.president);
        pasiden = (EditText)findViewById(R.id.religions);
        clan = (EditText)findViewById(R.id.currency);
        dial = (EditText)findViewById(R.id.dialing_code);


        saveBtn = (Button)findViewById(R.id.btnSave);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String xxxx = editText.getText().toString();


              int idd = 0;
                String username = name.getText().toString();
                String location = editText.getText().toString();
                String designation = desig.getText().toString();
                String population = popu11.getText().toString();
                String pras = pasiden.getText().toString();
                String conlan = clan.getText().toString();
                String dialing = dial.getText().toString();
                DbHandler dbHandler = new DbHandler(Countrydetails.this);
                dbHandler.insertData(xxxx, location,designation,population,pras,conlan,dialing);

                Toast.makeText(getApplicationContext(), "Details added Successfully",Toast.LENGTH_SHORT).show();


            }
        });





    }

}
