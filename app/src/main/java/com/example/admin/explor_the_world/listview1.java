package com.example.admin.explor_the_world;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//learn click open

public class listview1 extends AppCompatActivity{
    DbHandler mydb ;
    TextView name ;
    TextView phone;
    TextView email;
    TextView street;
    TextView place;
    int id_To_Update = 0;
    EditText editText;
    String TempHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview2);

        editText = (EditText)findViewById(R.id.editText2);



        // Receiving value into activity using intent.
        TempHolder = getIntent().getStringExtra("ListViewClickedValue");

        // Setting up received value into EditText.
        editText.setText(TempHolder);
        mydb = new DbHandler(this);


        String uname = TempHolder;
        if (uname.isEmpty())
        {
            //  Message.message(getApplicationContext(),"Enter data");
            Toast.makeText(this, "Enter data", Toast.LENGTH_SHORT).show();
        }
        String data = mydb.getData(uname);


        if(data.equals("")){
            Toast.makeText(this, "No data Found. pls login and insert data", Toast.LENGTH_SHORT).show();
        }else {
            // Message.message(this,data);
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show();

        }

    }

    private void viewdata(View view) {

        String uname = TempHolder;
        if (uname.isEmpty())
        {
            //  Message.message(getApplicationContext(),"Enter data");
            Toast.makeText(this, "Enter data", Toast.LENGTH_SHORT).show();
        }
        String data = mydb.getData(uname);


        // Message.message(this,data);


        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }







    /*
    public void viewdata(View view) {
        String TempHolder = name.getText().toString();
        if (TempHolder.isEmpty())
        {
            Toast.makeText(this, "Enter data", Toast.LENGTH_SHORT).show();




        }
        String data = mydb.getData(String TempHolder);
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show();



        editText = (EditText)findViewById(R.id.editText1);

        // Receiving value into activity using intent.
        String TempHolder = getIntent().getStringExtra("ListViewClickedValue");

        // Setting up received value into EditText.
        editText.setText(TempHolder+"345");

        street = (TextView) findViewById(R.id.editTextEmail);
        name = (TextView) findViewById(R.id.editTextName);
        phone = (TextView) findViewById(R.id.editTextPhone);
        email = (TextView) findViewById(R.id.editTextStreet);

        place = (TextView) findViewById(R.id.editTextCity);

        mydb = new DbHandler(this);
        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            int Value = extras.getInt("id");

            if(Value>0){
                //means this is the view part not the add contact part.
                Cursor rs = mydb.getData(Value);
                id_To_Update = Value;
                rs.moveToFirst();
                String stree = rs.getString(rs.getColumnIndex(DbHandler.KEY_ID));
                String nam = rs.getString(rs.getColumnIndex(DbHandler.KEY_NAME));
                String phon = rs.getString(rs.getColumnIndex(DbHandler.KEY_LOC));
                String emai = rs.getString(rs.getColumnIndex(DbHandler.KEY_DESG));



                if (!rs.isClosed()) {
                    rs.close();
                }
              //  Button b = (Button)findViewById(R.id.button1);
              //  b.setVisibility(View.INVISIBLE);
                street.setText((CharSequence)stree);
                street.setFocusable(false);
                street.setClickable(false);
                name.setText((CharSequence)nam);
                name.setFocusable(false);
                name.setClickable(false);
                phone.setText((CharSequence)phon);
                phone.setFocusable(false);
                phone.setClickable(false);
                email.setText((CharSequence)emai);
                email.setFocusable(false);
                email.setClickable(false);


            }
        }
    }
*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        Bundle extras = getIntent().getExtras();

        if(extras !=null) {
            int Value = extras.getInt("id");
            if(Value>0){
                getMenuInflater().inflate(R.menu.display_contact, menu);
            } else{
                getMenuInflater().inflate(R.menu.main_menu, menu);
            }
        }
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()) {
            case R.id.Edit_Contact:
              //  Button b = (Button)findViewById(R.id.button1);
              //  b.setVisibility(View.VISIBLE);

                street.setEnabled(true);

                street.setFocusableInTouchMode(true);
                street.setClickable(true);
                name.setEnabled(true);

                name.setFocusableInTouchMode(true);
                name.setClickable(true);
                phone.setEnabled(true);
                phone.setFocusableInTouchMode(true);
                phone.setClickable(true);
                email.setEnabled(true);
                email.setFocusableInTouchMode(true);
                email.setClickable(true);

                return true;
            case R.id.Delete_Contact:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.deleteContact)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                              //  mydb.DeleteUser(id_To_Update);
                                Toast.makeText(getApplicationContext(), "Deleted Successfully",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                AlertDialog d = builder.create();
                d.setTitle("Are you sure");
                d.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void run(View view) {
        Bundle extras = getIntent().getExtras();









    }
}