package com.example.admin.explor_the_world;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class DbHandler {
    myDbHelper myhelper;

    Cursor cursor=null;

    public DbHandler(Context context)
    {

        myhelper = new myDbHelper(context);
    }

    public long insertData(String xxxx, String name, String pass, String popu1, String prasid, String langu,String dialing)
    {

        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.UID, 0);
        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.MyPASSWORD, pass);
        contentValues.put(myDbHelper.POPU, popu1);
        contentValues.put(myDbHelper.PRASI, prasid);
        contentValues.put(myDbHelper.LANGUA, langu);
        contentValues.put(myDbHelper.DIAL, dialing);
        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }

    public String getData(String uname)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID,myDbHelper.NAME,myDbHelper.MyPASSWORD,myDbHelper.POPU,myDbHelper.PRASI,myDbHelper.DIAL};


         //cursor =db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        cursor = db.rawQuery("select * from " + myDbHelper.TABLE_NAME + " where " + myDbHelper.NAME + "='" + uname + "'" , null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String name =cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            String  popul =cursor.getString(cursor.getColumnIndex(myDbHelper.POPU));
            String  praside =cursor.getString(cursor.getColumnIndex(myDbHelper.PRASI));
            String  langua =cursor.getString(cursor.getColumnIndex(myDbHelper.LANGUA));
            String  dialingcode =cursor.getString(cursor.getColumnIndex(myDbHelper.DIAL));


            buffer.append(cid + " " + name + "   " + password + "  "  + popul+ "  "+praside+"   "+langua+ "  " +dialingcode+"\n");


        }
        return buffer.toString();
    }






    public int query(String uname)
    {
        SQLiteDatabase db=myhelper.getWritableDatabase();
        String[]whereArgs={uname};

        int  count =db.delete(myDbHelper.TABLE_NAME,myDbHelper.NAME+"=?",whereArgs);
        return count;
    }
    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "explo";    // Database Name
        private static final String TABLE_NAME = "Con_deta";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version
        private static final String UID="u_id";     // Column I (Primary Key)
        private static final String NAME = "Name";    //Column II
        private static final String MyPASSWORD= "Password";    // Column III
        private static final String POPU= "Popu";    // Column Iv
        private static final String PRASI= "prasid";    // Column Iv
        private static final String LANGUA= "lang";    // Column Iv
        private static final String DIAL= "dialing";    // Column Iv
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER(5) , "+NAME+" VARCHAR(255) PRIMARY KEY ,"+ MyPASSWORD+" VARCHAR(225),"+POPU+" VARCHAR(225),"+PRASI +" VARCHAR(225),"+LANGUA +" VARCHAR(225),"+DIAL +" VARCHAR(225));";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }




        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Message.message(context,""+e);
            }
        }





        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }
        }
    }
}







