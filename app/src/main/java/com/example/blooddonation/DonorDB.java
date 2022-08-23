package com.example.blooddonation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DonorDB extends SQLiteOpenHelper {
    private static String databaseName = "bloodDonationDatabase";
    SQLiteDatabase bloodDonationDatabase;

    public DonorDB(Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table donorRegistration (_id INTEGER PRIMARY KEY AUTOINCREMENT,first_name VARCHAR(250), last_name VARCHAR(250), user_name VARCHAR(250) UNIQUE, password VARCHAR(250)," +
                "email VARCHAR(250), phone_no NUMBER(11), city VARCHAR(250), country VARCHAR(250), gender VARCHAR(100), blood_type VARCHAR(100), user_type VARCHAR(100))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists donorRegistration");
        onCreate(db);
    }

    public void createNewDonor(String first_name, String last_name, String username, String pwd, String email, String phone, String city, String country, String gender, String bloodType, String userType) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("first_name", first_name);
        row.put("last_name", last_name);
        row.put("user_name", username);
        row.put("password", pwd);
        row.put("email", email);
        row.put("phone_no", phone);
        row.put("city", city);
        row.put("country", country);
        row.put("gender", gender);
        row.put("blood_type", bloodType);
        row.put("user_type", userType);


        long insert = db.insert("donorRegistration", null, row);
        Log.d("Data Inserted", "Data inserted successfully");
        db.close();
    }

    public boolean recipientLogin(String username, String pwd) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("Select * from donorRegistration where user_name = ? and password = ? and user_type = 'Recipient'", new String[]{username, pwd}, null);

        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean donarLogin(String username, String pwd) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("Select * from donorRegistration where user_name = ? and password = ? and user_type = 'Donar'", new String[]{username, pwd}, null);

        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public Cursor viewData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from donorRegistration where user_type = 'Donar'";
        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }

    public void updateDonarProfile(String fname, String lname, String pwd, String email, String number, String city, String country, String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("first_name", fname);
        values.put("last_name", lname);
        values.put("password", pwd);
        values.put("email", email);
        values.put("phone_no", number);
        values.put("city", city);
        values.put("country", country);

        db.update("donorRegistration", values, "user_name= ?", new String[]{username});
        Log.d("updated", "Data Updated");
    }


}
