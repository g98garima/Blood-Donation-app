/*
package com.example.blooddonation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class RecipientDB extends SQLiteOpenHelper {
    private static String databaseName = "bloodDonationDatabase";
    SQLiteDatabase bloodDonationDatabase;

    public RecipientDB(Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table recipientRegistration (_id INTEGER PRIMARY KEY AUTOINCREMENT,first_name VARCHAR(250), last_name VARCHAR(250), user_name VARCHAR(250) UNIQUE, password VARCHAR(250)," +
                "email VARCHAR(250), phone_no NUMBER(11), city VARCHAR(250), country VARCHAR(250), gender VARCHAR(100), blood_type VARCHAR(100))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

        db.execSQL("drop table if exists recipientRegistration");
        onCreate(db);
    }

    public void createNewRecipient(String first_name, String last_name, String username, String pwd, String email, String phone, String city, String country, String gender, String bloodType)
    {
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


        long insert = db.insert("recipientRegistration", null, row);
        Log.d("Data Inserted", "Data inserted successfully");
        db.close();
    }
}
*/


/*public List<ProfileInfoActivity> getEveryone() {
        List<ProfileInfoActivity> returnList = new ArrayList<>();
        String queryString = "Select * from donorRegistration";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
        do {
        String first_name = cursor.getString(1);
        String last_name = cursor.getString(2);
        String user_name = cursor.getString(3);
        String password = cursor.getString(4);
        String email = cursor.getString(5);
        String phone_no = cursor.getString(6);
        String city = cursor.getString(7);
        String country = cursor.getString(8);
        String gender = cursor.getString(9);
        String blood_type = cursor.getString(10);
        String user_type = cursor.getString(11);

        ProfileInfoActivity data = new ProfileInfoActivity(first_name, last_name, user_name, password,
        email, phone_no, city, country, gender, blood_type, user_type);

        returnList.add(data);

        } while (cursor.moveToNext());
        return returnList;
        } else {
        cursor.close();
        db.close();
        return returnList;
        }


        }*/
